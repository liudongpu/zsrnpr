package com.srnpr.zcontrol;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.entity.ResultGrid;



@Controller
public class Index {

	@RequestMapping(value="")
	public String defalut(Locale locale , Model model) {
		
		model.addAttribute("serverTime", "zmanage！！" );
		
		
		return "zsrnprmanage/default";
	}
	
	
	
	
	@RequestMapping(value="zsrnprmanage/list/{id}")
	public String home(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		
		return "zsrnprmanage/list";
	}
	
	@RequestMapping(value="zsrnprmanage/json/{type}/{id}")
	public String json(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		ResultGrid rGrid=new ResultGrid();
		
		rGrid.setFlag(1);
		
		
		
		
		for(int i=0;i<2;i++)
		{
			ConcurrentHashMap<String, String> chmFieid=new ConcurrentHashMap<String, String>();
			
			chmFieid.put("name", "namefield"+i);
			chmFieid.put("field", "field"+i);
			
			rGrid.getLayout().add(chmFieid);
		}
		
		
		for(int i=0,j=10;i<j;i++)
		{
			ConcurrentHashMap<String, String> cHashMap=new ConcurrentHashMap<String, String>();
			
			cHashMap.put("field0", "0"+i);
			cHashMap.put("field1", "0"+i);
			rGrid.getData().add(cHashMap);
		}
		
		
		ObjectMapper om=new ObjectMapper ();
	
		String sResponseString=null;
		try {
			sResponseString=om.writeValueAsString(rGrid);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		model.addAttribute("zsrnprmanage_json",sResponseString);
		
		return "zsrnprmanage/json";
	}
	
}
