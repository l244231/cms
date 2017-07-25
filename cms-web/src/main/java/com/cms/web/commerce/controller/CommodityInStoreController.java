/*
 * @(#)CommodityInStoreController.java
 * Author : Zain.Luo
 * Created Date: 2017年1月8日 
 */
package com.cms.web.commerce.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @title 入库记录Controller类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月8日 Zain.Luo create file<br>
 *              Id:CommodityInStoreController.java,v1.0 2017年1月8日 下午5:22:02
 */
@Controller
@RequestMapping("/commerce/inStore")
public class CommodityInStoreController extends BaseController {

	@Autowired
	private CommodityInStoreService commodityInStoreService;

	/** 
	* @Title: detial 
	* @author: Zain.Luo
	* @Description: 进入库存页面
	* @param request
	* @param response
	* @return    
	* @return ModelAndView    
	* @throws 
	* @history: 2017年1月8日 created
	*/
	@RequestMapping("detail")
	public ModelAndView detial(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageType", request.getParameter("pageType"));
		return mav;
	}

	/** 
	* @Title: search 
	* @author: Zain.Luo
	* @Description: 查询
	* @param request
	* @param response    
	* @return void    
	* @throws 
	* @history: 2017年1月8日 created
	*/
	@RequestMapping("search")
	public void search(HttpServletRequest request, HttpServletResponse response, PageVo vo) {
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			Map<String, Object> params = convertToPageParams(vo);
			if (StringUtils.isNotEmpty(request.getParameter("relativeId"))) {
				params.put("relativeId", Long.parseLong(request.getParameter("relativeId")));
			}
			if (StringUtils.isNotEmpty(request.getParameter("commodityId"))) {
				params.put("commodityId", Long.parseLong(request.getParameter("commodityId")));
			}
			if (StringUtils.isNotEmpty(request.getParameter("type"))) {
				params.put("type", Short.parseShort(request.getParameter("type")));
			}
			writeJson(getPageMap(commodityInStoreService.findListByParams(params)), response);
		}

	}
}
