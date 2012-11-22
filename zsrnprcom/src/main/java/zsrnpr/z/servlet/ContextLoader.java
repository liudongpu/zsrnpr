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
		
		
		if(BaseHelper.PpValueContains("zsrnpr.z.pluging"))
		{
			
			LogInfo(this.getClass().getClassLoader().getResource("").toString());
			//LogInfo(this.getClass().getClassLoader().getResource("zsrnpr.zfile.config.config-zsrnprcom.xml").toString());
			
			
		}
		
		
		
		//Reset rootpath
		BaseHelper.PpValueSet("zsrnpr.z.rootpath", sBasePath);
		LogInfo("zsrnpr.z.rootpath="+BaseHelper.PpValueGet("zsrnpr.z.rootpath"));
		LogInfo("zsrnpr.z.version="+BaseHelper.PpValueGet("zsrnpr.zrnprcom.version"));	
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
