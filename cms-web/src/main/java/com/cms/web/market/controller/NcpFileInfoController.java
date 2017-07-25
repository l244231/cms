/*
 * NcpFileInfoController.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月5日  <br>
 */
package com.cms.web.market.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cms.core.common.util.UploadFileUtil;
import com.cms.core.market.base.domain.NcpFileInfoDto;
import com.cms.core.market.base.service.NcpFileInfoService;
import com.cms.web.common.FileUtil;
import com.cms.web.common.controller.BaseController;

/**
 * @Title:文件表controller类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月5日 上午12:15:17 Zain.Luo <br>
 * @History:
 */
@Controller
@RequestMapping("/market/ncpFileInfo")
public class NcpFileInfoController extends BaseController {

	@Autowired
	private NcpFileInfoService ncpFileInfoService;

	/**
	 * @Title:getFileById
	 * @Author:Zain.Luo
	 * @Description:通过文件编号获取文件流，并返回前台
	 * @param request
	 * @param resopnse
	 * @Created:2017年1月5日 上午12:18:30<br>
	 * @History:
	 */
	@RequestMapping("getFileById")
	public void getFileById(HttpServletRequest request, HttpServletResponse resopnse) {
		try {
			String id = request.getParameter("id");
			if (id == null || id == "") {
				return;
			}
			NcpFileInfoDto file = ncpFileInfoService.findById(id);
			FileUtil.writeMediaFile(file, resopnse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	@RequestMapping("uploadMediaFile")
	public void uploadMediaFile(HttpServletRequest request,HttpServletResponse response) {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			MultipartFile file = multipartRequest.getFile("videoFile");   
			
			NcpFileInfoDto media = UploadFileUtil.mediaUpload(file);
			if (media == null) {
				returnOperationResult("N", "文件上传失败，请重试");
				return;
			}
			ncpFileInfoService.insert(media);
			returnOperationResult("Y",media.getId());
		} catch (Exception e) {
			returnOperationResult("N", e.getMessage());
		}
	}
	
}
