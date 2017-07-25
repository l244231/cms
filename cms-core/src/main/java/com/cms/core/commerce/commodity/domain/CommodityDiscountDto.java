/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 限时优惠商品表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityDiscountDto extends BaseEntity {

	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 优惠价
	 */
	private double price = -1;
	/**
	 * 参与优惠库存
	 */
	private int stock = -1;
	/**
	 * 已售
	 */
	private int sale = -1;
	/**
	 * 商品排序
	 */
	private int sortId = -1;
	/**
	 * 是否推荐到首页
	 */
	private int homeRecommended =-1;
	/**
	 * 是否支持单卖
	 */
	private int singleSold =-1;
	/**
	 * 发布时间
	 */
	private Date creationTime;
	/**
	 * 活动开始时间
	 */
	private Date startTime;
	/**
	 * 活动结束时间
	 */
	private Date expiryTime;

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getHomeRecommended() {
		return homeRecommended;
	}

	public void setHomeRecommended(int homeRecommended) {
		this.homeRecommended = homeRecommended;
	}

	public int getSingleSold() {
		return singleSold;
	}

	public void setSingleSold(int singleSold) {
		this.singleSold = singleSold;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

}
