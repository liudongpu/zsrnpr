package com.srnpr.com.system;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.srnpr.com.helper.BaseHelper;
import com.srnpr.com.helper.ConfigHelper;
import com.srnpr.com.inface.IRootInit;

public class RootInit extends RootInitBase implements IRootInit {

	
	
	public void Init() {
		LoadBasePp();
		
		LoadConfigValue();
		
		LoadJarInit();

	}


	public void LoadConfigValue()
	{
		
		
		 PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
			try {
				Resource[] resources = patternResolver.getResources("classpath*:com/srnpr/zfile/config/config-*.properties");
				
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
				ConfigHelper.PpValueSet("zsrnpr.z.rootpath", StaticConst.Const_RootPath);
			}
			
			
			
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
	
	
	
	
	
	
	
	
	
	
	public  void  LoadJarInit() {
		
		
		List<String> lClassList=ConfigHelper.GetListFromHash(StaticConst.Const_Zsrnpr_PP, "zsrnpr.z.init");
		 try {
			for (String sClassName : lClassList) {
				
				
					Class<?> cClass=Class.forName(sClassName);
					
					if(cClass!=null&&cClass.getDeclaredMethods()!=null)
					{
						
						
						IRootInit init=(IRootInit)cClass.newInstance();
					
						init.Init();
					}
					
					
				
				
				
				}
		 } catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
	}
	
	
	
	
	
	
}
