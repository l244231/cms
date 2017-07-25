/*
 * TrialMngService.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月26日  <br>
 */
package com.cms.core.commerce.action.service;

import java.util.Map;

/**
 * @Title:试用管理逻辑service类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月26日 下午11:13:17 Zain.Luo <br>
 * @History:
 */
public interface TrialMngService {
	/**
	 * @Title:adoptApply
	 * @Author:Zain.Luo
	 * @Description:通过用户试用申请
	 * @param id
	 *            用户试用ID
	 * @return 操作结果 status:Y-成功，N-失败<br>
	 *         message:操作信息<br>
	 * @Created:2016年12月26日 下午11:13:55<br>
	 * @History:
	 */
	Map<String, Object> adoptApply(long id);

	/**
	 * @Title:refuseApply
	 * @Author:Zain.Luo
	 * @Description:拒绝用户的试用申请
	 * @param id
	 *            用户试用ID
	 * @return
	 * @Created:2016年12月28日 下午8:59:25<br>
	 * @History:
	 */
	Map<String, Object> refuseApply(long id);

	/**
	 * @Title:updateBatchApply
	 * @Author:Zain.Luo
	 * @Description:批量更新试用申请状态
	 * @param idArray ID数组
	 * @param status 状态
	 * @Created:2017年2月17日 下午11:41:59<br>
	 * @History:
	 */
	void updateBatchApply(String idArray,int status);
}
