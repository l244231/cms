/*
 * test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * * @title 试用商品申请表DTO
 * 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class CommodityTrialUserDto extends BaseEntity {
	/** * 对应试用表ID */
	private long commodityTrialId;
	/** * 用户id */
	private long userId;
	/** * 申请日期 */
	private Date applyTime;
	/** * 是否申请成功默认0 */
	private int isWin;
	/** * 最后修改日期 */
	private Date lastModified;
	/** * 用户地址ID */
	private String addressId;

	/**
	 * @return the commodityTrialId
	 */
	public long getCommodityTrialId() {
		return commodityTrialId;
	}

	/**
	 * @param commodityTrialId
	 *            the commodityTrialId to set
	 */
	public void setCommodityTrialId(long commodityTrialId) {
		this.commodityTrialId = commodityTrialId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * @param applyTime
	 *            the applyTime to set
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @return the isWin
	 */
	public int getIsWin() {
		return isWin;
	}

	/**
	 * @param isWin
	 *            the isWin to set
	 */
	public void setIsWin(int isWin) {
		this.isWin = isWin;
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
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId
	 *            the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

}
