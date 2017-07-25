/*
 * @(#)DynamicDataSource.java
 * Author : Zain.Luo
 * Created Date: 2016年11月15日 
 */
package com.cms.core.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @title 动态切换数据源的工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年11月15日 Zain.Luo create file<br>
 *              Id:DynamicDataSource.java,v1.0 2016年11月15日 下午4:10:25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	 * determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDbType();
	}

}
