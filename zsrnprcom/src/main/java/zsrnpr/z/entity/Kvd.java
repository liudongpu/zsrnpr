package zsrnpr.z.entity;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

 /**
 * @author srnpr
 * Base Entity Kvd
 *
 */
public class Kvd extends KvdBase implements Serializable  {

	
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
