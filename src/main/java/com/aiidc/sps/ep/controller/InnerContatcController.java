package com.aiidc.sps.ep.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.entity.InnerContatc;
import com.aiidc.sps.ep.parameter.InnerContatcQueryEntity;
import com.aiidc.sps.ep.services.InnerContatcService;

@Controller
@RequestMapping("inner_contatc")
@ControllerInfo(order=10,value="内部通讯录")
public class InnerContatcController {

	@Autowired
	private InnerContatcService innerConService;
	
	@RequestMapping("list")
	@ActionInfo(name="内部通讯录列表页",access=06,index=0)
	public ModelAndView listPage()
	throws Exception
	{
		ModelAndView  m = new ModelAndView();
		m.setViewName("inner_contatc/list");
		return m;
	}
	

	@ActionInfo(name="内部通讯录：列表、搜索",access=06,index=1)
	@RequestMapping(value="getInnerContatcs",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getInnerContatcs(InnerContatcQueryEntity innerContatcQueryEntity) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		if(innerContatcQueryEntity.getPage()==null){
			innerContatcQueryEntity.setPage(1);
		}
		if(innerContatcQueryEntity.getRows() == null){
			innerContatcQueryEntity.setRows(10);
		}
		JSONArray jarr = innerConService.getInnerContatcList(innerContatcQueryEntity);
		JSONObject json =ControllerUtils.buildSuccessJson();
		json.put("total", innerConService.getInnerContatcCount(innerContatcQueryEntity));
		json.put("rows", jarr);
		return json.toString();
	}
	
	@RequestMapping("details")
	@ActionInfo(name="内部通讯录详情页",access=06,index=2)
	public String innerContatcDetailsPage()
	throws Exception
	{
		return "inner_contatc/details";
	}
	
	@ActionInfo(name="根据ID查询通讯录",access=06,index=3)
	@RequestMapping(value="findInnerContatcById",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String findInnerContatcById(int id) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONObject json = ControllerUtils.buildSuccessJson();
		try {
			JSONArray jarr =innerConService.getInnerContatcById(id);
			json.put("rows", jarr);
		}catch (AiidcException e) {
			e.printStackTrace();
			return  ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="根据ID删除通讯录",access=06,index=4)
	@RequestMapping(value="deleteInnerContatc",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String  deleteInnerContatc(@RequestParam List<Integer> ids){
		JSONObject json =ControllerUtils.buildSuccessJson();
		if(ids.size() <=0){
			AiidcException e = new AiidcException("LIST_NOT_NULL");
			return ControllerUtils.buildFailureJson(e).toString();
		}else{
			for(int id : ids){
				try {
					innerConService.deleteInnerContatcById(id);
				} catch (AiidcException e2) {
					return ControllerUtils.buildFailureJson(e2).toString();
				}
			}
		}
		json.put("success", true);
		return json.toString();
	}
	
	@ActionInfo(name="添加通讯录",access=06,index=5)
	@RequestMapping(value="saveInnerContatc",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String saveInnerContatc(@ModelAttribute InnerContatc innerContatc){
		try {
			innerConService.addInnerContatc(innerContatc);
		} catch (AiidcException e) {
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return ControllerUtils.buildSuccessJson().put("success",true).toString();
	}
	
	@ActionInfo(name="更新通讯录",access=06,index=6)
	@RequestMapping(value="updateInnerContatc",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String updateInnerContatc(@ModelAttribute InnerContatc innerContatc){
		try {
			innerConService.updateInnerContatc(innerContatc);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return ControllerUtils.buildSuccessJson().put("success",true).toString();
	}
	
}
