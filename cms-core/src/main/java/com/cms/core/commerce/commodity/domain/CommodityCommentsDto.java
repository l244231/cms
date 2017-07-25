/*
 * @(#)CommoditySpecDao.java
 * Author : Zain.Luo
 * Created Date: 2016年12月16日 
 */
package com.cms.core.commerce.commodity.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商品评论表Dao
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月16日 Zain.Luo create file<br>
 *              Id:CommoditySpecDao.java,v1.0 2016年12月16日 上午10:08:42
 */
public class CommodityCommentsDto extends BaseEntity {
 
	/**
	 * 对应评论id
	 */
	private long commentId;

	/**
	 * 对应商品ID
	 */
	private long commodityId;

	/**
	 * 用户ID
	 */
	private long userId;
	/**
	 * 分数
	 */
	private int score;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 发布时间
	 */
	private Date creationTime;
	
	/**
	 * 类型 默认为0，1：试用，2：团购
	 */
	private int type;
	/**
	 * 活动ID
	 */
	private long relativeId;
	/**
	 * 型号 颜色+规格
	 */
	private String model;
	/**
	 * 数量
	 */
	private int qty;
	/**
	 * 订单ID
	 */
	private String order_no;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(long relativeId) {
		this.relativeId = relativeId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
}
