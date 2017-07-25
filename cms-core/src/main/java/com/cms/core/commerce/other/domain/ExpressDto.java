/*
 * @(#)ExpressDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月13日 
 */
package com.cms.core.commerce.other.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title 快递公司表Dto
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月13日 Zain.Luo create file<br>
 * Id:ExpressDto.java,v1.0 2017年1月13日 下午2:24:36
 */
public class ExpressDto extends BaseEntity{
	/**
	 * 快递公司名称
	 */
	private String expressName;

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	
	
}
