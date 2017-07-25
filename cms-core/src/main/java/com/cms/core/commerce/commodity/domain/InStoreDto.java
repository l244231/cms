/*
 * @(#)InStoreDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月17日 
 */
package com.cms.core.commerce.commodity.domain;

/**
 * @title 入库记录前台记录 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月17日 Zain.Luo create file<br>
 * Id:InStoreDto.java,v1.0 2017年1月17日 下午3:20:15
 */
public class InStoreDto {
	private long commodityId;
	private long relativeId;
	private int stock;
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public long getRelativeId() {
		return relativeId;
	}
	public void setRelativeId(long relativeId) {
		this.relativeId = relativeId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
