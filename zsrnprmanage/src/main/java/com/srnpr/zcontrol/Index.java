package com.srnpr.zcontrol;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.srnpr.com.convert.JsonConvert;
import com.srnpr.com.entity.MapEntity;
import com.srnpr.com.entity.PageParams;
import com.srnpr.com.entity.ResultGrid;
import com.srnpr.com.entity.ResultSubmit;
import com.srnpr.com.helper.BaseHelper;
import com.srnpr.com.inface.IPageSubmit;
import com.srnpr.data.execute.DataExecute;
import com.srnpr.manage.process.PageAdd;
import com.srnpr.operate.page.PageSubmit;



@Controller
public class Index {

	@RequestMapping(value="")
	public String defalut(Locale locale , Model model) {
		
		model.addAttribute("serverTime", "zmanage！！" );
		
		
		return "zsrnprmanage/default";
	}
	
	
	
	
	@RequestMapping(value="zsrnprmanage/list/{id}")
	public String List(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		
		
		return "zsrnprmanage/list";
	}
	
	@RequestMapping(value="zsrnprmanage/add/{id}")
	public String Add(Locale locale ,@PathVariable("id") String sId, Model model) {
		

		PageAdd pageAdd=new PageAdd();

		model.addAttribute("zsrnprmanage_view_html",pageAdd.GetHtml(sId) );
		return "zsrnprmanage/add";
	}
	
	
	
	@RequestMapping(value="zsrnprmanage/submit/{type}/{id}")
	public String Submit(Locale locale,@PathVariable("type") String sType ,
			@PathVariable("id") String sId,
			@RequestParam("com_srnpr_operate_base_bpagehtml_submitinput") String sInput,
			Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		String sPageParam=null;
		try {
			sPageParam=java.net.URLDecoder.decode(sInput,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BaseHelper.Log(sPageParam);
		
		PageParams pageParams=new JsonConvert<PageParams>().StringToObj(sPageParam, new PageParams());
		

		IPageSubmit iPageSubmit=new PageSubmit();
		

		
		ResultSubmit rSubmit= iPageSubmit.Submit(pageParams);
		 
		 
		JsonConvert<ResultSubmit> jConvert=new JsonConvert<ResultSubmit>();
		 
		model.addAttribute("zsrnprmanage_view_json",jConvert.ObjToString(rSubmit) );
		
		return "zsrnprmanage/json";
	}
	
	
	
	@RequestMapping(value="zsrnprmanage/json/{type}/{id}")
	public String json(Locale locale , Model model) {
		
		//model.addAttribute("serverTime", "zmanage.dd！！！！！" );
		ResultGrid rGrid=new ResultGrid();
		
		rGrid.setFlag(1);
		
		
		DataExecute dExecute=new DataExecute("zd_table");
		
		List<MapEntity> listData=dExecute.QueryRows("");
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

		JsonConvert<ResultGrid> jConvert=new JsonConvert<ResultGrid>();
		
		model.addAttribute("zsrnprmanage_view_json",jConvert.ObjToString(rGrid));
		
		return "zsrnprmanage/json";
	}
	
}
