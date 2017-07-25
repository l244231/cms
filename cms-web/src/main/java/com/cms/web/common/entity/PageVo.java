package com.cms.web.common.entity;

import java.io.Serializable;

/**
 * 
 * @Title:分页参数VO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月21日 上午12:06:36 lijx  <br> 
 * @History:
 */
public class PageVo implements Serializable {

	private static final long serialVersionUID = 640975072364734572L;

	/**
	 * 当前页记录的start数
	 */
	private Integer offset;

	/**
	 * 每页记录数
	 */
	private Integer limit;

	/**
	 * 排序字段
	 */
	private String sort;
	
	/**
	 * 页码
	 */
	private Integer pageNumber;
	
	/**
	 * 每页记录数
	 */
	private Integer pageSize;

	/**
	 * 排序规则	ASC，DESC
	 */
	private String order;

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the pageNum
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	} 
	
}
