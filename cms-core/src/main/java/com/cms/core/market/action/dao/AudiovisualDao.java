package com.cms.core.market.action.dao;

import java.util.Map;

import com.cms.core.commerce.common.dao.BaseDao;
import com.cms.core.market.action.domain.AudiovisualDomain;
import com.cms.core.market.action.domain.AudiovisualDto;

/** 
 * @Title:每日视听dao类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月3日 下午10:40:03 Zain.Luo  <br> 
 * @History:
 */
public interface AudiovisualDao extends BaseDao<AudiovisualDto> {
	/**
	 * @Title:recommendAudiovisual
	 * @Author:Zain.Luo
	 * @Description:更新数据推荐到首页状态
	 * @param params
	 * 		id:主键ID
	 * 		isHome:是否推荐到首页，1：是，0：否
	 * @return 
	 * @Created:2017年1月3日  下午10:40:23<br>
	 * @History:
	 */
	public boolean recommendAudiovisual(Map<String, Object> params);
	
	/**
	 * @Title:queryAvDetail
	 * @Author:Zain.Luo
	 * @Description:根据视听ID查找视听明细
	 * @param params
	 * @return 
	 * @Created:2017年1月4日  下午10:14:13<br>
	 * @History:
	 */
	public Map<String,Object> queryAvDetail(long id);
	
	/**
	 * @Title:updateAv
	 * @Author:Zain.Luo
	 * @Description:更新视听信息
	 * @param domain 视听详细信息
	 * @return 
	 * @Created:2017年1月4日  下午11:24:48<br>
	 * @History:
	 */
	public boolean updateAv(AudiovisualDomain domain);
	
	/**
	 * @Title:insertAv
	 * @Author:Zain.Luo
	 * @Description:插入视听信息
	 * @param domain 视听详细信息
	 * @return 
	 * @Created:2017年1月4日  下午11:25:07<br>
	 * @History:
	 */
	public boolean insertAv(AudiovisualDomain domain);
	
	/** 
	* @Title: setStatus 
	* @author: Zain.Luo
	* @Description: 修改视听表状态
	* @param params
	* @return    
	* @return boolean    
	* @throws 
	* @history: 2017年1月5日 created
	*/
	public boolean setStatus(Map<String,Object> params);
}
