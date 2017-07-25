/*
 * AudiovisualDomain.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月4日  <br>
 */
package com.cms.core.market.action.domain;

/** 
 * @Title:每日视听前台数据封装类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月4日 下午11:16:54 Zain.Luo  <br> 
 * @History:
 */
public class AudiovisualDomain {
	/**
	 * 主题
	 */
	private String title;
	/**
	 * 主键ID
	 */
	private String id;
	
	/**
	 * 内容
	 */
	private String content; 
	
	/**
	 * 图片
	 */
	private String image;
	
	/**
	 * 排序
	 */
	private int sort;
	
	/**
	 * 文件类型
	 */
	private String fileType;
	
	/**
	 * 文件ID
	 */
	private String fileId;
	
	/**
	 * 文件URI
	 */
	private String uri;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * @return the type
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param type the type to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the fileId
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
