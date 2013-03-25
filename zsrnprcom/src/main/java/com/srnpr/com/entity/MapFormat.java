package com.srnpr.com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MapFormat extends ConcurrentHashMap<String, String> {

	
	
	
	
	private List<String> keyList=new ArrayList<String>();
	
	
	public List<String> getKeyList() {
		return keyList;
	}


	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}


	public List<String> getValueList() {
		return valueList;
	}


	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}


	private List<String> valueList=new ArrayList<String>();
	
	
	
	
	
	
}
