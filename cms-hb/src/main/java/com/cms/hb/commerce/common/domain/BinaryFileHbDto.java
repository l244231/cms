/*
 * @(#)BinaryFileHbDto.java
 * Author : Zain.Luo
 * Created Date: 2017年1月24日 
 */
package com.cms.hb.commerce.common.domain;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @title 文件实体类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月24日 Zain.Luo create file<br>
 *              Id:BinaryFileHbDto.java,v1.0 2017年1月24日 上午10:15:39
 */
@Entity
@Table(name = "binary_file", catalog = "eshop")
public class BinaryFileHbDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private int type;

	private int mimeType;

	private transient Blob content;

	private int status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "binary_file_id_seq")
	@SequenceGenerator(name = "binary_file_id_seq", sequenceName = "binary_file_id_seq")
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "type")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "mime_type")
	public int getMimeType() {
		return mimeType;
	}

	public void setMimeType(int mimeType) {
		this.mimeType = mimeType;
	}

	@Lob
	@Column(name = "content")
	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
