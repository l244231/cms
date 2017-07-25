/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品规格信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommoditySpecDto extends BaseEntity {
 
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 规格名称
	 */
	private String specName;
	/**
	 * 规格名称
	 */
	private String specNameEn;
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
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpecNameEn() {
		return specNameEn;
	}
	public void setSpecNameEn(String specNameEn) {
		this.specNameEn = specNameEn;
	}
	public double getPriceFluctuation() {
		return priceFluctuation;
	}
	public void setPriceFluctuation(double priceFluctuation) {
		this.priceFluctuation = priceFluctuation;
	}
}