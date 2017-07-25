/*
 * CommodityService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月27日  <br>
 */
package com.cms.core.commerce.commodity.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.common.service.BaseService;

/**
 * @Title:商品Service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月27日 上午12:42:37 Zain.Luo <br>
 * @History:
 */
public interface CommodityService extends BaseService<CommodityDto> {
	
	/**
	 * @Title:updateCommodityStatus
	 * @Author:Zain.Luo
	 * @Description:根据ID更新商品状态
	 * @param params
	 *            id:商品ID status:待更新状态
	 * @return
	 * @Created:2016年12月28日 上午12:24:48<br>
	 * @History:
	 */
	public boolean updateCommodityStatus(Map<String, Object> params);
	
	/**
	 * 获取商品信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> getCommodityInfoMap(long id);
	
	/**
	 * 保存和更新商品
	 * @Title:saveAndUpdateCommodity
	 * @Author:lijx
	 * @Description:TODO
	 * @param request
	 * @param commodityDto
	 * @return 
	 * @Created:2017年1月12日  下午9:35:34<br>
	 * @History:
	 */
	public boolean saveAndUpdateCommodity(HttpServletRequest request, CommodityDto commodityDto);
	
	/**
	 * @Title:updateStock
	 * @Author:Zain.Luo
	 * @Description:更新库存
	 * @param dto 
	 * @Created:2017年1月18日  下午10:30:08<br>
	 * @History:
	 */
	public void updateStock(CommodityDto dto);
	
	/**
	 * 查找商品是否被使用
	 * @param params
	 * @return
	 */
	public String findCommodityIsHadUse(Map<String, Object> params);
}
