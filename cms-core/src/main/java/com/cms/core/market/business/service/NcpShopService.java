/*
 * @(#)NcpShopService.java
 * Author : Zain.Luo
 * Created Date: 2016年12月30日 
 */
package com.cms.core.market.business.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cms.core.common.service.SqlServerBaseService;
import com.cms.core.market.business.domain.BrandDto;
import com.cms.core.market.business.domain.NcpShopDto;

/**
 * @title 商铺service类 
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 2016年12月30日 Zain.Luo create file<br>
 * Id:NcpShopService.java,v1.0 2016年12月30日 上午10:42:02
 */
public interface NcpShopService extends SqlServerBaseService<NcpShopDto>{
	
	/**
	 * @Title:updateStatus
	 * @Author:Zain.Luo
	 * @Description:更新商铺表状态
	 * @param params 
	 * @Created:2017年1月10日  下午10:47:34<br>
	 * @History:
	 */
	public void updateStatus(Map<String,Object> params);
	
	public Map<String,Object> saveShopInfo(HttpServletRequest request,MultipartFile[] imgList, BrandDto brand);
	
	public Map<Long,NcpShopDto> getAllShopMap();
}
