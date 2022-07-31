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
public class SwapController {

	@Autowired
	private SwapRepository swapRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	

	// add token - get
	@GetMapping("/")
	public String addSwap(Model model) {
		model.addAttribute("swap", new Swap());
		List<Token> listTokens = tokenRepository.findAll();
		model.addAttribute("listTokens", listTokens);
		return "index";
	}
	
	// add pool - post
		@PostMapping("/swap/save")
		public String saveSwap(@Valid Swap swap, BindingResult bindingResult) {

			if (bindingResult.hasErrors()) {
				return "index";
			}

			swapRepository.save(swap);
			return "redirect:index";
		}

}
