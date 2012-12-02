package com.srnpr.zcontrol;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.entity.ResultGrid;
import com.srnpr.data.helper.DataHelper;



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
	
	@RequestMapping(value="zsrnprmanage/add/{id}")
	public String Add(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		
		return "zsrnprmanage/add";
	}
	
	
	
	
	
	@RequestMapping(value="zsrnprmanage/json/{type}/{id}")
	public String json(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		ResultGrid rGrid=new ResultGrid();
		
		rGrid.setFlag(1);
		
		
		
		
		List<ConcurrentMap<String, String>> listData=DataHelper.QueryHashMap("zd_table", "");
		rGrid.setData(listData);
		
		if(listData.size()>0)
		{
			ConcurrentMap<String, String> cMap=listData.get(0);
			Iterator<String> iterator=cMap.keySet().iterator();
			while (iterator.hasNext()) {
				
				String sKey=iterator.next();
				ConcurrentHashMap<String, String> cHashMap=new ConcurrentHashMap<String, String>();
				cHashMap.put("name", sKey);
				cHashMap.put("field", sKey);
				rGrid.getLayout().add(cHashMap);
				
			}
			
			
		}
		
		rGrid.setSize(listData.size());
		
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
