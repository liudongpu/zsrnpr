package com.srnpr.com.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.BaseTest;
import com.srnpr.com.entity.Kvd;
import com.srnpr.com.servlet.ContextLoader;
import com.srnpr.com.system.LoadConfig;


public class ConfigHelperTest extends BaseTest {

	
	
	public void testParseFormat() throws JsonProcessingException
	{
		/*
		ConfigHelper chConfigHelper=new ConfigHelper();
		
		chConfigHelper.ParseFormat(new File("src/main/java/com/srnpr/zfile/config/config-zsrnprcom.xml"));
		*/
		
		Kvd kvd=new Kvd("aa","vv");
		kvd.setC(new ConcurrentHashMap<String, Kvd>());
		kvd.getC().put("data",new Kvd("aa","dd"));
		
		ObjectMapper om=new ObjectMapper ();
		BaseHelper.Log(om.writeValueAsString(kvd)) ;
		
	}
	
	
	public void testLoadConfig()
	{
		
		
		//new ContextLoader().InitProcess();
		
		//BaseHelper.Log(BaseHelper.ConfigValue("zsrnprcom.z.require"));
		
		
		
		
		
	}
	
	
	
}
