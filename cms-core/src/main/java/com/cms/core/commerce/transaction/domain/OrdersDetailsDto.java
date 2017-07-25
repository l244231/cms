/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 订单详情表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class OrdersDetailsDto extends BaseEntity {
	/** * 订单号 */
	private String orderNo;
	/** * 商品ID */
	private long commodityId;
	/** * 商品数量 */
	private long quantity;
	/** * 颜色 */
	private String color;
	/** * 规格 */
	private String spec;
	/** * 价格 */
	private double amount;
	/** * 实际价格 */
	private double amountActual;
	/** * 商品来源 */
	private String type;
	/** * 活动ID */
	private String relativeId;
	/** * 用户ID */
	private String userId;
	/** * 颜色ID */
	private String colorId;
	/** * 规格ID */
	private String specId;
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
	 * @return the commodityId
	 */
	public long getCommodityId() {
		return commodityId;
	}
	/**
	 * @param commodityId the commodityId to set
	 */
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}
	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the amountActual
	 */
	public double getAmountActual() {
		return amountActual;
	}
	/**
	 * @param amountActual the amountActual to set
	 */
	public void setAmountActual(double amountActual) {
		this.amountActual = amountActual;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the relativeId
	 */
	public String getRelativeId() {
		return relativeId;
	}
	/**
	 * @param relativeId the relativeId to set
	 */
	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the colorId
	 */
	public String getColorId() {
		return colorId;
	}
	/**
	 * @param colorId the colorId to set
	 */
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	/**
	 * @return the specId
	 */
	public String getSpecId() {
		return specId;
	}
	/**
	 * @param specId the specId to set
	 */
	public void setSpecId(String specId) {
		this.specId = specId;
	}

}
