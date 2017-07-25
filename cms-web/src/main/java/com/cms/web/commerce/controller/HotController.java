/*
 * HotController.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月20日  <br>
 */
package com.cms.web.commerce.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.commerce.commodity.domain.CommodityHotDto;
import com.cms.core.commerce.commodity.service.CommodityHotService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.other.service.DeliveryTagsService;
import com.cms.core.common.entity.BaseParams;
import com.cms.core.common.util.DateUtil;
import com.cms.core.common.util.LogMannger;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @Title:爆款榜单Controller类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月20日 下午9:20:07 Zain.Luo <br>
 * @History:
 */
@Controller
@RequestMapping("commerce/hot")
public class HotController extends BaseController {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private NcpShopService ncpShopService;

	/**
	 * 爆款商品service类
	 */
	@Autowired
	private CommodityHotService commodityHotService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private DeliveryTagsService deliveryTagsService;

	/**
	 * @Title:toHotHtml
	 * @Author:Zain.Luo
	 * @Description:跳爆款榜单页面
	 * @param reqeust
	 * @param response
	 * @return
	 * @Created:2016年12月20日 下午9:27:41<br>
	 * @History:
	 */
	@RequestMapping("page")
	public ModelAndView toHotHtml(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cms/commerce/hot/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	/**
	 * @Title:toCommodityInfo
	 * @Author:Zain.Luo
	 * @Description:跳转商品详情页面
	 * @param request
	 * @param response
	 * @return
	 * @Created:2016年12月20日 下午11:21:38<br>
	 * @History:
	 */
	@RequestMapping("detail")
	public ModelAndView toCommodityInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("cms/commerce/hot/detail");
		CommodityHotDto dto = commodityHotService.findById(Long.parseLong(id));
		mav.addObject("hot", dto);
		mav.addAllObjects(commodityService.getCommodityInfoMap(dto.getCommodityId()));
		return mav;
	}

	/**
	 * @Title: toChoice
	 * @author: Zain.Luo
	 * @Description: 跳转选择商品页
	 * @return
	 * @return String
	 * @history: 2017年1月7日 created
	 */
	@RequestMapping("add")
	public ModelAndView toChoice() {
		ModelAndView mav = new ModelAndView("cms/commerce/hot/form");
		String commodityId = request.getParameter("commodityId");
		mav.addObject("hot", null);
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
	public ModelAndView toEditHtml(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("cms/commerce/hot/form");
		CommodityHotDto dto = commodityHotService.findById(Long.parseLong(id));
		mav.addObject("hot", dto);
		mav.addAllObjects(commodityService.getCommodityInfoMap(dto.getCommodityId()));
		return mav;
	}

	/**
	 * @Title:searchHotList
	 * @Author:Zain.Luo
	 * @Description:查询爆款榜单
	 * @param request
	 * @param response
	 * @Created:2016年12月20日 下午11:18:47<br>
	 * @History:
	 */
	@RequestMapping("search")
	public void searchHotList(HttpServletRequest request, PageVo vo, BaseParams bParams) {
		Map<String, Object> params = convertToPageParams(vo);
		/*if (StringUtils.isNotEmpty(vo.getSort()) && "sortId".equalsIgnoreCase(vo.getSort())) {
			vo.setSort("sort_id");
			params.put("sort", "ch." + vo.getSort());
		} else if (StringUtils.isNotEmpty(vo.getSort()) && "creationTime".equalsIgnoreCase(vo.getSort())) {
			vo.setSort("creation_time");
			params.put("sort", "ch." + vo.getSort());
		} else if (StringUtils.isNotEmpty(vo.getSort()) && !"sort_id".equalsIgnoreCase(vo.getSort())) {
			params.put("sort", "c." + vo.getSort());
		}*/
		params.put("commodityName", decodeStr(bParams.getKeyWord()));
		writeJson(getPageMap(commodityHotService.findListByParams(params)));
	}

	/**
	 * @Title:deleteHot
	 * @Author:Zain.Luo
	 * @Description:删除爆款榜单商品信息
	 * @param request
	 * @param response
	 * @Created:2016年12月20日 下午11:22:03<br>
	 * @History:
	 */
	@RequestMapping("delete")
	public void deleteHot(long id) {
		if (id <= 0) {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		if (commodityHotService.delete(id)) {
			returnOperationResult("Y", "删除成功");
		} else {
			returnOperationResult("N", "删除失败，请刷新后重试");
		}

	}

	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {

			CommodityHotDto dto = new CommodityHotDto();
			if (StringUtils.isEmpty(id)) {
				Long commodityId = Long.parseLong(request.getParameter("commodityId"));
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("commodityId", commodityId);

				//判断是否存在该商品的爆款信息，如有则不允许添加
				CommodityHotDto hotDto = commodityHotService.findByParams(params);
				if (hotDto != null && hotDto.getId() > 0) {
					returnOperationResult("N", "操作失败，该商品已经存在爆款榜单中！");
					return;
				}

				dto.setSortId(Integer.parseInt(request.getParameter("sortId")));
				dto.setCommodityId(commodityId);
				dto.setHomeRecommended(Integer.parseInt(request.getParameter("homeRecommended")));
				dto.setLastModified(new Date());
				dto.setCreationTime(new Date());
				dto.setStartTime(DateUtil.stringToDate(request.getParameter("startTime"),DateUtil.DATE_TO_STRING_SHORT_PATTERN));
				dto.setExpiryTime(DateUtil.stringToDate(request.getParameter("expiryTime"),DateUtil.DATE_TO_STRING_SHORT_PATTERN));
				dto.setStatus(Short.parseShort("1"));
				commodityHotService.insert(dto);
			} else {
				dto.setId(Long.parseLong(id));
				dto.setSortId(Integer.parseInt(request.getParameter("sortId")));
				dto.setHomeRecommended(Integer.parseInt(request.getParameter("homeRecommended")));
				dto.setLastModified(new Date());
				dto.setStartTime(DateUtil.stringToDate(request.getParameter("startTime"),DateUtil.DATE_TO_STRING_SHORT_PATTERN));
				dto.setExpiryTime(DateUtil.stringToDate(request.getParameter("expiryTime"),DateUtil.DATE_TO_STRING_SHORT_PATTERN));
				commodityHotService.update(dto);
			}
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			logger.error("添加或删除爆款商品时发生异常，原因{}", e.getMessage());
			returnOperationResult("N", "操作失败，数据保存发生异常，原因：" + e.getMessage());
			e.printStackTrace();
		}
	}

}
