package com.srnpr.com.convert;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.srnpr.com.helper.BaseHelper;

public class JsonConvert<T> {

	
	
	
	public String ObjToString(T oInput)
	{
		ObjectMapper om=new ObjectMapper ();
		
		String sResponseString=null;
		try {
			sResponseString=om.writeValueAsString(oInput);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sResponseString;
	}
	
	
	public T StringToObj(String sInput,T t)
	{
		//T t=null;
		
		ObjectMapper om=new ObjectMapper ();
		try {
			
			

			t=(T) om.readValue(sInput,t.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return t;
		
	}
	
	
}
