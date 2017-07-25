/*
 * CommodityTrialServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月22日  <br>
 */
package com.cms.core.commerce.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.commodity.dao.CommodityTrialDao;
import com.cms.core.commerce.commodity.domain.CommodityTrialDto;
import com.cms.core.commerce.commodity.service.CommodityTrialService;
import com.cms.core.common.service.impl.BaseServiceImpl;

/**
 * @Title:TODO
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月22日 下午11:18:46 Zain.Luo <br>
 * @History:
 */
@Service("commodityTrialService")
public class CommodityTrialServiceImpl extends BaseServiceImpl<CommodityTrialDto> implements CommodityTrialService {
	
	@Autowired
	private CommodityTrialDao commodityTrialDao;

	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityTrialService#updateStatus(com.cms.core.commerce.commodity.domain.CommodityTrialDto)
	 */
	@Override
	public void updateStatus(CommodityTrialDto dto) {
		commodityTrialDao.updateStatus(dto);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityTrialService#updateIsHome(com.cms.core.commerce.commodity.domain.CommodityTrialDto)
	 */
	@Override
	public void updateIsHome(CommodityTrialDto dto) {
		commodityTrialDao.updateIsHome(dto);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityTrialService#updateStock(com.cms.core.commerce.commodity.domain.CommodityTrialDto)
	 */
	@Override
	public void updateStock(CommodityTrialDto dto) {
		commodityTrialDao.updateStock(dto);
	}

}
