/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 优惠表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class DiscountDto extends BaseEntity {
	/** * 优惠名称 */
	private String name;
	/**
	 * * 触发条件时间指定日期格式为：{“type”:1,“value”:”
	 * 2010-01-01”}指定周格式：{“type”:2,“value”:1//周一}
	 */
	private String tiggerTime;
	/** * 触发条件商品 */
	private long tiggerCommodityId;
	/** * 触发条件金额 */
	private double tiggerAmount;
	/** * 触发条件店铺 */
	private long tiggerStore;
	/** * 触发条件全场默认0，开启1 */
	private long tiggerAll;
	/** * 有效开始时间 */
	private long startTime;
	/** * 有效结束时间 */
	private long expiryTime;
	/** * 创建时间 */
	private Date creationTime;
	/** * 最后修改日期 */
	private Date lastModified;
	/** * 折扣形式请参考discount_form */
	private long discountFormId;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tiggerTime
	 */
	public String getTiggerTime() {
		return tiggerTime;
	}

	/**
	 * @param tiggerTime
	 *            the tiggerTime to set
	 */
	public void setTiggerTime(String tiggerTime) {
		this.tiggerTime = tiggerTime;
	}

	/**
	 * @return the tiggerCommodityId
	 */
	public long getTiggerCommodityId() {
		return tiggerCommodityId;
	}

	/**
	 * @param tiggerCommodityId
	 *            the tiggerCommodityId to set
	 */
	public void setTiggerCommodityId(long tiggerCommodityId) {
		this.tiggerCommodityId = tiggerCommodityId;
	}

	/**
	 * @return the tiggerAmount
	 */
	public double getTiggerAmount() {
		return tiggerAmount;
	}

	/**
	 * @param tiggerAmount
	 *            the tiggerAmount to set
	 */
	public void setTiggerAmount(double tiggerAmount) {
		this.tiggerAmount = tiggerAmount;
	}

	/**
	 * @return the tiggerStore
	 */
	public long getTiggerStore() {
		return tiggerStore;
	}

	/**
	 * @param tiggerStore
	 *            the tiggerStore to set
	 */
	public void setTiggerStore(long tiggerStore) {
		this.tiggerStore = tiggerStore;
	}

	/**
	 * @return the tiggerAll
	 */
	public long getTiggerAll() {
		return tiggerAll;
	}

	/**
	 * @param tiggerAll
	 *            the tiggerAll to set
	 */
	public void setTiggerAll(long tiggerAll) {
		this.tiggerAll = tiggerAll;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the expiryTime
	 */
	public long getExpiryTime() {
		return expiryTime;
	}

	/**
	 * @param expiryTime
	 *            the expiryTime to set
	 */
	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
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
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the discountFormId
	 */
	public long getDiscountFormId() {
		return discountFormId;
	}

	/**
	 * @param discountFormId
	 *            the discountFormId to set
	 */
	public void setDiscountFormId(long discountFormId) {
		this.discountFormId = discountFormId;
	}

}
