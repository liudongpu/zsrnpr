package com.srnpr.data.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.srnpr.com.helper.BaseHelper;
import com.srnpr.data.entity.TableInfo;
import com.srnpr.data.system.StaticConst;

public class DataHelper {

	
	public static TableInfo TableInfoGet(String sTableName)
	{
		return StaticConst.Const_Data_TableInfos.get(sTableName);
	}
	
	
	
	
	
	
	public static List<ConcurrentMap<String, String>> QueryHashMap(String sTableName,String sRows) {
		
		
		 List<ConcurrentMap<String, String>> listReturnConcurrentMaps=new  ArrayList<ConcurrentMap<String, String>>();
		 
		 for(Map<String, Object> con: QueryList(sTableName, sRows))
		 {
			 ConcurrentMap<String, String> cMap=new ConcurrentHashMap<String, String>();
			 
			 Iterator<String> iterator=con.keySet().iterator();
			 while (iterator.hasNext()) {
				String sKeString=iterator.next();
				cMap.put(sKeString, con.get(sKeString).toString());
				
			}
			 
			 
			 listReturnConcurrentMaps.add(cMap);
		 }
		
		return listReturnConcurrentMaps;
	}
	
	public static Map<String, Object> QueryOne(String sTableName,String sRows,Object... args)
	{
		return QueryList(sTableName,sRows,"",-1,-1,args).get(0);
	}
	
	public static List<Map<String, Object>> QueryList(String sTableName,String sRows,Object... args)
	{
		return QueryList(sTableName,sRows,"",-1,-1,args);
	}
	
	public static List<Map<String, Object>> QueryList(String sTableName,String sRows,String sOrder,int start,int end,Object... args)
	{
		
		StringBuilder sBuilder=new StringBuilder();
		
		sBuilder.append("select ");
		if(!sRows.isEmpty()&&sRows.equals("*"))
		{
			sBuilder.append(sRows);
		}
		else
		{
			sBuilder.append(" * ");
		}
		
		sBuilder.append(" from "+sTableName);
		
		Object[] oArgsObjects=new Object[args.length%2];
		
		
		if(start>-1&&end>0)
		{
			sBuilder.append(" limit "+start+","+end);
		}
		
		BaseHelper.Log(sBuilder.toString());
		
		return StaticConst.Const_Data_Map.get(StaticConst.Const_Data_Table_Server.get(sTableName)).queryForList(sBuilder.toString(),oArgsObjects);
	}
	
	
	
	
	
	
	
}
