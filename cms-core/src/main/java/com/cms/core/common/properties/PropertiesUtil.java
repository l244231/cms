/*
 * @(#)PropertiesUtil.java
 * Author : Zain.Luo
 * Created Date: 2017年1月4日 
 */
package com.cms.core.common.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.cms.core.common.util.LogMannger;

/**
 * @title Properties配置文件工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月4日 Zain.Luo create file<br>
 *              Id:PropertiesUtil.java,v1.0 2017年1月4日 下午12:32:57
 */
public class PropertiesUtil {
	private Logger logger = LogMannger.getLogger();

	private final String defaultPath = "C:\\CMS\\";
	/**
	 * 配置文件名
	 */
	private String location = "";
	/**
	 * 配置文件信息
	 */
	private Properties prop;
	/**
	 * 最近读取时间
	 */
	private static long lastReadedTime = 0; 

	public PropertiesUtil() {
	}

	public PropertiesUtil(String fileName) {
		location = defaultPath + fileName;
		initProperties();
		if (prop == null) {
			location = fileName;
			initProperties();
		}
	}

	/**
	 * 从配置文件中读取数据
	 */
	private void initProperties() {
		logger.debug("进入初始化");
		synchronized (PropertiesUtil.class) {
			if (System.currentTimeMillis() - lastReadedTime > 60000) {
				logger.debug("60秒判断");
				InputStreamReader fis = null;
				try {
					logger.debug("加载配置文件:" + location);
					ClassLoader classloader = Thread.currentThread().getContextClassLoader();
					fis = new InputStreamReader(classloader.getResourceAsStream(location),"UTF-8");
					prop = new Properties();
					prop.load(fis);
					lastReadedTime = System.currentTimeMillis();

				} catch (FileNotFoundException e) {
					logger.error("无法找到文件{}，原因:{}" + location, e.getMessage());
				} catch (IOException e) {
					logger.error("无法读取文件{}，原因:{}" + location, e.getMessage());
				} catch (Exception e) {
					logger.error("读取文件异常{}，原因:{}" + location, e.getMessage());
				} finally {
					if (fis != null)
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		}

	}

	/**
	 * @Title: loadProperties
	 * @author: Zain.Luo
	 * @Description: 加载配置文件
	 * @return 配置文件信息
	 * @return Properties
	 * @throws @history:
	 *             2017年1月4日 created
	 */
	public Properties loadProperties() {
		initProperties();
		return prop;
	}
}
