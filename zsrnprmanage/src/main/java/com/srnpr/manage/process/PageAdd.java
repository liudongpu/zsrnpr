package com.srnpr.manage.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.HtmlUtils;
import org.w3c.dom.html.HTMLElement;

import com.srnpr.com.convert.JsonConvert;
import com.srnpr.com.helper.StringHelper;
import com.srnpr.data.entity.TableColumn;
import com.srnpr.data.entity.TableInfo;
import com.srnpr.data.helper.DataHelper;
import com.srnpr.operate.base.BPageHtml;

public class PageAdd extends BPageHtml {

	
	
	public String GetHtml(String sId)
	{
		
		String sTableIdString="zd_table";
		
		
		TableInfo tInfo=DataHelper.TableInfoGet(sTableIdString);
		
		StringBuilder sbBuilder=new StringBuilder();
		
		
		sbBuilder.append("<div></div>");
		
		sbBuilder.append(this.formHtml);
		
		List<String> lStrings=new ArrayList<String>();
		
		sbBuilder.append("<form id=\""+this.formId+"\">");
		
		sbBuilder.append("<table class=\"zmc_page_table\">");
		//Iterator<String> iKey=tInfo.getCloumns().keys();
		for(TableColumn tColumn :tInfo.getChildColumns())
		{
			lStrings.add(tColumn.getColumnName());
			
		
			sbBuilder.append("<tr><td class=\"left\">"+tColumn.getColumnDescription()+"</td><td><input id=\"zm_"+tColumn.getColumnName()+"\" name=\"zm_"+tColumn.getColumnName()+"\" data-dojo-type=\"dijit/form/TextBox\" />"+"</td></tr>");
	
			sbBuilder.append(String.format("%n"));
			
		}
		
		sbBuilder.append("</table>");
		
		//sbBuilder.append(StringHelper.Format(this.pageParam, StringHelper.Join(lStrings, ",")));
		
		sbBuilder.append("</form>");
		//Map<String, Object> map=DataHelper.QueryOne(sTableIdString, "*", "zid","1000200000000000001");
		
		JsonConvert<TableInfo> jConvert=new JsonConvert<TableInfo>();

		
		sbBuilder.append(StringHelper.Format(this.pageParam, HtmlUtils.htmlEscape(jConvert.ObjToString(tInfo))));
		
		return sbBuilder.toString();
		
	}
	
	
	
	
	
	
	
	
}
