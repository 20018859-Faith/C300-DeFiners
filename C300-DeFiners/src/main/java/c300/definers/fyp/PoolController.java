package c300.definers.fyp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PoolController {

	@Autowired
	private PoolRepository poolRepository;

	@Autowired
	private TokenRepository tokenRepository;

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
		
		List<Token> tokenList = tokenRepository.findAll();
		model.addAttribute("tokenList", tokenList);

		return "newPos";
	}

	// add pool - post
	@PostMapping("/pool/save")
	public String savePool(@Valid Pool pool, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "newPos";
		}

		poolRepository.save(pool);
		return "redirect:/pool/manage";
	}

	// pool manage view
	@GetMapping("/pool/manage")
	public String poolManage(Model model) {
		List<Pool> listPool = poolRepository.findAll();
		model.addAttribute("listPool", listPool);

		return "poolManage";
	}

	// edit pool - get
	@GetMapping("/pool/edit/{id}")
	public String editPool(@PathVariable("id") Integer id, Model model) {
		Pool pool = poolRepository.getById(id);
		model.addAttribute("pool", pool);

		return "poolEdit";
	}

	// edit pool - post
	@PostMapping("/pool/edit/pool/edit/{id}")
	public String saveEditPool(@PathVariable("id") Integer id, Pool pool) {

		poolRepository.save(pool);

		return "redirect:/pool/manage";
	}

	// delete
	@GetMapping("/pool/delete/{id}")
	public String deletePool(@PathVariable("id") Integer id) {
		poolRepository.deleteById(id);

		return "redirect:/pool/manage";
	}

}
