package com.srnpr.com.system;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.srnpr.com.helper.BaseHelper;

public class CheckProperties {

	
	
	
	private ConcurrentHashMap<String, String> concurrentHashMap=new ConcurrentHashMap<String, String>();
	

	
	public PropertiesConfiguration AutoCheck(PropertiesConfiguration pOldProperties,PropertiesConfiguration pNewProperties) {
		return AutoCheck(pOldProperties,pNewProperties,true);
	}
	
	
	/**
	 * @param pOldProperties 源属性
	 * @param pNewProperties 将要比较的属性
	 * @return
	 */
	public PropertiesConfiguration AutoCheck(PropertiesConfiguration pOldProperties,PropertiesConfiguration pNewProperties,boolean bFlagOverride) {
		
		String sOverride=BaseHelper.PpValue("zsrnpr.z.override");
		
		int iLength=-1;
		if(bFlagOverride)
		{
			iLength=sOverride.length();
		}
	
		
		Iterator<String> em=pNewProperties.getKeys();
		while (em.hasNext()) {
			String sKeyString=(String)em.next();
			String sValueString=pNewProperties.getString(sKeyString);
			
			boolean bOverride=false;
			
			
			if(bFlagOverride&&iLength>0)
			{
				if(sValueString.startsWith(sOverride))
				{
					bOverride=true;
					sValueString=sOverride.substring(iLength);
				}
			}
			
			
			if(pOldProperties.containsKey(sKeyString))
			{
				if(bOverride)
				{
					pOldProperties.setProperty(sKeyString, sValueString);
				}
			}
			else {
				pOldProperties.setProperty(sKeyString, sValueString);
			}
		}
		
		Iterator<String> emOld=pOldProperties.getKeys();
		while (emOld.hasNext()) {
			String sKeyString=(String)emOld.next();
			concurrentHashMap.put(sKeyString, pOldProperties.getString(sKeyString));
		}
		return pOldProperties;
	}
	
	public void Put(PropertiesConfiguration properties)
	{
		Put(properties, concurrentHashMap);
	}
	
	public void Put(PropertiesConfiguration properties,ConcurrentHashMap<String, String> hashMap)
	{
		Iterator<String> em=properties.getKeys();
		while (em.hasNext()) {
			String sKeyString=(String)em.next();
			hashMap.put(sKeyString, properties.getString(sKeyString));
		}
	}
	
	
	
}
