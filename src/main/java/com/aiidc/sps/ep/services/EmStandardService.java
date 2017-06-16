package com.aiidc.sps.ep.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.base.util.DateUtil;
import com.aiidc.sps.ep.entity.EmStandard;
import com.aiidc.sps.ep.mapper.EmStandardMapper;

@Service
public class EmStandardService {

	@Autowired
	private EmStandardMapper emStandarMapper;
	
	public String  findEmStandList(int page,int rows,String name,String pubDepartment) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		int begin = (page-1)*rows+1;
		int end = page*rows;
		List<EmStandard> emStandards;
		int total=0;
		if(name !=null && name.length()>0){
			if(pubDepartment !=null && pubDepartment.length()>0){
				emStandards=emStandarMapper.findEmStandListByNameAndDepartment(begin, end, name, pubDepartment);
				total=emStandarMapper.getTotalToEmStandListByNameAndDepartment(name, pubDepartment);
			}else{
				emStandards=emStandarMapper.findEmStandListByName(begin, end, name);
				total=emStandarMapper.getTotalToEmStandListByName(name);
			}
		}else{
			if(pubDepartment !=null && pubDepartment.length()>0){
				emStandards=emStandarMapper.findEmStandListByDepartment(begin, end, pubDepartment);
				total=emStandarMapper.getTotalToEmStandListByDepartment(pubDepartment);
			}else{
				emStandards=emStandarMapper.findEmStandList(begin, end);
				total=emStandarMapper.getTotalToEmStandList();
			}
		}
		JSONArray jarr = new JSONArray();
		for(EmStandard emStandard :emStandards){
			@SuppressWarnings("unchecked")
			Map<String, Object> map =BeanUtils.describe(emStandard);
			map.put("pubDateStr",DateUtil.getStringByDate(emStandard.getPubDate(), "yyyy-MM-dd"));
			map.put("impDateStr",DateUtil.getStringByDate(emStandard.getImpDate(), "yyyy-MM-dd"));
			jarr.put(map);
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("total", total);
		json.put("rows", jarr);
		return json.toString();
	}
	
	public JSONArray  findEmStandardById(int id) 
	throws AiidcException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		if(id>0 ){
			EmStandard emStandard = emStandarMapper.findEmStandardById(id);
			@SuppressWarnings("unchecked")
			Map<String, Object> map = BeanUtils.describe(emStandard);
			map.put("pubDateStr",DateUtil.getStringByDate(emStandard.getPubDate(), "yyyy-MM-dd"));
			map.put("impDateStr",DateUtil.getStringByDate(emStandard.getImpDate(), "yyyy-MM-dd"));
			jarr.put(map);
		}else{
			throw new AiidcException("ID_NOT_NULL");
		}
		return jarr;
	}
	
	public int getEmStandardId(){
		return emStandarMapper.getEmStandardId();
	}
	
	public void addEmStandard(EmStandard emStandard) 
	throws AiidcException
	{
		if(emStandard.getId() <=0){
			throw new AiidcException("ID_NOT_NULL");
		}else if(emStandard.getName() == null || emStandard.getName().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emStandard.getPubDepartment() ==null || emStandard.getPubDepartment().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emStandard.getPubDate() == null){
			throw new AiidcException("DATA_NOT_NULL");
		}else{
			emStandarMapper.addEmStandard(emStandard);
		}
	}
	
	public void updateEmStandard(EmStandard emStandard) 
	throws AiidcException{
		if(emStandard.getId() <=0){
			throw new AiidcException("ID_NOT_NULL");
		}else if(emStandard.getName() == null || emStandard.getName().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emStandard.getPubDepartment() ==null || emStandard.getPubDepartment().length()<=0){
			throw new AiidcException("DATA_NOT_NULL");
		}else if(emStandard.getPubDate() == null){
			throw new AiidcException("DATA_NOT_NULL");
		}else{
			emStandarMapper.updateEmStandard(emStandard);
		}
	}
	
	public void deleteEmStandardById(int id) 
	throws AiidcException
	{
		if(0>=id){
			throw new AiidcException("ID_NOT_NULL");
		}else{
			emStandarMapper.deleteEmStandardById(id);
		}
		
	}
}
