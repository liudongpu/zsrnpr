package com.srnpr.data.execute;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import com.srnpr.com.entity.MapEntity;
import com.srnpr.data.process.DataTemplete;

public class DataExecute {

	
	private String tableName="";
	
	public DataExecute(String sTableInfo)
	{
		tableName=sTableInfo;
	}
	
	
	public int Insert(MapEntity cParams)
	{
		return DataTemplete.Insert(tableName, cParams);
	}
	
	
	
	public  List<MapEntity> QueryRows(String sRows) {
		
		return DataTemplete.QueryHashMap(tableName, sRows);
	}
	
	
	
	
}
