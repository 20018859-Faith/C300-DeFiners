package c300.definers.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private TokenRepository tokenRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Token> listTokens = tokenRepository.findAll();
		model.addAttribute("listTokens", listTokens);

		return "index";
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "charts";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/about")
	public String about() {
		return "aboutUs";
	}

	@GetMapping("/docs")
	public String docs() {
		return "docs";
	}
	
}
