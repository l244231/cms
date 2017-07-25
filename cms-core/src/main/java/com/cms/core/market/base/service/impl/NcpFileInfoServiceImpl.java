/*
 * @(#)NcpFileInfoServiceImpl.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.market.base.dao.NcpFileInfoDao;
import com.cms.core.market.base.domain.NcpFileInfoDto;
import com.cms.core.market.base.service.NcpFileInfoService;

/**
 * @title 文件表service实现类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月5日 Zain.Luo create file<br>
 * Id:NcpFileInfoServiceImpl.java,v1.0 2017年1月5日 下午2:57:29
 */
@Service("ncpFileInfoService")
public class NcpFileInfoServiceImpl implements NcpFileInfoService{
	
	@Autowired
	private NcpFileInfoDao ncpFileInfoDao;
	
	/* (non-Javadoc)
	 * @see com.cms.core.market.base.service.NcpFileInfoService#insert(com.cms.core.market.base.domain.NcpFileInfoDto)
	 */
	@Override
	public long insert(NcpFileInfoDto dto) {
		return ncpFileInfoDao.insert(dto);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.market.base.service.NcpFileInfoService#findById(long)
	 */
	@Override
	public NcpFileInfoDto findById(String id) {
		return ncpFileInfoDao.findById(id);
	}

}
