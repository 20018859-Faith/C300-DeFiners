package c300.definers.fyp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	@GetMapping("/pool")
	public String pool() {
		return "pool";
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "charts";
	}
	
	@GetMapping("/walletConnect")
	public String walletConnect() {
		return "walletConnect";
	}
	
}
