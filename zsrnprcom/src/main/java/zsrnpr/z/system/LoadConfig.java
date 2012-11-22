package zsrnpr.z.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class LoadConfig {

	
	
	public void LoadConfig() {
		
		
	}
	
	
	public void LoadProperties(String sPath)
	{
		Properties properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream(sPath);
			properties.load(fis);
			
			Enumeration em=properties.propertyNames();
			while (em.hasMoreElements()) {
				String sKeyString=(String)em.nextElement();
				StaticConst.Const_Zsrnpr_PP.put(sKeyString, properties.getProperty(sKeyString));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
