/*
 * NcpShopActivityDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @Title:商铺活动
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 上午1:11:23 Zain.Luo <br>
 * @History:
 */
public class NcpShopActivityDto extends BaseEntity {
	/**
	 * 活动编号
	 */
	private String activityId;
	/**
	 * 商铺编号
	 */
	private String shopId;
	/**
	 * 活动名称
	 */
	private String name;
	/**
	 * 活动内容
	 */
	private String content;
	/**
	 * 图片
	 */
	private String imageId;
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	private String overTime; 
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建用户
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 更新用户
	 */
	private String updateUser;
	/**
	 * 扩展1(项目编号)
	 */
	private String extend1;
	/**
	 * 扩展2(活动地址)
	 */
	private String extend2;
	/**
	 * 扩展3
	 */
	private String extend3;
	/**
	 * 扩展4
	 */
	private String extend4;
	/**
	 * 扩展5
	 */
	private String extend5;
	/**
	 * @return the activityId
	 */
	public String getActivityId() {
		return activityId;
	}
	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	/**
	 * @return the shopId
	 */
	public String getShopId() {
		return shopId;
	}
	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the overTime
	 */
	public String getOverTime() {
		return overTime;
	}
	/**
	 * @param overTime the overTime to set
	 */
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	} 
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * @return the extend1
	 */
	public String getExtend1() {
		return extend1;
	}
	/**
	 * @param extend1 the extend1 to set
	 */
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	/**
	 * @return the extend2
	 */
	public String getExtend2() {
		return extend2;
	}
	/**
	 * @param extend2 the extend2 to set
	 */
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	/**
	 * @return the extend3
	 */
	public String getExtend3() {
		return extend3;
	}
	/**
	 * @param extend3 the extend3 to set
	 */
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	/**
	 * @return the extend4
	 */
	public String getExtend4() {
		return extend4;
	}
	/**
	 * @param extend4 the extend4 to set
	 */
	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	/**
	 * @return the extend5
	 */
	public String getExtend5() {
		return extend5;
	}
	/**
	 * @param extend5 the extend5 to set
	 */
	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}
}
