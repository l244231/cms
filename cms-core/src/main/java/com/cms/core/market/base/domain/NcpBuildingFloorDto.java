/*
 * NcpBuildingFloorDto.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2017年1月10日  <br>
 */
package com.cms.core.market.base.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @Title:楼层表DTO
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2017年1月10日 下午10:04:20 Zain.Luo <br>
 * @History:
 */
public class NcpBuildingFloorDto extends BaseEntity {
	/**
	 * 楼层编号
	 */
	private String floorId;
	/**
	 * 楼宇编号
	 */
	private String buildingId;
	/**
	 * 楼宇名称
	 */
	private String buildingName;
	/**
	 * 扩展1
	 */
	private String extend1;
	/**
	 * 扩展2
	 */
	private String extend2;
	/**
	 * 扩展3
	 */
	private String extend3;
	/**
	 * 扩展4
	 */
	private String extend4;
	/**
	 * 扩展5
	 */
	private String extend5;
	/**
	 * 楼层号
	 */
	private String floorIndex;
	/**
	 * 楼层名
	 */
	private String floorName;
	/**
	 * 是否默认
	 */
	private String isDefault;
	/**
	 * 楼层类型
	 */
	private String floorType;
	/**
	 * 楼层名(英)
	 */
	private String floorNameEn; 
	/**
	 * @return the floorId
	 */
	public String getFloorId() {
		return floorId;
	}
	/**
	 * @param floorId the floorId to set
	 */
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	/**
	 * @return the buildingId
	 */
	public String getBuildingId() {
		return buildingId;
	}
	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}
	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	/**
	 * @return the extend1
	 */
	public String getExtend1() {
		return extend1;
	}
	/**
	 * @param extend1 the extend1 to set
	 */
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	/**
	 * @return the extend2
	 */
	public String getExtend2() {
		return extend2;
	}
	/**
	 * @param extend2 the extend2 to set
	 */
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	/**
	 * @return the extend3
	 */
	public String getExtend3() {
		return extend3;
	}
	/**
	 * @param extend3 the extend3 to set
	 */
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	/**
	 * @return the extend4
	 */
	public String getExtend4() {
		return extend4;
	}
	/**
	 * @param extend4 the extend4 to set
	 */
	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	/**
	 * @return the extend5
	 */
	public String getExtend5() {
		return extend5;
	}
	/**
	 * @param extend5 the extend5 to set
	 */
	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}
	/**
	 * @return the floorIndex
	 */
	public String getFloorIndex() {
		return floorIndex;
	}
	/**
	 * @param floorIndex the floorIndex to set
	 */
	public void setFloorIndex(String floorIndex) {
		this.floorIndex = floorIndex;
	}
	/**
	 * @return the floorName
	 */
	public String getFloorName() {
		return floorName;
	}
	/**
	 * @param floorName the floorName to set
	 */
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	/**
	 * @return the isDefault
	 */
	public String getIsDefault() {
		return isDefault;
	}
	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * @return the floorType
	 */
	public String getFloorType() {
		return floorType;
	}
	/**
	 * @param floorType the floorType to set
	 */
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	/**
	 * @return the floorNameEn
	 */
	public String getFloorNameEn() {
		return floorNameEn;
	}
	/**
	 * @param floorNameEn the floorNameEn to set
	 */
	public void setFloorNameEn(String floorNameEn) {
		this.floorNameEn = floorNameEn;
	} 
}
