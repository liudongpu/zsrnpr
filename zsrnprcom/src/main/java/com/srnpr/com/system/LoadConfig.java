package com.srnpr.com.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.springsource.vfabric.licensing.client.CpuInfo;
import com.srnpr.com.helper.BaseHelper;
import com.srnpr.com.helper.ConfigHelper;


public class LoadConfig {

	
	
	public void LoadBasePp() {
		
		
		PropertiesConfiguration properties=new PropertiesConfiguration();
		try {
			
			CheckProperties checkProperties=new CheckProperties();
			
			boolean bFlagWebSite=StaticConst.Const_RootPath!=null;
			
			//自动加载 判断如果是否是网站加载
			if(bFlagWebSite)
			{
				//properties.load(StaticConst.Const_RootPath+StaticConst.CONST_ZSRNPR_Z_PATH_STRING);
				
				properties=new PropertiesConfiguration(StaticConst.Const_RootPath+StaticConst.CONST_ZSRNPR_Z_PATH_STRING);
				checkProperties.Put(properties, StaticConst.Const_Zsrnpr_PP);
			}
			
			
				 PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
				 Resource[] resources=patternResolver.getResources("com/srnpr/zfile/config/pp-zsrnpr.properties");
				 if (resources != null && resources.length > 0) { 
						
					 PropertiesConfiguration pJarConfiguration=new PropertiesConfiguration(resources[0].getURL());
						if(bFlagWebSite)
						{
					 checkProperties.AutoCheck(properties, pJarConfiguration);
						}
						else
						{
							properties=pJarConfiguration;
						}
				 }
			

			
			checkProperties.Put(properties, StaticConst.Const_Zsrnpr_PP);
			
			if(bFlagWebSite)
			{
				properties.save();
			}
			
			ConfigHelper.PpValueSet("zsrnpr.z.rootpath", StaticConst.Const_RootPath);
			
			if(BaseHelper.PpValue("zsrnpr.z.version")==null)
			{
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void LoadLanguage()
	{
		try {
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	public void LoadConfigValue()
	{
		
		
		 PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
			try {
				Resource[] resources = patternResolver.getResources("com/srnpr/zfile/config/config-*.properties");
				
				for(Resource r :resources )
				{
					CheckProperties cProperties=new CheckProperties();
					
					
					PropertiesConfiguration pJarConfiguration=new PropertiesConfiguration(r.getURL());

					
					if(!BaseHelper.PpValue("zsrnpr.z.rootpath").isEmpty())
					{
						PropertiesConfiguration pExitProperties=new PropertiesConfiguration();
						String sConfigDir=BaseHelper.PpValue("zsrnpr.z.rootpath")+BaseHelper.PpValue("zsrnpr.z.configpath");
						String sConfigFile=sConfigDir+r.getFilename();
						File fconfigFile=new File(sConfigFile);
						
					
						if(fconfigFile.exists())
						{
							pExitProperties.load(fconfigFile);
							
							
							
							
							cProperties.AutoCheck(pExitProperties, pJarConfiguration);
							
						}
						cProperties.AutoCheck(pExitProperties, pJarConfiguration);
						pExitProperties.save(fconfigFile);
						
						
						File fTargetConfigFile=new File(sConfigDir+r.getFilename().replace(".properties", ".properties"));
						
						if(fTargetConfigFile.exists())
						{
							PropertiesConfiguration pTargetConfiguration=new PropertiesConfiguration(fTargetConfigFile);
							cProperties.AutoCheck(pExitProperties, pTargetConfiguration);
						}
						
						
						cProperties.Put(pExitProperties,StaticConst.Const_Zsrnpr_Config);
						
					}
					else {
						cProperties.Put(pJarConfiguration,StaticConst.Const_Zsrnpr_Config);
					}
					
					
					
				}
		    
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	
		
		

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
