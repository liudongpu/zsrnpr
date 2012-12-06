package com.srnpr.com.html;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.srnpr.com.entity.HtmlBase;
import com.srnpr.com.enumer.EnumerHtml;

public class HtmlItem extends HtmlBase {

	
	
	
	public HtmlItem(EnumerHtml tag,String sId)
	{
		switch (tag) {
		case hidden:
			this.setTag("input");
			AddProperty("type", tag.toString());
			break;
		default:
			this.setTag(tag.toString());
			break;
		}
		
		if(!StringUtils.isEmpty(sId))
		{
			this.setId(sId);
		}
		
		
	}
	
	
	public void AddItem(HtmlItem hItem)
	{
		this.getChild().add(hItem);
	}
	
	public void AddProperty(String sKey,String sValue)
	{
		this.getProperty().put(sKey, sValue);
	}
	
	
	public String ToHtml()
	{
		return ToHtml(this);
	}
	
	
	
	
	
	
	public String ToHtml(HtmlItem hItem)
	{
		StringBuilder sBuilder=new StringBuilder();
		if(!StringUtils.isEmpty(hItem.getId()))
		{
			AddProperty("id", hItem.getId());
		}
		if(!StringUtils.isEmpty(hItem.getCss()))
		{
			AddProperty("class", hItem.getCss());
		}
		
		sBuilder.append("<"+hItem.getTag()+" ");
		Iterator<String> iterator=hItem.getProperty().keySet().iterator();
		
		while (iterator.hasNext()) {
			String sNameString=iterator.next();
			sBuilder.append(sNameString+"=\""+hItem.getProperty().get(sNameString)+"\" ");
			
		}
		sBuilder.append(">");
		
		for(HtmlBase hChildHtmlItem:hItem.getChild())
		{
			sBuilder.append(((HtmlItem)hChildHtmlItem).ToHtml());
		}
		
		sBuilder.append("</"+hItem.getTag()+">");
		
		
		
		return sBuilder.toString();
	}
	
	
}
