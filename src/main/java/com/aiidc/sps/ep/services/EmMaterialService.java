package com.aiidc.sps.ep.services;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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
import com.aiidc.sps.ep.entity.EmMaterial;
import com.aiidc.sps.ep.entity.EmMaterialClassify;
import com.aiidc.sps.ep.entity.EmMaterialSource;
import com.aiidc.sps.ep.entity.EmMaterialType;
import com.aiidc.sps.ep.entity.EmMaterialUtilEntity;
import com.aiidc.sps.ep.entity.EmEnterpriseInfo;
import com.aiidc.sps.ep.mapper.EmMaterialMapper;
import com.aiidc.sps.ep.parameter.EmMaterialParameter;

@Service
public class EmMaterialService {

	@Autowired
	private EmMaterialMapper emMaterialMapper;
	
	public  String getEmMaterialListToString(EmMaterialParameter emMaterialParamete) 
	throws Exception 
	{
		JSONArray jarr = new JSONArray();	
		List<EmMaterialUtilEntity> list =emMaterialMapper.getEmMaterialList(emMaterialParamete);
		for( EmMaterialUtilEntity emMaterialUtilEntity: list){
			@SuppressWarnings("unchecked")
			Map<String, Object> emMap =BeanUtils.describe(emMaterialUtilEntity);
			String expiryDateStr = DateUtil.getStringByDate( emMaterialUtilEntity.getExpiryDate(), "yyyy-MM-dd");
			String changeTimeStr = DateUtil.getStringByDate( emMaterialUtilEntity.getChangeTime(), "yyyy-MM-dd");
			String createTimeStr = DateUtil.getStringByDate( emMaterialUtilEntity.getCreateTime(), "yyyy-MM-dd");
			emMap.put("expiryDateStr", expiryDateStr);
			emMap.put("changeTimeStr", changeTimeStr);
			emMap.put("createTimeStr", createTimeStr);
			emMap.put("nowDate", DateUtil.getStringByDate(new Date(), "yyyy-MM-dd"));
			jarr.put(emMap);
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("total", emMaterialMapper.getEmMaterialListSize(emMaterialParamete));
		json.put("rows", jarr);
		return json.toString();
	}

	
	public String getEmMaterialClassifyListToString() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		List<EmMaterialClassify>  list= emMaterialMapper.getEmMaterialClassify();
		for(EmMaterialClassify emMaterialClassify : list){
			jarr.put(BeanUtils.describe(emMaterialClassify));
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("rows", jarr);
		return json.toString();
	}
	
	
	public String getEmMaterialTypListToString() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		List<EmMaterialType>  list= emMaterialMapper.getEmMaterialTyp();
		for(EmMaterialType emMaterialType : list){
			jarr.put(BeanUtils.describe(emMaterialType));
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("rows", jarr);
		return json.toString();
	}
	
	public JSONArray getEmMaterialSourceJson() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<EmMaterialSource> list = emMaterialMapper.getEmMaterialSource();
		JSONArray jarr = new JSONArray();
		for(EmMaterialSource emMaterialSource:list){
			jarr.put(BeanUtils.describe(emMaterialSource));
		}
		return jarr;
	}
	
	public JSONArray findEmMaterialByMaterialId(String materialId) 
	throws  IllegalAccessException, InvocationTargetException, NoSuchMethodException, AiidcException 
	{
		JSONArray jarr = new JSONArray();
		if(materialId == null  || "".equals(materialId)){
			AiidcException e1 = new AiidcException("ID_NOT_NULL");
			throw e1;
		}
		try {
			List<EmMaterial> list = emMaterialMapper.findEmMaterialById(materialId);
			EmMaterial emMaterial = list.get(0);
			@SuppressWarnings("unchecked")
			Map<String, Object> mapEntity = BeanUtils.describe(emMaterial);
			//有效期
			mapEntity.put("expiryDateStr", DateUtil.getStringByDate(emMaterial.getExpiryDate(), "yyyy-MM-dd"));
			//购买
			mapEntity.put("purchaseDateStr", DateUtil.getStringByDate(emMaterial.getPurchaseDate(), "yyyy-MM-dd"));
			//出厂
			mapEntity.put("productDateStr", DateUtil.getStringByDate(emMaterial.getProductDate(), "yyyy-MM-dd"));
			jarr.put(mapEntity);
		} catch (IndexOutOfBoundsException e) {
			AiidcException e2= new AiidcException("INDEX_OUT_OF_BOUNDS");
			throw e2;
		}
		return  jarr;
	}
	
	
	public EmEnterpriseInfo findEnterpriseById(String enterPriseId) 
	throws AiidcException{
		if(enterPriseId==null || enterPriseId.length()<=0){
			throw new AiidcException("ID_NOT_NULL");
		}else{
			List<EmEnterpriseInfo> list = emMaterialMapper.findEnterpriseById(enterPriseId);
			return list.get(0);
		}
		
	}
}
