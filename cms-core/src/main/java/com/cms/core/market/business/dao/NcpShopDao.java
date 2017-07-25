/*
 * @(#)NcpShopDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月30日 
 */
package com.cms.core.market.business.dao;

import java.util.List;
import java.util.Map;

import com.cms.core.commerce.common.dao.BaseDao;
import com.cms.core.market.business.domain.NcpShopDto;

/**
 * @title 商铺Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月30日 Zain.Luo create file<br>
 *              Id:NcpShopDao.java,v1.0 2016年12月30日 上午10:40:29
 */
public interface NcpShopDao extends BaseDao<NcpShopDto> {
	public List<Map<String, Object>> queryNcpShop();

	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新商铺表状态
	 * @param params
	 * @Created:2017年1月10日 下午10:47:34<br>
	 * @History:
	 */
	public void updateStatus(Map<String, Object> params);
	
	/**
	 * @Title:findByIdFull
	 * @Author:Zain.Luo
	 * @Description:根据ID查询原始数据
	 * @param id
	 * @return 
	 * @Created:2017年2月27日  上午12:15:30<br>
	 * @History:
	 */
	public NcpShopDto findByIdFull(long id);
}
