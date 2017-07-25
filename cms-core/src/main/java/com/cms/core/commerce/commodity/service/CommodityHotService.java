/*
 * CommodityHotService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月20日  <br>
 */
package com.cms.core.commerce.commodity.service;

import com.cms.core.commerce.commodity.domain.CommodityHotDto;
import com.cms.core.common.service.BaseService;

/** 
 * @Title:爆款商品Service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月20日 下午11:35:02 Zain.Luo  <br> 
 * @History:
 */
public interface CommodityHotService extends BaseService<CommodityHotDto>{
	/** 
	* @Title: addCommodityHot 
	* @author: Zain.Luo
	* @Description: 新增爆款商品
	* @param idList 商品ID列表
	* @return String 错误信息    
	* @throws 
	* @history: 2017年1月7日 created
	*/
	public String addCommodityHot(String idList);
}
