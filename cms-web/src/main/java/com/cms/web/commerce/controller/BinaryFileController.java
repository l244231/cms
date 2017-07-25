/*
 * @(#)BinaryFileController.java
 * Author : Zain.Luo
 * Created Date: 2017年1月6日 
 */
package com.cms.web.commerce.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cms.core.commerce.commodity.service.CommodityIconsService;
import com.cms.core.commerce.common.service.BinaryFileService;
import com.cms.core.common.util.LogMannger;
import com.cms.hb.commerce.common.domain.BinaryFileHbDto;
import com.cms.hb.commerce.common.service.BinaryFileHbService;
import com.cms.web.common.controller.BaseController;

/**
 * @title 电商文件管理controller类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月6日 Zain.Luo create file<br>
 *              Id:BinaryFileController.java,v1.0 2017年1月6日 下午11:20:29
 */
@Controller
@RequestMapping("/commerce/binaryFile")
@Scope("prototype")
public class BinaryFileController extends BaseController {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private BinaryFileService binaryFileService;

	@Autowired
	private CommodityIconsService commodityIconsService;

	@Autowired
	private BinaryFileHbService binaryFileHbService;

	/**
	 * @Title: getFileById
	 * @author: Zain.Luo
	 * @Description: 通过文件ID，获取文件流
	 * @param request
	 * @param response
	 * @return void
	 * @throws @history:
	 *             2017年1月6日 created
	 */
	@RequestMapping("getFileById")
	public void getFileById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return;
		}

		/* 获取流 */
		InputStream in = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		OutputStream out = null;
		try {
			out = response.getOutputStream(); 
			BinaryFileHbDto dto = binaryFileHbService.findById(Long.parseLong(id));
			if (dto == null || dto.getContent() == null) {
				return;
			}
			in = dto.getContent().getBinaryStream();

			bis = new BufferedInputStream(in);
			byte[] data = new byte[1024];
			int length = 0;
			while ((length = bis.read(data)) > 0) {
				out.write(data,0,length);
				out.flush();
			}
			
		} catch (SQLException e) {
			logger.error("根据ID【{}】获取图片，数据读取时发生异常：{}",id, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("根据ID【{}】获取图片，输出图片时发生异常：{}",id, e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
					bis = null;
				} 
				if (in != null) {
					in.close();
					in = null;
				}
				if(out != null){
					out.close();
					out = null;
				}
			} catch (Exception e2) {
				logger.error("根据ID【{}】获取图片，关闭资源时发生异常：{}",id, e2.getMessage());
				e2.printStackTrace();
			}
		}
	}
	

	/**
	 * 根据id删除文件
	 * 
	 * @Title:del
	 * @Author:lijx
	 * @Description:TODO
	 * @param request
	 * @param response
	 * @param id
	 * @Created:2017年1月14日 上午12:27:56<br>
	 * @History:
	 */
	@RequestMapping("del")
	public void del(HttpServletRequest request, HttpServletResponse response, long id) {
		// 先删除图片文件关联
		if (commodityIconsService.deleteByFileId(id)) {
			boolean boo = binaryFileService.delete(id);
			if (boo) {
				returnOperationResult("Y", "删除成功");
			} else {
				returnOperationResult("N", "删除失败");
			}
		} else {
			returnOperationResult("N", "删除失败");
		}
	}

	/**
	 * @Title: uploadBinaryFile
	 * @author: Zain.Luo
	 * @Description: 对上传的文件转换成二进制，并存入数据库中
	 * @param request
	 * @param file
	 * @return void
	 * @throws @history:
	 *             2017年1月6日 created
	 */
	@RequestMapping("upload")
	public void uploadBinaryFile(HttpServletRequest request, @RequestParam("imgFile") MultipartFile file) {
		try {
			BinaryFileHbDto fileDto = binaryFileHbService.insertImage(file);
			if (fileDto != null) {
				returnOperationResult("Y", fileDto.getId() + "");
			} else {
				returnOperationResult("N", "文件上传失败，请刷新后重试");
			}
		} catch (Exception e) {
			logger.error("上传文件转换成二进制，并存入数据库时发生异常，原因：", e.getMessage());
			returnOperationResult("N", "文件上传异常，信息：" + e.getMessage());
		}
	}

}
