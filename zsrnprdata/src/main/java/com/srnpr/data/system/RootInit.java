package com.srnpr.data.system;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.srnpr.com.helper.BaseHelper;
import com.srnpr.com.inface.IRootInit;
import com.srnpr.com.system.RootInitBase;

import com.srnpr.data.entity.TableColumn;
import com.srnpr.data.entity.TableInfo;

public class RootInit extends RootInitBase implements IRootInit {

	
	
	
	
	public void InitDataBase()
	{
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(BaseHelper.ConfigValue("zsrnprdata.springroot"));
    	
    	com.mchange.v2.c3p0.ComboPooledDataSource cm=(com.mchange.v2.c3p0.ComboPooledDataSource)ctx.getBean(BaseHelper.ConfigValue("zsrnprdata.beanbasedatasource"));

    	try {
			cm.setDriverClass(BaseHelper.PpValue("zsrnpr.z.zsrnprdata.jdbcclass"));
			cm.setJdbcUrl(BaseHelper.PpValue("zsrnpr.z.zsrnprdata.jdbcurl"));
			cm.setUser(BaseHelper.PpValue("zsrnpr.z.zsrnprdata.jdbcuser"));
			cm.setPassword(BaseHelper.PpValue("zsrnpr.z.zsrnprdata.jdbcpasswd"));
			
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JdbcTemplate jdbcTemplate=new JdbcTemplate(cm);
    	StaticConst.Const_Data_Map.put(BaseHelper.PpValue("zsrnpr.z.zsrnprdata"),jdbcTemplate);
    	
    	
    	
    	List<Map<String, Object>> lServerMaps=jdbcTemplate.queryForList("select * from zd_table");
    	
    	BaseHelper.Log( lServerMaps.size()) ;
    	
    	
    	jdbcTemplate.queryForList("select * from zd_table");
    	
    		
	}
	
	
	public void InitDataServer()
	{
		List<Map<String, Object>> lServerMaps=StaticConst.Const_Data_Map.get(BaseHelper.PpValue("zsrnpr.z.zsrnprdata")).queryForList("select * from zd_server");

		try {
			for(Map<String, Object> mapServer:lServerMaps)
			{
				com.mchange.v2.c3p0.ComboPooledDataSource cm=new ComboPooledDataSource();
				cm.setDriverClass((String) mapServer.get("class"));
				cm.setJdbcUrl((String) mapServer.get("source"));
				cm.setUser((String) mapServer.get("user"));
				cm.setPassword((String) mapServer.get("password"));
				
				JdbcTemplate jdbcTemplate=new JdbcTemplate(cm);
		    	StaticConst.Const_Data_Map.put((String)mapServer.get("code"),jdbcTemplate);
			}	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void InitDataTable()
	{
		List<Map<String, Object>> lServerMaps=StaticConst.Const_Data_Map.get(BaseHelper.PpValue("zsrnpr.z.zsrnprdata")).queryForList("select * from zd_table");

		for(Map<String, Object> mapTable:lServerMaps)
		{
			
			TableInfo tiInfo=new TableInfo();
			tiInfo.setTableName(String.valueOf( mapTable.get("name")));
			tiInfo.setTableDescription(String.valueOf( mapTable.get("description")));
			
			
			for(Map<String, Object> mapColumn:StaticConst.Const_Data_Map.get(BaseHelper.PpValue("zsrnpr.z.zsrnprdata")).queryForList("select * from zd_table_column where fid=?",mapTable.get("zid")))
			{
				TableColumn tColumn=new TableColumn();
				tColumn.setColumnName((String)mapColumn.get("name"));
				tColumn.setColumnDescription((String)mapColumn.get("description"));
				tiInfo.getCloumns().put(tColumn.getColumnName(), tColumn);
			}     

			
			StaticConst.Const_Data_Table_Server.put(tiInfo.getTableName(), String.valueOf(mapTable.get("server_code")));
		}
		
		
	}
	
	
	
	
	
	
	
	

	public void Init() {
		
		
		
		
		InitDataBase();
		
		InitDataServer();
		
		InitDataTable();
		
		
	}
	
	
	
	
}
