package com.cms.core.market.action.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cms.core.common.service.SqlServerBaseService;
import com.cms.core.market.action.domain.AudiovisualDomain;
import com.cms.core.market.action.domain.AudiovisualDto;

public interface AudiovisualService extends SqlServerBaseService<AudiovisualDto>{
	
	/**
	 * @Title:recommendAudiovisual
	 * @Author:Zain.Luo
	 * @Description:更新数据推荐到首页状态
	 * @param params
	 * 		id:主键ID
	 * 		isHome:是否推荐到首页，1：是，0：否
	 * @return 
	 * @Created:2017年1月3日  下午10:38:15<br>
	 * @History:
	 */
	public boolean recommendAudiovisual(Map<String,Object> params);
	
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
	 * @Title:save
	 * @Author:Zain.Luo
	 * @Description:保存视听信息
	 * @param imgFile 图片文件信息
	 * @param mediaFile 视频/音频文件信息
	 * @param domain 视听信息
	 * @return 错误信息，无返回信息则表示上传成功
	 * @Created:2017年1月4日  下午11:21:10<br>
	 * @History:
	 */
	public String save(MultipartFile imgFile,MultipartFile mediaFile,AudiovisualDomain domain);
	
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
