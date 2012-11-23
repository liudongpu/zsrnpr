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
			
			
			InitProcess(StaticConst.Const_RootPath);
			
		}
		catch(RuntimeException ex)
		{
			servletContext.log("Initializing zsrnpr Error"+ex.getMessage());
		}
		
		
	}
	
	/**
	 * @param sBasePath RootPath
	 * process
	 */
	public void InitProcess(String sBasePath)
	{
		LogInfo("zsrnpr begin init");
		
		LoadConfig loadConfig=new LoadConfig();
		
		loadConfig.LoadBasePp();
		
		
		
		
		
		new LoadConfig().LoadProperties(sBasePath+StaticConst.CONST_ZSRNPR_Z_PATH_STRING);
		

		if(BaseHelper.PpValueContains("zsrnpr.z.pluging"))
		{
			
			 PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
			    Resource[] resources;
				try {
					resources = patternResolver.getResources("com/srnpr/zfile/config/*");
					
					for(int i=0,j=resources.length;i<j;i++)
					{
						LogInfo(resources[i].getFilename());
					}
					
					
					
				
			    if (resources != null && resources.length > 0) { 
			    	
			    	
			    	
			        InputStreamReader inputStreamReader = new InputStreamReader(resources[0].getInputStream());//<---①  
			        
			        BufferedReader br=new BufferedReader (inputStreamReader);
			        
			        String sReadString=null;
			        
			        StringBuilder sbBuilder=new StringBuilder();
			        while((sReadString=br.readLine())!=null)
			        {
			        	sbBuilder.append(sReadString);
			        }
			       
			        
			        LogInfo(new String(sbBuilder.toString()));
			        
			       
			    }
			 
			    
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			//LogInfo(this.getClass().getClassLoader().getResource("").toString());
			//LogInfo(this.getClass().getClassLoader().getResource("zsrnpr.zfile.config.config-zsrnprcom.xml").toString());
			
			
			
			
			
		}
		
		
		
		//Reset rootpath
		BaseHelper.PpValueSet("zsrnpr.z.rootpath", sBasePath);
		LogInfo("zsrnpr.z.rootpath="+BaseHelper.PpValueGet("zsrnpr.z.rootpath"));
		LogInfo("zsrnpr.z.version="+BaseHelper.PpValueGet("zsrnpr.zrnprcom.version"));	
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
