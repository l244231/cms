package com.cms.web.commerce.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cms.core.commerce.action.service.CommodityMngService;
import com.cms.core.commerce.commodity.domain.CommodityCategoryDto;
import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.commerce.commodity.domain.CommodityInStoreDto;
import com.cms.core.commerce.commodity.domain.InStoreDto;
import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.commerce.other.domain.DeliveryTagsDto;
import com.cms.core.commerce.other.service.DeliveryTagsService;
import com.cms.core.common.util.LogMannger;
import com.cms.core.demo.service.CommodityCategoryService;
import com.cms.core.market.business.domain.NcpShopDto;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @Title:商品管理
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月21日 下午8:42:29 lijx <br>
 * @History:
 */
@Controller
@RequestMapping("commerce/commodity")
public class CommodityController extends BaseController {

	Logger logger = LogMannger.getLogger();

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CommodityMngService commodityMngService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private NcpShopService ncpShopService;

	@Autowired
	private DeliveryTagsService deliveryTagsService;
	
	@Autowired
	private CommodityInStoreService commodityInStoreService;

	/**
	 * 
	 * @Title:toPage
	 * @Author:lijx
	 * @Description:跳转列表页面
	 * @return
	 * @Created:2016年12月21日 下午9:04:20<br>
	 * @History:
	 */
	@RequestMapping("page")
	public ModelAndView toPage() {
		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodity/page");
		// 获取分类
		List<CommodityCategoryDto> commodityCategoryDtoList = commodityCategoryService.findAllList();
		modelAndView.addObject("commodityCategoryDtoList", commodityCategoryDtoList);
		// 获取店铺
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isVirtual", 1);
		List<NcpShopDto> ncpShopDtoList = ncpShopService.findAllListByParams(params);
		modelAndView.addObject("ncpShopDtoList", ncpShopDtoList);
		modelAndView.addObject("isBack",request.getParameter("isBack"));
		return modelAndView;
	}

	/**
	 * 
	 * @Title:toDetail
	 * @Author:lijx
	 * @Description:跳转详情
	 * @return
	 * @Created:2017年1月10日 下午10:41:52<br>
	 * @History:
	 */
	@RequestMapping("detail")
	public ModelAndView toDetail(long id, ModelMap modelMap) {

		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodity/detail");

		modelAndView.addObject("isEdit", false);

		modelMap.putAll(commodityService.getCommodityInfoMap(id));

		return modelAndView;
	}

	/**
	 * 
	 * @Title:toAdd
	 * @Author:lijx
	 * @Description:跳转新增
	 * @return
	 * @Created:2017年1月10日 上午1:43:05<br>
	 * @History:
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd() {
		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodity/form");
		modelAndView.addObject("isEdit", false);

		// 获取店铺
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isVirtual", 1);
		List<NcpShopDto> ncpShopDtoList = ncpShopService.findAllListByParams(params);
		modelAndView.addObject("ncpShopDtoList", ncpShopDtoList);

		// 获取商品分类
		List<CommodityCategoryDto> commodityCategoryDtoList = commodityCategoryService.findAllList();
		modelAndView.addObject("commodityCategoryDtoList", commodityCategoryDtoList);

		// 获取配送标签
		List<DeliveryTagsDto> deliveryTagsDtoList = deliveryTagsService.findAllList();
		modelAndView.addObject("deliveryTagsDtoList", deliveryTagsDtoList);

		return modelAndView;
	}

	/**
	 * 
	 * 
	 * @Title:toEdit
	 * @Author:lijx
	 * @Description:跳转修改
	 * @param id
	 * @return
	 * @Created:2017年1月10日 下午10:41:32<br>
	 * @History:
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(long id, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodity/form");
		modelAndView.addObject("isEdit", true);

		modelMap.putAll(commodityService.getCommodityInfoMap(id));

		return modelAndView;
	}

	/**
	 * @Title:search
	 * @Author:Zain.Luo
	 * @Description:商品查询
	 * @param request
	 * @param vo
	 * @Created:2016年12月27日 上午12:41:47<br>
	 * @History:
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("search")
	public void search(HttpServletRequest request, HttpServletResponse response, PageVo vo) {
		Map<String, Object> params = convertToPageParams(vo);
		if (StringUtils.isNotBlank(request.getParameter("status"))) {
			params.put("status", Integer.parseInt(request.getParameter("status")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("storeId"))) {
			params.put("storeId", Long.parseLong(request.getParameter("storeId")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("categoryId"))) {
			params.put("categoryId", Long.parseLong(request.getParameter("categoryId")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("name"))) {
			params.put("name", "%" + decodeStr(request.getParameter("name")) + "%");
		}
		if(StringUtils.isNotEmpty(request.getParameter("isHot"))){
			params.put("isHot", request.getParameter("isHot"));
		}

		Map<String, Object> map = getPageMap(commodityService.findListByParams(params));
		logger.info("rows:{}", JSON.toJSONString(map.get("rows")));
		List<Object> list = (List<Object>) map.get("rows");

		// 获取所有商铺
		Map<Long, NcpShopDto> ncpShopDtoMap = ncpShopService.getAllShopMap();
		List<Object> newList = new ArrayList<Object>();
		for (Object object : list) {
			JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(object));
			CommodityDto commodityDto = new CommodityDto();
			commodityDto.setCategoryName(jsonObject.get("categoryName").toString());
			commodityDto.setSale((Integer) jsonObject.get("sale"));
			commodityDto.setListIconId((Integer) jsonObject.get("listIconId"));
			commodityDto.setSortId((Integer) jsonObject.get("sortId"));
			BigDecimal price = (BigDecimal) jsonObject.get("price");
			commodityDto.setPrice(price.doubleValue());
			commodityDto.setStock((Integer) jsonObject.get("stock"));
			commodityDto.setName(jsonObject.get("name").toString());
			BigDecimal currentPrice = (BigDecimal) jsonObject.get("currentPrice");
			commodityDto.setCurrentPrice(currentPrice.doubleValue());
			commodityDto.setId((Integer) jsonObject.get("id"));
			commodityDto.setStoreId((Integer) jsonObject.get("storeId"));
			commodityDto.setStoreName(ncpShopDtoMap.get(Long.valueOf(jsonObject.get("storeId") + "")) == null ? ""
					: ncpShopDtoMap.get(Long.valueOf(jsonObject.get("storeId") + "")).getShopName());
			commodityDto.setPopularity((Integer) jsonObject.get("popularity"));
			
			object = commodityDto;
			newList.add(object);
		}
		map.put("rows", newList);

		writeJson(map, response);
	}

	/**
	 * 
	 * @Title:save
	 * @Author:lijx
	 * @Description:保存商品信息
	 * @param request
	 * @param file
	 * @param iconImages
	 * @param commodityDto
	 * @Created:2017年1月10日 上午1:43:17<br>
	 * @History:
	 */
	@RequestMapping("save")
	public void save(HttpServletRequest request, CommodityDto commodityDto) {
		boolean boo = commodityService.saveAndUpdateCommodity(request, commodityDto);
		if (boo) {
			returnOperationResult("Y", "保存成功");
		} else {
			returnOperationResult("N", "保存失败");
		}
	}

	/**
	 * @Title:del
	 * @Author:lijx
	 * @Description:删除商品
	 * @param request
	 * @param response
	 * @param id
	 * @Created:2017年1月13日 上午1:45:16<br>
	 * @History:
	 */
	@RequestMapping("del")
	public void del(HttpServletRequest request, HttpServletResponse response, long id) {
		//首先判断商品是否被爆款、团购、试用、限时优惠在使用
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String useStr = commodityService.findCommodityIsHadUse(params);
		if(useStr.length()>0){
			returnOperationResult("N", "删除失败,原因："+useStr);
		}else{
			if (commodityService.delete(id)) {
				returnOperationResult("Y", "删除成功");
			} else {
				returnOperationResult("N", "删除失败");
			}
		}
	}

	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新商品状态
	 * @param request
	 * @param response
	 * @Created:2016年12月28日 上午12:29:19<br>
	 * @History:
	 */
	@RequestMapping("updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id").toString());
		int status = Integer.parseInt(request.getParameter("status").toString());
		boolean flag = false;
		String message = "";
		if (id <= 0) {
			message = "商品不存在，请刷新后重试！";
		} else if (status <= 0) {
			message = "无效操作，请刷新后重试！";
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			params.put("status", status);
			try {
				if(status == 4){
					String useStr = commodityService.findCommodityIsHadUse(params);
					if(useStr.length()>0){
						returnOperationResult("N", "更新失败，原因："+useStr);
						return;
					}
				}
				flag = commodityMngService.updateStatus(params);
				if (!flag) {
					message = "更新失败，请刷新后重试！";
				}
			} catch (RuntimeException e) {
				// message = e.getMessage();
				e.printStackTrace();
				message = "更新失败，请刷新后重试！";
			}
		}
		returnOperationResult(flag ? "Y" : "N", message);
	}

	@RequestMapping("choice")
	public ModelAndView toChoice(HttpServletRequest request, HttpServletResponse response) {

		// 标识跳转过来的页面和选择商品确定之后的页面
		String method = request.getParameter("method");
		String commodityTypeForUrl = request.getParameter("commodityTypeForUrl");

		ModelAndView modelAndView = new ModelAndView("cms/commerce/commodity/choice");
		// 获取分类
		List<CommodityCategoryDto> commodityCategoryDtoList = commodityCategoryService.findAllList();
		modelAndView.addObject("commodityCategoryDtoList", commodityCategoryDtoList);
		// 获取店铺
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isVirtual", 1);
		List<NcpShopDto> ncpShopDtoList = ncpShopService.findAllListByParams(params);
		modelAndView.addObject("ncpShopDtoList", ncpShopDtoList);

		modelAndView.addObject("method", method);
		modelAndView.addObject("commodityTypeForUrl", commodityTypeForUrl);

		return modelAndView;
	}

	/**
	 * @Title:getCommodityCategory
	 * @Author:Zain.Luo
	 * @Description:获取商品分类
	 * @param request
	 * @param response 
	 * @Created:2017年1月20日  上午12:01:45<br>
	 * @History:
	 */
	@RequestMapping("getCommodityCategory")
	public void getCommodityCategory(HttpServletRequest request, HttpServletResponse response) {
		// 获取分类
		List<CommodityCategoryDto> commodityCategoryDtoList = commodityCategoryService.findAllList();
		writeJson(commodityCategoryDtoList);
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

			CommodityDto dto = commodityService.findById(inStore.getCommodityId());
			CommodityInStoreDto cInStore = new CommodityInStoreDto();
			cInStore.setRelativeId(inStore.getRelativeId());
			cInStore.setCommodityId(inStore.getCommodityId());
			cInStore.setInStoreAmount(inStore.getStock());
			cInStore.setInStoreTime(new Date());
			cInStore.setStoreAmount(dto.getStock() + inStore.getStock());
			cInStore.setType(CommodityConstant.RelativeType.CMMODITY);
			commodityInStoreService.insert(cInStore);

			dto.setStock(dto.getStock() + inStore.getStock());
			commodityService.updateStock(dto);
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			logger.error("商品添加库存失败，原因：{}", e.getMessage());
			returnOperationResult("N", "操作发生异常，原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title:updateSaleAndPopularity
	 * @Author:Zain.Luo
	 * @Description:更新销量或人气
	 * @param request
	 * @param response 
	 * @Created:2017年1月20日  上午12:13:08<br>
	 * @History:
	 */
	@RequestMapping("updateSaleAndPopularity")
	public void updateSaleAndPopularity(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String sale = request.getParameter("sale");
		String popularity = request.getParameter("popularity");
		
		if(!StringUtils.isEmpty(id)){
			try {
				CommodityDto dto = commodityService.findById(Long.parseLong(id));
				if(!StringUtils.isEmpty(sale)){
					dto.setSale(Integer.parseInt(sale)+dto.getSale());
				}
				if(!StringUtils.isEmpty(popularity)){
					dto.setPopularity(Integer.parseInt(popularity)+dto.getPopularity());
				}
				commodityService.updateStock(dto);
				returnOperationResult("Y", "操作成功");
			} catch (Exception e) {
				logger.error("商品修改失败，原因：{}", e.getMessage());
				returnOperationResult("N", "操作发生异常，原因：" + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
