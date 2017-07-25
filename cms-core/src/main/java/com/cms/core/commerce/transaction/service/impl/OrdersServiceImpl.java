/*
 * OrdersServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月26日  <br>
 */
package com.cms.core.commerce.transaction.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.commerce.transaction.dao.OrdersDao;
import com.cms.core.commerce.transaction.domain.OrdersDto;
import com.cms.core.commerce.transaction.service.OrdersService;
import com.cms.core.common.service.impl.BaseServiceImpl;

/**
 * @Title:订单service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月26日 下午10:33:07 Zain.Luo <br>
 * @History:
 */
@Service("ordersService")
public class OrdersServiceImpl extends BaseServiceImpl<OrdersDto> implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.transaction.service.OrdersService#updateOrdersStatus(java.
	 * util.Map)
	 */
	@Override
	public boolean updateOrdersStatus(Map<String, Object> params) {
		return ordersDao.updateOrdersStatus(params);
	}

}
