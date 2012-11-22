package zsrnpr.z.servlet;

import javax.servlet.ServletContext;
import zsrnpr.z.helper.BaseHelper;
import zsrnpr.z.system.StaticConst;

/**
 * @author srnpr
 *
 */
public class ContextLoader {

	
	
	/**
	 * @param servletContext servlet load
	 */
	public  void Init(ServletContext servletContext) {
		
		try {
			servletContext.log("Initializing zsrnpr");
			StaticConst.Const_RootPath=servletContext.getRealPath("")+"/";
			InitProcess(StaticConst.Const_RootPath);
			
		}
		catch(RuntimeException ex)
		{
			servletContext.log("Initializing zsrnpr Error"+ex.getMessage());
		}
		
		
	}
	
	/**
	 * @param sBasePath RootPath
	 * process
	 */
	void InitProcess(String sBasePath)
	{
		LogInfo("zsrnpr begin init");
		new zsrnpr.z.system.LoadConfig().LoadProperties(sBasePath+StaticConst.CONST_ZSRNPR_Z_PATH_STRING);
		//Reset rootpath
		BaseHelper.SetPPValue("zsrnpr.z.rootpath", sBasePath);
		LogInfo("zsrnpr.z.rootpath="+BaseHelper.GetPPValue("zsrnpr.z.rootpath"));
		LogInfo("zsrnpr.zrnprcom.version="+BaseHelper.GetPPValue("zsrnpr.zrnprcom.version"));	
	}
	
	
	
	
	/**
	 * @param sText Log info text
	 * system.out
	 */
	public  void LogInfo(String sText)
	{
		BaseHelper.Log("ZsrnprInit : " +sText);
	}
	
	
	
	
	
}
