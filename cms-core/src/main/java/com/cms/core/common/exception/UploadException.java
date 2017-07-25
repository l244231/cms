/*
 * @(#)UploadException.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.exception;

/**
 * @title 文件上传异常
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月13日 Zain.Luo create file<br>
 *              Id:UploadException.java,v1.0 2016年12月13日 下午3:41:43
 */
public class UploadException extends Exception {
	public UploadException(String msg) {
		super(msg);
	}

	public UploadException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UploadException(Throwable cause) {
		super(cause);
	}
}
