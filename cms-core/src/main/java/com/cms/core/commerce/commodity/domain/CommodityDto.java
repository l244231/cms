/*
 * @(#)CommodityDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品信息表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityDao.java,v1.0 2016年12月16日 上午10:06:52
 */
public class CommodityDto extends BaseEntity {
	
	private static final long serialVersionUID = 662248047136050599L;
	
	/**
	 * 所属分类
	 */
	private long categoryId;
	
	/**
	 * 所属分类名称
	 */
	private String categoryName;
	/**
	 * 商品名称
	 */
	private String name; 
	/**
	 * 商品短名称
	 */
	private String shortName;
	
	/**
	 * 商品短英文名
	 */
	private String shortNameEn;
	 
	/**
	 * 商品英文名称
	 */
	private String engName;
	/**
	 * 规格名称
	 */
	private String specName;
	/**
	 * 规格名称
	 */
	private String specNameEn;
	/**
	 * 列表默认图
	 */
	private long listIconId;
	/**
	 * 商品排序
	 */
	private Integer sortId;
	/**
	 * 所属店铺
	 */
	private long storeId;
	/**
	 * 所属店铺名称
	 */
	private String storeName;
	/**
	 * 规格名称
	 */
	private String model;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 现价
	 */
	private Double currentPrice;
	/**
	 * 商品说明
	 */
	private String description;
	/**
	 * 商品说明
	 */
	private String descriptionEn;
	/**
	 * 配送说明
	 */
	private String distribution;
	/**
	 * 配送说明
	 */
	private String distributionEn;
	/**
	 * 购买须知
	 */
	private String purchaseNotes;
	/**
	 * 购买须知
	 */
	private String purchaseNotesEn;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 销量
	 */
	private Integer sale;
	/**
	 * 人气
	 */
	private Integer popularity;
	/**
	 * 发布时间  
	 */
	private Date creationTime;
 
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecNameEn() {
		return specNameEn;
	}

	public void setSpecNameEn(String specNameEn) {
		this.specNameEn = specNameEn;
	}

	public long getListIconId() {
		return listIconId;
	}

	public void setListIconId(long listIconId) {
		this.listIconId = listIconId;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getDistributionEn() {
		return distributionEn;
	}

	public void setDistributionEn(String distributionEn) {
		this.distributionEn = distributionEn;
	}

	public String getPurchaseNotes() {
		return purchaseNotes;
	}

	public void setPurchaseNotes(String purchaseNotes) {
		this.purchaseNotes = purchaseNotes;
	}

	public String getPurchaseNotesEn() {
		return purchaseNotesEn;
	}

	public void setPurchaseNotesEn(String purchaseNotesEn) {
		this.purchaseNotesEn = purchaseNotesEn;
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
		if(sale == null){
			this.sale = new Integer(0);
		}else{
			this.sale = sale;
		}
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		if(popularity == null){
			this.popularity = new Integer(0);
		}else{
			this.popularity = popularity;
		}
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the shortNameEn
	 */
	public String getShortNameEn() {
		return shortNameEn;
	}

	/**
	 * @param shortNameEn the shortNameEn to set
	 */
	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
}
