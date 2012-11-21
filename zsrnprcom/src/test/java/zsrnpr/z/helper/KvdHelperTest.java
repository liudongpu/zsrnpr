package zsrnpr.z.helper;

import zsrnpr.z.entity.Kvd;
import junit.framework.TestCase;

public class KvdHelperTest extends TestCase {

	
	
	public void testKvd() {
		
		
		
		
		Kvd kvd=new Kvd("key","value");
		for(int i=0,j=100000;i<j;i++)
		{

			//kvd.Add("key1", "value1");
			
			kvd.Add("key"+String.valueOf(i), String.valueOf(i));
			
			//System.out.println(kvd.getC().get("key1").getV());
		}
		
		assertTrue(kvd.getC().get("key999").getV().equals("999"));
	}
	
	
	
	
}
