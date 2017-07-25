/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 订单表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class OrdersDto extends BaseEntity {
	/** * 订单号 */
	private String orderNo;
	/** * 商铺id */
	private long storeId;
	/** * 用户ID */
	private long userId;
	/** * 支付类型 */
	private long payType;
	/** * 订单总金额 */
	private double amount;
	/** * 订单实际金额 */
	private double amountActual;
	/** * 订单支付时间 */
	private Date payTime;
	/** * 订单创建时间 */
	private Date creationTime;
	/** * 最后修改时间 */
	private Date lastModified;
	/** * 收货人姓名 */
	private String consignee;
	/** * 收货人联系电话 */
	private String mobile;
	/** * 收货地址 */
	private String address;
	/** * 邮编 */
	private String zipCode;
	/** * 快递公司 */
	private String deliveryCompany;
	/** * 快递单号 */
	private String deliveryNub;
	/** * 发货时间 */
	private Date deliveryTime;
	/** * 备注 */
	private String notes;
	
	/**
	 * 商铺名 
	 */
	private String storeName;
	
	/**
	 * 取消人
	 */
	private Date cancelTime;
	
	/**
	 * 取消时间
	 */
	private String cancelUser;
	
	/**
	 * 取消原因
	 */
	private String cancelReason;

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo
	 *            the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the storeId
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId
	 *            the storeId to set
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
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
	 * @return the payType
	 */
	public long getPayType() {
		return payType;
	}

	/**
	 * @param payType
	 *            the payType to set
	 */
	public void setPayType(long payType) {
		this.payType = payType;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountActual
	 */
	public double getAmountActual() {
		return amountActual;
	}

	/**
	 * @param amountActual
	 *            the amountActual to set
	 */
	public void setAmountActual(double amountActual) {
		this.amountActual = amountActual;
	}

	/**
	 * @return the payTime
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * @param payTime
	 *            the payTime to set
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime
	 *            the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}

	/**
	 * @param consignee
	 *            the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the deliveryCompany
	 */
	public String getDeliveryCompany() {
		return deliveryCompany;
	}

	/**
	 * @param deliveryCompany
	 *            the deliveryCompany to set
	 */
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}

	/**
	 * @return the deliveryNub
	 */
	public String getDeliveryNub() {
		return deliveryNub;
	}

	/**
	 * @param deliveryNub
	 *            the deliveryNub to set
	 */
	public void setDeliveryNub(String deliveryNub) {
		this.deliveryNub = deliveryNub;
	}

	/**
	 * @return the deliveryTime
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @param deliveryTime
	 *            the deliveryTime to set
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelUser() {
		return cancelUser;
	}

	public void setCancelUser(String cancelUser) {
		this.cancelUser = cancelUser;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
