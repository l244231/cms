package com.cms.core.common.util;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 主键生成工具
 * 
 * @Title: CreateSequenceKey.java
 * @Company SHANGHAI MIAOMI MDT INFO TECH LTD.
 * @Description: TODO
 * @author luyi
 * @date 2015年2月7日 上午10:20:02
 * @version V1.0
 */
public class CreateSequenceKey
{
	static Long time = System.currentTimeMillis();
	
	/**
	 * 获取唯一主键ID
	 *
	 * @return
	 */
	public static String getIndexNum(String flag)
	{
		String indexCode = flag + Long.toHexString(time++).toUpperCase();
		return indexCode;
	}
	
	public static String getIndexNumEx(String flag)
	{
		if(flag == null || flag.length() < 1)
		{
			flag = "";
		}
	    Long num = System.currentTimeMillis();
	    SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String str=flag+bartDateFormat.format(num);
		return str;
	}
	
	public static String getValidationCode()
	{
		Random r = new Random(); 
		Double d = r.nextDouble(); 
		String s = d + ""; 
		s = s.substring(3,3+6); 
		return s;
	}
}


 