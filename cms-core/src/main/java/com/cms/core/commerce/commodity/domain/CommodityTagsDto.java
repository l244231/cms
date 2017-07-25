/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品标签信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityTagsDto extends BaseEntity {
 
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 标签名称
	 */
	private String name;
	/**
	 * 标签名称
	 */
	private String nameEn;
 
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}