/*
 * @(#)NcpImageInfoService.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.service;

import com.cms.core.market.base.domain.NcpImageInfoDto;

/**
 * @title 文件表service类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月5日 Zain.Luo create file<br>
 *              Id:NcpImageInfoService.java,v1.0 2017年1月5日 下午3:04:33
 */
public interface NcpImageInfoService {
	/**
	 * @Title: insert
	 * @author: Zain.Luo
	 * @Description: 新增
	 * @param dto
	 * @return
	 * @return long
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	long insert(NcpImageInfoDto dto);

	/**
	 * @Title: findById
	 * @author: Zain.Luo
	 * @Description: 通过ID查询
	 * @param id
	 *            图片ID
	 * @return
	 * @return NcpFileInfoDto
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	NcpImageInfoDto findById(String id);
}
