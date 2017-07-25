/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 订单商品折扣表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class OrdersDetailDiscountDto extends BaseEntity {

	/** * 订单详情id */
	private long ordersDetailId;
	/** * 折扣id */
	private long discountId;
	/** * 折扣信息 */
	private String discountDescription;

	/**
	 * @return the ordersDetailId
	 */
	public long getOrdersDetailId() {
		return ordersDetailId;
	}

	/**
	 * @param ordersDetailId
	 *            the ordersDetailId to set
	 */
	public void setOrdersDetailId(long ordersDetailId) {
		this.ordersDetailId = ordersDetailId;
	}

	/**
	 * @return the discountId
	 */
	public long getDiscountId() {
		return discountId;
	}

	/**
	 * @param discountId
	 *            the discountId to set
	 */
	public void setDiscountId(long discountId) {
		this.discountId = discountId;
	}

	/**
	 * @return the discountDescription
	 */
	public String getDiscountDescription() {
		return discountDescription;
	}

	/**
	 * @param discountDescription
	 *            the discountDescription to set
	 */
	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

}
