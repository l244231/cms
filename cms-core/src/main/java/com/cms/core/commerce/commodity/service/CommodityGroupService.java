package com.cms.core.commerce.commodity.service;

import java.util.Map;

import com.cms.core.commerce.commodity.domain.CommodityGroupDto;
import com.cms.core.common.service.BaseService;
import com.github.pagehelper.PageInfo;

public interface CommodityGroupService extends BaseService<CommodityGroupDto> {
	@SuppressWarnings("rawtypes")
	public PageInfo<Map> findCommodityGroupUserByParams(Map<String, Object> params);
	
	/**
	 * 更新库存
	 * @Title:updateStock
	 * @Author:lijx
	 * @Description:TODO
	 * @param commodityGroupDto 
	 * @Created:2017年1月18日  上午1:31:59<br>
	 * @History:
	 */
	public void updateStock(CommodityGroupDto commodityGroupDto);
}
