package com.srnpr.manage.process;

import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.metadata.Column;

import com.srnpr.data.entity.TableColumn;
import com.srnpr.data.entity.TableInfo;
import com.srnpr.data.helper.DataHelper;

public class PageAdd {

	
	
	public String GetHtml(String sId)
	{
		
		String sTableIdString="zd_table";
		
		
		TableInfo tInfo=DataHelper.TableInfoGet(sTableIdString);
		
		StringBuilder sbBuilder=new StringBuilder();
		
		
		sbBuilder.append("<div></div>");
		
		
		sbBuilder.append("<table class=\"zmc_page_table\">");
		//Iterator<String> iKey=tInfo.getCloumns().keys();
		for(TableColumn tColumn :tInfo.getChildColumns())
		{
			sbBuilder.append("<tr><td class=\"left\">"+tColumn.getColumnDescription()+"</td><td><input id=\"zm_"+tColumn.getColumnName()+"\" name=\"zm_"+tColumn.getColumnName()+"\" data-dojo-type=\"dijit/form/TextBox\" />"+"</td></tr>");
		}
		
		sbBuilder.append("</table>");
		
		
		

		//Map<String, Object> map=DataHelper.QueryOne(sTableIdString, "*", "zid","1000200000000000001");
		
		
		return sbBuilder.toString();
		
	}
	
	
	
	
	
	
	
	
}
