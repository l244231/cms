/*
 * NcpShopRecommendDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @Title:TODO
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 下午11:38:06 Zain.Luo <br>
 * @History:
 */
public class NcpShopRecommendDto extends BaseEntity {
	/**
	 * 商铺编号
	 */
	private long shopId;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 类型
	 */
	private short type;
	/**
	 * 项目编号
	 */
	private String projectId;
	
	private int sort;

	/**
	 * @return the shopId
	 */
	public long getShopId() {
		return shopId;
	}

	/**
	 * @param shopId
	 *            the shopId to set
	 */
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the type
	 */
	public short getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(short type) {
		this.type = type;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
