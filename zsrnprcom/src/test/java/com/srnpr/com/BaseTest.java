package com.srnpr.com;

import com.srnpr.com.helper.BaseHelper;

import junit.framework.TestCase;

public class BaseTest extends TestCase {

	
	
	public  void testBaseText()
	{
		BaseHelper.Log("test begin ");
	}
	
	
	
	public void  BaseTestLog(String sInfo) {
		BaseHelper.Log("BaseTestLog:"+sInfo);
	}
	
	
	
}
