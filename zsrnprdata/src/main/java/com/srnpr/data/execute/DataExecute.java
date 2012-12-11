package com.srnpr.data.execute;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import com.srnpr.data.helper.DataHelper;

public class DataExecute {

	
	private String tableName="";
	
	public DataExecute(String sTableInfo)
	{
		tableName=sTableInfo;
	}
	
	
	public int Insert(ConcurrentMap<String, String> cParams)
	{
		
		
		
		return 0;
	}
	
	
	
	public  List<ConcurrentMap<String, String>> QueryRows(String sTableName,String sRows) {
		
		return DataHelper.QueryHashMap(sTableName, sRows);
	}
}
