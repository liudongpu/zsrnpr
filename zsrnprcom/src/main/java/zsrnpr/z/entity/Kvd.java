package zsrnpr.z.entity;

import java.util.List;

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


	private String v="";
	
	private String d="";
	
	

	private List<Kvd> c=null;

	public List<Kvd> getC() {
		return c;
	}

	public void setC(List<Kvd> c) {
		this.c = c;
	}
	
	
	
}
