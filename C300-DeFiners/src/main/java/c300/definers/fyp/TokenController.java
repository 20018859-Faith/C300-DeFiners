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
		public String saveToken(@Valid Token token, BindingResult bindingResult) {

			if (bindingResult.hasErrors()) {
				return "add_token";
			}

			tokenRepository.save(token);
			return "redirect:/tokens";

			}

		
		
		@GetMapping("/token/edit/{id}")
		public String editToken(@PathVariable("id") Integer id, Model model) {
			
			Token token = tokenRepository.getById(id);
			model.addAttribute("token", token);
			
			return "edit_token";
		}
		
		@PostMapping("/token/edit/{id}")
		public String saveEditToken(@PathVariable("id") Integer id, Token token) {

			tokenRepository.save(token);

			return "redirect:/tokens";
		}
		
		@GetMapping("/token/delete/{id}")
		public String deleteToken(@PathVariable("id") Integer id) {
			tokenRepository.deleteById(id);
			return "redirect:/tokens";
		}

}
