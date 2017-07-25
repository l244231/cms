/*
 * @(#)CommodityColor.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品颜色信息表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class CommodityColorDto  extends BaseEntity {
	 
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	
	/**
	 * 颜色名称
	 */
	private String colorName;
	
	/**
	 * 颜色名称
	 */
	private String colorNameEn;
	
	/**
	 * 价格变化值
	 */
	private double priceFluctuation;

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorNameEn() {
		return colorNameEn;
	}

	public void setColorNameEn(String colorNameEn) {
		this.colorNameEn = colorNameEn;
	}

	public double getPriceFluctuation() {
		return priceFluctuation;
	}

	public void setPriceFluctuation(double priceFluctuation) {
		this.priceFluctuation = priceFluctuation;
	}
}
