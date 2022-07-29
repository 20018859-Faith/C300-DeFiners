package c300.definers.fyp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PoolController {

	@Autowired
	private PoolRepository poolRepository;

	// view pool
	@GetMapping("/pool")
	public String pool(Model model) {
		
		List<Pool> listPool = poolRepository.findAll();
		model.addAttribute("listPool", listPool);

		return "pool";
	}

	// add pool - get
	@GetMapping("/pool/newPool")
	public String newPool(Model model) {
		model.addAttribute("pool", new Pool());

		return "newPos";
	}

	// add pool - post
	@PostMapping("/pool/save")
	public String savePool(@Valid Pool pool, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "newPos";
		}
		
		poolRepository.save(pool);
		return "redirect:/pool";
	}
}