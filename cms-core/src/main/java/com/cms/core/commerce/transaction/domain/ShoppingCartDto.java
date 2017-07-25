/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 购物车表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class ShoppingCartDto extends BaseEntity {

	/** * 用户id */
	private long userId;
	/** * 商品id */
	private long commondityId;
	/** * 商品颜色 */
	private String color;
	/** * 商品颜色ID */
	private long colorId;
	/** * 商品规格ID */
	private long specId;
	/** * 商品规格 */
	private String spec;
	/** * 购买数量 */
	private long qty;
	/** * 价格 */
	private double price;
	/** * 实际价格 */
	private double priceActual;
	/** * 添加时间 */
	private Date creationTime;
	/** * 商品来源 */
	private String type;
	/** * 活动ID */
	private String relativeId;

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the commondityId
	 */
	public long getCommondityId() {
		return commondityId;
	}

	/**
	 * @param commondityId
	 *            the commondityId to set
	 */
	public void setCommondityId(long commondityId) {
		this.commondityId = commondityId;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the colorId
	 */
	public long getColorId() {
		return colorId;
	}

	/**
	 * @param colorId
	 *            the colorId to set
	 */
	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	/**
	 * @return the specId
	 */
	public long getSpecId() {
		return specId;
	}

	/**
	 * @param specId
	 *            the specId to set
	 */
	public void setSpecId(long specId) {
		this.specId = specId;
	}

	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * @param spec
	 *            the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * @return the qty
	 */
	public long getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(long qty) {
		this.qty = qty;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the priceActual
	 */
	public double getPriceActual() {
		return priceActual;
	}

	/**
	 * @param priceActual
	 *            the priceActual to set
	 */
	public void setPriceActual(double priceActual) {
		this.priceActual = priceActual;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime
	 *            the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
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
	 * @param relativeId
	 *            the relativeId to set
	 */
	public void setRelativeId(String relativeId) {
		this.relativeId = relativeId;
	}

}
