package zsrnpr.z.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

 /**
 * @author srnpr
 * Base Entity Kvd
 *
 */
public class Kvd extends KvdBase {

	
	public Kvd()
	{
		
	}
	public Kvd(String sKey,String sValue)
	{
		this(sKey, sValue, "");
	}
	public Kvd(String sKey,String sValue,String sDescription)
	{
		this.setK(sKey);
		this.setV(sValue);
		this.setD(sDescription);
	}
	
	public ConcurrentMap<String, Kvd> getC() {
		return c;
	}


	public void setC(ConcurrentMap<String, Kvd> c) {
		this.c = c;
	}

	private  ConcurrentMap<String, Kvd> c;
	

	
	public void Add(String sKey,String sValue)
	{
		this.Add(sKey, sValue,"");
	}
	
	public void Add(String sKey,String sValue,String sDescription)
	{
		if(this.getC()==null)
		{
			this.setC(new ConcurrentHashMap<String, Kvd>());
		}
		this.getC().put(sKey,new Kvd(sKey, sValue,sDescription));
	}

	
	
}
