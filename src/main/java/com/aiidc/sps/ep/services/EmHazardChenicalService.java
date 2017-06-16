package com.aiidc.sps.ep.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiidc.base.AiidcException;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmHazardChenical;
import com.aiidc.sps.ep.mapper.EmHazardChenicalMapper;
import com.aiidc.sps.ep.parameter.EmHazardChenicalQueryEntity;


@Service
public class EmHazardChenicalService {
	
	@Autowired
	private EmHazardChenicalMapper emHazardChenicalMapper;
	
	public JSONArray findEmHazardChenicalList(EmHazardChenicalQueryEntity queryEntity) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<EmHazardChenical> list = emHazardChenicalMapper.findEmHazardChenicalList(queryEntity);
		JSONArray jarr = new JSONArray();
		for(EmHazardChenical emHazardChenical : list){
			jarr.put(BeanUtils.describe(emHazardChenical));
		}
		return jarr;
	}
	
	public Integer getCountForEmHazardChenical(EmHazardChenicalQueryEntity queryEntity){
		return emHazardChenicalMapper.findCountForEmHazardChenical(queryEntity);
	}
	
	
	public JSONArray findEmHazardById(int id) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, AiidcException
	{
		JSONArray jarr = new JSONArray();
		if(id>0){
			EmHazardChenical emHazard=emHazardChenicalMapper.findEmHazardById(id);
			jarr.put(BeanUtils.describe(emHazard));
		}else{
			throw new AiidcException("CAS_IS_NULL");
		}
		return jarr;
	}
	
	
	public void deleteEmHazardById(int id) throws AiidcException{
		if(id>0){
			emHazardChenicalMapper.deleteEmHazardById(id);
		}else{
			throw new AiidcException("CAS_IS_NULL");
		}
	}
	

	public void addEmHazard(EmHazardChenical emHazard) throws AiidcException{
		if(emHazard.getChineseName() == null || emHazard.getChineseName().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emHazard.getEnglishName() == null || emHazard.getEnglishName().length()<=0 ){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emHazard.getCasCode() ==null || emHazard.getCasCode().length()<=0){
			throw new AiidcException("CAS_IS_NULL");
		}else if(emHazard.getContent() ==null || emHazard.getContent().length()<=0){
			throw new AiidcException("CAS_IS_NULL");
		}else{
			emHazard.setId(emHazardChenicalMapper.getEmHazardId());
			emHazardChenicalMapper.addEmHazard(emHazard);
		}
	}
	

	public void updateEmHazard(EmHazardChenical emHazard) throws AiidcException{
		if(emHazard.getId()<=0){
			throw new AiidcException("ID_NOT_NULL");
		}else if(emHazard.getChineseName() == null || emHazard.getChineseName().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emHazard.getEnglishName() == null || emHazard.getEnglishName().length()<=0 ){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emHazard.getCasCode() ==null || emHazard.getCasCode().length()<=0){
			throw new AiidcException("CAS_IS_NULL");
		}else if(emHazard.getContent() ==null || emHazard.getContent().length()<=0){
			throw new AiidcException("CAS_IS_NULL");
		}else{
			emHazardChenicalMapper.updateEmHazard(emHazard);
		}
	}
	
	
	
	
}
