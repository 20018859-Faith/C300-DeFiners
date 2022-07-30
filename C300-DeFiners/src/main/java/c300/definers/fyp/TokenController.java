package c300.definers.fyp;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TokenController {
	
	@Autowired
	private TokenRepository tokenRepository;
	
	// view token
		@GetMapping("/tokens")
		public String token(Model model) {
			
			List<Token> listTokens = tokenRepository.findAll();
			model.addAttribute("listTokens", listTokens);

			return "view_tokens";
		}
		
		// add token - get
		@GetMapping("/tokens/add")
		public String addToken(Model model) {
			model.addAttribute("token", new Token());

			return "add_token";
		}
		
		// add token - post
		@PostMapping("/tokens/save")
		public String saveToken(Token token, @RequestParam("itemImage") MultipartFile imgFile) {

			if (!imgFile.isEmpty()) {

				// get file name of the image uploaded
				String imageToken = imgFile.getOriginalFilename();
				System.out.println("Image name from imgFile: " + imageToken);

				// set file name to item object
				token.setImgToken(imageToken);

				Token savedToken = tokenRepository.save(token);

				// upload file to local directory
				try {
					// create directory to upload
					String uploadDir = "uploads/tokens/" + savedToken.getId();

					Path uploadPath = Paths.get(uploadDir);

					System.out.println("Directory path: " + uploadPath);

					// check if the directory path exists
					// if it does not exist create the directory path
					if (!Files.exists(uploadPath)) {
						Files.createDirectories(uploadPath);
					}
					// copy the file to the directory path
					Path fileToCreatePath = uploadPath.resolve(imageToken);

					System.out.println("File path: " + fileToCreatePath);

					// source is the input
					// destination is to fileToCreatePath
					// in case file exist, replace, overwrite
					Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);

				} catch (IOException io) {
					// if it fails throw an exception
					io.printStackTrace();
				}

			}

			// no edit to image, save item object as passed.
			else {
				System.out.println("Image name from item object: " + token.getImgToken());
				tokenRepository.save(token);
			}

			return "redirect:/tokens";
		}
		
		@GetMapping("/token/edit/{id}")
		public String editToken(@PathVariable("id") Integer id, Model model) {
			
			Token token = tokenRepository.getById(id);
			model.addAttribute("token", token);
			
			return "edit_token";
		}
		
		@PostMapping("/token/edit/{id}")
		public String saveUpdatedToken(@PathVariable("id") Integer id, Token token,
				@RequestParam("itemImage") MultipartFile imgFile, BindingResult bindingResult) {

			if (bindingResult.hasErrors()) {
				return "edit_token";
			}

			if (!imgFile.isEmpty()) {
				String imageToken = imgFile.getOriginalFilename();

				token.setImgToken(imageToken);

				Token savedToken = tokenRepository.save(token);

				try {
					String uploadDir = "uploads/tokens/" + savedToken.getId();

					Path uploadPath = Paths.get(uploadDir);

					if (!Files.exists(uploadPath)) {
						Files.createDirectory(uploadPath);
					}

					Path fileToCreatePath = uploadPath.resolve(imageToken);
					Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING); // Overwrite
																													// existing
																													// image.
					// Converts whole image into bytes of data and store it there

				} catch (IOException io) {
					io.printStackTrace();
				}

			} else { // no edit to image, save item object as passed
				tokenRepository.save(token);
			}

			return "redirect:/tokens";
		}
		
		@GetMapping("/token/delete/{id}")
		public String deleteToken(@PathVariable("id") Integer id) {
			tokenRepository.deleteById(id);
			return "redirect:/tokens";
		}

}
