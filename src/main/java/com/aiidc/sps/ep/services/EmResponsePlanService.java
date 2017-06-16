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
import com.aiidc.sps.ep.entity.EmResponsePlan;
import com.aiidc.sps.ep.entity.EmResponsePlanType;
import com.aiidc.sps.ep.entity.EmResponsePlanUsageType;
import com.aiidc.sps.ep.mapper.EmResponsePlanMapper;
import com.aiidc.sps.ep.parameter.EmPlanListParameter;
import com.aiidc.sps.ep.parameter.EmPlanParameter;

@Service
public class EmResponsePlanService {

	@Autowired
	private EmResponsePlanMapper emResponsePlan;
	
	/**
	 * 获取应急预案类别
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String getEmResonsePlanTypeListToString() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<EmResponsePlanType> list = emResponsePlan.getEmResponsePlanTypeList();
		JSONArray jarr = new JSONArray();
		for(EmResponsePlanType emResponsePlanType :list){
			jarr.put(BeanUtils.describe(emResponsePlanType));
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("rows", jarr);
		return json.toString();
	}
	
	
	/**
	 * 获取应急预案适用领域
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String getEmPlanUsageTypeListToString() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<EmResponsePlanUsageType> list = emResponsePlan.getEmPlanUsageTypeList();
		JSONArray jarr = new JSONArray();
		for(EmResponsePlanUsageType emPlanUsageType :list){
			jarr.put(BeanUtils.describe(emPlanUsageType));
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("rows", jarr);
		return json.toString();
	}
	
	/**
	 * 获取应急预案的集合列表:分页
	 * @param map
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String getEmPlanListToString(EmPlanParameter emPlan) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		List<EmPlanListParameter> list = emResponsePlan.getEmPlanList(emPlan);
		JSONArray jarr = new JSONArray();
		for(EmPlanListParameter emPlanListParameter : list){
			@SuppressWarnings("unchecked")
			Map<String, Object> map = BeanUtils.describe(emPlanListParameter);
			map.put("eeportingTimeStr", DateUtil.getStringByDate(emPlanListParameter.getReportingTime(), "yyyy-MM-dd"));
			jarr.put(map);
		}
		//创建返回结果集
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("total",emResponsePlan.getEmPlanCount(emPlan));
		json.put("rows", jarr);
		return json.toString();
	}
	
	/**
	 * 根据planId查找应急预案
	 * @param planId
	 * @return
	 * @throws AiidcException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public JSONArray findEmPlanByPlanId(int planId) 
	throws AiidcException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr = new JSONArray();
		if(planId<=0){
			throw new AiidcException("ID_NOT_NULL");
		}else{
			EmResponsePlan emPlan= emResponsePlan.findEmPlanByPlanId(planId);
			jarr.put(BeanUtils.describe(emPlan));
		}
		return jarr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
