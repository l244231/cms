/*
 * @(#)UploadFileUtil.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.cms.core.common.exception.UploadException;
import com.cms.core.common.properties.SystemProperties;
import com.cms.core.market.base.domain.NcpFileInfoDto;
import com.cms.core.market.base.domain.NcpImageInfoDto;

/**
 * @title 文件上传工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月13日 Zain.Luo create file<br>
 *              Id:UploadFileUtil.java,v1.0 2016年12月13日 下午3:01:31
 */
public class UploadFileUtil {
	private static Logger logger = LogMannger.getLogger();

	/**
	 * @Title: fileUpload
	 * @author: Zain.Luo
	 * @Description: 文件上传
	 * @param request
	 *            前端request请求
	 * @param filePath
	 *            指定文件存放路径
	 * @return UploadFiles 上传文件集合类
	 * @throws UploadException
	 *             文件上传异常
	 * @history: 2016年12月13日 created
	 */
	public static NcpFileInfoDto mediaUpload(MultipartFile file) throws UploadException {
		NcpFileInfoDto uploadFile = null;

		/* 判断是否指定存放路径，没有指定将存放在临时目录中 */
		String filePath = "";
		filePath = SystemProperties.getMediaUploadPath() + File.separator;

		/* 多文件上传处理逻辑 */
		try {

			// 取得上传文件
			if (file != null) {
				uploadFile = new NcpFileInfoDto();
				String originalFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (originalFileName.trim() != "") {
					String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
					uploadFile.setId(CreateSequenceKey.getIndexNum("FILE"));
					uploadFile.setSuffix(suffix);
					uploadFile.setName(uploadFile.getId()+"."+uploadFile.getSuffix());
					uploadFile.setPath(filePath+ uploadFile.getName());
					uploadFile.setSize(file.getSize());
					uploadFile.setType(suffix);
					uploadFile.setUpdateDate(new Date());

					File localFile = new File(uploadFile.getPath());
					checkPath(filePath, true);
					file.transferTo(localFile);
					logger.info("文件上传成功：" + uploadFile.getPath());
				}
			}

		} catch (IllegalStateException e) {
			logger.error("文件上传失败：" + e.getMessage());
			throw new UploadException("文件上传失败，请重新上传！");
		} catch (IOException e) {
			logger.error("文件上传失败：" + e.getMessage());
			throw new UploadException("文件上传失败，请确认文件是否正确！");
		}

		return uploadFile;
	}

	/**
	 * @Title:imageUpload
	 * @Author:Zain.Luo
	 * @Description:上传图片，默认限制图片大小600*600
	 * @param file
	 * @return
	 * @throws UploadException 
	 * @Created:2017年1月11日  上午12:40:17<br>
	 * @History:
	 */
	public static NcpImageInfoDto imageUpload(MultipartFile file) throws UploadException {

		/* 生成路径 */
		String filePath = "";
		filePath = SystemProperties.getImageUploadPath() + File.separator;

		NcpImageInfoDto image = null;
		try {
			// 取得上传文件
			if (file != null) {

				String originalFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (originalFileName.trim() != "") {
					String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
					BufferedImage buffImage = ImageIO.read(file.getInputStream());
					int maxWidth = SystemProperties.getImageMaxWidth();
					int maxHeight = SystemProperties.getImageMaxHeight();
					int actualWidth = buffImage.getWidth();
					int actualHeight = buffImage.getHeight();
					if (actualWidth > maxWidth || actualHeight > maxHeight) {
						logger.error("图片上传超限制，最大范围（宽*高）：{}，实际（宽*高）：{}", maxWidth + "*" + maxHeight, actualWidth + "*" + actualHeight);
						throw new RuntimeException("图片上传超限制，最大范围（宽*高）：" + maxWidth + "*" + maxHeight + "，实际（宽*高）：" + actualWidth + "*" + actualHeight);
					}

					image = new NcpImageInfoDto();
					image.setId(CreateSequenceKey.getIndexNum("IMAGE"));
					image.setSuffix(suffix);
					image.setName(image.getId()+"."+image.getSuffix());
					image.setPath(filePath + image.getName());
					image.setWidth(actualWidth);
					image.setHeight(actualHeight);

					File localFile = new File(image.getPath());
					checkPath(filePath, true);
					file.transferTo(localFile);
					logger.info("文件上传成功：" + image.getPath());
				}
			}

		} catch (IOException e) {
			logger.error("文件上传失败：" + e.getMessage());
			throw new UploadException("文件上传失败，请确认文件是否正确！");
		}

		return image;
	}
	
	/**
	 * @Title:imageUpload
	 * @Author:Zain.Luo
	 * @Description:上传图片，
	 * @param file 图片信息
	 * @param paramName 图片长宽配置参数名
	 * @return
	 * @throws UploadException 
	 * @Created:2017年1月11日  上午12:39:54<br>
	 * @History:
	 */
	public static NcpImageInfoDto imageUpload(MultipartFile file,String paramName) throws UploadException {

		/* 生成路径 */
		String filePath = "";
		filePath = SystemProperties.getImageUploadPath() + File.separator;

		NcpImageInfoDto image = null;
		try {
			// 取得上传文件
			if (file != null) {

				String originalFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (originalFileName.trim() != "") {
					String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
					BufferedImage buffImage = ImageIO.read(file.getInputStream());
					int maxWidth = SystemProperties.getImageMaxWidth(paramName);
					int maxHeight = SystemProperties.getImageMaxHeight(paramName);
					int actualWidth = buffImage.getWidth();
					int actualHeight = buffImage.getHeight();
					if (actualWidth > maxWidth || actualHeight > maxHeight) {
						logger.error("图片上传超限制，最大范围（宽*高）：{}，实际（宽*高）：{}", maxWidth + "*" + maxHeight, actualWidth + "*" + actualHeight);
						throw new RuntimeException("图片上传超限制，最大范围（宽*高）：" + maxWidth + "*" + maxHeight + "，实际（宽*高）：" + actualWidth + "*" + actualHeight);
					}

					image = new NcpImageInfoDto();
					image.setId(CreateSequenceKey.getIndexNum("IMAGE"));
					image.setSuffix(suffix);
					image.setName(image.getId()+"."+image.getSuffix());
					image.setPath(filePath + image.getId());
					image.setWidth(actualWidth);
					image.setHeight(actualHeight);

					File localFile = new File(image.getPath());
					checkPath(filePath, true);
					file.transferTo(localFile);
					logger.info("文件上传成功：" + image.getPath());
				}
			}

		} catch (IOException e) {
			logger.error("文件上传失败：" + e.getMessage());
			throw new UploadException("文件上传失败，请确认文件是否正确！");
		}

		return image;
	}
	
	/**
	 * @Title:imageUpload
	 * @Author:Zain.Luo
	 * @Description:上传图片，默认限制图片大小600*600
	 * @param file
	 * @return
	 * @throws UploadException 
	 * @Created:2017年1月11日  上午12:40:17<br>
	 * @History:
	 */
	public static NcpImageInfoDto imageListUpload(MultipartFile file) throws UploadException {

		/* 生成路径 */
		String filePath = "";
		filePath = SystemProperties.getImageUploadPath() + File.separator;

		NcpImageInfoDto image = null;
		try {
			// 取得上传文件
			if (file != null) {

				String originalFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (originalFileName.trim() != "") {
					String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
					BufferedImage buffImage = ImageIO.read(file.getInputStream());
					int maxWidth = SystemProperties.getImageMaxWidth();
					int maxHeight = SystemProperties.getImageMaxHeight();
					int actualWidth = buffImage.getWidth();
					int actualHeight = buffImage.getHeight();
					if (actualWidth > maxWidth || actualHeight > maxHeight) {
						logger.error("图片上传超限制，最大范围（宽*高）：{}，实际（宽*高）：{}", maxWidth + "*" + maxHeight, actualWidth + "*" + actualHeight);
						throw new RuntimeException("图片上传超限制，最大范围（宽*高）：" + maxWidth + "*" + maxHeight + "，实际（宽*高）：" + actualWidth + "*" + actualHeight);
					}

					image = new NcpImageInfoDto();
					image.setId(CreateSequenceKey.getIndexNum("IMAGE"));
					image.setSuffix(suffix);
					image.setName(image.getId()+"."+image.getSuffix());
					image.setPath(filePath + image.getName() );
					image.setWidth(actualWidth);
					image.setHeight(actualHeight);

					File localFile = new File(image.getPath());
					checkPath(filePath, true);
					file.transferTo(localFile);
					logger.info("文件上传成功：" + image.getPath());
				}
			}

		} catch (IOException e) {
			logger.error("文件上传失败：" + e.getMessage());
			throw new UploadException("文件上传失败，请确认文件是否正确！");
		}

		return image;
	}

	/**
	 * @Title: checkPath
	 * @author: Zain.Luo
	 * @Description: 判断文件路径是否存在，根据create进行创建路径。
	 * @param path
	 *            文件路径
	 * @param create
	 *            是否创建该路径true创建路径，false不创建路径
	 * @return boolean 路径是否存在，如果路径不存在，并通过该方法进行创建后，返回true。
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public static boolean checkPath(String path, boolean create) {
		File dir = new File(path);
		if (dir.exists()) {
			return true;
		} else if (create) {
			dir.mkdirs();
			return true;
		}
		return false;
	}
}
