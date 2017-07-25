/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 订单折扣表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class OrdersDiscountDto extends BaseEntity {
	 
	/** * 订单号 */
	private String orderNo;
	/** * 折扣id */
	private long discountId;
	/** * 折扣信息 */
	private String discountDescription;
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the discountId
	 */
	public long getDiscountId() {
		return discountId;
	}
	/**
	 * @param discountId the discountId to set
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
	 * @param discountDescription the discountDescription to set
	 */
	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}
	
	
}
