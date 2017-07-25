/*
 * @(#)ShopInterceptor.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.web.common.handler;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cms.core.common.util.LogMannger;
import com.cms.web.common.constant.GlobalConstant;

/**
 * @title shop拦截器
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月13日 Zain.Luo create file<br>
 *              Id:ShopInterceptor.java,v1.0 2016年12月13日 下午4:03:47
 */
public class ShopInterceptor implements HandlerInterceptor {
	private Logger logger = LogMannger.getLogger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		String basePath = request.getContextPath(); // 项目路径
		request.setAttribute("basePath", basePath);

		String picPath = basePath + GlobalConstant.PIC_PATH; // 图片路径
		request.setAttribute("picPath", picPath);

	}

	/* 调用controller前动作 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		Enumeration<String> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String[] value = request.getParameterValues(name);
			if (value.length > 1) {
				map.put(name, value);
			} else {
				map.put(name, request.getParameter(name));
			}
		}

		String uri = request.getRequestURI();
		if (StringUtils.isNotEmpty(uri) && uri.indexOf("js") < 0 && uri.indexOf("css") < 0 && uri.indexOf(".") < 0) {
			logger.info("请求URI：{},请求参数：{}", JSON.toJSONString(uri), JSON.toJSONString(map));
		} else {
			if (logger.isDebugEnabled()) {
				//				logger.info("请求静态资源URI：{}", JSON.toJSONString(uri));
			}
		}

		return true;
	}

}
