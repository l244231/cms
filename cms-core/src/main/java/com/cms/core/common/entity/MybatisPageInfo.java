/*
 * MybatisPageInfo.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月17日  <br>
 */
package com.cms.core.common.entity;

/** 
 * @Title:mybatis分页信息
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月17日 上午11:08:01 Zain.Luo  <br> 
 * @History:
 */
public class MybatisPageInfo {
	/**
	 * 页码
	 */
	private int pageNum;
	
	/**
	 * 每页显示数量
	 */
	private int pageSize;
	
/**
	 * 是否计算总记录数
	 */
	private boolean isCount;
	
	/**
	 * 总记录数
	 */
	private int total;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 空构造函数
	 */
	public MybatisPageInfo(){
		
	}
	
	/**
	 * 构造函数，默认不进行统计总数
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 */
	public MybatisPageInfo(int pageNum,int pageSize){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.isCount = false;
	}
	
	/**
	 * 构造函数
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 * @param isCount 是否计算总记录数
	 */
	public MybatisPageInfo(int pageNum,int pageSize,boolean isCount){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.isCount = isCount;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the isCount
	 */
	public boolean isCount() {
		return isCount;
	}

	/**
	 * @param isCount the isCount to set
	 */
	public void setCount(boolean isCount) {
		this.isCount = isCount;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
