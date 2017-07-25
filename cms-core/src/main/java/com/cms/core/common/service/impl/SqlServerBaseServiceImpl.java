package com.cms.core.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.cms.core.commerce.common.dao.BaseDao;
import com.cms.core.common.entity.BaseEntity;
import com.cms.core.common.service.SqlServerBaseService;

@Service("SqlServerBaseService")
public class SqlServerBaseServiceImpl<T extends BaseEntity> implements SqlServerBaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	/**
	 * 暂只做逻辑删除，修改状态为5
	 */
	@Override
	public boolean delete(long id) {
		return baseDao.delete(id);
	}

	@Override
	public T findById(long id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAllList() {
		return baseDao.findAllList();
	}

	@Override
	public PageInfo<T> findListByPage(Map<String, Object> params) {
		PageInfo<T> pageInfo = new PageInfo<T>();
		// 分页
		pageInfo.setTotal(baseDao.countListByParams(params));
		pageInfo.setList(baseDao.findListByPage(params));
		return pageInfo;

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
		PageInfo<Map> pageInfo = new PageInfo<Map>();
		// 分页
		pageInfo.setTotal(baseDao.countListByParams(params));
		pageInfo.setList(baseDao.findListByParams(params));
		return pageInfo;

	}

	/* (non-Javadoc)
	 * @see com.cms.core.common.service.SqlServerBaseService#countByParams(java.util.Map)
	 */
	@Override
	public int countByParams(Map<String, Object> params) {
		return baseDao.countByParams(params);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.common.service.SqlServerBaseService#queryByParams(java.util.Map)
	 */
	@Override
	public Map queryByParams(Map<String, Object> params) {
		return baseDao.queryByParams(params);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.common.service.SqlServerBaseService#findByParams(java.util.Map)
	 */
	@Override
	public T findByParams(Map<String, Object> params) {
		return baseDao.findByParams(params);
	}
 
}
