/*
 * BenefitDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月15日  <br>
 */
package com.cms.core.commerce.commodity.domain;

import com.alibaba.druid.util.StringUtils;

/** 
 * @Title:限时优惠前台传参DTO
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月15日 下午10:34:22 Zain.Luo  <br> 
 * @History:
 */
public class BenefitDto {
	private String id;
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 优惠价
	 */
	private double price;
	/**
	 * 参与优惠库存
	 */
	private String stock;
	 
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
	 * 活动开始时间
	 */
	private String startTime;
	/**
	 * 活动结束时间
	 */
	private String expiryTime;
	
	private short status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStock() {
		return StringUtils.isEmpty(stock)?"0":stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}
	
	public int changeStock(){
		if(StringUtils.isEmpty(stock)){
			return 0;
		}else{
			return Integer.parseInt(stock);
		}
	}
}
