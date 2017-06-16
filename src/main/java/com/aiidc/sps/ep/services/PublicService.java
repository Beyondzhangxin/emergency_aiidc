package com.aiidc.sps.ep.services;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiidc.base.AiidcException;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.Area;
import com.aiidc.sps.ep.entity.EmAttcahment;
import com.aiidc.sps.ep.entity.EmImage;
import com.aiidc.sps.ep.mapper.PublicMapper;

@Service
public class PublicService {

	@Autowired
	private PublicMapper publicMapper;

	public JSONArray findAllProvince() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		List<Area> list = publicMapper.findAllPro();
		for(Area area : list){
			jarr.put(BeanUtils.describe(area));
		}
		return jarr;
	}
	
	public JSONArray findArea(String provId,String cityId,String countyId) 
	throws AiidcException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		//检查省份是否为空
		if(provId == null || "".equals(provId)){
			AiidcException e1 = new AiidcException("ID_NOT_NULL");
			throw e1;
		}else if(cityId ==null  || "".equals(cityId)){
			//查询指定省份下：所有市区
			map.put("provId", provId);
			map.put("cityId", null);
			map.put("countyId", "00");
			return getJSONArrayForFindArea(map);
		}else if(countyId == null || "".equals(countyId)){
			//查询指定市的所有区县
			map.put("provId", provId);
			map.put("cityId", cityId);
			map.put("countyId", null);
			return getJSONArrayForFindArea(map);
		}else{
			//查询指定的区县
			map.put("provId", provId);
			map.put("cityId", cityId);
			map.put("countyId", countyId);
			return getJSONArrayForFindArea(map);
		}
	}
	
	public JSONArray getJSONArrayForFindArea(Map<String, Object> map) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<Area> list = publicMapper.findArea(map);
		JSONArray jarr = new JSONArray();
		for(Area area : list){
			jarr.put(BeanUtils.describe(area));
		}
		return jarr;
	}
	
	public int getImageId(){
		return publicMapper.getImageId();
	}
	
	public void addImage(EmImage emImage )
	throws Exception
	{
		publicMapper.addImage(emImage);
	}
	
	public EmImage findEmImageById(int imageId)
	throws Exception
	{
		return publicMapper.findImageById(imageId);
	}
	
	public int getAttcahmentId(){
		return publicMapper.getAttcahmentId();
	}
	
	public void addAttachment(EmAttcahment emAttachment)
	throws Exception
	{
		publicMapper.addAttachment(emAttachment);
	}
	
	public EmAttcahment findAttachmentById(int attachmentId)
	throws Exception
	{
		return publicMapper.findAttachmentById(attachmentId);
	}
	
	public void deleteEmImage(String libraryCode,int standardId){
		publicMapper.deleteEmImage(libraryCode, standardId);
	}
	
	public void deleteEmAttachment(String libraryCode,int standardId){
		publicMapper.deleteEmAttachment(libraryCode, standardId);
	}
	
}




