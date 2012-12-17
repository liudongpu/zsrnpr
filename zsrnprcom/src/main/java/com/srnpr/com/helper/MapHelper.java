package com.srnpr.com.helper;

import java.util.Iterator;
import java.util.Map;

import com.srnpr.com.entity.MapFormat;

public class MapHelper {

	
	
	
	
	public static MapFormat ToEntity(Map<String, String> map)
	{
		
		MapFormat mEntity=new MapFormat();
		
		Iterator<String> iterator=map.keySet().iterator();
		while (iterator.hasNext()) {
			String sKeyString=iterator.next();
			mEntity.getKeyList().add(sKeyString);
			mEntity.getValueList().add(map.get(sKeyString));
			
		}
		
		
		
		
		
		return mEntity;
		
	}
	
	
	
	
	
	
	
}
