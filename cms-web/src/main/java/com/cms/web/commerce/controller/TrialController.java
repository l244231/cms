/*
 * TrialController.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月22日  <br>
 */
package com.cms.web.commerce.controller;

import java.io.UnsupportedEncodingException;
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
import com.cms.core.commerce.action.service.TrialMngService;
import com.cms.core.commerce.commodity.domain.CommodityInStoreDto;
import com.cms.core.commerce.commodity.domain.CommodityTrialDto;
import com.cms.core.commerce.commodity.domain.InStoreDto;
import com.cms.core.commerce.commodity.domain.TrialDto;
import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.commodity.service.CommodityTrialService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.commerce.other.service.DeliveryTagsService;
import com.cms.core.commerce.transaction.service.CommodityTrialUserService;
import com.cms.core.common.entity.BaseParams;
import com.cms.core.common.util.DateUtil;
import com.cms.core.common.util.LogMannger;
import com.cms.core.demo.service.CommodityCategoryService;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * @Title:试用商品Controller类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月22日 下午10:19:57 Zain.Luo <br>
 * @History:
 */
@Controller
@RequestMapping("commerce/trial")
public class TrialController extends BaseController {
	private Logger logger = LogMannger.getLogger();
	@Autowired
	private CommodityTrialService commodityTrialService;

	@Autowired
	private CommodityTrialUserService commodityTrialUserService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private TrialMngService trialMngService;

	@Autowired
	private NcpShopService ncpShopService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private DeliveryTagsService deliveryTagsService;

	@Autowired
	private CommodityInStoreService commodityInStoreService;

	/**
	 * @Title:toTrialHtml
	 * @Author:Zain.Luo
	 * @Description:跳转试用列表页面
	 * @param request
	 * @param response
	 * @return
	 * @Created:2016年12月22日 下午10:21:25<br>
	 * @History:
	 */
	@RequestMapping("page")
	public ModelAndView toTrialHtml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("cms/commerce/trial/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	/**
	 * @Title:toCommodityInfo
	 * @Author:Zain.Luo
	 * @Description:跳转到商品详情页面
	 * @param request
	 * @param response
	 * @return
	 * @Created:2016年12月22日 下午10:23:35<br>
	 * @History:
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("detail")
	public ModelAndView toCommodityInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("cms/commerce/trial/detail");
		CommodityTrialDto trial = commodityTrialService.findById(Long.parseLong(id));
		mav.addObject("trial", trial);
		mav.addAllObjects(commodityService.getCommodityInfoMap(trial.getCommodityId()));
		return mav;
	}

	/**
	 * @Title:toTrialPeopleHtml
	 * @Author:Zain.Luo
	 * @Description: 跳转试用人数详情页面
	 * @param request
	 * @param response
	 * @return
	 * @Created:2016年12月22日 下午10:29:51<br>
	 * @History:
	 */
	@RequestMapping("peoplePage")
	public ModelAndView toTrialPeopleHtml(HttpServletRequest request, HttpServletResponse response, long id) {
		ModelAndView mav = new ModelAndView("cms/commerce/trial/peoplePage");
		mav.addObject("id", id);
		return mav;
	}

	/**
	 * @Title: toAddHtml
	 * @author: Zain.Luo
	 * @Description: 跳转新增页面
	 * @param request
	 * @param response
	 * @return
	 * @return String
	 * @throws @history:
	 *             2017年1月7日 created
	 */
	@RequestMapping("add")
	public ModelAndView toAddHtml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("cms/commerce/trial/form");
		String commodityId = request.getParameter("commodityId");
		mav.addObject("trial",null);
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
		ModelAndView mav = new ModelAndView("cms/commerce/trial/form");
		CommodityTrialDto dto = commodityTrialService.findById(Long.parseLong(id));
		mav.addObject("trial", dto);
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
	@RequestMapping("choice")
	public ModelAndView toChoice() {
		ModelAndView mav = new ModelAndView("cms/commerce/trial/choice");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isVirtual", 1);
		mav.addObject("shopList", ncpShopService.findAllListByParams(params));
		mav.addObject("categoryList", commodityCategoryService.findAllListByParams(params));
		return mav;
	}

	/**
	 * @Title:searchTrialList
	 * @Author:Zain.Luo
	 * @Description:查询 试用列表
	 * @param request
	 * @param response
	 * @param vo
	 * @throws UnsupportedEncodingException
	 * @Created:2016年12月22日 下午10:25:08<br>
	 * @History:
	 */
	@RequestMapping("search")
	public void searchTrialList(HttpServletRequest request, HttpServletResponse response, PageVo vo, BaseParams bParams) throws UnsupportedEncodingException {
		Map<String, Object> params = convertToPageParams(vo);
		params.put("keyWord", decodeStr(bParams.getKeyWord()));
		params.put("type", bParams.getType());
		params.put("status", bParams.getStatus());
		writeJson(getPageMap(commodityTrialService.findListByParams(params)));
	}

	/**
	 * @Title:deleteTrialInfo
	 * @Author:Zain.Luo
	 * @Description: 删除试用信息
	 * @param id
	 *            主键ID
	 * @Created:2016年12月22日 下午10:29:10<br>
	 * @History:
	 */
	@RequestMapping("delete")
	public void deleteTrialInfo(long id) {
		if (id <= 0) {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		if (commodityTrialService.delete(id)) {
			returnOperationResult("Y", "");
		} else {
			returnOperationResult("N", "删除失败，请刷新后重试");
		}
	}

	/**
	 * @Title:searchTrialPeopleList
	 * @Author:Zain.Luo
	 * @Description:查询试用申请人列表
	 * @param request
	 * @param response
	 * @param vo
	 * @Created:2016年12月22日 下午10:30:06<br>
	 * @History:
	 */
	@RequestMapping("searchPeople")
	public void searchTrialPeopleList(HttpServletRequest request, HttpServletResponse response, PageVo vo, long id) {
		Map<String, Object> params = convertToPageParams(vo);
		params.put("trialId", id);
		writeJson(getPageMap(commodityTrialUserService.findListByParams(params)));
	}

	/**
	 * @Title:adoptApply
	 * @Author:Zain.Luo
	 * @Description:试用申请通过
	 * @param id
	 * @Created:2016年12月23日 上午1:59:59<br>
	 * @History:
	 */
	@RequestMapping("adoptApply")
	public void adoptApply(long id) {

		if (id <= 0) {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		try {
			Map<String, Object> result = trialMngService.adoptApply(id);
			returnOperationResult(result.get("status").toString(), result.get("message").toString());
		} catch (Exception e) {
			returnOperationResult("N", e.getMessage());
		}
	}

	/**
	 * @Title:deleteApply
	 * @Author:Zain.Luo
	 * @Description:试用申请删除
	 * @param id
	 * @Created:2016年12月23日 上午2:00:13<br>
	 * @History:
	 */
	@RequestMapping("deleteApply")
	public void deleteApply(long id) {
		if (id <= 0) {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		try {
			Map<String, Object> result = trialMngService.refuseApply(id);
			returnOperationResult(result.get("status").toString(), result.get("message").toString());
		} catch (Exception e) {
			returnOperationResult("N", e.getMessage());
		}
	}

	/**
	 * @Title:recommendAudiovisual
	 * @Author:Zain.Luo
	 * @Description:将数据推荐至首页
	 * @param request
	 * @param response
	 * @Created:2017年1月3日 下午10:34:40<br>
	 * @History:
	 */
	@RequestMapping("recommendTrial")
	public void recommendTrial(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		String isHome = request.getParameter("param");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("homeRecommended", Integer.parseInt(isHome));

		if (isHome.equals("1")) {
			long count = commodityTrialService.countByParams(params);
			if (count > 10) {
				returnOperationResult("N", "已存在10条推荐到首页的试用信息，请取消相关推荐后再进行该操作");
				return;
			}
		}
		CommodityTrialDto trial = new CommodityTrialDto();
		trial.setId(Long.parseLong(id));
		trial.setHomeRecommended(Integer.parseInt(isHome));
		try {
			commodityTrialService.updateIsHome(trial);
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			returnOperationResult("N", "操作失败，请刷新后重试");
			e.printStackTrace();
		}
	}

	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response, TrialDto dto) {
		CommodityTrialDto trial = new CommodityTrialDto();
		trial.setCreationTime(new Date());
		trial.setStartTime(DateUtil.stringToDate(dto.getStartTime(), "yyyy-MM-dd"));
		trial.setExpiryTime(DateUtil.stringToDate(dto.getExpiryTime(), "yyyy-MM-dd"));
		trial.setSortId(dto.getSortId());
		trial.setHomeRecommended(dto.getHomeRecommended());
		trial.setSingleSold(dto.getSingleSold());
		trial.setPrice(dto.getPrice());
		trial.setStatus(dto.getStatus());
		trial.setCommodityId(dto.getCommodityId());
		trial.setNumberPeople(dto.getNumberPeople());
		trial.setLimits(dto.getLimits());
		trial.setType(dto.getType());
		try {
			if (StringUtils.isEmpty(dto.getId())) {
				trial.setStock(dto.changeStock());
				commodityTrialService.insert(trial);
				CommodityInStoreDto inStore = new CommodityInStoreDto();
				inStore.setCommodityId(dto.getCommodityId());
				inStore.setInStoreAmount(dto.changeStock());
				inStore.setInStoreTime(new Date());
				inStore.setStoreAmount(dto.changeStock());
				inStore.setStatus(CommodityConstant.CommodityStatus.IS_SALSE);
				inStore.setRelativeId(trial.getId());
				inStore.setType(CommodityConstant.RelativeType.TRIAL);
				commodityInStoreService.insert(inStore);
				returnOperationResult("Y", "操作成功！");
			} else {
				trial.setId(Long.parseLong(dto.getId()));
				commodityTrialService.update(trial);
				returnOperationResult("Y", "操作成功！");
			}
		} catch (Exception e) {
			logger.error("试用商品操作发生异常，ID：{}，原因：{}", trial.getId(), e.getMessage());
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

			CommodityTrialDto dto = commodityTrialService.findById(inStore.getRelativeId());
			CommodityInStoreDto cInStore = new CommodityInStoreDto();
			cInStore.setRelativeId(inStore.getRelativeId());
			cInStore.setCommodityId(inStore.getCommodityId());
			cInStore.setInStoreAmount(inStore.getStock());
			cInStore.setInStoreTime(new Date());
			cInStore.setStoreAmount(dto.getStock() + inStore.getStock());
			cInStore.setType(CommodityConstant.RelativeType.TRIAL);
			commodityInStoreService.insert(cInStore);

			dto.setStock(dto.getStock() + inStore.getStock());
			commodityTrialService.updateStock(dto);
			returnOperationResult("Y", "操作成功");
		} catch (Exception e) {
			logger.error("试用商品添加库存失败，原因：{}", e.getMessage());
			returnOperationResult("N", "操作发生异常，原因：" + e.getMessage());
		}
	}
	
	/**
	 * @Title:batchDealApply
	 * @Author:Zain.Luo
	 * @Description: 批量处理试用申请
	 * @param request
	 * @param response
	 * @param inStore 
	 * @Created:2017年2月17日  下午11:37:26<br>
	 * @History:
	 */
	@RequestMapping("batchDealApply")
	public void batchDealApply(HttpServletRequest request, HttpServletResponse response, InStoreDto inStore){
		try{
			String idArray = request.getParameter("idArray");
			if(StringUtils.isEmpty(idArray)){
				returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
				return;
			}
			trialMngService.updateBatchApply(idArray, Integer.parseInt(request.getParameter("status").toString()));
			returnOperationResult("Y", "操作成功");
		}catch (Exception e) {
			logger.error("试用商品批量处理申请失败，原因：{}", e.getMessage());
			returnOperationResult("N", "操作发生异常，原因：" + e.getMessage());
			e.printStackTrace();
		}
	}
}
