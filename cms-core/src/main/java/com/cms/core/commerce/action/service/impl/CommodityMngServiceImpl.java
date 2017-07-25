/*
 * CommodityMngServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月28日  <br>
 */
package com.cms.core.commerce.action.service.impl;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.core.commerce.action.service.CommodityMngService;
import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.commerce.commodity.domain.CommodityHistoryDto;
import com.cms.core.commerce.commodity.service.CommodityHistoryService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.common.util.LogMannger;

/**
 * @Title:商品管理逻辑service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月28日 上午12:37:02 Zain.Luo <br>
 * @History:
 */
@Service("commodityMngService")
public class CommodityMngServiceImpl implements CommodityMngService {
	private Logger logger  = LogMannger.getLogger();
	
	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CommodityHistoryService commodityHistoryService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.commerce.service.CommodityMngService#updateStatus(com.cms.
	 * core.commerce.service.Map)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public boolean updateStatus(Map<String, Object> params) {
		boolean status = false;
		try {
			status = commodityService.updateCommodityStatus(params);

			if (!status) {
				return status;
			}
			CommodityDto commodity = commodityService.findById(Long.parseLong(params.get("id").toString()));
			insertCommodityHistory(commodity);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新商品状态失败，原因：", e.getMessage());
			throw new RuntimeException("更新商品状态失败，原因：" + e.getMessage());
		}
		return status;
	}

	/**
	 * @Title:insertCommodityHistory
	 * @Author:Zain.Luo
	 * @Description:将商品信息插入历史表中
	 * @param commodity
	 * @Created:2016年12月28日 上午12:42:41<br>
	 * @History:
	 */
	public void insertCommodityHistory(CommodityDto commodity) {
		commodityHistoryService.insert(new CommodityHistoryDto(commodity));
	}

}
