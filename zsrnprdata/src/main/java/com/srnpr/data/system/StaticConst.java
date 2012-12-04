package com.srnpr.data.system;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.jdbc.core.JdbcTemplate;

import com.srnpr.data.entity.TableInfo;

public class StaticConst {

	
	
	
	public final static HashMap<String, TableInfo> Const_Data_TableInfos=new HashMap<String, TableInfo>();
	
	public final static HashMap<String, JdbcTemplate> Const_Data_Map=new HashMap<String, JdbcTemplate>();
	
	public final static ConcurrentMap<String, String> Const_Data_Table_Server=new ConcurrentHashMap<String, String>();
	
}
