/*
 * @(#)SystemProperties.java
 * Author : Zain.Luo
 * Created Date: 2017年1月4日 
 */
package com.cms.core.common.properties;

import java.util.Properties;

/**
 * @title 根据key查询对应的映射关系
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月4日 Zain.Luo create file<br>
 *              Id:SystemProperties.java,v1.0 2017年1月4日 下午12:49:44
 */
public class ParamsMappingUtil {
	private static Properties pro;
	private static final PropertiesUtil PROPERTIES_UTIL = new PropertiesUtil("param-mapping.properties");

	/**
	 * @Title: getProperties
	 * @author: Zain.Luo
	 * @Description: 通过参数名获取配置参数
	 * @param key
	 *            配置参数key
	 * @return string 配置参数value
	 * @throws @history:
	 *             2017年1月4日 created
	 */
	private static String getProperties(String key) {
		synchronized (ParamsMappingUtil.class) {
			pro = PROPERTIES_UTIL.loadProperties();
		}
		return pro.getProperty(key);
	}

	/**
	 * @Title: getMappingByKey
	 * @author: Zain.Luo
	 * @Description: 根据key值，找到对应的配置信息
	 * @param key
	 * @return String 映射值
	 * @throws @history:
	 *             2017年1月7日 created
	 */
	public static String getMappingStringByKey(String key) {
		String result = getProperties(key);
		result = result == null ? "" : result;
		return result;
	}

	/**
	 * @Title: getMappingByteByKey
	 * @author: Zain.Luo
	 * @Description: 根据key值，找到对应的配置信息
	 * @param key
	 * @return
	 * @return byte[] 映射数组
	 * @throws @history:
	 *             2017年1月7日 created
	 */
	public static String getMappingByteByKey(String key) {
		String result = getProperties(key);
		result = result == null ? "" : result;
		return result;
	}

}
