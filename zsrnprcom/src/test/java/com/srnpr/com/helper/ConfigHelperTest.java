package com.srnpr.com.helper;

import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.BaseTest;
import com.srnpr.com.convert.JsonConvert;
import com.srnpr.com.entity.PageParams;
import com.srnpr.com.entity.ResultGrid;
import com.srnpr.com.entity.ResultSubmit;
import com.srnpr.com.enumer.EnumerHtml;
import com.srnpr.com.html.HtmlItem;


public class ConfigHelperTest extends BaseTest {

	
	
	public void testParseFormat() throws JsonProcessingException
	{
		
		HtmlItem hItem=new HtmlItem(EnumerHtml.div, "dd");
		
		hItem.AddItem(new HtmlItem(EnumerHtml.hidden, "xx"));
		
		BaseHelper.Log(hItem.ToHtml());
		
		
		ObjectMapper om=new ObjectMapper ();
		/*
		ConfigHelper chConfigHelper=new ConfigHelper();
		
		chConfigHelper.ParseFormat(new File("src/main/java/com/srnpr/zfile/config/config-zsrnprcom.xml"));
		*/
		
		/*
		Kvd kvd=new Kvd("aa","vv");
		kvd.setC(new ConcurrentHashMap<String, Kvd>());
		kvd.getC().put("data",new Kvd("aa","dd"));
		
		ObjectMapper om=new ObjectMapper ();
		BaseHelper.Log(om.writeValueAsString(kvd)) ;
		*/
		
		
		
		ResultGrid rGrid=new ResultGrid();
		
		rGrid.setFlag(1);
		
		
		
		
		for(int i=0,j=100;i<j;i++)
		{
			ConcurrentHashMap<String, String> cHashMap=new ConcurrentHashMap<String, String>();
			
			cHashMap.put("id", "0"+i);
			cHashMap.put("value", "0"+i);
			rGrid.getData().add(cHashMap);
		}
		
		
		
		
		
		//BaseHelper.Log(om.writeValueAsString(rGrid));
		
		JsonConvert<ResultGrid> jConvert=new JsonConvert<ResultGrid>();
		
		String sTo=jConvert.ObjToString(rGrid);
		BaseHelper.Log(sTo);
		
		
		JsonConvert<PageParams> jConvertPage=new JsonConvert<PageParams>();
		PageParams rsResultSubmit=new PageParams();
		
		rsResultSubmit.getParams().put("aa", "vv");
		
		String sNewToString=jConvertPage.ObjToString(rsResultSubmit);
		BaseHelper.Log(sNewToString);
		
		PageParams pSubmit=new PageParams();
		
		pSubmit=jConvertPage.StringToObj(sNewToString,pSubmit);
		
		BaseHelper.Log(pSubmit.getParams().get("aa"));
		
		
		
		
	}
	
	
	public void testLoadConfig()
	{
		
		
		//new ContextLoader().InitProcess();
		
		//BaseHelper.Log(BaseHelper.ConfigValue("zsrnprcom.z.require"));
		
		
		
		
		
	}
	
	
	
}
