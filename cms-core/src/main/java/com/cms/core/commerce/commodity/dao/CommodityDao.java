package com.cms.core.commerce.commodity.dao;
import java.util.Map;

import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.commerce.common.dao.BaseDao;
import com.github.pagehelper.PageInfo;
public interface CommodityDao extends BaseDao<CommodityDto> {
	
	/**
	 * @Title:updateCommodityStatus
	 * @Author:Zain.Luo
	 * @Description:根据ID更新商品状态
	 * @param params 
	 * 		id:商品ID
	 * 		status:待更新状态
	 * @return 
	 * @Created:2016年12月28日  上午12:24:48<br>
	 * @History:
	 */
	public boolean updateCommodityStatus(Map<String,Object> params);
	
	/**
	 * @Title:findListByParams
	 * @Author:Zain.Luo
	 * @Description:查询非爆款商品，通过params查询条件进行过滤
	 * @param params
	 *            查询条件
	 * @return
	 * @Created:2016年12月21日 上午12:24:52<br>
	 * @History:
	 */
	public PageInfo<Map> findUnHotListByParams(Map<String, Object> params);
	
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
	public Map findCommodityIsHadUse(Map<String, Object> params);
}