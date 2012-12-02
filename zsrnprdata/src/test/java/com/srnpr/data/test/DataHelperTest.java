package com.srnpr.data.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.srnpr.com.helper.BaseHelper;
import com.srnpr.data.BaseTest;
import com.srnpr.data.system.StaticConst;

public class DataHelperTest extends BaseTest  {

	
	
	public void testDataCall()
	{

		List<Map<String, Object>> listObjsList= StaticConst.Const_Data_Map.get("common").queryForList("select * from zd_table limit 0,1");
 
		for(Map<String, Object> map: listObjsList)
		{
			
			Iterator<String> iterator =  map.keySet().iterator();
			while (iterator.hasNext()) {
				
				String sKeyString=iterator.next();
				BaseHelper.Log(sKeyString+":"+map.get(sKeyString));
			}
		}
		
	
		
		
	}
	
}
