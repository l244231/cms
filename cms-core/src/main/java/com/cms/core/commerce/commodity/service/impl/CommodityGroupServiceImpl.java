package com.cms.core.commerce.commodity.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.commodity.dao.CommodityGroupDao;
import com.cms.core.commerce.commodity.domain.CommodityGroupDto;
import com.cms.core.commerce.commodity.service.CommodityGroupService;
import com.cms.core.common.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("commodityGroupService")
public class CommodityGroupServiceImpl extends BaseServiceImpl<CommodityGroupDto> implements CommodityGroupService {

	@Autowired
	private CommodityGroupDao commodityGroupDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	public PageInfo<Map> findCommodityGroupUserByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		// 分页
		PageHelper.startPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("limit").toString()), true);
		PageInfo<Map> page = new PageInfo<Map>((List<Map>)commodityGroupDao.findCommodityGroupUserByParams(params));

		return page;
	}

	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityGroupService#updateStock(com.cms.core.commerce.commodity.domain.CommodityGroupDto)
	 */
	@Override
	public void updateStock(CommodityGroupDto commodityGroupDto) {
		// TODO Auto-generated method stub
		commodityGroupDao.updateStock(commodityGroupDto);
	}

}
