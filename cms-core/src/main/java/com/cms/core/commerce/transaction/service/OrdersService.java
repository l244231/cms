/*
 * OrdersService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月26日  <br>
 */
package com.cms.core.commerce.transaction.service;

import java.util.Map;

import com.cms.core.commerce.transaction.domain.OrdersDto;
import com.cms.core.common.service.BaseService;

/**
 * @Title:订单service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月26日 下午10:32:15 Zain.Luo <br>
 * @History:
 */
public interface OrdersService extends BaseService<OrdersDto> {
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
