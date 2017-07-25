/*
 * CommodityMngService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月28日  <br>
 */
package com.cms.core.commerce.action.service;

import java.util.Map;

/**
 * @Title:商品管理逻辑service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月28日 上午12:36:36 Zain.Luo <br>
 * @History:
 */
public interface CommodityMngService {

	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新商品状态
	 * @param params
	 * @return
	 * @Created:2016年12月28日 上午12:37:54<br>
	 * @History:
	 */
	public boolean updateStatus(Map<String, Object> params);
}
