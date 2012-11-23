package com.srnpr.com.entity;

import java.util.concurrent.ConcurrentMap;

public class KvdBase {

	public ConcurrentMap<String, Kvd> getC() {
		return c;
	}


	public void setC(ConcurrentMap<String, Kvd> c) {
		this.c = c;
	}

	private  ConcurrentMap<String, Kvd> c;
	
	
	
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
	

	
	
}
