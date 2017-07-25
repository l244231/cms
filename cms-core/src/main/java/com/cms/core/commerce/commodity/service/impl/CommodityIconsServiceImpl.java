/*
 * CommodityIconsServiceImpl.java  <br>
 * Author:lijx  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.commerce.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.commodity.dao.CommodityIconsDao;
import com.cms.core.commerce.commodity.domain.CommodityIconsDto;
import com.cms.core.commerce.commodity.service.CommodityIconsService;
import com.cms.core.common.service.impl.BaseServiceImpl;

/** 
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2017年1月10日 上午1:54:30 lijx  <br> 
 * @History:
 */
@Service("commodityIconsService")
public class CommodityIconsServiceImpl extends BaseServiceImpl<CommodityIconsDto> implements CommodityIconsService {

	@Autowired
	private CommodityIconsDao commodityIconsDao;
	
	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityIconsService#deleteByFileId(long)
	 */
	@Override
	public boolean deleteByFileId(long id) {
		// TODO Auto-generated method stub
		return commodityIconsDao.deleteByFileId(id);
	}

}
