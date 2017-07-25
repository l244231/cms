/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品图信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityIconsDto extends BaseEntity {
	 
	
	/**
	 * 对应商品ID
	 */
	private long commodityId;
	/**
	 * 图标
	 */
	private long iconId;
 
	public long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}
	public long getIconId() {
		return iconId;
	}
	public void setIconId(long iconId) {
		this.iconId = iconId;
	}
}