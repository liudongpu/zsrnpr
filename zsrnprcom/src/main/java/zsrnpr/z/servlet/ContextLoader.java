package zsrnpr.z.servlet;

import javax.servlet.ServletContext;
import zsrnpr.z.helper.BaseHelper;

public class ContextLoader {

	
	
	public  void Init(ServletContext servletContext) {
		
		try {
			
			servletContext.log("Initializing zsrnpr");
			LogInfo("begin init");
			
			
			
			
			
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
