/*
 * @(#)NcpShopDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月5日 
 */
package com.cms.core.market.business.domain;

import java.util.Date;

import com.alibaba.druid.util.StringUtils;
import com.cms.core.common.entity.BaseEntity;

/**
 * @title 商铺表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月5日 Zain.Luo create file<br>
 *              Id:NcpShopDto.java,v1.0 2017年1月5日 下午2:48:58
 */
public class NcpShopDto extends BaseEntity {
	/**
	 * 楼宇编号
	 */
	private String buildingId;
	/**
	 * 楼宇名称
	 */
	private String buildingName;
	/**
	 * 楼层编号
	 */
	private String floorId;
	/**
	 * 商铺LOGO
	 */
	private String shopLogo;
	/**
	 * 图片编号,多图，以逗号“，”分隔
	 */
	private String imageId;
	/**
	 * POI名称
	 */
	private String name;
	/**
	 * POI编号
	 */
	private String poiId;
	/**
	 * 商铺名称
	 */
	private String shopName;
	/**
	 * 商铺类型
	 */
	private String shopType;
	/**
	 * 房间编号
	 */
	private String roomId;
	/**
	 * 营业时间
	 */
	private String shopHours;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 简介
	 */
	private String shopInfo;
	/**
	 * 人均消费
	 */
	private String cpc;
	private String belongTo;
	private String distance;
	/**
	 * 地址
	 */
	private String add;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 楼层名
	 */
	private String floorName;
	private String shopNameEn;
	private String shopNameTc;
	/**
	 * 收藏数
	 */
	private int collectionNum;
	/**
	 * 点赞数
	 */
	private int praiseNum;
	private int isTakeNumber;
	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 是否虚拟店铺
	 */
	private int isVirtual;
	/**
	 * 实体店编号
	 */
	private String physicalStore;
	/**
	 * 项目编号
	 */
	private String projectId;
	/**
	 * 标签
	 */
	private String propertyTag;
	/**
	 * Banner图片
	 */
	private String bannerImage;
	
	private int isHome; 
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoiId() {
		return poiId;
	}
	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getShopHours() {
		return shopHours;
	}
	public void setShopHours(String shopHours) {
		this.shopHours = shopHours;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}
	public String getCpc() {
		return cpc;
	}
	public void setCpc(String cpc) {
		this.cpc = cpc;
	}
	public String getBelongTo() {
		return belongTo;
	}
	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getShopNameEn() {
		return shopNameEn;
	}
	public void setShopNameEn(String shopNameEn) {
		this.shopNameEn = shopNameEn;
	}
	public String getShopNameTc() {
		return shopNameTc;
	}
	public void setShopNameTc(String shopNameTc) {
		this.shopNameTc = shopNameTc;
	}
	public int getCollectionNum() {
		return collectionNum;
	}
	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public int getIsTakeNumber() {
		return isTakeNumber;
	}
	public void setIsTakeNumber(int isTakeNumber) {
		this.isTakeNumber = isTakeNumber;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getIsVirtual() {
		return isVirtual;
	}
	public void setIsVirtual(int isVirtual) {
		this.isVirtual = isVirtual;
	}
	public String getPhysicalStore() {
		return physicalStore;
	}
	public void setPhysicalStore(String physicalStore) {
		this.physicalStore = physicalStore;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPropertyTag() {
		return propertyTag;
	}
	public void setPropertyTag(String propertyTag) {
		this.propertyTag = propertyTag;
	}
	public String getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	/**
	 * @return the isHome
	 */
	public int getIsHome() {
		return isHome;
	}
	/**
	 * @param isHome the isHome to set
	 */
	public void setIsHome(int isHome) {
		this.isHome = isHome;
	} 
}
