/*
 * @(#)BinaryFileHbDaoImpl.java
 * Author : Zain.Luo
 * Created Date: 2017年1月24日 
 */
package com.cms.hb.commerce.common.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.cms.hb.commerce.common.dao.BinaryFileHbDao;
import com.cms.hb.commerce.common.domain.BinaryFileHbDto;
import com.tnsoft.hibernate.BaseHibernateUtils;
import com.tnsoft.hibernate.DbSession;

/**
 * @title 文件管理dao实体类
 * @author Zain.Luo
 * @version 1.0<br>
 * @history<br>
 * 				2017年1月24日 Zain.Luo create file<br>
 *              Id:BinaryFileHbDaoImpl.java,v1.0 2017年1月24日 上午10:15:07
 */
@Repository("binaryFileHbDao")
public class BinaryFileHbDaoImpl implements BinaryFileHbDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cms.hb.commerce.common.dao.BinaryFileHbDao#findById(long)
	 */
	@Override
	public BinaryFileHbDto findById(long id) {
		DbSession session =  null;
		BinaryFileHbDto dto = null;
		try{
		session = BaseHibernateUtils.newSession();
		dto = (BinaryFileHbDto) session.get(BinaryFileHbDto.class, id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return dto;
	}
 

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cms.hb.commerce.common.dao.BinaryFileHbDao#insertImage()
	 */
	@Override
	public BinaryFileHbDto insertImage(MultipartFile file) {
		BinaryFileHbDto dto = null;
		Transaction tran = null;
		DbSession session = null;
		try {
			dto = new BinaryFileHbDto();

			session = BaseHibernateUtils.newSession();
			LobCreator lob = Hibernate.getLobCreator(session.getSession());
			tran = (Transaction) session.beginTransaction();// 开始事务
			Blob blob = lob.createBlob(file.getInputStream(), file.getSize());
			dto.setContent(blob);
			dto.setMimeType(2);
			dto.setType(2);
			session.save(dto);
			session.flush();
			tran.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session != null){
				session.clear();
				session.close();
			}
		}
		return dto;
	}
}
