package com.cms.core.commerce.commodity.dao;
import com.cms.core.commerce.commodity.domain.CommodityTrialDto;
import com.cms.core.commerce.common.dao.BaseDao;
public interface CommodityTrialDao extends BaseDao<CommodityTrialDto> {
	
	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新状态
	 * @param dto 
	 * @Created:2017年1月17日  下午11:36:06<br>
	 * @History:
	 */
	public void updateStatus(CommodityTrialDto dto);
	
	
	/**
	 * @Title:updateIsHome
	 * @Author:Zain.Luo
	 * @Description:更新推荐首页
	 * @param dto 
	 * @Created:2017年1月17日  下午11:36:33<br>
	 * @History:
	 */
	public void updateIsHome(CommodityTrialDto dto);
	
	/**
	 * @Title:updateStock
	 * @Author:Zain.Luo
	 * @Description:更新库存
	 * @param dto 
	 * @Created:2017年1月18日  下午10:30:08<br>
	 * @History:
	 */
	public void updateStock(CommodityTrialDto dto);
}