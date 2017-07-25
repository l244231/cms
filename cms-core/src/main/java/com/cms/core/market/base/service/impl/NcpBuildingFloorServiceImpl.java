/*
 * NcpBuildingFloorServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.base.service.impl;

import org.springframework.stereotype.Service;

import com.cms.core.common.service.impl.SqlServerBaseServiceImpl;
import com.cms.core.market.base.domain.NcpBuildingFloorDto;
import com.cms.core.market.base.service.NcpBuildingFloorService;

/** 
 * @Title:楼层表Service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 下午10:05:51 Zain.Luo  <br> 
 * @History:
 */
@Service("ncpBuildingFloorService")
public class NcpBuildingFloorServiceImpl extends SqlServerBaseServiceImpl<NcpBuildingFloorDto> implements NcpBuildingFloorService{

}
