/*
 * @(#)TestController.java
 * Author : Zain.Luo
 * Created Date: 2016年11月2日 
 */
package com.cms.web.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.hb.commerce.common.domain.BinaryFileHbDto;
import com.cms.hb.commerce.common.service.BinaryFileHbService;

/**
 * @title 测试类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年11月2日 Zain.Luo create file<br>
 *              Id:TestController.java,v1.0 2016年11月2日 下午4:33:17
 */
@Controller
@Scope("prototype")
public class TestController {

	@Autowired
	private BinaryFileHbService binaryFileHbService;

	/*
	 * @Autowired private NotesMngService notesMngService;
	 */
	// @RequestMapping("main")
	public String testController(HttpServletRequest request, HttpServletResponse resopnse) {
		/*
		 * logger.info("test info"); logger.trace("test trace"); logger.debug(
		 * "test debug"); logger.error("test error"); Map<String,Object> params
		 * = new HashMap<String,Object>(); Map<String,Object> result =
		 * notesMngService.queryCommodityCategoryInfo(params, null);
		 */
		return "cms/main/main";
	}

	// @RequestMapping("page")
	public String tagController(HttpServletRequest request, HttpServletResponse resopnse) {

		return "cms/commerce/page/page";
	}

	// @RequestMapping("testBeetl")
	public ModelAndView testBeetlDemo(HttpServletRequest request, HttpServletResponse resopnse) {
		return new ModelAndView("beetl", "message", "Hello World");
	}

	/**
	 * @Title: uploadFile
	 * @author: Zain.Luo
	 * @Description: 文件上传
	 * @param request
	 * @param resopnse
	 * @return
	 * @return String
	 * @throws @history:
	 *             2016年11月4日 created
	 */
	// @RequestMapping("testUpload")
	public void uploadFile(HttpServletRequest request, HttpServletResponse resopnse) {

		// UploadFiles files;
		// files = UploadFileUtil.fileUpload(request);
		// System.out.println(files.getFile(0).getFileName());

	}

	@RequestMapping("loadFile")
	public void loadFile(HttpServletRequest request, HttpServletResponse resopnse) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://139.196.149.9:5432/eshop", "root", "db@123$");
			String sql = "select content from binary_file where id = 41";
			LargeObjectManager lobj = ((org.postgresql.PGConnection) conn).getLargeObjectAPI();

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			OutputStream out = new FileOutputStream(new File("E:\\Test\\test.txt"));
			InputStream in = null;
			byte[] data = new byte[1024];
			BufferedOutputStream bos = new BufferedOutputStream(out);
			Blob blob = null;

			while (rs.next()) {

				Long test = rs.getLong(1);
				LargeObject obj = lobj.open(test, false);
				for (int i; (i = obj.read(data, 0, 1024)) > 0;) {
					bos.write(data);
				}
				bos.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("findById")
	public void findById(HttpServletRequest request, HttpServletResponse resopnse) {
		InputStream in = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(resopnse.getOutputStream());

			BinaryFileHbDto dto = binaryFileHbService.findById(41);
			if (dto == null || dto.getContent() == null) {
				return;
			}
			in = dto.getContent().getBinaryStream();

			bis = new BufferedInputStream(in);
			byte[] data = new byte[1024];
			while ((bis.read(data)) > 0) {
				bos.write(data);
			}
			bos.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				if (bis != null) {
					bis.close();
					bis = null;
				}
				if (bos != null) {
					bos.close();
					bos = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
