package com.aiidc.sps.ep.services;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiidc.base.AiidcException;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.base.util.DateUtil;
import com.aiidc.sps.ep.entity.InnerContatc;
import com.aiidc.sps.ep.mapper.InnerContatcMapper;
import com.aiidc.sps.ep.parameter.InnerContatcQueryEntity;

@Service
public class InnerContatcService {

	@Autowired
	private InnerContatcMapper innerContMapper;
	
	public Integer getInnerContatcCount(InnerContatcQueryEntity innerContatcQueryEntity){
		return  innerContMapper.getInnerContaticCount(innerContatcQueryEntity);
	}
	
	public JSONArray getInnerContatcList(InnerContatcQueryEntity innerContatcQueryEntity) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		List<InnerContatc> list = innerContMapper.getInnerContatcList(innerContatcQueryEntity);
		JSONArray jarr = new JSONArray();
		for(InnerContatc innerContatc : list){
			@SuppressWarnings("unchecked")
			Map<String, Object> innerMap = BeanUtils.describe(innerContatc);
			innerMap.put("changeTimeStr", DateUtil.getStringByDate(innerContatc.getChangeTime(), "yyyy-MM-dd"));
			jarr.put(innerMap);
		}
		return jarr;
	}
	
	public JSONArray getInnerContatcById(int id) 
	throws AiidcException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		if(id >0){
			InnerContatc innerContatc = innerContMapper.getInnerContatcById(id).get(0);
			@SuppressWarnings("unchecked")
			Map<String, Object> innerMap = BeanUtils.describe(innerContatc);
			innerMap.put("changeTimeStr", DateUtil.getStringByDate(innerContatc.getChangeTime(), "yyyy-MM-dd"));
			jarr.put(innerMap);
		}else{
			AiidcException e = new AiidcException("ID_NOT_NULL");
			throw e;
		}
		return jarr;
	}
	
	public void deleteInnerContatcById(int id) throws AiidcException{
		if(id>0){
			innerContMapper.deleteInnerContatcById(id);
		}else{
			throw new AiidcException("ID_NOT_NULL");
		}
	}
	
	public void addInnerContatc(InnerContatc innerContatc) throws AiidcException{
		 if(innerContatc.getContacts() ==null || innerContatc.getContacts().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(innerContatc.getDepartment()==null || innerContatc.getDepartment().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(innerContatc.getTelephone() ==null || innerContatc.getTelephone().length()<=0 ){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(innerContatc.getMobilePhone() ==null || innerContatc.getMobilePhone().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(innerContatc.getEmail() == null || innerContatc.getEmail().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(innerContatc.getCompanyName() ==null || innerContatc.getCompanyName().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else{
			innerContatc.setId(innerContMapper.getInnerContatcId());
			innerContatc.setChangeTime(new Date());
			innerContMapper.addInnerContatc(innerContatc);
		}
	}
	
	public void updateInnerContatc(InnerContatc innerContatc) throws AiidcException{
		 	if(innerContatc.getId()<=0){
		 		throw new AiidcException("ID_NOT_NULL");
		 	}else if(innerContatc.getContacts() ==null || innerContatc.getContacts().length()<=0){
				throw new AiidcException("DATA_NOT_NULL");
			}else if(innerContatc.getDepartment()==null || innerContatc.getDepartment().length()<=0){
				throw new AiidcException("DATA_NOT_NULL");
			}else if(innerContatc.getTelephone() ==null || innerContatc.getTelephone().length()<=0 ){
				throw new AiidcException("DATA_NOT_NULL");
			}else if(innerContatc.getMobilePhone() ==null || innerContatc.getMobilePhone().length()<=0){
				throw new AiidcException("DATA_NOT_NULL");
			}else if(innerContatc.getEmail() == null || innerContatc.getEmail().length()<=0){
				throw new AiidcException("DATA_NOT_NULL");
			}else if(innerContatc.getCompanyName() ==null || innerContatc.getCompanyName().length()<=0){
				throw new AiidcException("DATA_NOT_NULL");
			}else{
				innerContMapper.updateContatc(innerContatc);
			}
	}
	
	
	
	
	
}


















