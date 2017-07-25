/*
 * CommodityIconsService.java  <br>
 * Author:lijx  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.commerce.commodity.service;

import com.cms.core.commerce.commodity.domain.CommodityIconsDto;
import com.cms.core.common.service.BaseService;

/** 
 * @Title:TODO
 * @Author:lijx
 * @Version:1.0
 * @Created:2017年1月10日 上午1:53:57 lijx  <br> 
 * @History:
 */
public interface CommodityIconsService extends BaseService<CommodityIconsDto> {
	public boolean deleteByFileId(long id);
}
