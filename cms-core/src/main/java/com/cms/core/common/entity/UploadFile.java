/*
 * @(#)UploadFile.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.entity;

/**
 * @title 上传文件实体类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月13日 Zain.Luo create file<br>
 *              Id:UploadFile.java,v1.0 2016年12月13日 下午2:53:03
 */
public class UploadFile {
	/**
	 * 文件名
	 */
	private String fileName;

	/**
	 * 原文件名
	 */
	private String originalFileName;

	/**
	 * 上传后保存路径
	 */
	private String savePath;

	/**
	 * 文件大小
	 */
	private long size;

	/**
	 * 文件类型
	 */
	private String type;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	/**
	 * @Title: getFullFileName
	 * @author: Zain.Luo
	 * @Description: 获取文件保存全路径
	 * @return String 文件保存全路径
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public String getFullFileName() {
		return this.savePath + this.fileName;
	}

}
