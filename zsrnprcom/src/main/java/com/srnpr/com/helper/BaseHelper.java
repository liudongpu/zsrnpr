package com.srnpr.com.helper;

import com.srnpr.com.system.*;

public  abstract  class BaseHelper {

	public final static void Log(String sLogInfo) {
		
		System.out.println(sLogInfo);
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
	
	
	
	
}
