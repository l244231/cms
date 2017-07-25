package com.cms.web.commerce.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.commerce.common.constant.OrderConstant;
import com.cms.core.commerce.other.service.ExpressService;
import com.cms.core.commerce.transaction.domain.OrdersDto;
import com.cms.core.commerce.transaction.service.OrdersDetailsService;
import com.cms.core.commerce.transaction.service.OrdersService;
import com.cms.core.common.util.LogMannger;
import com.cms.core.market.business.domain.NcpShopDto;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;
import com.github.pagehelper.PageInfo;

@Scope("prototype")
@Controller
@RequestMapping("commerce/order")
public class OrderController extends BaseController {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrdersDetailsService ordersDetailsService;

	@Autowired
	private NcpShopService ncpShopService;

	@Autowired
	private ExpressService expressService;

	@RequestMapping("page")
	public ModelAndView toHotHtml(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cms/commerce/order/page");
		mav.addObject("expressList", expressService.findAllListByParams(new HashMap()));
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	@RequestMapping("add")
	public String toAdd() {
		return "cms/commerce/order/form";
	}

	@RequestMapping("detail")
	public ModelAndView toDetail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("cms/commerce/order/detail");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderNo", request.getParameter("orderNo"));
		Map<String, Object> result = ordersService.queryByParams(params);

		String bizType = StringUtils.isEmpty(request.getParameter("bizType")) ? "" : request.getParameter("bizType");
		mav.addObject("bizType", bizType);

		mav.addObject("order", result);
		mav.addObject("shop", ncpShopService.findById(Long.parseLong(result.get("storeId").toString())));
		mav.addObject("commodityList", ordersDetailsService.findMapListByParams(params));
		mav.addObject("expressList", expressService.findAllListByParams(params));
		return mav;
	}

	@RequestMapping("search")
	public void toSearch(HttpServletRequest request, HttpServletResponse response, PageVo vo) {
		Map<String, Object> params = convertToPageParams(vo);
		String status = request.getParameter("status");
		if (!StringUtils.isEmpty(status)) {
			params.put("status", Short.parseShort(status));
		}
		params.put("keyWord", request.getParameter("keyWord"));
		params.put("creationTime", request.getParameter("creationTime"));
		params.put("endTime", request.getParameter("endTime"));
		params.put("isVirtual", 1);

		List<NcpShopDto> shopList = ncpShopService.findAllListByParams(params);
		Map<String, String> shop = new HashMap<String, String>();
		if (shopList != null && shopList.size() != 0) {
			for (int i = 0; i < shopList.size(); i++) {
				shop.put(shopList.get(i).getId() + "", shopList.get(i).getShopName());
			}
		}

		PageInfo result = ordersService.findListByParams(params);

		List<Map> orderList = result.getList();
		if (orderList != null && orderList.size() > 0 && shop.size() > 0) {
			String storeName = "";
			Object o = null;
			for (int i = 0; i < orderList.size(); i++) {
				o = orderList.get(i).get("storeId");
				storeName = shop.get(o.toString());
				orderList.get(i).put("storeName", storeName);
			}
		}

		writeJson(getPageMap(result));
	}

	/**
	 * @Title:send
	 * @Author:Zain.Luo
	 * @Description:发货
	 * @param request
	 * @param response
	 * @Created:2017年1月12日 下午11:17:59<br>
	 * @History:
	 */
	@RequestMapping("send")
	public void send(HttpServletRequest request, HttpServletResponse response, OrdersDto order) {
		if (StringUtils.isEmpty(order.getOrderNo())) {
			returnOperationResult("N", "操作失败，订单号不能为空！");
			return;
		}
		if (StringUtils.isEmpty(order.getDeliveryNub())) {
			returnOperationResult("N", "操作失败，快递单号不能为空！");
			return;
		}
		try {
			order.setStatus(OrderConstant.Status.WAIT_EVALUATE);
			order.setDeliveryTime(new Date());
			ordersService.update(order);
			returnOperationResult("Y", "操作成功！");
		} catch (Exception e) {
			logger.error("取消订单失败（更新数据库），原因", e.getMessage());
			returnOperationResult("N", "操作失败，原因：！" + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @Title:cancel
	 * @Author:Zain.Luo
	 * @Description:订单取消
	 * @param request
	 * @param response
	 * @Created:2017年1月12日 下午11:18:13<br>
	 * @History:
	 */
	@RequestMapping("cancel")
	public void cancel(HttpServletRequest request, HttpServletResponse response, OrdersDto order) {

		if (StringUtils.isEmpty(order.getOrderNo())) {
			returnOperationResult("N", "操作失败，订单号不能为空！");
			return;
		}
		if (StringUtils.isEmpty(order.getCancelReason())) {
			returnOperationResult("N", "操作失败，取消原因不能为空！");
			return;
		}
		try {
			order.setStatus(OrderConstant.Status.TRANSACTION_CLOSE);
			order.setCancelTime(new Date());
			order.setCancelUser("TestUser");
			ordersService.update(order);
			returnOperationResult("Y", "操作成功！");
		} catch (Exception e) {
			logger.error("取消订单失败（更新数据库），原因", e.getMessage());
			returnOperationResult("N", "操作失败，原因：！" + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
