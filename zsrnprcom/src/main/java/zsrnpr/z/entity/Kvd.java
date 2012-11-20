package zsrnpr.z.entity;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

 /**
 * @author srnpr
 * Base Entity Kvd
 *
 */
public class Kvd {

	
	
	/**
	 * 
	 */
	private String k="";
	
	public String getK() {
		return k;
	}


	public void setK(String k) {
		this.k = k;
	}


	public String getV() {
		return v;
	}


	public void setV(String v) {
		this.v = v;
	}


	public String getD() {
		return d;
	}


	public void setD(String d) {
		this.d = d;
	}


	public ConcurrentMap<String, Kvd> getC() {
		return c;
	}


	public void setC(ConcurrentMap<String, Kvd> c) {
		this.c = c;
	}


	private String v="";
	
	private String d="";
	
	

	
	
	private ConcurrentMap<String, Kvd> c;
	
	
	
	
	
}
