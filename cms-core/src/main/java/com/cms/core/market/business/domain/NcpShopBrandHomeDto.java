/*
 * NcpShopBrandHome.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @Title:业态首页表Dto
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 下午9:53:51 Zain.Luo <br>
 * @History:
 */
public class NcpShopBrandHomeDto extends BaseEntity {
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 业态图片
	 */
	private String formatImage;
	/**
	 * 业态类型编号
	 */
	private long formatType;
	/**
	 * 业态类型名称
	 */
	private String formatTypeName;
	/**
	 * 地址
	 */
	private String formatUri;
	/**
	 * 项目编号
	 */
	private String projectId;
	/**
	 * 排序
	 */
	private int sort;

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the formatImage
	 */
	public String getFormatImage() {
		return formatImage;
	}

	/**
	 * @param formatImage
	 *            the formatImage to set
	 */
	public void setFormatImage(String formatImage) {
		this.formatImage = formatImage;
	}

	/**
	 * @return the formatType
	 */
	public long getFormatType() {
		return formatType;
	}

	/**
	 * @param formatType
	 *            the formatType to set
	 */
	public void setFormatType(long formatType) {
		this.formatType = formatType;
	}

	/**
	 * @return the formatTypeName
	 */
	public String getFormatTypeName() {
		return formatTypeName;
	}

	/**
	 * @param formatTypeName
	 *            the formatTypeName to set
	 */
	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
	}

	/**
	 * @return the formatUri
	 */
	public String getFormatUri() {
		return formatUri;
	}

	/**
	 * @param formatUri
	 *            the formatUri to set
	 */
	public void setFormatUri(String formatUri) {
		this.formatUri = formatUri;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

}
