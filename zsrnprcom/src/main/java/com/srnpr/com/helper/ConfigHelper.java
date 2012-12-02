package com.srnpr.com.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


import com.srnpr.com.system.StaticConst;



public class ConfigHelper {
	
	
	public final static String  ConfigValueGet(String sKey) {
		return StaticConst.Const_Zsrnpr_Config.get(sKey);
	}
	
	public  final static void ConfigValueSet(String sKey,String sValue) {
		StaticConst.Const_Zsrnpr_Config.put(sKey, sValue);
	}
	
	public final static boolean ConfigValueContains(String sKey)
	{
		return StaticConst.Const_Zsrnpr_Config.containsKey(sKey);
	}
	
	
	public final static boolean ConfigValueSetCheck(String sKey,String sValue)
	{
		if(StaticConst.Const_Zsrnpr_Config.containsKey(sKey))
		{
			return false;
		}
		else
		{
			ConfigValueSet(sKey, sValue);
			return true;
		}
	}
	
	
	public final static String  PpValueGet(String sKey) {
		return StaticConst.Const_Zsrnpr_PP.get(sKey);
	}
	
	public  final static void PpValueSet(String sKey,String sValue) {
		StaticConst.Const_Zsrnpr_PP.put(sKey, sValue);
	}
	
	public final static boolean PpValueContains(String sKey)
	{
		return StaticConst.Const_Zsrnpr_PP.containsKey(sKey);
	}
	
	
	public final static boolean PpValueSetCheck(String sKey,String sValue)
	{
		if(StaticConst.Const_Zsrnpr_PP.containsKey(sKey))
		{
			return false;
		}
		else
		{
			PpValueSet(sKey, sValue);
			return true;
		}
	}
	
	
	public final static List<String> GetListFromHash(ConcurrentHashMap<String, String> concurrentHashMap,String sArrayIndex) {
		
		List<String> rList=new ArrayList<String>();
		
		String sValueString=concurrentHashMap.get(sArrayIndex);
		
		if(sValueString.equals("")||sValueString.equals("[]"))
		{
			int iNowIndex=0;
			while (concurrentHashMap.containsKey(sArrayIndex+"."+iNowIndex)) {
				rList.add(concurrentHashMap.get(sArrayIndex+"."+iNowIndex));
				iNowIndex++;
			}
		}
		
		
		
		
		return rList;
		
	}
	
	

}
