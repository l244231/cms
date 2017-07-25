/*
 * BaseParams.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月28日  <br>
 */
package com.cms.core.common.entity;

import java.io.Serializable;

/**
 * @Title:基础参数类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月28日 下午11:37:47 Zain.Luo <br>
 * @History:
 */
public class BaseParams implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4788935596901188029L;
	/**
	 * id
	 */
	private long id;
	/**
	 * 类型
	 */
	private int type=-1;
	/**
	 * 状态
	 */
	private int status = -1;
	/**
	 * 关键字
	 */
	private String keyWord;
	
	/**
	 * 是否推荐到首页
	 */
	private int isHome = -1;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the keyWord
	 */
	public String getKeyWord() {
		if (!"".equals(keyWord)) {

			return keyWord;
		} else {
			return null;
		}
	}

	/**
	 * @param keyWord
	 *            the keyWord to set
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getIsHome() {
		return isHome;
	}

	public void setIsHome(int isHome) {
		this.isHome = isHome;
	}

}
