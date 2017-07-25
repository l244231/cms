package com.cms.core.commerce.commodity.dao;
import com.cms.core.commerce.commodity.domain.CommodityIconsDto;
import com.cms.core.commerce.common.dao.BaseDao;

public interface CommodityIconsDao extends BaseDao<CommodityIconsDto> {
	public boolean deleteByFileId(long id);
}