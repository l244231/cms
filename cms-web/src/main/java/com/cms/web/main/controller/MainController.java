package com.cms.web.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.commerce.commodity.domain.CommodityCategoryDto;
import com.cms.core.common.properties.SystemProperties;
import com.cms.core.common.util.LogMannger;
import com.cms.core.demo.service.CommodityCategoryService;
import com.cms.web.common.constant.GlobalConstant;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;
import com.github.pagehelper.PageInfo;

@Controller
public class MainController extends BaseController {

	private Logger logger = LogMannger.getLogger();

	 
	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@RequestMapping("main")
	public ModelAndView testController(HttpServletRequest request, HttpServletResponse response) {

		// 菜单json
		/**
		 * [ { tid:"模块id", tname:"模块名称", menu:[{ url:"", name:"", active:
		 * "是否展开true or false", icon:"没有就默认图标,具体参考Font Awesome 4.4.0",
		 * children:[ { url:"", name:"" },{ url:"", name:"" } ] }] } ]
		 */

		StringBuffer menus = new StringBuffer();
		menus.append("[");
		menus.append("{tid:1,tname:\"商场管理CMS\"}");
		menus.append("]");
		ModelAndView modelAndView = new ModelAndView("cms/main/main");

		modelAndView.addObject("menus", menus.toString());

		return modelAndView;
	}

	@RequestMapping("getCommodityCategory")
	public void getCommodityCategory(PageVo vo) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("limit", vo.getLimit());
		params.put("offset", vo.getOffset());
		params.put("sort", vo.getSort());
		params.put("order", vo.getOrder());

		PageInfo<CommodityCategoryDto> page = commodityCategoryService.findListByPage(params);

		logger.info("分页参数:offset:{},limit:{},sort:{},order:{}", vo.getOffset(), vo.getLimit(), vo.getSort(), vo.getOrder());

		Map<String, Object> pageMap = getPageMap(page);
		writeJson(pageMap);
	}

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("cms/main/main");
		return modelAndView;
	}

	@RequestMapping("page")
	public String tagController(HttpServletRequest request, HttpServletResponse resopnse) {

		return "cms/commerce/page/page";
	}

	@RequestMapping("testBeetl")
	public ModelAndView testBeetlDemo(HttpServletRequest request, HttpServletResponse resopnse) {
		return new ModelAndView("beetl", GlobalConstant.MESSAGE, "Hello World");
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
	@RequestMapping("testUpload")
	public void uploadFile(HttpServletRequest request, HttpServletResponse resopnse) {

		// files = UploadFileUtil.fileUpload(request);

	}

	@RequestMapping("testSqlServer")
	public void testSqlServer(HttpServletRequest request, HttpServletResponse resopnse) {
		System.out.println(SystemProperties.getImageMaxHeight());
	}

}
