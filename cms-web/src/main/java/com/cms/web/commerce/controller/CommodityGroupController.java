package com.cms.web.commerce.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.commerce.commodity.domain.CommodityGroupDto;
import com.cms.core.commerce.commodity.domain.CommodityInStoreDto;
import com.cms.core.commerce.commodity.domain.InStoreDto;
import com.cms.core.commerce.commodity.service.CommodityGroupService;
import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.common.entity.BaseParams;
import com.cms.core.common.util.LogMannger;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * 
 * @Title: 团购管理
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月21日 下午8:42:29 lijx <br>
 * @History:
 */
@Controller
@RequestMapping("commerce/commodityGroup")
public class CommodityGroupController extends BaseController {

	Logger logger = LogMannger.getLogger();

	@Autowired
	private CommodityGroupService commodityGroupService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CommodityInStoreService commodityInStoreService;

	/**
	 * @Title:toPage
	 * @Author:lijx
	 * @Description:跳转列表页面
	 * @return
	 * @Created:2016年12月21日 下午9:04:20<br>
	 * @History:
	 */
	@RequestMapping("page")
	public ModelAndView toPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cms/commerce/commodityGroup/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	/**
	 * @Title:toCommodityUserPage
	 * @Author:lijx
	 * @Description:跳转参团人列表
	 * @return
	 * @Created:2016年12月26日 下午10:47:39<br>
	 * @History:
	 */
	@RequestMapping("toCommodityGroupUserPage")
	public ModelAndView toCommodityGroupUserPage(HttpServletRequest request) {

		long commodityGroupId = Long.parseLong(request.getParameter("commodityGroupId"));
		logger.info("commodityGroupId:{}", commodityGroupId);
		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodityGroup/commodityGroupUserPage");
		modelAndView.addObject("commodityGroupId", commodityGroupId);

		return modelAndView;
	}

	/**
	 * @Title:toAdd
	 * @Author:lijx
	 * @Description:跳转新增页面
	 * @param request
	 * @return 
	 * @Created:2017年1月17日  上午12:41:53<br>
	 * @History:
	 */
	@RequestMapping("add")
	public ModelAndView toAdd(HttpServletRequest request) {

		String commodityId = request.getParameter("commodityId");

		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodityGroup/form");

		if (StringUtils.isNotEmpty(commodityId)) {
			modelAndView.addObject("commodityId", commodityId);
			modelAndView.addAllObjects(commodityService.getCommodityInfoMap(Long.parseLong(commodityId)));
		}

		modelAndView.addObject("method", "add");
		modelAndView.addObject("commodityTypeForUrl", "commodityGroup");
		modelAndView.addObject("isEdit", false);

		return modelAndView;
	}

	/**
	 * 
	 * @Title:detail
	 * @Author:lijx
	 * @Description:查看团购详情
	 * @param request
	 * @param id
	 * @Created:2016年12月28日 下午9:26:53<br>
	 * @History:
	 */
	@RequestMapping("detail")
	public ModelAndView detail(HttpServletRequest request, long id) {

		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodityGroup/detail");

		modelAndView.addObject("id", id);

		CommodityGroupDto commodityGroupDto = commodityGroupService.findById(id);

		long commodityId = commodityGroupDto.getCommodityId();

		modelAndView.addAllObjects(commodityService.getCommodityInfoMap(commodityId));

		modelAndView.addObject("commodityGroupDto", commodityGroupDto);
		modelAndView.addObject("isEdit", false);

		return modelAndView;
	}

	/**
	 * @Title:toEdit
	 * @Author:lijx
	 * @Description:跳转编辑页面
	 * @param request
	 * @param id
	 * @return 
	 * @Created:2017年1月18日  上午12:22:00<br>
	 * @History:
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(HttpServletRequest request, long id) {

		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodityGroup/form");

		CommodityGroupDto commodityGroupDto = commodityGroupService.findById(id);
		long commodityId = commodityGroupDto.getCommodityId();
		modelAndView.addObject("id", id);
		modelAndView.addObject("commodityId", commodityId);

		modelAndView.addObject("commodityGroupDto", commodityGroupDto);
		modelAndView.addAllObjects(commodityService.getCommodityInfoMap(commodityId));

		modelAndView.addObject("isEdit", true);

		return modelAndView;
	}

	/**
	 * 查询
	 * 
	 * @Title:search
	 * @Author:lijx
	 * @Description:
	 * @param request
	 * @Created:2016年12月21日 下午8:43:07<br>
	 * @History:
	 */
	@RequestMapping("search")
	public void search(HttpServletRequest request, PageVo vo) {
		Map<String, Object> params = convertToPageParams(vo);

		if (!StringUtils.isEmpty(request.getParameter("para_home_recommended"))) {
			short home_recommended = 1;
			home_recommended = Short.parseShort(request.getParameter("para_home_recommended"));
			params.put("home_recommended", home_recommended);
		}

		if (!StringUtils.isEmpty(request.getParameter("para_keyword"))) {
			String keyword = request.getParameter("para_keyword");
			params.put("keyword", "%" + keyword.trim() + "%");
		}

		//status(未开始1、正在进行2、已过期3)根据时间来判定
		if (!StringUtils.isEmpty(request.getParameter("para_status"))) {
			short status = Short.parseShort(request.getParameter("para_status"));
			params.put("status", status);
		}

		writePageJson(commodityGroupService.findListByParams(params));
	}

	/**
	 * 
	 * @Title:commodityGroupUserSearch
	 * @Author:lijx
	 * @Description:参团人列表
	 * @param vo
	 * @Created:2016年12月26日 下午10:47:21<br>
	 * @History:
	 */
	@RequestMapping("commodityGroupUserPage")
	public void commodityGroupUserPage(HttpServletRequest request, PageVo vo) {
		Map<String, Object> params = convertToPageParams(vo);

		long commodityGroupId = Long.parseLong(request.getParameter("commodityGroupId"));
		params.put("commodityGroupId", commodityGroupId);

		writePageJson(commodityGroupService.findCommodityGroupUserByParams(params));
	}

	/**
	 * @Title:homeRecommended
	 * @Author:lijx
	 * @Description:推荐到首页
	 * @param id 
	 * @Created:2017年1月8日  下午1:03:57<br>
	 * @History:
	 */
	@RequestMapping("homeRecommended")
	public void homeRecommended(HttpServletRequest request,BaseParams bParams) {
		
		CommodityGroupDto commodityGroupDto = commodityGroupService.findById(bParams.getId());
		commodityGroupDto.setHomeRecommended(bParams.getIsHome());
		if (commodityGroupService.update(commodityGroupDto) > 0) {
			returnOperationResult("Y", "推荐成功");
		} else {
			returnOperationResult("N", "推荐失败");
		}
	}

	/**
	 * 
	 * 
	 * @Title:del
	 * @Author:lijx
	 * @Description:删除记录，将status修改为5
	 * @param request
	 * @param id
	 * @Created:2016年12月23日 上午12:55:47<br>
	 * @History:
	 */
	@RequestMapping("del")
	public void del(HttpServletRequest request, long id) {
		if (commodityGroupService.delete(id)) {
			returnOperationResult("Y", "删除成功");
		} else {
			returnOperationResult("N", "删除失败");
		}
	}

	/**
	 * 
	 * @Title:save
	 * @Author:lijx
	 * @Description:保存团购商品
	 * @param request
	 * @param file
	 * @param commodityGroupDto 
	 * @Created:2017年1月17日  上午12:47:48<br>
	 * @History:
	 */
	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response, CommodityGroupDto commodityGroupDto, long commodityId) {
		commodityGroupDto.setCommodityId(commodityId);

		try {
			boolean isSuccess = false;
			if (commodityGroupDto.getId() != 0) {
				if (commodityGroupService.update(commodityGroupDto) > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
			} else {
				//保存入库记录
				CommodityInStoreDto inStore = new CommodityInStoreDto();
				inStore.setCommodityId(commodityGroupDto.getCommodityId());
				inStore.setInStoreAmount(commodityGroupDto.getStock());
				inStore.setInStoreTime(new Date());
				inStore.setStoreAmount(commodityGroupDto.getStock());
				inStore.setStatus(CommodityConstant.CommodityStatus.IS_SALSE);
				inStore.setType(CommodityConstant.RelativeType.GROUP);
				inStore.setRelativeId(commodityGroupDto.getId());
				commodityInStoreService.insert(inStore);

				if (commodityGroupService.insert(commodityGroupDto) > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
			}

			if (isSuccess) {
				returnOperationResult("Y", "保存成功");
			} else {
				returnOperationResult("N", "保存失败");
			}

		} catch (Exception e) {
			logger.error("保存失败：{}", e.getMessage());
			returnOperationResult("N", "保存失败");
		}
	}

	/**
	 * @Title:inStore
	 * @Author:lijx
	 * @Description:入库记录
	 * @param request
	 * @param response
	 * @param inStore 
	 * @Created:2017年1月18日  上午1:24:16<br>
	 * @History:
	 */
	@RequestMapping("inStore")
	public void inStore(HttpServletRequest request, HttpServletResponse response, InStoreDto inStore) {
		try {
			CommodityGroupDto commodityGroupDto = commodityGroupService.findById(inStore.getRelativeId());
			CommodityInStoreDto cInStore = new CommodityInStoreDto();
			cInStore.setRelativeId(inStore.getRelativeId());
			cInStore.setCommodityId(inStore.getCommodityId());
			cInStore.setInStoreAmount(inStore.getStock());
			cInStore.setInStoreTime(new Date());
			cInStore.setStoreAmount(commodityGroupDto.getStock() + inStore.getStock());
			cInStore.setType(CommodityConstant.RelativeType.GROUP);
			commodityInStoreService.insert(cInStore);

			commodityGroupDto.setStock(commodityGroupDto.getStock() + inStore.getStock());
			commodityGroupService.updateStock(commodityGroupDto);
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			logger.error("团购添加库存失败，原因：{}", e.getMessage());
			returnOperationResult("N", "操作失败");
			e.printStackTrace();
		}
	}
}
