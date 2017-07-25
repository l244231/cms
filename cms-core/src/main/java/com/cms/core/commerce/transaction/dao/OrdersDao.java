package com.cms.core.commerce.transaction.dao;

import java.util.Map;

import com.cms.core.commerce.common.dao.BaseDao;
import com.cms.core.commerce.transaction.domain.OrdersDto;

public interface OrdersDao extends BaseDao<OrdersDto> {

	/**
	 * @Title:updateOrdersStatus
	 * @Author:Zain.Luo
	 * @Description:更新订单状态
	 * @param params
	 *            orderNo:订单号 <br>
	 *            status:订单状态
	 * @return 是否更新成功
	 * @Created:2016年12月26日 下午10:34:21<br>
	 * @History:
	 */
	public boolean updateOrdersStatus(Map<String, Object> params);

}