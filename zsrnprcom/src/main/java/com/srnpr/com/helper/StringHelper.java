package com.srnpr.com.helper;

import java.util.Collection;
import java.util.Iterator;

public class StringHelper {

	/**
	 * 转换函数
	 * @param str  
	 * @param args
	 * @return
	 */
	public static String Format(String str,Object ... args)
	{
		//这里用于验证数据有效性  
        if(str==null||"".equals(str))  
            return "";  
        if(args.length==0)  
        {  
            return str;  
        }  
  
        /* 
         *如果用于生成SQL语句，这里用于在字符串前后加单引号 
        for(int i=0;i<args.length;i++) 
        { 
            String type="java.lang.String"; 
            if(type.equals(args[i].getClass().getName())) 
                args[i]="'"+args[i]+"'"; 
        } 
        */  
  
        String result=str;  
  
        //这里的作用是只匹配{}里面是数字的子字符串  
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\{(\\d+)\\}");  
        java.util.regex.Matcher m = p.matcher(str);  
  
        while(m.find())  
        {  
            //获取{}里面的数字作为匹配组的下标取值  
            int index=Integer.parseInt(m.group(1));  
  
            //这里得考虑数组越界问题，{1000}也能取到值么？？  
            if(index<args.length)  
            {  
  
                //替换，以{}数字为下标，在参数数组中取值  
                result=result.replace(m.group(),args[index].toString());  
            }  
        }  
        return result;  
	}
	
	
	
	public static String Join(Collection<?> s, String delimiter) {
	    StringBuffer buffer = new StringBuffer();
	    Iterator<?> iter = s.iterator();
	    while (iter.hasNext()) {
	        buffer.append(iter.next());
	            buffer.append(delimiter);
	        
	    }

	    return buffer.substring(0,buffer.length()-delimiter.length());
	}
	
	
	
	
	
}
