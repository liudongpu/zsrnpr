package com.srnpr.com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HtmlBase {

	
	
	private String tag="";
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<HtmlBase> getChild() {
		return child;
	}

	public void setChild(List<HtmlBase> child) {
		this.child = child;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	private String id="";
	
	private List<HtmlBase> child=new ArrayList<HtmlBase>();
	
	private String css="";
	
	private ConcurrentMap<String, String> property=new ConcurrentHashMap<String, String>();

	public ConcurrentMap<String, String> getProperty() {
		return property;
	}

	public void setProperty(ConcurrentMap<String, String> property) {
		this.property = property;
	}
	
	
	
	
	
}
