package zsrnpr.web.site;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/zmanage/{id}")
public class Index {

	
	
	public String index(Locale locale ,@PathVariable("id")String id, Model model) {
		
		model.addAttribute("serverTime", "ccvvccffffffxxeee" );
		
		model.addAttribute("thisid", id);
		return "home";
	}
	
	
	@RequestMapping(value="/")
	public String home(Locale locale , Model model) {
		
		model.addAttribute("serverTime", "ccvvccffffffxxeee" );
		
		
		return "home";
	}
}
