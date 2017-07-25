/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 试用商品信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityTrialDto extends BaseEntity {
	 
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 试用类型 1 免费    2 付邮
	 */
	private int type;
	/**
	 * 团购价
	 */
	private double price;
	/**
	 * 团购库存
	 */
	private int stock;
	/**
	 * 团购销量
	 */
	private int sale;
	/**
	 * 商品排序
	 */
	private int sortId;
	/**
	 * 是否推荐到首页
	 */
	private int homeRecommended;
	/**
	 * 是否支持单卖
	 */
	private int singleSold;
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
	/**
	 * 最后编辑日期
	 */
	private Date lastModified = new Date();
	/**
	 * 参团人数设置
	 */
	private int numberPeople;
	/**
	 * 实际参团人数
	 */
	private int numberPeopleActual;
	/**
	 * 单人团购数量
	 */
	private int limits;
	/**
	 * 人气
	 */
	private int popularity;
	 
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public int getNumberPeople() {
		return numberPeople;
	}
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}
	public int getNumberPeopleActual() {
		return numberPeopleActual;
	}
	public void setNumberPeopleActual(int numberPeopleActual) {
		this.numberPeopleActual = numberPeopleActual;
	}
	public int getLimits() {
		return limits;
	}
	public void setLimits(int limits) {
		this.limits = limits;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}