package com.aiidc.sps.ep.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.entity.EmHazardChenical;
import com.aiidc.sps.ep.parameter.EmHazardChenicalQueryEntity;
import com.aiidc.sps.ep.services.EmHazardChenicalService;

@Controller
@RequestMapping("em_hazard")
@ControllerInfo(order=10,value="危险化学品库")
public class EmHazardChenicalController {
	
	@Autowired
	private EmHazardChenicalService emHazardChenicalService;
	
	@RequestMapping("list")
	@ActionInfo(name="危险化学品库列表页",access=06,index=0)
	public ModelAndView listPage()
	throws Exception
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("em_hazard/list");
		return m;
	}

	@ActionInfo(name="危险化学品库:列表、搜索",access=06,index=1)
	@RequestMapping(value="getEmHazardChenicalList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmHazardChenicalList(EmHazardChenicalQueryEntity queryEntity) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		if(queryEntity.getPage() == null){
			queryEntity.setPage(1);
		}
		if(queryEntity.getRows()==null){
			queryEntity.setRows(10);
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("total", emHazardChenicalService.getCountForEmHazardChenical(queryEntity));
		json.put("rows", emHazardChenicalService.findEmHazardChenicalList(queryEntity));
		return json.toString();
	}
	

	@RequestMapping("details")
	@ActionInfo(name="危险化学品详情页",access=06,index=2)
	public String hazardDetailsPage()
	throws Exception
	{		
		return "em_hazard/details";
	}
	
	@ActionInfo(name="根据ID查询化学危险品",access=06,index=3)
	@RequestMapping(value="getEmHazardChenicalByCasCode",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmHazardChenicalByCasCode(int id) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		JSONObject json = ControllerUtils.buildSuccessJson();
		try {
			json.put("rows", emHazardChenicalService.findEmHazardById(id));
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="根据ID删除化学危险品",access=06,index=4)
	@RequestMapping(value="deleteEmHazardByCasCode",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String deleteEmHazardByCasCode(@RequestParam List<Integer> ids){
		JSONObject json = ControllerUtils.buildSuccessJson();
		for(int id :ids){
			try {
				emHazardChenicalService.deleteEmHazardById(id);
				json.put("success", true);
			} catch (AiidcException e) {
				e.printStackTrace();
				return ControllerUtils.buildFailureJson(e).toString();
			}
		}
		return json.toString();
	}
	
	@ActionInfo(name="增加化学危险品",access=06,index=5)
	@RequestMapping(value="addEmHazard",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String addEmHazard(EmHazardChenical emHazard){
		JSONObject json = ControllerUtils.buildSuccessJson();
		try {
			emHazardChenicalService.addEmHazard(emHazard);
			json.put("success", true);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="编辑化学危险品",access=06,index=6)
	@RequestMapping(value="updateEmHazard",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String updateEmHazard(EmHazardChenical emHazard){
		JSONObject json = ControllerUtils.buildSuccessJson();
		try {
			emHazardChenicalService.updateEmHazard(emHazard);
			json.put("success", true);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
}
