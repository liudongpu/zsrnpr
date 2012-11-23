package com.srnpr.com.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadConfig {

	
	
	public void LoadBasePp() {
		
		
		Properties properties=new Properties();
		try {
			
			if(StaticConst.Const_RootPath!=null)
			{
				properties.load(new FileInputStream(StaticConst.Const_RootPath));
			}
			else {
				
			}
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	public  void LoadProperties(String sPath)
	{
		Properties properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream(sPath);
			properties.load(fis);
			
			@SuppressWarnings("rawtypes")
			Enumeration em=properties.propertyNames();
			while (em.hasMoreElements()) {
				String sKeyString=(String)em.nextElement();
				StaticConst.Const_Zsrnpr_PP.put(sKeyString, properties.getProperty(sKeyString));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void LoadConfig(String sPath)
	{
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}