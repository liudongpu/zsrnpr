package com.srnpr.zcontrol;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.convert.JsonConvert;
import com.srnpr.com.entity.ResultGrid;
import com.srnpr.com.entity.ResultSubmit;
import com.srnpr.data.helper.DataHelper;
import com.srnpr.manage.page.PageSubmitAdd;
import com.srnpr.manage.process.PageAdd;



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
	public String Add(Locale locale ,@PathVariable("id") String sId, Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		PageAdd pageAdd=new PageAdd();
		
		
		model.addAttribute("zsrnprmanage_view_html",pageAdd.GetHtml(sId) );
		
		
		return "zsrnprmanage/add";
	}
	
	
	
	@RequestMapping(value="zsrnprmanage/submit/{type}/{id}")
	public String Submit(Locale locale,@PathVariable("type") String sType ,@PathVariable("id") String sId, Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		
		PageAdd pageAdd=new PageAdd();

		
		
		
		PageSubmitAdd pageSubmitAdd=new PageSubmitAdd();
		
		 ResultSubmit rSubmit= pageSubmitAdd.Submit(null);
		 
		 
		 JsonConvert<ResultSubmit> jConvert=new JsonConvert<ResultSubmit>();
		 
		model.addAttribute("zsrnprmanage_view_json",jConvert.ObjToString(rSubmit) );
		
		return "zsrnprmanage/json";
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
		
		/*
		ObjectMapper om=new ObjectMapper ();
	
		String sResponseString=null;
		try {
			sResponseString=om.writeValueAsString(rGrid);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		JsonConvert jConvert=new JsonConvert();
		
		
		
		
		model.addAttribute("zsrnprmanage_view_json",jConvert.ObjToString(rGrid));
		
		return "zsrnprmanage/json";
	}
	
}
