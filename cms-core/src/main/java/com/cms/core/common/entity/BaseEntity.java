package com.cms.core.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cms.core.common.util.DateUtil;

/**
 * 所有实体类基类
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月19日 下午11:43:52 lijx  <br> 
 * @History:
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 3420816621176449970L;
	
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDD = "yyyy-MM-dd";

	/**
	 * 唯一ID
	 */
	private long id;
	
	/**
	 * 最后编辑日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date lastModified = new Date();
	
	/**
	 * 最后编辑日期，用于前台展示
	 */
	private String lastModifiedLabel;
	
	/**
	 * 状态
	 */
	private short status = 0;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 更新人
	 */
	private String updateUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getLastModifiedLabel() {
		if(lastModified != null){
			lastModifiedLabel = DateUtil.DateToString(lastModified, YYYYMMDDHHMMSS);
			return lastModifiedLabel;
		}else{
			return "";
		}
	}

	public void setLastModifiedLabel(String lastModifiedLabel) {
		this.lastModifiedLabel = lastModifiedLabel;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
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
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
