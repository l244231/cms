/*
 * NcpShopActivityServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.service.impl;

import org.springframework.stereotype.Service;

import com.cms.core.common.service.impl.SqlServerBaseServiceImpl;
import com.cms.core.market.business.domain.NcpShopActivityDto;
import com.cms.core.market.business.service.NcpShopActivityService;

/** 
 * @Title:商铺活动service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 上午1:17:49 Zain.Luo  <br> 
 * @History:
 */
@Service("ncpShopActivityService")
public class NcpShopActivityServiceImpl extends SqlServerBaseServiceImpl<NcpShopActivityDto> implements NcpShopActivityService{

}
