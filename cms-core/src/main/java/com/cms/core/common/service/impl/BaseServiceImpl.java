package com.cms.core.common.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.common.dao.BaseDao;
import com.cms.core.common.entity.BaseEntity;
import com.cms.core.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("baseService")
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	/**
	 * 暂只做逻辑删除，修改状态为5
	 */
	@Override
	public boolean delete(long id) {
		T entity = baseDao.findById(id);
		short status = 5;
		entity.setStatus(status);
		entity.setLastModified(new Date());
		baseDao.update(entity);
		return true;
	}

	@Override
	public T findById(long id) {
		return baseDao.findById(id);
	}

	public T findByParams(Map<String,Object> params){
		return baseDao.findByParams(params);
	}
	@Override
	public List<T> findAllList() {
		return baseDao.findAllList();
	}

	@Override
	public PageInfo<T> findListByPage(Map<String, Object> params) {

		// 分页
		PageHelper.startPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("limit").toString()));
		PageInfo<T> page = new PageInfo<T>(baseDao.findListByPage(params));

		return page;

	}

	@Override
	public long insert(T entity) {
		return baseDao.insert(entity);
	}

	@Override
	public long update(T entity) {
		return baseDao.update(entity);
	}

	@Override
	public List<T> findAllListByParams(Map<String, Object> params) {
		return baseDao.findAllListByParams(params);
	}

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
	@SuppressWarnings("rawtypes")
	public PageInfo<Map> findListByParams(Map<String, Object> params) {
		// 分页
		PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("limit").toString()), true);
		PageInfo<Map> page = new PageInfo<Map>((List<Map>) baseDao.findListByParams(params));

		return page;

	}
	
	public List<Map> findMapListByParams(Map<String,Object> params){
		return baseDao.findListByParams(params);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.common.service.BaseService#countByParams(java.util.Map)
	 */
	@Override
	public int countByParams(Map<String, Object> params) {
		return baseDao.countByParams(params);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.common.service.BaseService#deleteByParams(java.util.Map)
	 */
	@Override
	public boolean deleteByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseDao.deleteByParams(params);
	}
	
	public Map queryByParams(Map<String,Object> params){
		return baseDao.queryByParams(params);
	}
	
}
