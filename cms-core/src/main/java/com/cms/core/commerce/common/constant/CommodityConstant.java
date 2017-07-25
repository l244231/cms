/*
 * ComodityConstant.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月28日  <br>
 */
package com.cms.core.commerce.common.constant;

/** 
 * @Title:商品常量类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月28日 下午9:21:47 Zain.Luo  <br> 
 * @History:
 */
public class CommodityConstant {
	
	/** 
	 * @Title:用户试用结果状态常量类
	 * @Author:Zain.Luo
	 * @Version:1.0
	 * @Created:2016年12月28日 下午9:22:16 Zain.Luo  <br> 
	 * @History:
	 */
	public static class TrialUserIsWin{
		/**
		 * 试用申请通过
		 */
		public static final int ADOPT = 1;
		
		/**
		 * 试用申请拒绝
		 */
		public static final int REFUSE = 2;
		
		/**
		 * 试用申请默认状态
		 */
		public static final int DEFAULT = 0;
	}
	
	/** 
	 * @Title:商品状态常量类
	 * @Author:Zain.Luo
	 * @Version:1.0
	 * @Created:2017年1月7日 下午12:09:46 Zain.Luo  <br> 
	 * @History:
	 */
	public static class CommodityStatus{
		/**
		 * 在售
		 */
		public static final short IS_SALSE=1;
		
		/**
		 * 停售
		 */
		public static final short STOP_SALSE=4;
	}
	
	/**
	 * @title 是否推荐首页常量类
	 * @author Zain.Luo
	 * @version 1.0<br>
	 * @history<br>
	 * 2017年1月8日 Zain.Luo create file<br>
	 * Id:CommodityConstant.java,v1.0 2017年1月8日 下午1:11:51
	 */
	public static class CommodityIsHome{
		/**
		 * 推荐首页
		 */
		public static final int IS_HOME = 1;
		
		/**
		 * 不推荐首页
		 */
		public static final int IS_NOT_HOME = 0;
	}
	
	/**
	 * @title 商品活动类型表
	 * @author Zain.Luo
	 * @version 1.0<br>
	 * @history<br>
	 * 2017年1月17日 Zain.Luo create file<br>
	 * Id:CommodityConstant.java,v1.0 2017年1月17日 下午3:27:42
	 */
	public static class RelativeType{
		/**
		 * 商品
		 */
		public static final short CMMODITY = 1;
		
		/**
		 * 团购
		 */
		public static final short GROUP = 4;
		
		/**
		 * 试用
		 */
		public static final short TRIAL = 3;
		
		/**
		 * 优惠活动
		 */
		public static final short DISCOUNT = 5;
		
		/**
		 * 跳转
		 */
		public static final short SKIP = 0;
	}
}
