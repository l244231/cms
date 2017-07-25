/*
 * @(#)NcpImageInfoDao.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.dao;

import com.cms.core.market.base.domain.NcpImageInfoDto;

/**
 * @title TODO 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月5日 Zain.Luo create file<br>
 * Id:NcpImageInfoDao.java,v1.0 2017年1月5日 下午3:01:25
 */
public interface NcpImageInfoDao {
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
	long insert(NcpImageInfoDto dto);

	/** 
	* @Title: findById 
	* @author: Zain.Luo
	* @Description: 通过ID查询
	* @param id 图片ID
	* @return    
	* @return NcpFileInfoDto    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	NcpImageInfoDto findById(String id);
}
