/*
 * Test.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月18日  <br>
 */
package com.cms.core.commerce.transaction.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 折扣形式表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommodityColor.java,v1.0 2016年12月16日 上午10:07:33
 */
public class DiscountFormDto extends BaseEntity {
	/**	 * 折扣形式名称	 */ 
	private String name;
	/**	 * 折扣形式名称	 */ 
	private String NameEn;
	/**	 * 折扣形式类型1:降价 2：打折 3：送商品	 */ 
	private long type;
	/**	 * 关联值	 */ 
	private long relativeValue;
	/**	 * 创建	 */ 
	private Date creationTime;
	/**	 * 最后修改日期	 */ 
	private Date lastModified;
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
	 * @return the nameEn
	 */
	public String getNameEn() {
		return NameEn;
	}
	/**
	 * @param nameEn the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		NameEn = nameEn;
	}
	/**
	 * @return the type
	 */
	public long getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(long type) {
		this.type = type;
	}
	/**
	 * @return the relativeValue
	 */
	public long getRelativeValue() {
		return relativeValue;
	}
	/**
	 * @param relativeValue the relativeValue to set
	 */
	public void setRelativeValue(long relativeValue) {
		this.relativeValue = relativeValue;
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
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}
	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
