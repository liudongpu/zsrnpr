package zsrnpr.z.helper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import zsrnpr.z.entity.Kvd;

public class KvdHelper extends Kvd {

	
	public KvdHelper()
	{
		
	}
	public KvdHelper(String sKey,String sValue)
	{
		this.setK(sKey);
		this.setV(sValue);
	}
	
	
	
	public void AddChildren(String sKey,String sValue)
	{
		if(this.getC()==null)
		{
			//this.setC(new List<Kvd>());
		}
	}
	
	
	/**
	 * @param pStrings 传递按照Kvd三个分别传递 
	 */
	public void AddChildrenMore(String... pStrings)
	{
		
	}
	
	
	
	
	
}
