package com.cms.core.commerce.common.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * 二进制文件实体类
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月29日 下午9:19:22 lijx  <br> 
 * @History:
 */
public class BinaryFileDto extends BaseEntity {

	private static final long serialVersionUID = 4335543574601466318L;
	
	/**
	 * 业务类型
	 */
	private Integer type;
	
	/**
	 * 文件mime类型
	 */
	private Integer mimeType;
	
	/**
	 * 文件内容
	 */
	private String content;
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMimeType() {
		return mimeType;
	}

	public void setMimeType(Integer mimeType) {
		this.mimeType = mimeType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
