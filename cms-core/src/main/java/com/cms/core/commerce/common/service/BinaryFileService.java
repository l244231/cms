package com.cms.core.commerce.common.service;

import org.springframework.web.multipart.MultipartFile;

import com.cms.core.commerce.common.domain.BinaryFileDto;
import com.cms.core.common.service.BaseService;

public interface BinaryFileService extends BaseService<BinaryFileDto> {
	/** 
	* @Title: uploadFile 
	* @author: Zain.Luo
	* @Description: 前台上传的文件转换成二进制，并存入数据库中
	* @param file 文件信息
	* @return    
	* @return BinaryFileDto    
	* @throws 
	* @history: 2017年1月6日 created
	*/
	public BinaryFileDto uploadFile(MultipartFile file);
}
