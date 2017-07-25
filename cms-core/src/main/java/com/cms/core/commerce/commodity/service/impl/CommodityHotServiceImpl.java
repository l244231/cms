/*
 * CommodityHotServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月20日  <br>
 */
package com.cms.core.commerce.commodity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.core.commerce.commodity.dao.CommodityDao;
import com.cms.core.commerce.commodity.dao.CommodityHotDao;
import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.commerce.commodity.domain.CommodityHotDto;
import com.cms.core.commerce.commodity.service.CommodityHotService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.common.service.impl.BaseServiceImpl;

/**
 * @Title:爆款商品Service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月20日 下午11:36:41 Zain.Luo <br>
 * @History:
 */
@Service("commodityHotService")
public class CommodityHotServiceImpl extends BaseServiceImpl<CommodityHotDto> implements CommodityHotService {
	@Autowired
	private CommodityHotDao commodityHotDao;
	
	@Autowired
	private CommodityDao commodityDao;
	
	/* (non-Javadoc)
	 * @see com.cms.core.commerce.commodity.service.CommodityHotService#addCommodityHot(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public String addCommodityHot(String idList) {
		String[] idArray = idList.split(",");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", 1);
		CommodityHotDto hotDto = null;
		for(int i=0;i<idArray.length;i++){
			params.put("commodityId", Long.parseLong(idArray[i]));
			hotDto = commodityHotDao.findByParams(params);
			if(hotDto != null){
				CommodityDto dto = commodityDao.findById(Long.parseLong(idArray[i]));
				throw new RuntimeException("爆款榜单中已存在商品：【"+dto.getName()+"】");
			}
			hotDto = new CommodityHotDto();
			hotDto.setCommodityId(Long.parseLong(idArray[i]));
			hotDto.setHomeRecommended(CommodityConstant.CommodityIsHome.IS_NOT_HOME);
			hotDto.setCreationTime(new Date());
			hotDto.setLastModified(new Date());
			hotDto.setSortId(0);
			hotDto.setStatus((short) 1);
			commodityHotDao.insert(hotDto);
		}
		return null;
	}
}
