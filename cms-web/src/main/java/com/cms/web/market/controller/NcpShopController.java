/*
 * @(#)NcpShopController.java
 * Author : Zain.Luo
 * Created Date: 2017年1月7日 
 */
package com.cms.web.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.cms.core.common.entity.BaseParams;
import com.cms.core.market.base.service.NcpBuildingFloorService;
import com.cms.core.market.base.service.NcpPoiDataService;
import com.cms.core.market.business.domain.BrandDto;
import com.cms.core.market.business.domain.NcpShopDto;
import com.cms.core.market.business.domain.NcpShopRecommendDto;
import com.cms.core.market.business.service.NcpShopActivityService;
import com.cms.core.market.business.service.NcpShopBrandHomeService;
import com.cms.core.market.business.service.NcpShopRecommendService;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.core.market.business.service.NcpShopUserCommentService;
import com.cms.core.market.common.constant.BusinessConstant;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @title 商铺Controller类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月7日 Zain.Luo create file<br>
 *              Id:NcpShopController.java,v1.0 2017年1月7日 下午12:45:05
 */
@Controller
@RequestMapping("/market/ncpShop")
public class NcpShopController extends BaseController {
	@Autowired
	private NcpShopService ncpShopService;

	@Autowired
	private NcpShopActivityService ncpShopActivityService;

	@Autowired
	private NcpShopUserCommentService ncpShopUserCommentService;

	@Autowired
	private NcpBuildingFloorService ncpBuildingFloorService;

	@Autowired
	private NcpShopBrandHomeService ncpShopBrandHomeService;

	@Autowired
	private NcpShopRecommendService ncpShopRecommendService;

	@Autowired
	private NcpPoiDataService ncpPoiDataService;

	/**
	 * @Title: findById
	 * @author: Zain.Luo
	 * @Description: 通过商铺ID获取商铺信息
	 * @param request
	 * @param response
	 * @return void
	 * @throws @history:
	 *             2017年1月7日 created
	 */
	@RequestMapping("findById")
	public void findById(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return;
		} else {
			writeJson(ncpShopService.findById(Long.parseLong(id)));
		}
	}

	/**
	 * @Title:search
	 * @Author:Zain.Luo
	 * @Description:品牌管理，查询
	 * @param request
	 * @param response
	 * @param bparams
	 * @Created:2017年1月9日 下午9:02:22<br>
	 * @History:
	 */
	@RequestMapping("search")
	public void search(HttpServletRequest request, HttpServletResponse response, PageVo vo, BaseParams bparams) {
		Map<String, Object> params = convertToPageParams(vo);
		params.put("shopName", decodeStr(bparams.getKeyWord()));
		params.put("isHome", bparams.getIsHome());
		writeJson(getPageMap(ncpShopService.findListByParams(params)), response);
	}

	@RequestMapping("page")
	public ModelAndView page(HttpServletRequest request, HttpServletResponse resopnse) {
		ModelAndView mav = new ModelAndView("cms/market/shop/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/shop/form");
		modelAndView.addObject("floorList", ncpBuildingFloorService.findAllListByParams(null));
		modelAndView.addObject("typeList", ncpShopBrandHomeService.findAllListByParams(null));
		modelAndView.addObject("poiList", ncpPoiDataService.findAllListByParams(null));
		modelAndView.addObject("imgList", null);
		modelAndView.addObject("isEdit", true);
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/shop/form");
		String id = request.getParameter("id");
		Map<String,Object> params = new HashMap<String,Object>();
		
		if (!StringUtils.isEmpty(id)) {
			params.put("id", id);
			NcpShopDto shop = ncpShopService.findById(Long.parseLong(id));
			String recom = request.getParameter("recom");
			int isHome = shop.getIsHome();
			if(!StringUtils.isEmpty(recom) && Boolean.parseBoolean(recom) == true){
				shop.setIsHome(1);
			}
			modelAndView.addObject("shop", shop);
			String imgList = shop.getImageId() == null ? "" : shop.getImageId().toString();
			modelAndView.addObject("imgList", imgList.length() == 0 ? null : imgList.split(","));

			if (!StringUtils.isEmpty(shop.getShopHours())) {
				String[] timeArr = shop.getShopHours().split("-");
				if (timeArr.length != 0) {
					modelAndView.addObject("beginTime", timeArr[0]);
					modelAndView.addObject("endTime", timeArr[1]);
				}
			}
			
			if(isHome >0){
				
				params.put("shopId", shop.getId());
				modelAndView.addObject("homeImg",ncpShopRecommendService.queryByParams(params).get("image"));
				modelAndView.addObject("haveHomeImg","Y");
			}
		}
		
		modelAndView.addObject("floorList", ncpBuildingFloorService.findAllListByParams(null));
		modelAndView.addObject("typeList", ncpShopBrandHomeService.findAllListByParams(null));
		modelAndView.addObject("poiList", ncpPoiDataService.findAllListByParams(null));
		modelAndView.addObject("isEdit", true);
		return modelAndView;
	}

	@RequestMapping("detail")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/shop/detail");
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("shopId", id);
			params.put("id", id);
			Map shop = ncpShopService.queryByParams(params);
			modelAndView.addObject("shop", shop);
			String imgList = shop.get("imageId") == null ? "" : shop.get("imageId").toString();
			modelAndView.addObject("imgList", imgList.length() == 0 ? null : imgList.split(","));
			modelAndView.addObject("activityList", ncpShopActivityService.findAllListByParams(params));
			modelAndView.addObject("commentCount", ncpShopUserCommentService.countByParams(params));
			modelAndView.addObject("","");
			
			if(!shop.get("isHome").toString().equals("0")){
				params.put("shopId", id);
				modelAndView.addObject("homeImg",ncpShopRecommendService.queryByParams(params).get("image"));
			}
		}
		return modelAndView;
	}

	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("shopId", id);
			int count = ncpShopRecommendService.countByParams(params);
			if(count >0){
				returnOperationResult("N", "删除失败，原因：请先取消推荐首页！");
			}else{
				NcpShopDto shop = ncpShopService.findById(Long.parseLong(id));
				if(shop == null){
					returnOperationResult("N", "品牌不存在，请确认！");
				}
				
				/*判断是否为虚拟商铺，删除虚拟商铺时，需要删除实体商铺！删除实体商铺时，需要对应删除虚拟商铺*/
				if(StringUtils.isEmpty(shop.getPhysicalStore())){
					params.put("physicalStore", shop.getId());
					shop = ncpShopService.findByParams(params);
					ncpShopService.delete(shop.getId());
				}else{
					ncpShopService.delete(Long.parseLong(shop.getPhysicalStore()));
				}
				
				ncpShopService.delete(Long.parseLong(id));
				returnOperationResult("Y", "删除成功！");
			}
			
		} else {
			returnOperationResult("N", "品牌不存在，请确认！");
		}
	}

	@RequestMapping("setStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			params.put("status", request.getParameter("status"));
			ncpShopService.updateStatus(params);
			returnOperationResult("Y", "操作成功！");
		} else {
			returnOperationResult("N", "品牌不存在，请确认！");
		}
	}

	@RequestMapping("recommendShop")
	public void recommendShop(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			String isHome = request.getParameter("isHome");
			if (!StringUtils.isEmpty(isHome)) {
				NcpShopRecommendDto dto = new NcpShopRecommendDto();
				NcpShopDto shop = ncpShopService.findById(Long.parseLong(id));
				dto.setShopId(shop.getId());
				dto.setProjectId(shop.getProjectId());
				if (isHome.equals("1")) {
					ncpShopRecommendService.insert(dto);
				} else {
					ncpShopRecommendService.delete(shop.getId());
				}
				returnOperationResult("Y", "操作成功！");
			} else {
				returnOperationResult("N", "错误的操作，请刷新后重试！");
			}
		} else {
			returnOperationResult("N", "品牌不存在，请确认！");
		}
	}

	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam("imgList") MultipartFile[] imgList, BrandDto brand) {
		try {
			Map<String, Object> result = ncpShopService.saveShopInfo(request, imgList, brand);
			returnOperationResult(result.get("flag").toString(), result.get("message").toString());
		} catch (Exception e) {
			returnOperationResult("N", e.getMessage());
		}
	}
	
	/**
	 * @Title:searchPoiData
	 * @Author:Zain.Luo
	 * @Description:查询商铺POI值
	 * @Created:2017年2月18日  上午12:25:56<br>
	 * @History:
	 */
	@RequestMapping("searchPoiData")
	public void searchPoiData(PageVo vo,BaseParams bparams){
		Map<String, Object> params = convertToPageParams(vo);
		params.put("keyWord", decodeStr(bparams.getKeyWord()));
		writeJson(getPageMap(ncpPoiDataService.findListByParams(params)), response);
	}

}
