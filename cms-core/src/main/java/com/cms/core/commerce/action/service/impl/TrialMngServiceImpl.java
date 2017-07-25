/*
 * TrialMngServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月26日  <br>
 */
package com.cms.core.commerce.action.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.core.commerce.action.service.TrialMngService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.commerce.common.constant.OrderConstant;
import com.cms.core.commerce.transaction.domain.CommodityTrialUserDto;
import com.cms.core.commerce.transaction.service.CommodityTrialUserService;
import com.cms.core.commerce.transaction.service.OrdersService;
import com.cms.core.common.util.LogMannger;

/**
 * @Title:试用管理逻辑service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月26日 下午11:14:37 Zain.Luo <br>
 * @History:
 */
@Service("trialMngService")
public class TrialMngServiceImpl implements TrialMngService {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private CommodityTrialUserService commodityTrialUserService;

	@Autowired
	private OrdersService ordersService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cms.core.commerce.service.TrialMngService#adoptApply(long)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Map<String, Object> adoptApply(long id) {
		String status = "N";
		String message = "";
		try {
			CommodityTrialUserDto trialUser = new CommodityTrialUserDto();
			trialUser.setId(id);
			trialUser.setIsWin(CommodityConstant.TrialUserIsWin.ADOPT);
			if (commodityTrialUserService.update(trialUser) > 0) {

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", id);
				params.put("offset", "0");
				params.put("limit", "1");
				List<Map> orders = commodityTrialUserService.findListByParams(params).getList();

				if (orders == null || orders.size() == 0) {
					message = "订单不存在，请刷新后重试";
					throw new RuntimeException("订单不存在");
				} else {
					params.put("orderNo", orders.get(0).get("orderNo"));
					params.put("status", OrderConstant.Status.WAIT_SENT);
					ordersService.updateOrdersStatus(params);
					status = "Y";
				}
			} else {
				message = "操作失败，请刷新后重试";
			}
		} catch (Exception e) {
			logger.error("用户试用申请发生异常，具体信息{}", e.getMessage());
			throw new RuntimeException("用户试用申请发生异常，具体信息：" + e.getMessage());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", status);
		result.put("message", message);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cms.core.commerce.service.TrialMngService#refuseApply(long)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Map<String, Object> refuseApply(long id) {
		String status = "N";
		String message = "";
		try {
			CommodityTrialUserDto trialUser = new CommodityTrialUserDto();
			trialUser.setId(id);
			trialUser.setIsWin(CommodityConstant.TrialUserIsWin.ADOPT);
			if (commodityTrialUserService.update(trialUser) > 0) {

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", id);
				params.put("offset", "0");
				params.put("limit", "1");
				List<Map> orders = commodityTrialUserService.findListByParams(params).getList();

				if (orders == null || orders.size() == 0) {
					message = "订单不存在，请刷新后重试";
					throw new RuntimeException("订单不存在");
				} else {
					params.put("orderNo", orders.get(0).get("orderNo"));
					params.put("status", OrderConstant.Status.TRANSACTION_CLOSE);
					ordersService.updateOrdersStatus(params);
					status = "Y";
				}
			} else {
				message = "操作失败，请刷新后重试";
			}
		} catch (Exception e) {
			logger.error("用户试用申请发生异常，具体信息{}", e.getMessage());
			throw new RuntimeException("用户试用申请发生异常，具体信息：" + e.getMessage());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", status);
		result.put("message", message);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.cms.core.commerce.action.service.TrialMngService#updateBatchApply(java.util.Map)
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void updateBatchApply(String idArray,int status) {
		String[] idList = idArray.split(",");
		try{
			if(status == CommodityConstant.TrialUserIsWin.ADOPT){
				for(int i=0;i<idList.length;i++){
					this.adoptApply(Long.parseLong(idList[i]));
				}
			}else{
				for(int i=0;i<idList.length;i++){
					this.refuseApply(Long.parseLong(idList[i]));
				}
			}
		}catch (Exception e) {
			logger.error("试用商品批量处理申请失败，原因：{}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("试用商品批量处理申请失败，具体信息：" + e.getMessage());
		}
		
		
	}

}
