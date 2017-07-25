/*
 * TrialDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月17日  <br>
 */
package com.cms.core.commerce.commodity.domain;

import com.alibaba.druid.util.StringUtils;

/** 
 * @Title:试用前台传参DTO
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月17日 下午10:18:01 Zain.Luo  <br> 
 * @History:
 */
public class TrialDto {
	private String id;
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	
	/**
	 * 试用价格
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
	
	/**
	 * 试用从数设置
	 */
	private int numberPeople;
	
	/**
	 * 限购数量
	 */
	private int limits;
	
	private int type;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @return the sortId
	 */
	public int getSortId() {
		return sortId;
	}

	/**
	 * @param sortId the sortId to set
	 */
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	/**
	 * @return the homeRecommended
	 */
	public int getHomeRecommended() {
		return homeRecommended;
	}

	/**
	 * @param homeRecommended the homeRecommended to set
	 */
	public void setHomeRecommended(int homeRecommended) {
		this.homeRecommended = homeRecommended;
	}

	/**
	 * @return the singleSold
	 */
	public int getSingleSold() {
		return singleSold;
	}

	/**
	 * @param singleSold the singleSold to set
	 */
	public void setSingleSold(int singleSold) {
		this.singleSold = singleSold;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the expiryTime
	 */
	public String getExpiryTime() {
		return expiryTime;
	}

	/**
	 * @param expiryTime the expiryTime to set
	 */
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * @return the status
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(short status) {
		this.status = status;
	}
 

	/**
	 * @return the numberPeople
	 */
	public int getNumberPeople() {
		return numberPeople;
	}

	/**
	 * @param numberPeople the numberPeople to set
	 */
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	 
	/**
	 * @return the limits
	 */
	public int getLimits() {
		return limits;
	}

	/**
	 * @param limits the limits to set
	 */
	public void setLimits(int limits) {
		this.limits = limits;
	}

	public int changeStock(){
		if(StringUtils.isEmpty(stock)){
			return 0;
		}else{
			return Integer.parseInt(stock);
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
