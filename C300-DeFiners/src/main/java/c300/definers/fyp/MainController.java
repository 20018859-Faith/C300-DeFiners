package c300.definers.fyp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


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
