/*
 * CommodityDiscountServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月13日  <br>
 */
package com.cms.core.commerce.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.commodity.dao.CommodityDiscountDao;
import com.cms.core.commerce.commodity.domain.CommodityDiscountDto;
import com.cms.core.commerce.commodity.service.CommodityDiscountService;
import com.cms.core.common.service.impl.BaseServiceImpl;

/** 
 * @Title:限时优惠
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月13日 上午12:35:06 Zain.Luo  <br> 
 * @History:
 */
@Service("CommodityDiscountService")
public class CommodityDiscountServiceImpl extends BaseServiceImpl<CommodityDiscountDto> implements CommodityDiscountService{
	@Autowired
	private CommodityDiscountDao commodityDiscountDao;
	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityDiscountService#updateStock(com.cms.core.commerce.commodity.domain.CommodityDiscountDto)
	 */
	@Override
	public void updateStock(CommodityDiscountDto dto) {
		commodityDiscountDao.updateStock(dto);
	}

}
