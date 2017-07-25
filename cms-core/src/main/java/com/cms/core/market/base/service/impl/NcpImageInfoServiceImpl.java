/*
 * @(#)NcpImageInfoServiceImpl.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.core.market.base.dao.NcpImageInfoDao;
import com.cms.core.market.base.domain.NcpImageInfoDto;
import com.cms.core.market.base.service.NcpImageInfoService;

/**
 * @title TODO 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月5日 Zain.Luo create file<br>
 * Id:NcpImageInfoServiceImpl.java,v1.0 2017年1月5日 下午3:05:17
 */
@Service("ncpImageInfoService")
public class NcpImageInfoServiceImpl implements NcpImageInfoService{

	@Autowired
	private NcpImageInfoDao ncpImageInfoDao;
	
	/* (non-Javadoc)
	 * @see com.cms.core.market.base.service.NcpImageInfoService#insert(com.cms.core.market.base.domain.NcpImageInfoDto)
	 */
	@Override
	public long insert(NcpImageInfoDto dto) {
		return ncpImageInfoDao.insert(dto);
	}

	/* (non-Javadoc)
	 * @see com.cms.core.market.base.service.NcpImageInfoService#findById(java.lang.String)
	 */
	@Override
	public NcpImageInfoDto findById(String id) {
		return ncpImageInfoDao.findById(id);
	}

}
