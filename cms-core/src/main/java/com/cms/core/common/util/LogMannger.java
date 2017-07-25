/*
 * @(#)LogMannger.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @title log4j管理内 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2016年12月13日 Zain.Luo create file<br>
 * Id:LogMannger.java,v1.0 2016年12月13日 上午11:20:44
 */
public class LogMannger{
	 
	/** 
	* @Title: getLogger 
	* @author: Zain.Luo
	* @Description: 获取logger对象
	* @return    
	* @return Logger    
	* @throws 
	* @history: 2016年12月13日 created
	*/
	public static Logger getLogger() {
		return LogManager.getLogger("baseLogger");
	}
	
	public static <T> Logger getLogger(Class<T> objClass) {
		return LogManager.getLogger(objClass);
	}
}
