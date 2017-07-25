/*
 * CommodityServiceImpl.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月27日  <br>
 */
package com.cms.core.commerce.commodity.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.cms.core.commerce.commodity.dao.CommodityDao;
import com.cms.core.commerce.commodity.domain.CommodityCategoryDto;
import com.cms.core.commerce.commodity.domain.CommodityColorDto;
import com.cms.core.commerce.commodity.domain.CommodityDeliveryDto;
import com.cms.core.commerce.commodity.domain.CommodityDto;
import com.cms.core.commerce.commodity.domain.CommodityIconsDto;
import com.cms.core.commerce.commodity.domain.CommodityInStoreDto;
import com.cms.core.commerce.commodity.domain.CommoditySpecDto;
import com.cms.core.commerce.commodity.service.CommodityColorService;
import com.cms.core.commerce.commodity.service.CommodityDeliveryService;
import com.cms.core.commerce.commodity.service.CommodityIconsService;
import com.cms.core.commerce.commodity.service.CommodityInStoreService;
import com.cms.core.commerce.commodity.service.CommodityService;
import com.cms.core.commerce.commodity.service.CommoditySpecService;
import com.cms.core.commerce.common.constant.CommodityConstant;
import com.cms.core.commerce.common.service.BinaryFileService;
import com.cms.core.commerce.other.domain.DeliveryTagsDto;
import com.cms.core.commerce.other.service.DeliveryTagsService;
import com.cms.core.common.service.impl.BaseServiceImpl;
import com.cms.core.common.util.LogMannger;
import com.cms.core.demo.service.CommodityCategoryService;
import com.cms.core.market.business.domain.NcpShopDto;
import com.cms.core.market.business.service.NcpShopService;
import com.cms.hb.commerce.common.domain.BinaryFileHbDto;
import com.cms.hb.commerce.common.service.BinaryFileHbService;

import sun.misc.BASE64Encoder;

/**
 * @Title:商品service实现类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月27日 上午12:43:35 Zain.Luo <br>
 * @History:
 */
@Service("commodityService")
public class CommodityServiceImpl extends BaseServiceImpl<CommodityDto> implements CommodityService {
	@Autowired
	private CommodityDao commodityDao;

	Logger logger = LogMannger.getLogger();

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private BinaryFileService binaryFileService;

	@Autowired
	private CommodityIconsService commodityIconsService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	@Autowired
	private NcpShopService ncpShopService;

	@Autowired
	private CommoditySpecService commoditySpecService;

	@Autowired
	private CommodityColorService commodityColorService;

	@Autowired
	private CommodityDeliveryService commodityDeliveryService;

	@Autowired
	private DeliveryTagsService deliveryTagsService;

	@Autowired
	private BinaryFileHbService binaryFileHbService;
	
	@Autowired
	private CommodityInStoreService commodityInStoreService;

	public static final String INSERT = "insert";
	public static final String UPDATE = "update";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.commodity.service.CommodityService#updateCommodityStatus(
	 * java.util.Map)
	 */
	@Override
	public boolean updateCommodityStatus(Map<String, Object> params) {
		return commodityDao.updateCommodityStatus(params);
	}

	/**
	 * 
	 * @Title:saveAndUpdateCommodity
	 * @Author:lijx
	 * @Description: 保存和更新商品
	 * @param request
	 * @param commodityDto
	 * @return
	 * @Created:2017年1月12日 下午9:34:21<br>
	 * @History:
	 */
	@Override
	@SuppressWarnings("restriction")
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public boolean saveAndUpdateCommodity(HttpServletRequest request, CommodityDto commodityDto) {
		List<Long> imgList = new ArrayList<Long>();
		try {

			String type = INSERT;
			if (commodityDto.getId() != 0) {
				type = UPDATE;
			}

			if (commodityDto != null) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile listIcon = multipartRequest.getFile("imgFile");
				List<MultipartFile> iconImages = multipartRequest.getFiles("imgMultipleFile");

				BinaryFileHbDto binaryFileDto = null; 

				long commodityId = 0;

				// 去掉文本编辑框中前后多余的\r\n
				commodityDto.setDescription(replaceString(commodityDto.getDescription()));
				commodityDto.setPurchaseNotes(replaceString(commodityDto.getPurchaseNotes()));

				// 保存列表图片到二进制表和商品表
				if (INSERT.equals(type)) {
					commodityDto.setCreationTime(new Date());
					commodityService.insert(commodityDto);
					commodityId = commodityDto.getId();
					if(commodityDto.getStock()>0){
						inStoreLog(commodityDto,commodityDto.getStock());
					}
				} else {
					commodityId = commodityDto.getId();
					commodityService.update(commodityDto);
				}

				if (listIcon != null && listIcon.getSize() > 0 && listIcon.getBytes().length > 0) {

					if (INSERT.equals(type)) {
						binaryFileDto = binaryFileHbService.insertImage(listIcon);
						long listIconFileId = binaryFileDto.getId();
						imgList.add(binaryFileDto.getId());

						/*
						 * 列表图上不存入commodity_icons表中 CommodityIconsDto
						 * commodityIconsDto = new CommodityIconsDto();
						 * commodityIconsDto.setIconId(listIconFileId);
						 * 
						 * commodityIconsDto.setCommodityId(commodityId);
						 * commodityIconsService.insert(commodityIconsDto); long
						 * listIconId = commodityIconsDto.getId();
						 */
						commodityDto.setListIconId(listIconFileId);
						commodityService.update(commodityDto);
					} else {
						// 先删除原图片
						/*
						 * CommodityIconsDto commodityListIconForDelete =
						 * commodityIconsService.findById(commodityDto.
						 * getListIconId()); if (commodityListIconForDelete !=
						 * null) {
						 * binaryFileService.delete(commodityListIconForDelete.
						 * getIconId());
						 * commodityIconsService.delete(commodityDto.
						 * getListIconId()); }
						 */
						binaryFileDto = binaryFileHbService.insertImage(listIcon);
						long listIconFileId = binaryFileDto.getId();
						/*
						 * 列表图上不存入commodity_icons表中
						 * imgList.add(binaryFileDto.getId());
						 * 
						 * CommodityIconsDto commodityIconsDto = new
						 * CommodityIconsDto();
						 * commodityIconsDto.setIconId(listIconFileId);
						 * 
						 * commodityIconsDto.setCommodityId(commodityId);
						 * commodityIconsService.insert(commodityIconsDto); long
						 * listIconId = commodityIconsDto.getId();
						 */
						commodityDto.setListIconId(listIconFileId);
						commodityService.update(commodityDto);

					}

				}

				List<Long> iconIds = new ArrayList<Long>();
				// 保存商品图片到二进制表
				if (iconImages != null && iconImages.size() > 0) {
					// 修改前先删除已有商品图片----暂改为ajax删除图片，这里只需上传图片
					// if(UPDATE.equals(type)){
					// //获取所有关联的iconId和fileId，且为非列表图片
					// Map<String,Object> params = new HashMap<String,Object>();
					// params.put("commodityId", commodityId);
					// List<CommodityIconsDto> commodityIcons =
					// commodityIconsService.findAllListByParams(params);
					// List<Long> commodityIconFileIds = new ArrayList<Long>();
					// for (CommodityIconsDto commodityIcon : commodityIcons) {
					// commodityIconFileIds.add(commodityIcon.getIconId());
					// if (commodityDto.getListIconId() !=
					// commodityIcon.getId()) {
					// commodityIconsService.delete(commodityIcon.getId());
					// }
					// }
					// }

					for (MultipartFile icon : iconImages) {
						binaryFileDto = binaryFileHbService.insertImage(icon);
						iconIds.add(binaryFileDto.getId());
						imgList.add(binaryFileDto.getId());
					}
				}

				// 保存商品图片到icons表
				if (!CollectionUtils.isEmpty(iconIds)) {
					for (Long iconId : iconIds) {
						CommodityIconsDto commodityIconsDto = new CommodityIconsDto();
						commodityIconsDto.setCommodityId(commodityId);
						commodityIconsDto.setIconId(iconId);
						commodityIconsService.insert(commodityIconsDto);
					}
				}

				// 保存子规格到规格表
				String specData = request.getParameter("specData");
				if (StringUtils.isNotEmpty(specData)) {
					if (UPDATE.equals(type)) {
						// 更新前先删除所有子规格
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("commodityId", commodityId);
						commoditySpecService.deleteByParams(params);
					}
					List<CommoditySpecDto> commoditySpecDtoList = JSON.parseArray(specData, CommoditySpecDto.class);
					for (CommoditySpecDto commoditySpecDto : commoditySpecDtoList) {
						commoditySpecDto.setCommodityId(commodityId);
						commoditySpecService.insert(commoditySpecDto);
					}
				}

				// 保存颜色到颜色表
				String colorData = request.getParameter("colorData");
				if (StringUtils.isNotEmpty(colorData)) {
					if (UPDATE.equals(type)) {
						// 更新前先删除所有颜色的子规格
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("commodityId", commodityId);
						commodityColorService.deleteByParams(params);
					}
					List<CommodityColorDto> commodityColorDtoList = JSON.parseArray(colorData, CommodityColorDto.class);
					for (CommodityColorDto commodityColorDto : commodityColorDtoList) {
						commodityColorDto.setCommodityId(commodityId);
						commodityColorDto.setColorNameEn("en");
						commodityColorService.insert(commodityColorDto);
					}
				}

				// 保存配送标签到配送标签表
				String[] deliveryIds = request.getParameterValues("delivery");
				logger.info("deliveryIds:{}", JSON.toJSONString(deliveryIds));
				if (deliveryIds != null) {
					if (UPDATE.equals(type)) {
						// 更新前先删除所有关联的配送标签
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("commodityId", commodityId);
						commodityDeliveryService.deleteByParams(params);
					}
					for (String deliveryId : deliveryIds) {
						CommodityDeliveryDto commodityDeliveryDto = new CommodityDeliveryDto();
						commodityDeliveryDto.setCommodityId(commodityId);
						commodityDeliveryDto.setDeliveryId(Long.parseLong(deliveryId));
						commodityDeliveryDto.setCreationTime(new Date());
						commodityDeliveryDto.setLastModified(new Date());
						commodityDeliveryService.insert(commodityDeliveryDto);
					}
				}
			}

			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			// 异常，图片删除。 Hibernate插入图片不受该事务影响，需要将图片重新删除
			if (imgList.size() > 0) {
				for (int i = 0; i < imgList.size(); i++) {
					binaryFileService.delete(imgList.get(i));
				}
			}
			throw new RuntimeException("商品保存失败，原因"+e.getMessage());
		}
	}

	/**
	 * 获取商品信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> getCommodityInfoMap(long id) {

		Map<String, Object> commodityInfoMap = new HashMap<String, Object>();

		// 获取商品分类
		List<CommodityCategoryDto> commodityCategoryDtoList = commodityCategoryService.findAllList();
		commodityInfoMap.put("commodityCategoryDtoList", commodityCategoryDtoList);

		// 获取商品
		CommodityDto commodityDto = commodityService.findById(id);
		commodityInfoMap.put("commodityDto", commodityDto);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("commodityId", commodityDto.getId());

		// 获取规格的子规格
		List<CommoditySpecDto> commoditySpecDtoList = commoditySpecService.findAllListByParams(params);
		commodityInfoMap.put("commoditySpecDtoList", commoditySpecDtoList);

		// 获取颜色
		List<CommodityColorDto> commodityColorDtoList = commodityColorService.findAllListByParams(params);
		commodityInfoMap.put("commodityColorDtoList", commodityColorDtoList);

		// 获取商品图片
		List<CommodityIconsDto> commodityIcons = commodityIconsService.findAllListByParams(params);
		List<Long> commodityIconFileIds = new ArrayList<Long>();
		for (CommodityIconsDto commodityIcon : commodityIcons) {
			commodityIconFileIds.add(commodityIcon.getIconId());
		}
		commodityInfoMap.put("commodityIconFileIds", commodityIconFileIds);

		// 获取店铺
		Map<String, Object> paramsForShop = new HashMap<String, Object>();
		paramsForShop.put("isVirtual", 1);
		List<NcpShopDto> ncpShopDtoList = ncpShopService.findAllListByParams(paramsForShop);
		commodityInfoMap.put("ncpShopDtoList", ncpShopDtoList);

		// 获取所有配送标签
		List<DeliveryTagsDto> deliveryTagsDtoList = deliveryTagsService.findAllList();
		commodityInfoMap.put("deliveryTagsDtoList", deliveryTagsDtoList);

		// 获取所有已关联的配送标签
		List<CommodityDeliveryDto> deliveryIds = commodityDeliveryService.findAllListByParams(params);

		Map<Long, Boolean> commodityDeliveryDtoMap = new HashMap<Long, Boolean>();
		for (CommodityDeliveryDto commodityDeliveryDto : deliveryIds) {
			commodityDeliveryDtoMap.put(commodityDeliveryDto.getDeliveryId(), true);
		}

		commodityInfoMap.put("deliveryIds", commodityDeliveryDtoMap);

		return commodityInfoMap;
	}

	/**
	 * @Title: replaceString
	 * @author: Zain.Luo
	 * @Description: 去掉前后多余的换行符
	 * @param str
	 * @return
	 * @return String
	 * @throws @history:
	 *             2017年1月19日 created
	 */
	private String replaceString(String str) {
		String result = StringUtils.isEmpty(str) ? "" : str;
		result = result.replaceAll("^[\r\n]*", "");
		result = result.replaceAll("[\r\n]*$", "");
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cms.core.commerce.commodity.service.CommodityService#updateStock(com.
	 * cms.core.commerce.commodity.domain.CommodityDto)
	 */
	@Override
	public void updateStock(CommodityDto dto) { 
		commodityDao.updateStock(dto);
	}

	@Override
	public String findCommodityIsHadUse(Map<String, Object> params) {
		HashMap result = (HashMap) commodityDao.findCommodityIsHadUse(params);
		String resultStr = "";
		String str = "存在";
		if ((long) result.get("group") != 0) {
			str += "【团购爆款】";
		}
		if ((long) result.get("hot") != 0) {
			str += "【爆款榜单】";
		}
		if ((long) result.get("trial") != 0) {
			str += "【热门试用】";
		}
		if ((long) result.get("discount") != 0) {
			str += "【限时优惠】";
		}
		str += "信息";
		if(str.length() >4){
			resultStr = str;
		}
		return resultStr;
	}
	
	/**
	 * @Title:inStoreLog
	 * @Author:Zain.Luo
	 * @Description:添加入库记录
	 * @param commodity
	 * @param stock 
	 * @Created:2017年2月19日  下午5:08:23<br>
	 * @History:
	 */
	private void inStoreLog(CommodityDto commodity,int stock){
		CommodityInStoreDto cInStore = new CommodityInStoreDto();
		cInStore.setCommodityId(commodity.getId());
		cInStore.setInStoreAmount(stock);
		cInStore.setInStoreTime(new Date());
		cInStore.setStoreAmount(commodity.getStock());
		cInStore.setType(CommodityConstant.RelativeType.CMMODITY);
		commodityInStoreService.insert(cInStore);
	}
}
