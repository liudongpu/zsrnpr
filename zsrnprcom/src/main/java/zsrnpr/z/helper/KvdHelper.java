package zsrnpr.z.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import zsrnpr.z.entity.Kvd;

public class KvdHelper extends Kvd {

	
	public KvdHelper()
	{
		
	}
	public KvdHelper(String sKey,String sValue)
	{
		this(sKey, sValue, "");
	}
	public KvdHelper(String sKey,String sValue,String sDescription)
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
			//ConcurrentMap<String, Kvd> cMap=new ConcurrentMap<String, Kvd>();
		}
		
		//KvdHelper kh=new KvdHelper(sKey,sValue,sDescription);
		//this.getC().put(sKey,new KvdHelper(sKey, sValue,sDescription));
		
	}

	
	/**
	 * @param pStrings 传递按照Kvd三个分别传递 
	 */
	public void AddTwo(String... sStrings)
	{
		
	}
	
	public void AddThree(String...sStrings )
	{
		
	}
	
	
	public void GetValue(String sKey)
	{
		
		
		//ConcurrentHashMap<K, V>
		
	}
	
	
	
	
	
	
}
