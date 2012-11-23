package com.srnpr.com.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.srnpr.com.BaseTest;
import com.srnpr.com.servlet.ContextLoader;
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
		
		new ContextLoader().InitProcess();
		
		BaseHelper.Log(BaseHelper.ConfigValue("zsrnprcom.z.require"));
		
		
		
		
		
	}
	
	
	
}
