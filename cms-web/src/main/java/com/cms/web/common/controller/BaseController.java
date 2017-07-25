package com.cms.web.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.cms.core.common.util.LogMannger;
import com.cms.web.common.entity.PageVo;
import com.github.pagehelper.PageInfo;

/**
 * 所有controller的基类
 * 
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月20日 下午10:07:18 lijx <br>
 * @History:
 */
public class BaseController {

	private Logger logger = LogMannger.getLogger();

	

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 将对象封装成JSON且回写到页面
	 * 
	 * @Title:writeJson
	 * @Author:lijx
	 * @Description:TODO
	 * @param obj
	 * @Created:2016年12月20日 下午10:07:55<br>
	 * @History:
	 */
	public void writeJson(Object obj) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			logger.debug("JSON输出{}", JSON.toJSONString(obj));
			pw.write(JSON.toJSONString(obj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.debug("writeJson异常:{},obj:{}", e.getMessage(), JSON.toJSONString(obj));
		}
	}

	/**
	 * 将对象封装成JSON且回写到页面
	 * 
	 * @Title:writeJson
	 * @Author:lijx
	 * @Description:TODO
	 * @param obj
	 * @Created:2016年12月20日 下午10:07:55<br>
	 * @History:
	 */
	public void writeJson(Object obj, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			logger.debug("JSON输出{}", JSON.toJSONString(obj));
			pw.write(JSON.toJSONString(obj));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("writeJson异常:{},obj:{}", e.getMessage(), JSON.toJSONString(obj));
		}
	}

	/**
	 * 将Page分页信息封装成前台需要的JSON格式且回写到页面
	 * 
	 * @Title:writePageJson
	 * @Author:lijx
	 * @Description:TODO
	 * @param page
	 * @Created:2016年12月21日 下午11:42:38<br>
	 * @History:
	 */
	public void writePageJson(PageInfo<?> page) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(getPageMap(page)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.debug("writeJson异常:{},obj:{}", e.getMessage(), JSON.toJSONString(getPageMap(page)));
		}
	}

	/**
	 * 转化为前台需要的分页JSON
	 * 
	 * @Title:getPageInfo
	 * @Author:lijx
	 * @Description:TODO
	 * @param list
	 * @return
	 * @Created:2016年12月20日 下午10:22:00<br>
	 * @History:
	 */
	public Map<String, Object> getPageMap(PageInfo<?> page) {
		Map<String, Object> pageMap = new HashMap<String, Object>();

		pageMap.put("rows", page.getList());
		pageMap.put("total", page.getTotal());
		return pageMap;
	}

	/**
	 * 将前端传过来的分页参数转化为后端查询需要的参数 limit offset sort order
	 * 
	 * @Title:convertToPageParams
	 * @Author:lijx
	 * @Description:TODO
	 * @param vo
	 * @return
	 * @Created:2016年12月21日 下午10:44:34<br>
	 * @History:
	 */
	public Map<String, Object> convertToPageParams(PageVo vo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("limit", vo.getLimit());
		params.put("offset", vo.getOffset());
		params.put("sort", vo.getSort());
		params.put("order", vo.getOrder());
		params.put("pageNumber", vo.getPageNumber());
		params.put("pageSize", vo.getPageSize());
		return params;
	}

	/**
	 * @Title:returnOperationResult
	 * @Author:Zain.Luo
	 * @Description:操作返回前台结果封装
	 * @param flag
	 *            操作结果 ，Y：成功，N失败
	 * @param message
	 *            信息提示
	 * @Created:2016年12月22日 上午12:43:50<br>
	 * @History:
	 */
	public void returnOperationResult(String flag, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter pw = response.getWriter();
			result.put("flag", flag);
			result.put("message", message);
			pw.write(JSON.toJSONString(result));
			logger.debug("flag:{},message{}",flag,message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Title:decodeStr
	 * @Author:Zain.Luo
	 * @Description:将ISO编码转换成UTF-8
	 * @param str
	 * @return 
	 * @Created:2016年12月28日  下午11:25:04<br>
	 * @History:
	 */
	public String decodeStr(String str) {
		String result = null;
		try {
			if (str != null)
				result = new String(str.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
