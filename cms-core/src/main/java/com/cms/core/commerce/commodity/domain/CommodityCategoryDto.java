/*
 * @(#)CommodityCategory.java
 * Author : Zain.Luo
 * Created Date: 2016年12月15日 
 */
package com.cms.core.commerce.commodity.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品分类信息表实体类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月15日 Zain.Luo create file<br>
 *              Id:CommodityCategory.java,v1.0 2016年12月15日 下午4:59:27
 */
public class CommodityCategoryDto extends BaseEntity {

	/**
	 * 商铺ID
	 */
	private int storeId;
	/**
	 * 父分类ID
	 */
	private long parentId;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 分类图标
	 */
	private long iconId;
	/**
	 * 排序
	 */
	private int sortId;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIconId() {
		return iconId;
	}

	public void setIconId(long iconId) {
		this.iconId = iconId;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

}
