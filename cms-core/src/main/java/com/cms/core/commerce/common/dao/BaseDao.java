package com.cms.core.commerce.common.dao;

import java.util.List;
import java.util.Map;

import com.cms.core.common.entity.BaseEntity;

/**
 * 
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月17日 下午10:24:09 lijx <br>
 * @History:
 */
public interface BaseDao<T extends BaseEntity> {
	long insert(T entity);

	long update(T entity);

	boolean delete(long id);

	T findById(long id);
	
	T findByParams(Map<String,Object> params);

	List<T> findAllList();

	List<T> findAllListByParams(Map<String, Object> params);

	List<T> findListByPage(Map<String, Object> params);

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
	public List<Map> findListByParams(Map<String, Object> params);
	
	/**
	 * @Title:countListByParams
	 * @Author:Zain.Luo
	 * @Description: 通过参数查询总记录数
	 * @param params 查询参数
	 * @return 记录数
	 * @Created:2017年1月3日  下午9:33:55<br>
	 * @History:
	 */
	public long countListByParams(Map<String,Object> params);
	
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
	
	Map queryByParams(Map<String,Object> params);
	
	public boolean deleteByParams(Map<String,Object> params);
	
}
