/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 团购商品信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityGroupDto extends BaseEntity {

	private static final long serialVersionUID = -6324944357267005087L;
	/**
	 * 团购标题
	 */
	private String title;
	/**
	 * 列表图标
	 */
	private long iconId;
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 团购价
	 */
	private double price = 0;
	/**
	 * 团购库存
	 */
	private Integer stock = 0;
	/**
	 * 团购销量
	 */
	private Integer sale = 0;
	/**
	 * 商品排序
	 */
	private Integer sortId;
	/**
	 * 是否推荐到首页
	 */
	private Integer homeRecommended;
	/**
	 * 是否支持单卖
	 */
	private Integer singleSold;
	/**
	 * 发布时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date creationTime = new Date();
	/**
	 * 活动开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date startTime;
	/**
	 * 活动结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date expiryTime;
	
	/**
	 * 参团人数设置
	 */
	private Integer numberPeople = 0;
	/**
	 * 实际参团人数
	 */
	private Integer numberPeopleActual = 0;
	/**
	 * 单人团购数量
	 */
	private Integer limits = 0;
	/**
	 * 人气
	 */
	private Integer popularity = 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getIconId() {
		return iconId;
	}

	public void setIconId(long iconId) {
		this.iconId = iconId;
	}

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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Integer getHomeRecommended() {
		return homeRecommended;
	}

	public void setHomeRecommended(Integer homeRecommended) {
		this.homeRecommended = homeRecommended;
	}

	public Integer getSingleSold() {
		return singleSold;
	}

	public void setSingleSold(Integer singleSold) {
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

	public Integer getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(Integer numberPeople) {
		this.numberPeople = numberPeople;
	}

	public Integer getNumberPeopleActual() {
		return numberPeopleActual;
	}

	public void setNumberPeopleActual(Integer numberPeopleActual) {
		this.numberPeopleActual = numberPeopleActual;
	}

	public Integer getLimits() {
		return limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

}