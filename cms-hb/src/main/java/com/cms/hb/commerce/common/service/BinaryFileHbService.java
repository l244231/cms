/*
 * @(#)BinaryFileHbService.java
 * Author : Zain.Luo
 * Created Date: 2017年1月24日 
 */
package com.cms.hb.commerce.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cms.hb.commerce.common.domain.BinaryFileHbDto;

/**
 * @title 文件管理service类 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月24日 Zain.Luo create file<br>
 * Id:BinaryFileHbService.java,v1.0 2017年1月24日 上午10:16:05
 */
public interface BinaryFileHbService {
	
	/** 
	* @Title: findById 
	* @author: Zain.Luo
	* @Description: 根据ID获取文件信息
	* @param id
	* @return    
	* @return BinaryFileHbDto    
	* @throws 
	* @history: 2017年1月25日 created
	*/
	public BinaryFileHbDto findById(long id);
	
	/** 
	* @Title: insertImage 
	* @author: Zain.Luo
	* @Description: 上传图片
	* @param file    
	* @return void    
	* @throws 
	* @history: 2017年1月25日 created
	*/
	public BinaryFileHbDto insertImage(MultipartFile file);
}
