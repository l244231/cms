/*
 * NcpShopUserCommentDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @Title:商铺评论表Dto
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 上午1:35:23 Zain.Luo <br>
 * @History:
 */
public class NcpShopUserCommentDto extends BaseEntity {
	/**
	 * 商铺编号
	 */
	private String shopId;
	/**
	 * 用户编号
	 */
	private String userCode;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 图片
	 */
	private String images;
	/**
	 * 源ID
	 */
	private long sourceId;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
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
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	 * @return the images
	 */
	public String getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}
	/**
	 * @return the sourceId
	 */
	public long getSourceId() {
		return sourceId;
	}
	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
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
	
}
