/*
 * @(#)BinaryFileHbServiceImpl.java
 * Author : Zain.Luo
 * Created Date: 2017年1月24日 
 */
package com.cms.hb.commerce.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cms.hb.commerce.common.dao.BinaryFileHbDao;
import com.cms.hb.commerce.common.domain.BinaryFileHbDto;
import com.cms.hb.commerce.common.service.BinaryFileHbService;

/**
 * @title 文件管理service实现类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月24日 Zain.Luo create file<br>
 *              Id:BinaryFileHbServiceImpl.java,v1.0 2017年1月24日 上午10:16:38
 */
@Service("binaryFileHbService")
public class BinaryFileHbServiceImpl implements BinaryFileHbService {

	@Autowired
	private BinaryFileHbDao binaryFileHbDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.hb.commerce.common.service.BinaryFileHbService#findById(long)
	 */
	@Override
	public BinaryFileHbDto findById(long id) {

		return binaryFileHbDao.findById(id);
	}
 
	/* (non-Javadoc)
	 * @see com.cms.hb.commerce.common.service.BinaryFileHbService#insertImage(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public BinaryFileHbDto insertImage(MultipartFile file) {
		 
		return binaryFileHbDao.insertImage(file);
	}

}
