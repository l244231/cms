/*
 * @(#)LoggerUtil.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @title lo4j日志工具类包 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2016年12月13日 Zain.Luo create file<br>
 * Id:LoggerUtil.java,v1.0 2016年12月13日 上午10:48:13
 */
public class LoggerUtil {
	private static Logger logger = LogManager.getLogger("baseLogger");
	
	/** 
	* @Title: debug 
	* @author: Zain.Luo
	* @Description: debug日志输出
	* @param msg    
	* @return void    
	* @throws 
	* @history: 2016年12月13日 created
	*/
	public static void debug(String msg){
		logger.debug(msg);
	}
	
	/** 
	* @Title: trace 
	* @author: Zain.Luo
	* @Description: trace日志输出
	* @param msg    
	* @return void    
	* @throws 
	* @history: 2016年12月13日 created
	*/
	public static void trace(String msg){
		logger.trace(msg);
	}
	
	/** 
	* @Title: info 
	* @author: Zain.Luo
	* @Description: info日志输出
	* @param msg    
	* @return void    
	* @throws 
	* @history: 2016年12月13日 created
	*/
	public static void info(String msg){
		logger.info(msg);
	}
	
	/** 
	* @Title: error 
	* @author: Zain.Luo
	* @Description: error日志输出
	* @param msg    
	* @return void    
	* @throws 
	* @history: 2016年12月13日 created
	*/
	public static void error(String msg){
		logger.error(msg);
	}
}
