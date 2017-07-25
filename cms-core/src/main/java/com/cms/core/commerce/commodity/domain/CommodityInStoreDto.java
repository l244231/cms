/*
 * @(#)CommodityInStoreDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月8日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品入库记录表DTO 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月8日 Zain.Luo create file<br>
 * Id:CommodityInStoreDto.java,v1.0 2017年1月8日 下午4:40:09
 */
public class CommodityInStoreDto extends BaseEntity{
	/**
	 * 商品ID
	 */
	private long commodityId;
	/**
	 * 入库数量
	 */
	private long inStoreAmount;
	/**
	 * 批次号
	 */
	private String batchNumber = System.currentTimeMillis()+"";
	/**
	 * 库存数量
	 */
	private long storeAmount;
	/**
	 * 入库时间
	 */
	private Date inStoreTime;
	
	/**
	 * 类型
	 */
	private short type;
	/**
	 * 活动ID
	 */
	private long relativeId;
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public long getInStoreAmount() {
		return inStoreAmount;
	}
	public void setInStoreAmount(long inStoreAmount) {
		this.inStoreAmount = inStoreAmount;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public long getStoreAmount() {
		return storeAmount;
	}
	public void setStoreAmount(long storeAmount) {
		this.storeAmount = storeAmount;
	}
	public Date getInStoreTime() {
		return inStoreTime;
	}
	public void setInStoreTime(Date inStoreTime) {
		this.inStoreTime = inStoreTime;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public long getRelativeId() {
		return relativeId;
	}
	public void setRelativeId(long relativeId) {
		this.relativeId = relativeId;
	}
	
}
