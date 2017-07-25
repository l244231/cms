/*
 * BrandDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月11日  <br>
 */
package com.cms.core.market.business.domain;

import com.alibaba.druid.util.StringUtils;

/**
 * @Title:品牌前端传参实体
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月11日 上午1:36:10 Zain.Luo <br>
 * @History:
 */
public class BrandDto {
	private String id;
	private String title;
	private String belongTo;
	private String sort;
	private String name;
	private String add;
	private String floorId;
	private String floorName;
	private String isVirtual;
	private String isHome;
	private String cpc;
	private String shopType;
	private String tel;
	private String shopInfo;
	private String beginTime;
	private String endTime;
	private String poiId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the belongTo
	 */
	public String getBelongTo() {
		return belongTo;
	}

	/**
	 * @param belongTo
	 *            the belongTo to set
	 */
	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		if (StringUtils.isEmpty(sort)) {
			return "0";
		}
		return sort;
	}

	/**
	 * @param sort
	 *            the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the add
	 */
	public String getAdd() {
		return add;
	}

	/**
	 * @param add
	 *            the add to set
	 */
	public void setAdd(String add) {
		this.add = add;
	}

	/**
	 * @return the floorId
	 */
	public String getFloorId() {
		return floorId;
	}

	/**
	 * @param floorId
	 *            the floorId to set
	 */
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	/**
	 * @return the isVirtual
	 */
	public String getIsVirtual() {
		if (StringUtils.isEmpty(isVirtual)) {
			return "0";
		}
		return isVirtual;
	}

	/**
	 * @param isVirtual
	 *            the isVirtual to set
	 */
	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	/**
	 * @return the isHome
	 */
	public String getIsHome() {
		if (StringUtils.isEmpty(isHome)) {
			return "0";
		}
		return isHome;
	}

	/**
	 * @param isHome
	 *            the isHome to set
	 */
	public void setIsHome(String isHome) {
		this.isHome = isHome;
	}

	/**
	 * @return the cpc
	 */
	public String getCpc() {
		return cpc;
	}

	/**
	 * @param cpc
	 *            the cpc to set
	 */
	public void setCpc(String cpc) {
		this.cpc = cpc;
	}

	/**
	 * @return the shopType
	 */
	public String getShopType() {
		return shopType;
	}

	/**
	 * @param shopType
	 *            the shopType to set
	 */
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the shopInfo
	 */
	public String getShopInfo() {
		return shopInfo;
	}

	/**
	 * @param shopInfo
	 *            the shopInfo to set
	 */
	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}

	/**
	 * @return the floorName
	 */
	public String getFloorName() {
		return floorName;
	}

	/**
	 * @param floorName
	 *            the floorName to set
	 */
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the poiId
	 */
	public String getPoiId() {
		return poiId;
	}

	/**
	 * @param poiId
	 *            the poiId to set
	 */
	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}

}
