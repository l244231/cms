/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.other.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商铺运费表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class StoreFreightDto extends BaseEntity {
	/** * 商铺ID */
	private long storeId;
	/** * 运费 */
	private double amount;
	/** * 免运费额度 */
	private double amountFree;
	/** * 扩展1 */
	private String extend1;
	/** * 扩展2 */
	private String extend2;
	/** * 扩展3 */
	private String extend3;
	/** * 创建日期 */
	private Date creationTime;
	/** * 最后修改日期 */
	private Date lastModified;

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
	 * @return the amountFree
	 */
	public double getAmountFree() {
		return amountFree;
	}

	/**
	 * @param amountFree
	 *            the amountFree to set
	 */
	public void setAmountFree(double amountFree) {
		this.amountFree = amountFree;
	}

	/**
	 * @return the extend1
	 */
	public String getExtend1() {
		return extend1;
	}

	/**
	 * @param extend1
	 *            the extend1 to set
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
	 * @param extend2
	 *            the extend2 to set
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
	 * @param extend3
	 *            the extend3 to set
	 */
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
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

}
