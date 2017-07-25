/*
 * @(#)SystemProperties.java
 * Author : Zain.Luo
 * Created Date: 2017年1月4日 
 */
package com.cms.core.common.properties;

import java.util.Properties;

/**
 * @title 系统配置类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月4日 Zain.Luo create file<br>
 *              Id:SystemProperties.java,v1.0 2017年1月4日 下午12:49:44
 */
public class SystemProperties {
	private static Properties pro;
	private static final PropertiesUtil PROPERTIES_UTIL = new PropertiesUtil("system-config.properties");

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
		synchronized (SystemProperties.class) {
			pro = PROPERTIES_UTIL.loadProperties();
		}
		return pro.getProperty(key);
	}

	/**
	 * @Title: getMediaUploadPath
	 * @author: Zain.Luo
	 * @Description: 获取视频/音频上传保存路径
	 * @return
	 * @return String
	 * @throws @history:
	 *             2017年1月4日 created
	 */
	public static String getMediaUploadPath() {
		return getProperties("mediaUploadPath");
	}

	/**
	 * @Title: getImageUploadPath
	 * @author: Zain.Luo
	 * @Description: 获取图片上传保存路径
	 * @return
	 * @return String
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	public static String getImageUploadPath() {
		return getProperties("imageUploadPath");
	}
	
	/** 
	* @Title: getAvUrl 
	* @author: Zain.Luo
	* @Description: 获取每日视听URL配置
	* @return    
	* @return String    
	* @throws 
	* @history: 2017年2月16日 created
	*/
	public static String getAvUrl(){
		return getProperties("av.url");
	}

	/**
	 * @Title:getImageMaxHeight
	 * @Author:Zain.Luo
	 * @Description:获取图片文件上传最大高度限制
	 * @return
	 * @Created:2017年1月6日 上午1:50:37<br>
	 * @History:
	 */
	public static int getImageMaxHeight() {
		String value = getProperties("imageMaxHeight");
		if (value == null || value == "") {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}

	/**
	 * @Title:getImageMaxWidth
	 * @Author:Zain.Luo
	 * @Description:获取图片文件上传最大宽度限制
	 * @return
	 * @Created:2017年1月6日 上午1:51:08<br>
	 * @History:
	 */
	public static int getImageMaxWidth() {
		String value = getProperties("imageMaxWidth");
		if (value == null || value == "") {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}

	/**
	 * @Title:getImageMaxWidth
	 * @Author:Zain.Luo
	 * @Description:获取图片文件上传最大宽度限制
	 * @param 配置项目名称
	 * @return
	 * @Created:2017年1月6日 上午1:51:08<br>
	 * @History:
	 */
	public static int getImageMaxWidth(String paramName) {
		String value = getProperties(paramName + "ImageMaxWidth");
		if (value == null || value == "") {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}

	/**
	 * @Title:getImageMaxHeight
	 * @Author:Zain.Luo
	 * @Description:获取图片文件上传最大高度限制
	 * @return
	 * @Created:2017年1月6日 上午1:50:37<br>
	 * @History:
	 */
	public static int getImageMaxHeight(String paramName) {
		String value = getProperties(paramName + "ImageMaxHeight");
		if (value == null || value == "") {
			return 0;
		} else {
			return Integer.parseInt(value);
		}
	}
}
