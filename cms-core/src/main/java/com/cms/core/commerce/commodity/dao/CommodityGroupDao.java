package com.cms.core.commerce.commodity.dao;
import java.util.List;
import java.util.Map;

import com.cms.core.commerce.commodity.domain.CommodityGroupDto;
import com.cms.core.commerce.common.dao.BaseDao;

public interface CommodityGroupDao extends BaseDao<CommodityGroupDto> {
	@SuppressWarnings("rawtypes")
	public List<Map> findCommodityGroupUserByParams(Map<String, Object> params);
	
	public void updateStock(CommodityGroupDto commodityGroupDto);
}