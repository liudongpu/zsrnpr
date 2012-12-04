package com.srnpr.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TableInfo {

	
	private String tableName="";
	
	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getTableDescription() {
		return tableDescription;
	}


	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}


	


	public List<TableColumn> getChildColumns() {
		return childColumns;
	}


	public void setChildColumns(List<TableColumn> childColumns) {
		this.childColumns = childColumns;
	}





	private String tableDescription="";
	
	
	
	
	private List<TableColumn> childColumns=new ArrayList<TableColumn>();
	
	
	
	
	
}
