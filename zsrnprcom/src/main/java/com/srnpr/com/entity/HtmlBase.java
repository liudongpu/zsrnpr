package com.srnpr.com.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	
	
}
