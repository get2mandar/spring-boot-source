package blog.panditmandar.sbvue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SBViewMainController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("eventName", "FIFA 2023");
		return "index";
	}

}
