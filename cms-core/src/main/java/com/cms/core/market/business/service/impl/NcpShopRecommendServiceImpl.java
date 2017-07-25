/*
 * NcpShopRecommendServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.business.service.impl;

import org.springframework.stereotype.Service;

import com.cms.core.common.service.impl.SqlServerBaseServiceImpl;
import com.cms.core.market.business.domain.NcpShopRecommendDto;
import com.cms.core.market.business.service.NcpShopRecommendService;

/**
 * @Title:商铺推荐表Service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 下午11:39:02 Zain.Luo <br>
 * @History:
 */
@Service("ncpShopRecommendService")
public class NcpShopRecommendServiceImpl extends SqlServerBaseServiceImpl<NcpShopRecommendDto> implements NcpShopRecommendService {

}
