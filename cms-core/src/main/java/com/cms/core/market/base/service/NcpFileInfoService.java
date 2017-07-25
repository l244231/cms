/*
 * @(#)NcpFileInfoService.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.service;

import com.cms.core.market.base.domain.NcpFileInfoDto;

/**
 * @title 文件Service接口类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月5日 Zain.Luo create file<br>
 * Id:NcpFileInfoService.java,v1.0 2017年1月5日 下午2:56:55
 */
public interface NcpFileInfoService {
	/** 
	* @Title: insert 
	* @author: Zain.Luo
	* @Description: 新增
	* @param dto
	* @return    
	* @return long    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	long insert(NcpFileInfoDto dto);

	/** 
	* @Title: findById 
	* @author: Zain.Luo
	* @Description: 通过ID查询
	* @param id 文件编号
	* @return    
	* @return NcpFileInfoDto    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	NcpFileInfoDto findById(String id);
}
