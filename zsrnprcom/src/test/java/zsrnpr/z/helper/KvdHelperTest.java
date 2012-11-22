package zsrnpr.z.helper;

import zsrnpr.z.entity.Kvd;
import junit.framework.TestCase;
import java.beans.*;
import java.io.*;

public class KvdHelperTest extends TestCase {

	
	
	public void testKvd() {
		
		
		
		/*
		Kvd kvd=new Kvd("key","value");
		for(int i=0,j=100000;i<j;i++)
		{

			//kvd.Add("key1", "value1");
			
			kvd.Add("key"+String.valueOf(i), String.valueOf(i));
			
			//System.out.println(kvd.getC().get("key1").getV());
		}
		
		assertTrue(kvd.getC().get("key999").getV().equals("999"));
		*/
	}
	
	
	public void testSe() throws IOException
	{
		/*
		Kvd kvd=new Kvd("key","value");
		for(int i=0,j=20;i<j;i++)
		{
			kvd.Add("key"+String.valueOf(i), String.valueOf(i));
		}
		FileOutputStream fOutputStream=new FileOutputStream("src\\test\\config\\xx.xml");
		XMLEncoder xEncoder=new XMLEncoder(fOutputStream) ;
		xEncoder.writeObject(kvd);
		xEncoder.flush();
		fOutputStream.close();
		
		String fileStr="src\\test\\config\\xx.xml";//XML文件，在本目录下，延用上次使用文件。

	      
	       FileInputStream fStream=new FileInputStream(fileStr);

	       XMLDecoder xmld=new XMLDecoder(fStream);//创建一个XMLDecoder对象。

	       Kvd pu=(Kvd)xmld.readObject();//通过XMLDecoder中的readObject方法获得PrintUnit对象。
	       fStream.close();
	       
	       BaseHelper.Log(String.valueOf( pu.getC().get("key05").getV()));
	       */
	}
	
	
	
	
	
}
