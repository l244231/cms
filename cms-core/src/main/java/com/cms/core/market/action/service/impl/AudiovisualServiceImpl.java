package com.cms.core.market.action.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cms.core.common.properties.SystemProperties;
import com.cms.core.common.service.impl.SqlServerBaseServiceImpl;
import com.cms.core.common.util.LogMannger;
import com.cms.core.common.util.UploadFileUtil;
import com.cms.core.market.action.dao.AudiovisualDao;
import com.cms.core.market.action.domain.AudiovisualDomain;
import com.cms.core.market.action.domain.AudiovisualDto;
import com.cms.core.market.action.service.AudiovisualService;
import com.cms.core.market.base.domain.NcpFileInfoDto;
import com.cms.core.market.base.domain.NcpImageInfoDto;
import com.cms.core.market.base.service.NcpFileInfoService;
import com.cms.core.market.base.service.NcpImageInfoService;

@Service("audiovisualService")
public class AudiovisualServiceImpl extends SqlServerBaseServiceImpl<AudiovisualDto> implements AudiovisualService {
	private Logger logger  = LogMannger.getLogger();
	
	@Autowired
	private AudiovisualDao audiovisualDao;
	
	@Autowired
	private NcpFileInfoService ncpFileInfoService;
	
	@Autowired
	private NcpImageInfoService ncpImageInfoService;
	
	/* (non-Javadoc)
	 * @see com.cms.core.market.action.service.AudiovisualService#recommendAudiovisual(java.util.Map)
	 */
	@Override
	public boolean recommendAudiovisual(Map<String, Object> params) {
		 
		return audiovisualDao.recommendAudiovisual(params);
	}
	/* (non-Javadoc)
	 * @see com.cms.core.market.action.service.AudiovisualService#queryAvDetail(long)
	 */
	@Override
	public Map<String, Object> queryAvDetail(long id) {
		return audiovisualDao.queryAvDetail(id);
	}
	/* (non-Javadoc)
	 * @see com.cms.core.market.action.service.AudiovisualService#save(com.cms.core.market.action.domain.AudiovisualDomain)
	 */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public String save(MultipartFile imgFile,MultipartFile mediaFile,AudiovisualDomain domain) {
		try{
			if(imgFile != null && imgFile.getSize() > 0){
				NcpImageInfoDto image = UploadFileUtil.imageUpload(imgFile);
				if (image == null) {
					throw new RuntimeException("操作失败，原因：图片上传失败");
				}
				ncpImageInfoService.insert(image);
				domain.setImage(image.getId());
			}
			if(mediaFile != null && mediaFile.getSize() > 0){
				NcpFileInfoDto media = UploadFileUtil.mediaUpload(mediaFile);
				if (media == null) {
					throw new RuntimeException("操作失败，原因：视频/音频上传失败");
				}
				ncpFileInfoService.insert(media);
				domain.setFileId(media.getId());
				domain.setFileType(media.getType());
				String uri = SystemProperties.getAvUrl()+media.getId()+"."+media.getType();
				domain.setUri(uri);
				
			} 
			if(StringUtils.isEmpty(domain.getId())){
				audiovisualDao.insertAv(domain);
			}else{
				audiovisualDao.updateAv(domain);
			}
		}catch (Exception e) {
			logger.error("视听详细保存/更新失败{}",e.getMessage());
			throw new RuntimeException("操作失败，原因："+e.getMessage());
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.cms.core.market.action.service.AudiovisualService#setStatus(java.util.Map)
	 */
	@Override
	public boolean setStatus(Map<String, Object> params) {
		return audiovisualDao.setStatus(params);
	}

}
