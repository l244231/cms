package com.cms.web.commerce.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.cms.core.commerce.commodity.domain.BenefitDto;
import com.cms.core.commerce.commodity.domain.CommodityDiscountDto;
import com.cms.core.commerce.commodity.domain.CommodityInStoreDto;
import com.cms.core.commerce.commodity.domain.InStoreDto;
import com.cms.core.commerce.commodity.service.CommodityDiscountService;
import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.commerce.other.service.DeliveryTagsService;
import com.cms.core.common.entity.BaseParams;
import com.cms.core.common.util.DateUtil;
import com.cms.core.common.util.LogMannger;
import com.cms.core.demo.service.CommodityCategoryService;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @Title:限时优惠
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月13日 上午12:24:25 Zain.Luo <br>
 * @History:
 */
@Controller
@RequestMapping("/commerce/benefit")
public class BenefitController extends BaseController {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private CommodityDiscountService commodityDiscountService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private NcpShopService ncpShopService; 

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private DeliveryTagsService deliveryTagsService;

	@Autowired
	private CommodityInStoreService commodityInStoreService;

	@RequestMapping("page")
	public ModelAndView toPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("cms/commerce/benefit/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	@RequestMapping("detail")
	public ModelAndView toDetail(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("cms/commerce/benefit/detail");
		CommodityDiscountDto benefit = commodityDiscountService.findById(Long.parseLong(id));
		mav.addObject("benefit", benefit);
		mav.addAllObjects(commodityService.getCommodityInfoMap(benefit.getCommodityId()));
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("cms/commerce/benefit/form");
		String commodityId = request.getParameter("commodityId");
		if (StringUtils.isEmpty(commodityId)) {
			Map<String, Object> params = new HashMap<String, Object>();
			mav.addObject("deliveryTagsDtoList", deliveryTagsService.findAllList());
			params.put("isVirtual", 1);
			mav.addObject("ncpShopDtoList", ncpShopService.findAllListByParams(params));
		} else {
			mav.addObject("commodityId", commodityId);
			mav.addAllObjects(commodityService.getCommodityInfoMap(Long.parseLong(commodityId)));
		}

		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("cms/commerce/benefit/form");
		CommodityDiscountDto benefit = commodityDiscountService.findById(Long.parseLong(id));
		mav.addObject("benefit", benefit);
		mav.addAllObjects(commodityService.getCommodityInfoMap(benefit.getCommodityId()));
		return mav;
	}

	@RequestMapping("choice")
	public ModelAndView choice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("cms/commerce/benefit/choice");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isVirtual", 1);
		mav.addObject("shopList", ncpShopService.findAllListByParams(params));
		mav.addObject("categoryList", commodityCategoryService.findAllListByParams(params));
		return mav;
	}

	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			returnOperationResult("N", "操作失败，该限时优惠信息不存在,请刷新后重试！");
			return;
		}
		try {
			commodityDiscountService.delete(Long.parseLong(id));
			returnOperationResult("Y", "操作成功！");
		} catch (Exception e) {
			logger.error("删除限时优惠信息时发生异常，原因：{}", e.getMessage());
			returnOperationResult("N", "操作成功，原因:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("search")
	public void search(HttpServletRequest request, HttpServletResponse response, PageVo vo, BaseParams bParams) {
		Map<String, Object> params = convertToPageParams(vo);
		params.put("commodityName", decodeStr(bParams.getKeyWord()));
		params.put("homeRecommended", bParams.getIsHome());
		params.put("type", bParams.getType());
		writeJson(getPageMap(commodityDiscountService.findListByParams(params)));
	}

	@RequestMapping("recommend")
	public void recommend(HttpServletRequest request, HttpServletResponse response, BaseParams bParams) {
		if (bParams.getId() == 0) {
			returnOperationResult("N", "操作失败，该限时优惠信息不存在,请刷新后重试！");
		}
		try {
			CommodityDiscountDto dto = new CommodityDiscountDto();
			dto.setId(bParams.getId());
			dto.setHomeRecommended(bParams.getIsHome());

			commodityDiscountService.update(dto);
			returnOperationResult("Y", "操作成功！");
		} catch (Exception e) {
			logger.error("推荐限时优惠发生异常，原因：{}", e.getMessage());
			returnOperationResult("N", "操作失败，原因:" + e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response, BenefitDto benefit) {
		CommodityDiscountDto discount = new CommodityDiscountDto();
		discount.setCreationTime(new Date());
		discount.setStartTime(DateUtil.stringToDate(benefit.getStartTime(), "yyyy-MM-dd"));
		discount.setExpiryTime(DateUtil.stringToDate(benefit.getExpiryTime(), "yyyy-MM-dd"));
		discount.setSortId(benefit.getSortId());
		discount.setHomeRecommended(benefit.getHomeRecommended());
		discount.setSingleSold(benefit.getSingleSold());
		discount.setPrice(benefit.getPrice());
		discount.setStatus(benefit.getStatus());
		discount.setCommodityId(benefit.getCommodityId());
		try {
			if (StringUtils.isEmpty(benefit.getId())) {
				discount.setStock(benefit.changeStock());
				commodityDiscountService.insert(discount);
				CommodityInStoreDto inStore = new CommodityInStoreDto();
				inStore.setCommodityId(benefit.getCommodityId());
				inStore.setInStoreAmount(benefit.changeStock());
				inStore.setInStoreTime(new Date());
				inStore.setStoreAmount(benefit.changeStock());
				inStore.setStatus(CommodityConstant.CommodityStatus.IS_SALSE);
				inStore.setRelativeId(discount.getId());
				commodityInStoreService.insert(inStore);
				returnOperationResult("Y", "操作成功！");
			} else {
				discount.setId(Long.parseLong(benefit.getId()));
				commodityDiscountService.update(discount);
				returnOperationResult("Y", "操作成功！");
			}
		} catch (Exception e) {
			logger.error("限时优惠操作发生异常，ID：{}，原因：{}", benefit.getId(), e.getMessage());
			returnOperationResult("N", "操作失败，原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @Title: inStore
	 * @author: Zain.Luo
	 * @Description: 入库操作
	 * @param request
	 * @param response
	 * @return void
	 * @throws @history:
	 *             2017年1月17日 created
	 */
	@RequestMapping("inStore")
	public void inStore(HttpServletRequest request, HttpServletResponse response, InStoreDto inStore) {
		try {

			CommodityDiscountDto dto = commodityDiscountService.findById(inStore.getRelativeId());
			CommodityInStoreDto cInStore = new CommodityInStoreDto();
			cInStore.setRelativeId(inStore.getRelativeId());
			cInStore.setCommodityId(inStore.getCommodityId());
			cInStore.setInStoreAmount(inStore.getStock());
			cInStore.setInStoreTime(new Date());
			cInStore.setStoreAmount(dto.getStock() + inStore.getStock());
			cInStore.setType(CommodityConstant.RelativeType.DISCOUNT);
			commodityInStoreService.insert(cInStore);

			dto.setStock(dto.getStock() + inStore.getStock());
			commodityDiscountService.updateStock(dto);
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			logger.error("优惠商品添加库存失败，原因：{}", e.getMessage());
			returnOperationResult("N", "操作发生异常，原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

}
