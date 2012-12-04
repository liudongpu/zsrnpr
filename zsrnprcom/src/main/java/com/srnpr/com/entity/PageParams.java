package com.srnpr.com.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PageParams {

	
	private ConcurrentMap<String, String> params=new ConcurrentHashMap<String, String>();

	public ConcurrentMap<String, String> getParams() {
		return params;
	}

	public void setParams(ConcurrentMap<String, String> params) {
		this.params = params;
	}
	
	
}
