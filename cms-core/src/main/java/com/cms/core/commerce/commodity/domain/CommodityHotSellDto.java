/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 热销商品表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityHotSellDto extends BaseEntity {
 
	
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 商品排序
	 */
	private int sortId;
	/**
	 * 图标
	 */
	private long iconId;
	/**
	 * 发布时间
	 */
	private Date creationTime;
	/**
	 * 最后编辑日期
	 */
	private Date lastModified;
	 
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public long getIconId() {
		return iconId;
	}
	public void setIconId(long iconId) {
		this.iconId = iconId;
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
}