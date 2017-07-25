/*
 * @(#)UploadFiles.java
 * Author : Zain.Luo
 * Created Date: 2016年12月13日 
 */
package com.cms.core.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @title 上传文件集合实体类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2016年12月13日 Zain.Luo create file<br>
 *              Id:UploadFiles.java,v1.0 2016年12月13日 下午2:58:13
 */
public class UploadFiles {
	/**
	 * 上传文件集合
	 */
	private List<UploadFile> list;

	public List<UploadFile> getList() {
		return list;
	}

	public void setList(List<UploadFile> list) {
		this.list = list;
	}

	/**
	 * @Title: getCount
	 * @author: Zain.Luo
	 * @Description: 获取文件个数
	 * @return
	 * @return int
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public int getCount() {
		if (this.list == null) {
			return 0;
		} else {
			return list.size();
		}
	}

	/**
	 * @Title: addUploadFile
	 * @author: Zain.Luo
	 * @Description: 将上传文件添加到集合中
	 * @param file
	 * @return void
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public void addUploadFile(UploadFile file) {
		if (this.list == null) {
			this.list = new ArrayList<UploadFile>();
		}
		list.add(file);
	}

	/**
	 * @Title: removeUploadFile
	 * @author: Zain.Luo
	 * @Description: 从集合中移除上传文件
	 * @param file
	 *            文件信息
	 * @return void
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public void removeUploadFile(UploadFile file) {
		if (getCount() >= 0) {
			this.list.remove(file);
		}
	}

	/**
	 * @Title: removeUploadFile
	 * @author: Zain.Luo
	 * @Description: 通过集合下标，将上传文件信息从集合中移除
	 * @param index
	 *            下标
	 * @return void
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public void removeUploadFile(int index) {
		if (getCount() >= 0) {
			this.list.remove(index);
		}
	}

	/**
	 * @Title: clear
	 * @author: Zain.Luo
	 * @Description: 清空集合
	 * @return void
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public void clear() {
		if (this.list == null) {
			this.list = new ArrayList<UploadFile>();
		} else if (getCount() >= 0) {
			this.list.clear();
		}
	}

	/**
	 * @Title: getFile
	 * @author: Zain.Luo
	 * @Description: 通过上传文件集合下标获取文件信息
	 * @param index
	 *            文件下标
	 * @return
	 * @return UploadFile 上传文件信息
	 * @throws @history:
	 *             2016年12月13日 created
	 */
	public UploadFile getFile(int index) {
		if (getCount() >= 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
