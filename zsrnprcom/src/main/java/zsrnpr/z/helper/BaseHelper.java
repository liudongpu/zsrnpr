package zsrnpr.z.helper;

import zsrnpr.z.system.StaticConst;

public  abstract  class BaseHelper {

	public final static void Log(String sLogInfo) {
		System.out.println(sLogInfo);
	}
	
	
	public final static String  GetPPValue(String sKey) {
		return StaticConst.Const_Zsrnpr_PP.get(sKey);
	}
	
	public  final static void SetPPValue(String sKey,String sValue) {
		StaticConst.Const_Zsrnpr_PP.put(sKey, sValue);
	}
	
	public final static boolean SetPPValueCheck(String sKey,String sValue)
	{
		if(StaticConst.Const_Zsrnpr_PP.containsKey(sKey))
		{
			return false;
		}
		else
		{
			SetPPValue(sKey, sValue);
			return true;
		}
	}
	
	
	
	
}
