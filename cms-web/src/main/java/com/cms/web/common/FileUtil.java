/*
 * @(#)FileUtil.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import com.cms.core.common.util.LogMannger;
import com.cms.core.market.base.domain.NcpFileInfoDto;
import com.cms.core.market.base.domain.NcpImageInfoDto;

/**
 * @title 文件操作工具类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月5日 Zain.Luo create file<br>
 *              Id:FileUtil.java,v1.0 2017年1月5日 上午10:14:27
 */
public class FileUtil {
	private static Logger logger = LogMannger.getLogger();

	/**
	 * @Title: writeMediaFile
	 * @author: Zain.Luo
	 * @Description: 将视频，音频文件输出至前台
	 * @param file
	 *            文件信息
	 * @param response
	 * @return void
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	public static void writeMediaFile(NcpFileInfoDto file, HttpServletResponse response) {
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();
			is = new FileInputStream(new File(file.getPath()));
			byte[] buffer = new byte[10*1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer);
				os.flush();
			}
		} catch (IOException e) {
			logger.error("输出视频/音频文件错误，原因:{}", e.getMessage());
			//throw new RuntimeException("输出视频/音频文件错误，原因:" + e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("IO流关闭异常，原因：{}", e.getMessage());
				throw new RuntimeException("IO流关闭异常，原因："+e.getMessage());
			}
		}
	}
	
	/** 
	* @Title: writeImageFile 
	* @author: Zain.Luo
	* @Description: 将图片以流的形式返回前台
	* @param image
	* @param response    
	* @return void    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	public static void writeImageFile(NcpImageInfoDto image, HttpServletResponse response) {
		OutputStream os = null;
		InputStream is = null;
		try {
			os = response.getOutputStream();
			is = new FileInputStream(new File(image.getPath()));
			if(is != null){
				byte[] buffer = new byte[1024];
				int length;
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer);
				}
			}
		} catch (IOException e) {
			logger.error("输出图片文件发生异常，原因:{}", e.getMessage());
			throw new RuntimeException("输出图片文件发生异常，原因:" + e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				logger.error("IO流关闭异常，原因：{}", e.getMessage());
				throw new RuntimeException("IO流关闭异常，原因："+e.getMessage());
			}
		}
	}
}
