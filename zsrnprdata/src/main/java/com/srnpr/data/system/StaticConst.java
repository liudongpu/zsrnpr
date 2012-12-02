package com.srnpr.data.system;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.jdbc.core.JdbcTemplate;

public class StaticConst {

	
	
	
	
	
	public final static HashMap<String, JdbcTemplate> Const_Data_Map=new HashMap<String, JdbcTemplate>();
	
	public final static ConcurrentMap<String, String> Const_Data_Table_Server=new ConcurrentHashMap<String, String>();
	
}
