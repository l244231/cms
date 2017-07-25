/*
 * CommodityTrialService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月22日  <br>
 */
package com.cms.core.commerce.commodity.service;

import java.util.Map;

import com.cms.core.commerce.commodity.domain.CommodityTrialDto;
import com.cms.core.common.service.BaseService;

/**
 * @Title: 试用商品Service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月22日 下午11:17:50 Zain.Luo <br>
 * @History:
 */

public interface CommodityTrialService extends BaseService<CommodityTrialDto> {
	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新状态
	 * @param dto
	 * @Created:2017年1月17日 下午11:36:06<br>
	 * @History:
	 */
	void updateStatus(CommodityTrialDto dto);

	/**
	 * @Title:updateIsHome
	 * @Author:Zain.Luo
	 * @Description:更新推荐首页
	 * @param dto
	 * @Created:2017年1月17日 下午11:36:33<br>
	 * @History:
	 */
	void updateIsHome(CommodityTrialDto dto);

	/**
	 * @Title:updateStock
	 * @Author:Zain.Luo
	 * @Description:更新库存
	 * @param dto
	 * @Created:2017年1月18日 下午10:30:08<br>
	 * @History:
	 */
	void updateStock(CommodityTrialDto dto);

}
