/*
 * @(#)CommodityDeliveryDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品配送标签表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityDeliveryDao.java,v1.0 2016年12月16日 上午10:08:07
 */
public class CommodityDeliveryDto extends BaseEntity {

	private static final long serialVersionUID = 4007818265580807692L;

	/**
	 * 对应商品ID
	 */
	private long commodityId;

	/**
	 * 配送标签ID
	 */
	private long deliveryId;

	/**
	 * 创建日期
	 */
	private Date creationTime;
	/**
	 * 最后编辑日期
	 */
	private Date lastModified;
	
	private int homeRecommended;

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
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
}
