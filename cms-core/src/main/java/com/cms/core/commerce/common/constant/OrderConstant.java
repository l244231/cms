/*
 * OrderConstant.java  <br>
 * Author:Zain.Luo  <br>
 * Created Date: 2016年12月26日  <br>
 */
package com.cms.core.commerce.common.constant;

/**
 * @Title:订单常量类
 * @Author:Zain.Luo
 * @Version:1.0
 * @Created:2016年12月26日 下午10:39:31 Zain.Luo <br>
 * @History:
 */
public class OrderConstant {

	/**
	 * @Title:订单状态常量类
	 * @Author:Zain.Luo
	 * @Version:1.0
	 * @Created:2016年12月26日 下午10:50:17 Zain.Luo <br>
	 * @History:
	 */
	public static class Status {
		/**
		 * 待支付
		 */
		public final static short NOT_PAY = 0;

		/**
		 * 待发货
		 */
		public final static short WAIT_SENT = 1;
		/**
		 * 待收货
		 */
		public final static short WAIT_RECEIPT = 2;
		/**
		 * 待评价
		 */
		public final static short WAIT_EVALUATE = 3;
		/**
		 * 交易关闭
		 */
		public final static short TRANSACTION_CLOSE = 4;
		/**
		 * 待审核（免费试用）
		 */
		public final static short WAIT_AUDITING = 5;
		/**
		 * 交易成功
		 */
		public final static short SUCCESSFUL_TRADE = 6;
		/**
		 * 参团成功
		 */
		public final static short SUCCESS_GROUP = 7;
	}

	/**
	 * @Title:订单类型常量类
	 * @Author:Zain.Luo
	 * @Version:1.0
	 * @Created:2016年12月26日 下午10:50:35 Zain.Luo <br>
	 * @History:
	 */
	public static class Type {
		/**
		 * 默认(商品)
		 */
		public final static int DEFAULT = 1;

		/**
		 * 试用
		 */
		public final static int TRIAL = 3;

		/**
		 * 团购
		 */
		public final static int GROUP = 4;

		/**
		 * 优惠活动
		 */
		public final static int PREFERENTIAL_ACTIVITY = 5;
	}
}
