package com.aiidc.sps.ep.controller;

import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.parameter.EmPlanParameter;
import com.aiidc.sps.ep.services.EmResponsePlanService;

@Controller
@RequestMapping("em_plan")
@ControllerInfo(order=10,value="应急预案")
public class EmPlanController {

	@Autowired
	private EmResponsePlanService emPlanService;
	
	@RequestMapping("list")
	@ActionInfo(name="应急预案列表页",access=06,index=0)
	public ModelAndView listPage()
	throws Exception
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("em_plan/list");
		return m;
	}
	
	@ActionInfo(name="应急预案类别",access=06,index=1)
	@RequestMapping(value="getEmPlanTypes",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmPlanTypes() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		return emPlanService.getEmResonsePlanTypeListToString();
	}
	
	
	@ActionInfo(name="应急预案适用领域",access=06,index=2)
	@RequestMapping(value="getEmPlanUsageTypes",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmPlanUsageTypes() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		return emPlanService.getEmPlanUsageTypeListToString();
	}
	

	@ActionInfo(name="应急预案分页列表",access=06,index=3)
	@RequestMapping(value="getEmPlans",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmPlans(EmPlanParameter emPlan) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		if(emPlan.getPage() == null){
			emPlan.setPage(1);
		}
		if(emPlan.getRows() == null){
			emPlan.setRows(10);
		}
		return emPlanService.getEmPlanListToString(emPlan);
	}
	
	
	@RequestMapping("details")
	@ActionInfo(name="应急预案详情页",access=06,index=4)
	public String emPlanDetailsPage()
	throws Exception
	{
		return "em_plan/details";
	}
	
	@ActionInfo(name="应急预案详情数据",access=06,index=5)
	@RequestMapping(value="getEmPlanByPlanId",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmPlanByPlanId(int emPlanId) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr;
		try {
			jarr = emPlanService.findEmPlanByPlanId(emPlanId);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		return json.put("rows", jarr).toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
