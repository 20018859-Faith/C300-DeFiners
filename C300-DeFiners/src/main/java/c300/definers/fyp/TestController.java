package c300.definers.fyp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String demo() {
		//test html.
		return "test";

	}
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}

}
