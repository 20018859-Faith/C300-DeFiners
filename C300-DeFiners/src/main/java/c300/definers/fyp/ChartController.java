package c300.definers.fyp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ChartController {

	@Autowired
	private ChartRepository chartRepository;

	// view chart
	@GetMapping("/charts")
	public String Chart(Model model) {
		List<Chart> listChart = chartRepository.findAll();
		model.addAttribute("listChart", listChart);

		return "charts";
	}

}
