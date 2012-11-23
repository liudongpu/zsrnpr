package com.srnpr.com.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.srnpr.com.BaseTest;
import com.srnpr.com.system.LoadConfig;

import junit.framework.TestCase;

public class ConfigHelperTest extends BaseTest {

	
	
	public void testParseFormat()
	{
		/*
		ConfigHelper chConfigHelper=new ConfigHelper();
		
		chConfigHelper.ParseFormat(new File("src/main/java/com/srnpr/zfile/config/config-zsrnprcom.xml"));
		*/
		
		
		
	}
	
	
	public void testLoadConfig()
	{
		//String sBasePathString="src/main/java/com.srnpr/zfile/config/";
		
		//LoadConfig lConfig=new LoadConfig();
		
		//lConfig.LoadConfig(sBasePathString);
		
		
		if(BaseHelper.PpValueContains("zsrnpr.z.rootpath"))
		{
			
		}
		
		
		
		
		
		
		
		
		 PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();  
		    Resource[] resources;
			try {
				resources = patternResolver.getResources("com/srnpr/zfile/config/*");
				
				for(int i=0,j=resources.length;i<j;i++)
				{
					BaseTestLog(resources[i].getFilename());
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
		       
		        
		        BaseTestLog(new String(sbBuilder.toString()));
		        
		       
		    }
		 
		    
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
		
		
		
	}
	
	
	
}
