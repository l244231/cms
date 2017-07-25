/*
 * @(#)NcpUserDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月8日 
 */
package com.cms.core.market.base.domain;

import java.util.Date;

import com.cms.core.common.entity.BaseEntity;

/**
 * @title TODO
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月8日 Zain.Luo create file<br>
 *              Id:NcpUserDto.java,v1.0 2017年1月8日 下午4:54:22
 */
public class NcpUserDto extends BaseEntity {
	/**
	 * 用户编号
	 */
	private String userCode;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 证件号码
	 */
	private String cardNumber;
	/**
	 * 证件类型
	 */
	private String cardType;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 邮箱
	 */
	private String email;
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
	private String followCount;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 头像
	 */
	private String imageId;
	/**
	 * 手机号
	 */
	private String mobilePhone;
	/**
	 * 组织编号
	 */
	private String organizationId;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 昵称
	 */
	private String userAlias;
	private String userPwd;
	/**
	 * 爱好
	 */
	private String hobby;
	/**
	 * 真实姓名
	 */
	private String realName;
	private String star;
	private String sign;
	private String cid;
	/**
	 * 年龄
	 */
	private String age;
	private String backGround;
	private String deviceToken;
	private String position;
	/**
	 * 座机
	 */
	private String telePhone;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExtend1() {
		return extend1;
	}
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	public String getExtend2() {
		return extend2;
	}
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	public String getExtend3() {
		return extend3;
	}
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	public String getExtend4() {
		return extend4;
	}
	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	public String getFollowCount() {
		return followCount;
	}
	public void setFollowCount(String followCount) {
		this.followCount = followCount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBackGround() {
		return backGround;
	}
	public void setBackGround(String backGround) {
		this.backGround = backGround;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	
	

}
