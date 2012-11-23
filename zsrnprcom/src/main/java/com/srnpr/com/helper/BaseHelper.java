package com.srnpr.com.helper;

import com.srnpr.com.system.*;

/**
 * @author srnpr
 *	系统核心基础类  
 */
public  abstract  class BaseHelper {

	public final static void Log(String sLogInfo) {
		
		System.out.println(sLogInfo);
	}
	
	public final static String  ConfigValue(String sKey) {
		return StaticConst.Const_Zsrnpr_Config.get(sKey);
	}


	public final static String  PpValue(String sKey) {
		return StaticConst.Const_Zsrnpr_PP.get(sKey);
	}
	
	
	
	/**
	 * @param sKey
	 * @return 日常信息拼装
	 */
	public final static String MessageValue(String sKey)
	{
		return StaticConst.Const_Zsrnpr_Language.get(sKey);
	}
	
	public final static boolean StringIsNull(String string)
	{
		return string.isEmpty();
	}
	
}
