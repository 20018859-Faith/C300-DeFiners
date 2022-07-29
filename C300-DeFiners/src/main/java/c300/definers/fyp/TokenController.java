package c300.definers.fyp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class TokenController {
	
	@Autowired
	private TokenRepository tokenRepository;
	
	// view token
		@GetMapping("/view_tokens")
		public String view_tokens(Model model) {
			
			List<Token> listTokens = tokenRepository.findAll();
			model.addAttribute("listTokens", listTokens);

			return "view_tokens";
		}
		
		// add token - get
		@GetMapping("/add_token")
		public String add_token(Model model) {
			model.addAttribute("token", new Token());

			return "add_token";
		}
		
		// add token - post
		@PostMapping("/add_token/save")
		public String saveToken(@Valid Token token, BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "add_token";
			}
			
			tokenRepository.save(token);
			return "redirect:/add_token";
		}

}
