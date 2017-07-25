/*
 * @(#)NcpImageInfoDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.domain;

import java.util.Date;

/**
 * @title 图片表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月5日 Zain.Luo create file<br>
 *              Id:NcpImageInfoDto.java,v1.0 2017年1月5日 下午3:02:01
 */
public class NcpImageInfoDto {
	/**
	 * 图片编号
	 */
	private String id;
	/**
	 * 长
	 */
	private int width;
	/**
	 * 宽
	 */
	private int height;
	/**
	 * 图片名称
	 */
	private String name;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 后缀名
	 */
	private String suffix;
	/**
	 * 状态
	 */
	private String status = "1";
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
