package c300.definers.fyp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
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
