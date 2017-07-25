/*
 * @(#)NcpShopServiceImpl.java
 * Author : Zain.Luo
 * Created Date: 2016年12月30日 
 */
package com.cms.core.market.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.util.StringUtils;
import com.cms.core.common.exception.UploadException;
import com.cms.core.common.service.impl.SqlServerBaseServiceImpl;
import com.cms.core.common.util.LogMannger;
import com.cms.core.common.util.UploadFileUtil;
import com.cms.core.market.base.domain.NcpImageInfoDto;
import com.cms.core.market.base.service.NcpImageInfoService;
import com.cms.core.market.business.dao.NcpShopDao;
import com.cms.core.market.business.domain.BrandDto;
import com.cms.core.market.business.domain.NcpShopDto;
import com.cms.core.market.business.domain.NcpShopRecommendDto;
import com.cms.core.market.business.service.NcpShopRecommendService;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.core.market.common.constant.BusinessConstant;

/**
 * @title 商铺service实现类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月30日 Zain.Luo create file<br>
 *              Id:NcpShopServiceImpl.java,v1.0 2016年12月30日 上午10:42:20
 */
@Service("ncpShopService")
public class NcpShopServiceImpl extends SqlServerBaseServiceImpl<NcpShopDto>implements NcpShopService {
	private Logger logger = LogMannger.getLogger();

	@Autowired
	private NcpShopDao ncpShopDao;

	@Autowired
	private NcpImageInfoService ncpImageInfoService;

	@Autowired
	private NcpShopRecommendService ncpShopRecommendService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.market.business.service.NcpShopService#updateStatus(java.
	 * util.Map)
	 */
	@Override
	public void updateStatus(Map<String, Object> params) {
		ncpShopDao.updateStatus(params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.market.business.service.NcpShopService#saveShopInfo(javax.
	 * servlet.http.HttpServletRequest,
	 * org.springframework.web.multipart.MultipartFile[],
	 * com.cms.core.market.business.domain.BrandDto)
	 */
	@Override
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public Map<String, Object> saveShopInfo(HttpServletRequest request, MultipartFile[] imgList, BrandDto brand) {

		String flag = "N";
		String message = "";
		String id = request.getParameter("id");
		NcpShopDto shop = new NcpShopDto();
		/* 图片上传 */
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile logoImg = multipartRequest.getFile("logoImg");
		MultipartFile bigImg = multipartRequest.getFile("bigImg");
		MultipartFile homeImg = multipartRequest.getFile("homeImg");
		try {
			NcpImageInfoDto logo = UploadFileUtil.imageUpload(logoImg, "logo");
			NcpImageInfoDto big = UploadFileUtil.imageUpload(bigImg, "big");
			NcpImageInfoDto home = UploadFileUtil.imageUpload(homeImg,"home");
			List<NcpImageInfoDto> list = new ArrayList<NcpImageInfoDto>();
			NcpImageInfoDto img = null;
			if (imgList.length != 0) {
				for (int i = 0; i < imgList.length; i++) {
					 img = UploadFileUtil.imageListUpload(imgList[i]);
					 if(img != null){
						 list.add(img);
					 }
				}
			}
			if (logo != null) {
				ncpImageInfoService.insert(logo);
				shop.setShopLogo(logo.getId());
				logger.info("上传LOGO图片");
			}
			if (big != null) {
				logger.info("上传大图片");
				ncpImageInfoService.insert(big);
				shop.setBannerImage(big.getId());
			}
			if(home != null){
				logger.info("上传首页图片");
				ncpImageInfoService.insert(home);
			}
			if (list.size() != 0) {
				logger.info("上展示图");
				String imgArr = "";
				for (int i = 0; i < list.size(); i++) {
					ncpImageInfoService.insert(list.get(i));
					imgArr += list.get(i).getId() + ",";
				}
				shop.setImageId(imgArr.substring(0, imgArr.length() - 1));
			}

			/* 前台数据转换 */
			brandToShop(brand, shop);
			/* 判断是否虚拟店，是则创新实体店 */
			

			Map<String, Object> params = new HashMap<String, Object>();
			/* 保存信息 */
			
			long shopId = 0;

			if (StringUtils.isEmpty(brand.getId())) {
				/*
				 * 是否创建实体商铺，如果是直接创建，否则优先创建实体商铺，后创建虚拟商铺
				 * */
				 if(shop.getIsVirtual() == BusinessConstant.ShopIsVirtual.VIRTUAL){
					 shop.setIsVirtual(BusinessConstant.ShopIsVirtual.REALITY);
					 ncpShopDao.insert(shop);
					 shop.setPhysicalStore(shop.getId()+"");
					 shopId = shop.getId();
					 shop.setIsVirtual(BusinessConstant.ShopIsVirtual.VIRTUAL);
					 ncpShopDao.insert(shop);
				 } else{
					 ncpShopDao.insert(shop);
					 shopId = shop.getId();
				 }
				 
				 
				
			} else {
				shop.setId(Long.parseLong(brand.getId()));
				shopId = Long.parseLong(brand.getId());
				NcpShopDto oldShop = ncpShopDao.findByIdFull(shop.getId());
				
				/*虚拟店铺更新，需要将数据同步到实体店铺中*/
				if(shop.getIsVirtual() == BusinessConstant.ShopIsVirtual.VIRTUAL){
					
					/*判断是否做变更，由实体店铺变为虚拟店铺*/
					if(oldShop.getIsVirtual() == BusinessConstant.ShopIsVirtual.REALITY){
						
						/*实体店铺转虚拟店铺，则将新增一条虚拟店铺信息*/
						shop.setIsVirtual(BusinessConstant.ShopIsVirtual.REALITY);
						update(shop);
						params.put("physicalStore", shop.getId());
						NcpShopDto ncpShop = ncpShopDao.findByParams(params);
						
						long newId;
						if(ncpShop == null){
							ncpShopDao.insert(oldShop);
							newId = oldShop.getId();
						}else{
							newId = ncpShop.getId();
						}
						
						shop.setPhysicalStore(shop.getId()+"");
						shop.setIsVirtual(BusinessConstant.ShopIsVirtual.VIRTUAL);
						shop.setId(newId);
						update(shop);
					}else{
						
						/*虚拟店铺做更新，同时将数据同步至实体店铺中*/
						//判断之前是否存在该虚拟店铺的实体店铺数据，如没有将新增
						if(StringUtils.isEmpty(oldShop.getPhysicalStore())){
							oldShop.setIsVirtual(BusinessConstant.ShopIsVirtual.REALITY);
							insert(oldShop);
							shop.setPhysicalStore(oldShop.getId()+"");
							oldShop.setPhysicalStore(oldShop.getId()+"");
						}
						shop.setPhysicalStore(oldShop.getPhysicalStore());
						update(shop);
						oldShop = findById(Long.parseLong(oldShop.getPhysicalStore()));
						shop.setId(oldShop.getId());
						shop.setPhysicalStore(null);
						shop.setIsVirtual(BusinessConstant.ShopIsVirtual.REALITY);
						update(shop);
					}
				}else{
					
					/*判断是否由虚拟店铺转为实体店铺*/
					if(oldShop.getIsVirtual() == BusinessConstant.ShopIsVirtual.REALITY){
						/*实体店铺做更新，判断是否存在虚拟店铺，需同时更新虚拟和实体店铺*/
						update(shop);
						params.put("physicalStore", shop.getId());
						oldShop = ncpShopDao.findByParams(params);
						if(oldShop != null){
							delete(oldShop.getId());
						}
					}else{
						
						/*虚拟店铺转实体店铺，需将虚拟店铺做逻辑删除，并更新实体店铺信息*/
						/*虚拟店铺没有实体店铺，将该虚拟店铺改为实体店铺*/
						if(StringUtils.isEmpty(oldShop.getPhysicalStore())){
							shop.setIsVirtual(BusinessConstant.ShopIsVirtual.REALITY);
						}else{
							ncpShopDao.delete(shop.getId());
							shop.setId(Long.parseLong(oldShop.getPhysicalStore()));
						}
						ncpShopDao.update(shop);
					}
				}
			}

			params.put("shopId", shopId);
			/* 判断是否推荐到首页 */
			if (shop.getIsHome() == 0) {
				ncpShopRecommendService.delete(shopId);
			} else {
				if (ncpShopRecommendService.countByParams(params) == 0) {
					
					/*判断首页图片是否有上传*/
					if(home == null){
						logger.info("品牌操作失败，推荐首页未上传首页图片!");
						throw new RuntimeException("操作失败，推荐首页时必需上传首页图片!");
					}
					
					NcpShopRecommendDto dto = new NcpShopRecommendDto();
					dto.setShopId(shopId);
					dto.setProjectId("PROJECT158CE494A1B");//TODO 业务需求写死
					dto.setSort(shop.getSort());
					dto.setImage(home.getId());
					dto.setCreateDate(new Date());
					ncpShopRecommendService.insert(dto);
				}
			}
			
			flag = "Y";

		} catch (UploadException e) {
			logger.error("图片上传发生异常：{}", e.getMessage());
			throw new RuntimeException("图片上传发生异常，原因：" + e.getMessage());
		} catch (Exception e) {
			logger.error("保存品牌信息发生异常，原因：{}", e.getMessage());
			throw new RuntimeException("保存信息发生异常，原因：" + e.getMessage());
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("flag", flag);
		result.put("message", message);
		return result;
	}
	
	/**
	 * 将商铺list转为map
	 * @Title:getAllShopMap
	 * @Author:lijx
	 * @Description:TODO
	 * @return 
	 * @Created:2017年1月12日  上午1:05:29<br>
	 * @History:
	 */
	@Override
	public Map<Long,NcpShopDto> getAllShopMap(){
		Map<Long,NcpShopDto> map = new HashMap<Long,NcpShopDto>();
		List<NcpShopDto> list = ncpShopDao.findAllList();
		if(!CollectionUtils.isEmpty(list)){
			for (NcpShopDto ncpShopDto : list) {
				map.put(ncpShopDto.getId(), ncpShopDto);
			}
		}
		
		return map;
	}

	private void brandToShop(BrandDto brand, NcpShopDto shop) {
		shop.setShopName(brand.getTitle());
		shop.setBelongTo(brand.getBelongTo());
		shop.setAdd(brand.getAdd());
		shop.setName(brand.getName());
		shop.setSort(Integer.parseInt(brand.getSort()));
		shop.setFloorId(brand.getFloorId());
		shop.setFloorName(brand.getFloorName());
		shop.setIsVirtual(Integer.parseInt(brand.getIsVirtual()));
		shop.setIsHome(Integer.parseInt(brand.getIsHome()));
		shop.setCpc(brand.getCpc());
		shop.setShopType(brand.getShopType());
		shop.setTel(brand.getTel());
		shop.setShopInfo(brand.getShopInfo());
		shop.setCreateDate(new Date());
		shop.setUpdateDate(new Date());
		shop.setShopHours(brand.getBeginTime()+"-"+brand.getEndTime());
		shop.setPoiId(brand.getPoiId());
	}
}
