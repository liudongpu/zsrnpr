package com.srnpr.com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class ResultGrid extends ResultBase {

	
	
	
	private List<MapEntity> data=new ArrayList<MapEntity>();

	public List<MapEntity> getData() {
		return data;
	}

	public void setData(List<MapEntity> data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private int count=-1;
	
	private int index=-1;
	
	private int size=10;
	
	
	private List<ConcurrentMap<String, String>> layout=new ArrayList<ConcurrentMap<String,String>>();

	public List<ConcurrentMap<String, String>> getLayout() {
		return layout;
	}

	public void setLayout(List<ConcurrentMap<String, String>> layout) {
		this.layout = layout;
	}

	
}
