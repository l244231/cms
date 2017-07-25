/*
 * BinaryFileServiceImpl.java  <br>
 * Author:lijx  <br>
 * Created Date: 2016年12月29日  <br>
 */
package com.cms.core.commerce.common.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cms.core.commerce.common.dao.BinaryFileDao;
import com.cms.core.commerce.common.domain.BinaryFileDto;
import com.cms.core.commerce.common.service.BinaryFileService;
import com.cms.core.common.service.impl.BaseServiceImpl;
import com.cms.core.common.util.LogMannger;

import sun.misc.BASE64Encoder;

/**
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月29日 下午9:21:06 lijx <br>
 * @History:
 */
@Service("binaryFileService")
public class BinaryFileServiceImpl extends BaseServiceImpl<BinaryFileDto>implements BinaryFileService {

	private Logger logger = LogMannger.getLogger();

	@Autowired
	private BinaryFileDao binaryFileDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cms.core.commerce.common.service.BinaryFileService#uploadFile()
	 */
	@Override
	public BinaryFileDto uploadFile(MultipartFile file) {
		BinaryFileDto binaryFileDto = null;
		try {

			binaryFileDto = new BinaryFileDto();

			/*BASE64Encoder decode = new BASE64Encoder();
			String imageStr = decode.encode(file.getBytes());*/
			
			String imageStr = new String(file.getBytes());

			binaryFileDto.setContent(imageStr);
			this.insert(binaryFileDto);
		} catch (Exception e) {
			logger.error("文件上传并存入数据库时发生异常，原因：{}", e.getMessage());
			throw new RuntimeException("文件上传并存入数据库时发生异常，原因："+e.getMessage());
		}
		return binaryFileDto;
	}

}
