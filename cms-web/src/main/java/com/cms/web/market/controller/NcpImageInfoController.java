/*
 * @(#)NcpImageInfoController.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.web.market.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cms.core.common.util.LogMannger;
import com.cms.core.common.util.UploadFileUtil;
import com.cms.core.market.base.domain.NcpImageInfoDto;
import com.cms.core.market.base.service.NcpImageInfoService;
import com.cms.web.common.FileUtil;
import com.cms.web.common.controller.BaseController;

/**
 * @title 图片controller类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2017年1月5日 Zain.Luo create file<br>
 * Id:NcpImageInfoController.java,v1.0 2017年1月5日 下午3:06:57
 */
@Controller
@RequestMapping("/market/ncpImageInfo")
public class NcpImageInfoController extends BaseController{
	private Logger logger = LogMannger.getLogger();
	
	@Autowired
	private NcpImageInfoService ncpImageInfoService;
	
	@RequestMapping("getFileById")
	public void getFileById(HttpServletRequest request, HttpServletResponse resopnse) {
		try {
			String id = request.getParameter("id");
			if (id == null || id == "") {
				return;
			}
			NcpImageInfoDto image = ncpImageInfoService.findById(id);
			if(image != null)
			FileUtil.writeImageFile(image, resopnse);
		} catch (Exception e) {
			 logger.error("获取图片异常：{}",e.getMessage());
		}
	}
	
	/** 
	* @Title: uploadMediaFile 
	* @author: Zain.Luo
	* @Description: 视频/音频文件上传
	* @param request
	* @param response    
	* @return void    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	@RequestMapping("uploadImageFile")
	public void uploadImageFile(HttpServletRequest request,HttpServletResponse response) {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			MultipartFile file = multipartRequest.getFile("imgFile");    
			
			NcpImageInfoDto image = UploadFileUtil.imageUpload(file);
			if (image == null) {
				returnOperationResult("N", "文件上传失败，请重试");
				return;
			}
			ncpImageInfoService.insert(image);
			returnOperationResult("Y",image.getId());
		} catch (Exception e) {
			logger.error("图片上传异常：{}",e.getMessage());
			returnOperationResult("N", e.getMessage());
		}
	}
}	
