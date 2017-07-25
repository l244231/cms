/*
 * NcpFileInfoDao.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月4日  <br>
 */
package com.cms.core.market.base.dao;

import com.cms.core.market.base.domain.NcpFileInfoDto;

/**
 * @Title:文件表dao类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月4日 下午11:38:12 Zain.Luo <br>
 * @History:
 */
public interface NcpFileInfoDao {
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
