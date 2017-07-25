/*
 * @(#)NcpPoiDataDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月19日 
 */
package com.cms.core.market.base.domain;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title POI数据表DTO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月19日 Zain.Luo create file<br>
 *              Id:NcpPoiDataDto.java,v1.0 2017年1月19日 下午2:49:57
 */
public class NcpPoiDataDto extends BaseEntity {
	private String poiId;
	private String buildingId;
	private String buildingName;
	private int color;
	private String layer;
	private String floorId;
	private String floorIndex;
	private String floorName;
	private String geoId;
	private String geometry;
	private float latitude;
	private float longitude;
	private String name;
	private String poiType;
	private float shapeArea;
	private float shapeLeng; 
	private String version;
	private String remark;
	private String areaType;
	private String poiView;
	private float labelX;
	private float labelY;
	private String nameEn;
	private String nameTc;
	public String getPoiId() {
		return poiId;
	}
	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}
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
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getFloorIndex() {
		return floorIndex;
	}
	public void setFloorIndex(String floorIndex) {
		this.floorIndex = floorIndex;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getGeoId() {
		return geoId;
	}
	public void setGeoId(String geoId) {
		this.geoId = geoId;
	}
	public String getGeometry() {
		return geometry;
	}
	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoiType() {
		return poiType;
	}
	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}
	public float getShapeArea() {
		return shapeArea;
	}
	public void setShapeArea(float shapeArea) {
		this.shapeArea = shapeArea;
	}
	public float getShapeLeng() {
		return shapeLeng;
	}
	public void setShapeLeng(float shapeLeng) {
		this.shapeLeng = shapeLeng;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public String getPoiView() {
		return poiView;
	}
	public void setPoiView(String poiView) {
		this.poiView = poiView;
	}
	public float getLabelX() {
		return labelX;
	}
	public void setLabelX(float labelX) {
		this.labelX = labelX;
	}
	public float getLabelY() {
		return labelY;
	}
	public void setLabelY(float labelY) {
		this.labelY = labelY;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameTc() {
		return nameTc;
	}
	public void setNameTc(String nameTc) {
		this.nameTc = nameTc;
	}
}
