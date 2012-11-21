package zsrnpr.web.site;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

	@RequestMapping(value="/index/{id}")
	public String index(Locale locale ,@PathVariable("id")String id, Model model) {
		
		model.addAttribute("serverTime", "ccvvccffxxeee" );
		
		model.addAttribute("thisid", id);
		return "index";
	}
}
