package com.srnpr.operate.test;

import com.srnpr.com.convert.JsonConvert;
import com.srnpr.com.entity.PageParams;
import com.srnpr.com.helper.BaseHelper;
import com.srnpr.com.helper.StringHelper;
import com.srnpr.operate.BaseTest;


public class CommonTest extends BaseTest {

	
	
	
	public void testString()
	{
		//BaseHelper.Log(StringHelper.Format("adfad{0}adfa", "aa"));
		
		JsonConvert<PageParams> jConvertPage=new JsonConvert<PageParams>();
		PageParams rsResultSubmit=new PageParams();
		
		rsResultSubmit.getParams().put("aa", "vv");
		
		String sNewToString=jConvertPage.ObjToString(rsResultSubmit);
		BaseHelper.Log(sNewToString);
		
		PageParams pSubmit=new PageParams();
		
		pSubmit=jConvertPage.StringToObj(sNewToString,pSubmit);
		
		BaseHelper.Log(pSubmit.getParams().get("aa"));
		
	}
	
	
}
