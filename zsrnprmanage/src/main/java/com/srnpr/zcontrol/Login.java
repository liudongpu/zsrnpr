package com.srnpr.zcontrol;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class Login {

	
	public String home(Locale locale, Model model) {

		
		//model.addAttribute("serverTime", formattedDate );
		model.addAttribute("serverTime", "ccvvccffddffxxeee" );
		return "home";
	}
	
}
