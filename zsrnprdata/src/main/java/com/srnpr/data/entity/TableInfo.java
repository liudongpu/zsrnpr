package com.srnpr.data.entity;

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


	public ConcurrentHashMap<String, TableColumn> getCloumns() {
		return cloumns;
	}


	public void setCloumns(ConcurrentHashMap<String, TableColumn> cloumns) {
		this.cloumns = cloumns;
	}


	private String tableDescription="";
	
	
	private ConcurrentHashMap<String, TableColumn> cloumns=new ConcurrentHashMap<String, TableColumn>();
	
	
	
	
	
	
}
