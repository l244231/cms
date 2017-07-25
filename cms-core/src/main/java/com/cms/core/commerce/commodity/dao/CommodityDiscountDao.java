package com.cms.core.commerce.commodity.dao;
import com.cms.core.commerce.commodity.domain.CommodityDiscountDto;
import com.cms.core.commerce.common.dao.BaseDao;
public interface CommodityDiscountDao extends BaseDao<CommodityDiscountDto> {
	/** 
	* @Title: updateStock 
	* @author: Zain.Luo
	* @Description: 更新库存
	* @param dto    
	* @return void    
	* @throws 
	* @history: 2017年1月17日 created
	*/
	public void updateStock(CommodityDiscountDto dto);
}