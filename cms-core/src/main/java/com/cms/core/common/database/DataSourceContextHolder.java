/*
 * @(#)DataSourceContextHolder.java
 * Author : Zain.Luo
 * Created Date: 2016年11月15日 
 */
package com.cms.core.common.database;

/**
 * @title 数据库切换工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年11月15日 Zain.Luo create file<br>
 *              Id:DataSourceContextHolder.java,v1.0 2016年11月15日 下午4:05:18
 */
public class DataSourceContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * @Title: setDbType
	 * @author: Zain.Luo
	 * @Description: 设置数据库源
	 * @param dbType
	 * @return void
	 * @throws @history:
	 *             2016年11月15日 created
	 */
	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	/**
	 * @Title: getDbType
	 * @author: Zain.Luo
	 * @Description: 获取数据源
	 * @return
	 * @return String
	 * @throws @history:
	 *             2016年11月15日 created
	 */
	public static String getDbType() {
		return ((String) contextHolder.get());
	}

	/**
	 * @Title: clearDbType
	 * @author: Zain.Luo
	 * @Description: 清空数据源
	 * @return void
	 * @throws @history:
	 *             2016年11月15日 created
	 */
	public static void clearDbType() {
		contextHolder.remove();
	}
}
