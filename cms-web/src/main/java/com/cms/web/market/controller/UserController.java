/*
 * HotController.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月20日  <br>
 */
package com.cms.web.market.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.core.common.util.LogMannger;
import com.cms.web.common.controller.BaseController;

/**
 * @Title:爆款榜单Controller类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月20日 下午9:20:07 Zain.Luo <br>
 * @History:
 */
@Controller
@RequestMapping("market/user")
public class UserController extends BaseController {
	private Logger logger = LogMannger.getLogger();

	

	
	@RequestMapping("page")
	public String toHotHtml() {
		return "cms/market/user/page";
	}

	

}
