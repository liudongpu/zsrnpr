package zsrnpr.zmanage;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CallIndex {

	
	@RequestMapping(value="/call/{id}")
	public String callindex(Locale locale ,@PathVariable("id")String id, Model model) {
		
		model.addAttribute("serverTime", "ccvvccffffffxxeee" );
		
		model.addAttribute("thisid", id);
		return "home";
	}
}
