package zsrnpr.z.servlet;

import javax.servlet.ServletContext;
import zsrnpr.z.helper.BaseHelper;
import zsrnpr.z.system.StaticConst;

public class ContextLoader {

	
	
	public  void Init(ServletContext servletContext) {
		
		try {
			
			servletContext.log("Initializing zsrnpr");
			LogInfo("begin init");
			
			
			new zsrnpr.z.system.LoadConfig().LoadProperties(StaticConst.CONST_ZSRNPR_Z_PATH_STRING);
			
			LogInfo("zsrnpr.zrnprcom.version="+StaticConst.Const_Zsrnpr_PP.get("zsrnpr.zrnprcom.version"));
			
			
			
		}
		catch(RuntimeException ex)
		{
			servletContext.log("Initializing zsrnpr Error"+ex.getMessage());
		}
		
		
	}
	
	
	public  void LogInfo(String sText)
	{
		BaseHelper.Log("ZsrnprInit : " +sText);
	}
	
	
	
	
	
}
