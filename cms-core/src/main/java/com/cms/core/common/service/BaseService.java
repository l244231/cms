package com.cms.core.common.service;

import java.util.List;
import java.util.Map;

import com.cms.core.common.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月17日 下午10:24:09 lijx <br>
 * @History:
 */
public interface BaseService<T extends BaseEntity> {
	long insert(T entity);

	long update(T entity);

	boolean delete(long id);

	T findById(long id);
	
	T findByParams(Map<String,Object> params);

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
	
	public List<Map> findMapListByParams(Map<String,Object> params);
	
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
	public int countByParams(Map<String,Object> params);
	
	/**
	 * 根据参数进行删除
	 * @Title:deleteByParams
	 * @Author:lijx
	 * @Description:TODO
	 * @param params 
	 * @Created:2017年1月12日  上午12:41:12<br>
	 * @History:
	 */
	public boolean deleteByParams(Map<String,Object> params);
	
	Map queryByParams(Map<String,Object> params);
}
