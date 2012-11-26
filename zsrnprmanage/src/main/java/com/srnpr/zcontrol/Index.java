package com.srnpr.zcontrol;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="")
public class Index {

	@RequestMapping(value="")
	public String dd(Locale locale , Model model) {
		
		model.addAttribute("serverTime", "zmanage！！" );
		
		
		return "zsrnprmanage/default";
	}
	
	
	
	
	@RequestMapping(value="dd")
	public String home(Locale locale , Model model) {
		
		model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		
		return "home";
	}
	
	
}
