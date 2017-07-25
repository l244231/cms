package com.cms.web.common.beetl.function;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.beetl.core.Context;
import org.beetl.core.Function;

import com.cms.core.common.properties.ParamsMappingUtil;
import com.cms.core.common.util.LogMannger;

public class SysParameterFun implements Function{
	private Logger logger = LogMannger.getLogger(); 
	
	@Override
	public Object call(Object[] paras, Context ctx) {
		// TODO Auto-generated method stub
		Object key=paras[0];
		Object value=paras[1];
		try {
			logger.debug("key:{}--value:{}",key,value);
			ctx.byteWriter.writeString(getMapping(key.toString(),value.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	private String getMapping(String key,String value){
		logger.debug("key+value:{}",key+value);
		return ParamsMappingUtil.getMappingByteByKey(key+value);
	}
}
