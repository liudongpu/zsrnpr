package com.srnpr.com.html;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.srnpr.com.entity.HtmlBase;
import com.srnpr.com.enumer.EnumerHtml;

public class HtmlItem extends HtmlBase {

	
	public HtmlItem(EnumerHtml tag)
	{
		this(tag.toString(), "");
	}
	
	public HtmlItem(EnumerHtml tag,String sId)
	{
		this(tag.toString(), sId);
	}
	public HtmlItem(EnumerHtml tag,String sId,String sValue)
	{
		this(tag.toString(), sId);
		switch (tag) {
		case hidden:
			AddProperty("value", sValue);
			break;
		default:
			this.setText(sValue);
			break;
		}
	}
	
	public HtmlItem(String sTag,String sId)
	{
		if(sTag.equals("hidden")||sTag.equals("text"))
		{
			this.setTag("input");
			AddProperty("type",sTag);
		}
		else
		{
			this.setTag(sTag);
		}
		
		if(!StringUtils.isEmpty(sId))
		{
			this.setId(sId);
		}
		
		
		
		
	}
	public HtmlItem AddItem(EnumerHtml enumerHtml)
	{
		
		HtmlItem hReturnItem=new HtmlItem(enumerHtml);
		
		this.getChild().add(hReturnItem);
		return hReturnItem;
	}
	
	
	public HtmlItem AddItem(HtmlItem hItem)
	{
		this.getChild().add(hItem);
		return hItem;
	}
	
	public void AddProperty(String sKey,String sValue)
	{
		this.getProperty().put(sKey, sValue);
	}
	
	
	public String ToHtml()
	{
		return ToHtml(this,0);
	}
	
	
	public String ToHtml(int iDeep)
	{
		return ToHtml(this,iDeep);
	}
	
	
	
	public String ToHtml(HtmlItem hItem,int iDeep)
	{
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append(String.format("%n"));
		
		if(iDeep>0)
		{
			for(int i=0;i<iDeep;i++)
			{
				sBuilder.append(" ");
			}
		}
		
		if(!StringUtils.isEmpty(hItem.getId()))
		{
			AddProperty("id", hItem.getId());
		}
		if(!StringUtils.isEmpty(hItem.getCss()))
		{
			AddProperty("class", hItem.getCss());
		}
		
		sBuilder.append("<"+hItem.getTag());
		Iterator<String> iterator=hItem.getProperty().keySet().iterator();
		
		while (iterator.hasNext()) {
			String sNameString=iterator.next();
			sBuilder.append(" "+sNameString+"=\""+hItem.getProperty().get(sNameString)+"\"");
			
		}
		
		
		if(hItem.getChild().size()==0&&StringUtils.isEmpty(hItem.getText()))
		{
			
			sBuilder.append("/>");
			//sBuilder.append(String.format("%n"));
		}
		else
		{
		
		sBuilder.append(">");
		
		for(HtmlBase hChildHtmlItem:hItem.getChild())
		{
			//sBuilder.append(String.format("%n"));
			sBuilder.append(((HtmlItem)hChildHtmlItem).ToHtml(iDeep+1));
		}
		
		if(!StringUtils.isEmpty(hItem.getText()))
		{
			sBuilder.append(hItem.getText());
		}
		
		if(hItem.getChild().size()>0)
		{
			sBuilder.append(String.format("%n"));
			if(iDeep>0)
			{
				for(int i=0;i<iDeep;i++)
				{
					sBuilder.append(" ");
				}
			}
		}
		
		
		
			sBuilder.append("</"+hItem.getTag()+">");
		}
		
		
		return sBuilder.toString();
	}
	
	
}
