package com.srnpr.com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.srnpr.com.helper.*;
import com.srnpr.com.system.*;
/**
 * @author srnpr
 *
 */
public class ContextLoader {

	
	
	/**
	 * @param servletContext servlet load
	 */
	public  void Init(ServletContext servletContext) {
		
		try {
			
			 
			servletContext.log("Initializing zsrnpr");
			StaticConst.Const_RootPath=servletContext.getRealPath("")+"/";
			
			
			InitProcess();
			
		}
		catch(RuntimeException ex)
		{
			servletContext.log("Initializing zsrnpr Error"+ex.getMessage());
		}
		
		
	}
	
	
	public void InitProcess()
	{
		LogInfo("zsrnpr begin init");
		
		LoadConfig loadConfig=new LoadConfig();
		
		loadConfig.LoadBasePp();
		
		loadConfig.LoadConfigValue();


		//Reset rootpath
		
		LogInfo("zsrnpr.z.rootpath="+BaseHelper.PpValue("zsrnpr.z.rootpath"));
		LogInfo("zsrnpr.z.version="+BaseHelper.PpValue("zsrnpr.z.version"));	
	}
	
	
	
	
	/**
	 * @param sText Log info text
	 * system.out
	 */
	public  void LogInfo(String sText)
	{
		BaseHelper.Log("ZsrnprInit : " +sText);
	}
	
	
	
	
	
}
