/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.other.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 首页广告表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class AdsDto extends BaseEntity {
	/** * 广告类型1：跳转 2：商品3：活动 */
	private int type;
	/** * 广告标题 */
	private String title;
	/** * */
	private String titleEn;
	/** * 链接地址 */
	private String url;
	/** * 商品/活动ID跳转广告为空 */
	private String commodityId;
	/** * 活动类型 */
	private String activityType;
	/** * 发布时间 */
	private Date creationTime;
	/** * 截止时间 */
	private Date expiryTime;
	/** * 广告图片 */
	private String iconId;
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the titleEn
	 */
	public String getTitleEn() {
		return titleEn;
	}
	/**
	 * @param titleEn the titleEn to set
	 */
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the commodityId
	 */
	public String getCommodityId() {
		return commodityId;
	}
	/**
	 * @param commodityId the commodityId to set
	 */
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/**
	 * @return the expiryTime
	 */
	public Date getExpiryTime() {
		return expiryTime;
	}
	/**
	 * @param expiryTime the expiryTime to set
	 */
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
	/**
	 * @return the iconId
	 */
	public String getIconId() {
		return iconId;
	}
	/**
	 * @param iconId the iconId to set
	 */
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	
}
