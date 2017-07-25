/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品信息修改表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityHistoryDto extends BaseEntity {

	/**
	 * 商品ID
	 */
	private long commodityId;
	/**
	 * 所属分类
	 */
	private long categoryId;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品名称
	 */
	private String nameEn;
	/**
	 * 商品短名称
	 */
	private String shortName;

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
	private int sortId;
	/**
	 * 所属店铺
	 */
	private long storeId;
	/**
	 * 规格名称
	 */
	private String model;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 现价
	 */
	private double currentPrice;
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
	private int stock;
	/**
	 * 销量
	 */
	private int sale;
	/**
	 * 人气
	 */
	private int popularity;
	/**
	 * 发布时间
	 */
	private Date creationTime;
	/**
	 * 最后编辑日期
	 */
	private Date lastModified;

	public CommodityHistoryDto() {

	}

	public CommodityHistoryDto(CommodityDto commodity) {
		this.commodityId = commodity.getId();
		this.categoryId = commodity.getCategoryId();
		this.name = commodity.getName();
		this.shortName = commodity.getShortName();
		this.specName = commodity.getSpecName();
		this.specNameEn = commodity.getSpecNameEn();
		if(StringUtils.isNotEmpty(commodity.getEngName())){
			this.engName = commodity.getEngName();
		}else{
			this.engName = "default";
		}
		this.listIconId = commodity.getListIconId();
		this.sortId = commodity.getSortId();
		this.storeId = commodity.getStoreId();
		this.model = commodity.getModel();
		this.price = commodity.getPrice();
		this.currentPrice = commodity.getCurrentPrice();
		this.description = commodity.getDescription();
		this.distribution = commodity.getDistribution();
		this.purchaseNotes = commodity.getPurchaseNotes();
		if(StringUtils.isNotEmpty(commodity.getDescriptionEn())){
			this.descriptionEn = commodity.getDescriptionEn();
		}else{
			this.descriptionEn = "default";
		}
		if(StringUtils.isNotEmpty(commodity.getDistributionEn())){
			this.distributionEn = commodity.getDistributionEn();
		}else{
			this.distributionEn = "default";
		}
		if(StringUtils.isNotEmpty(commodity.getPurchaseNotesEn())){
			this.purchaseNotesEn = commodity.getPurchaseNotesEn();
		}else{
			this.purchaseNotesEn = "default";
		}
		this.stock = commodity.getStock();
		this.sale = commodity.getSale();
		this.popularity = commodity.getPopularity();
		this.creationTime = commodity.getCreationTime();
		this.lastModified = commodity.getLastModified();
		if(StringUtils.isNotEmpty(commodity.getShortNameEn())){
			this.shortNameEn = commodity.getShortNameEn();
		}else{
			this.shortNameEn = "default";
		}
	}

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

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
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
	 * @return the shortNameEn
	 */
	public String getShortNameEn() {
		return shortNameEn;
	}

	/**
	 * @param shortNameEn
	 *            the shortNameEn to set
	 */
	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}

	/**
	 * @return the commodityId
	 */
	public long getCommodityId() {
		return commodityId;
	}

	/**
	 * @param commodityId
	 *            the commodityId to set
	 */
	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

}