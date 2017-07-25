/*
 * CommodityDiscountService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月13日  <br>
 */
package com.cms.core.commerce.commodity.service;

import com.cms.core.commerce.commodity.domain.CommodityDiscountDto;
import com.cms.core.common.service.BaseService;

/**
 * @Title:限时优惠service
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月13日 上午12:34:24 Zain.Luo <br>
 * @History:
 */
public interface CommodityDiscountService extends BaseService<CommodityDiscountDto> {
	/**
	 * @Title: updateStock
	 * @author: Zain.Luo
	 * @Description: 更新库存
	 * @param dto
	 * @return void
	 * @throws @history:
	 *             2017年1月17日 created
	 */
	public void updateStock(CommodityDiscountDto dto);
}
