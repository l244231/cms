/*
 * SqlServerBaseService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月3日  <br>
 */
package com.cms.core.common.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

/** 
 * @Title:Sqlserver基础service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月3日 下午9:23:37 Zain.Luo  <br> 
 * @History:
 */
public interface SqlServerBaseService<T> {
	long insert(T entity);

	long update(T entity);

	boolean delete(long id);

	T findById(long id);

	List<T> findAllList();

	List<T> findAllListByParams(Map<String, Object> params);

	PageInfo<T> findListByPage(Map<String, Object> params);

	/**
	 * @Title:findListByParams
	 * @Author:Zain.Luo
	 * @Description:查询分布，通过params查询条件进行过滤
	 * @param params
	 *            查询条件
	 * @return
	 * @Created:2016年12月21日 上午12:24:52<br>
	 * @History:
	 */
	PageInfo<Map> findListByParams(Map<String, Object> params);
	
	/** 
	* @Title: countByParams 
	* @author: Zain.Luo
	* @Description: 计数
	* @param params
	* @return    
	* @return int    
	* @throws 
	* @history: 2017年1月7日 created
	*/
	int countByParams(Map<String,Object> params);
	
	Map queryByParams(Map<String,Object> params);
	
	T findByParams(Map<String,Object> params);
	
} 
