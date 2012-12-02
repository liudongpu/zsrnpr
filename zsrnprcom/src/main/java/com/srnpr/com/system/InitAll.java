package com.srnpr.com.system;

import com.srnpr.com.inface.IRootInit;

public class InitAll implements IRootInit {

	
	/**
	 * 标记是否已经初始化加载
	 */
	private static boolean initFlag=false;
	
	
	public void Init() {
		
		if(!initFlag)
		{
				
			new RootInit().Init();
			initFlag=true;
		}
		

	}

}
