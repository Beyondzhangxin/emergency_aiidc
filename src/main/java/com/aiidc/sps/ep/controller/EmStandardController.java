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
import com.aiidc.sps.ep.entity.EmStandard;
import com.aiidc.sps.ep.parameter.EmStaticFinalValues;
import com.aiidc.sps.ep.services.EmStandardService;
import com.aiidc.sps.ep.services.PublicService;

@Controller
@RequestMapping("em_standard")
@ControllerInfo(order=10,value="标准规范库")
public class EmStandardController {
	
	@Autowired
	private EmStandardService emStandardService;
	
	@Autowired
	private PublicService publicService;

	@RequestMapping("list")
	@ActionInfo(name="标准规范库列表页",access=06,index=0)
	public ModelAndView listPage()
	throws Exception
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("em_standard/list");
		return m;
	}
	
	/**
	 * 标准规范分页列表，包括搜索功能
	 * @param page
	 * @param rows
	 * @param name
	 * @param pubDepartment
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@ActionInfo(name="标准规范库列表、搜索",access=06,index=1)
	@RequestMapping(value="getEmStandList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmStandList(Integer page,Integer rows,String name,String pubDepartment) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		if(page==null){
			page=1;
		}
		if(rows==null){
			rows=10;
		}
		return emStandardService.findEmStandList(page, rows, name, pubDepartment);
	}
	

	@RequestMapping("details")
	@ActionInfo(name="标准规范库详情页",access=06,index=2)
	public ModelAndView emStandardDetailsPage()
	throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("em_standard/details");
		return mav;
	}
	
	@ActionInfo(name="根据ID查询标准规范库",access=06,index=3)
	@RequestMapping(value="findEmStandardById",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String findEmStandardById(int id) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		try {
			JSONArray jarr = emStandardService.findEmStandardById(id);
			return ControllerUtils.buildSuccessJson().put("data", jarr).toString();
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
	}
	
	@ActionInfo(name="删除标准规范库",access=06,index=4)
	@RequestMapping(value="deleteEmStandards",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String deleteEmStandards(@RequestParam List<Integer> ids){
		JSONObject json =ControllerUtils.buildSuccessJson();
		for(Integer id : ids){
			try {
				emStandardService.deleteEmStandardById(id);
				//删除图片
				publicService.deleteEmImage(EmStaticFinalValues.EMSTANDARDCODE, id);
				//删除附件
				publicService.deleteEmAttachment(EmStaticFinalValues.EMSTANDARDCODE, id);
			} catch (AiidcException e) {
				e.printStackTrace();
				return ControllerUtils.buildFailureJson(e).toString();
			}
		}
		return json.put("success", true).toString();
	}
	
	@ActionInfo(name="保存标准规范库",access=06,index=5)
	@RequestMapping(value="saveEmStandard",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String saveEmStandard(@ModelAttribute EmStandard emStandard){
		JSONObject json =ControllerUtils.buildSuccessJson();
		try {
			emStandardService.addEmStandard(emStandard);
			json.put("success", true);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="更新标准规范库",access=06,index=6)
	@RequestMapping(value="updateEmStandard",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String updateEmStandard(@ModelAttribute EmStandard emStandard){
		JSONObject json =ControllerUtils.buildSuccessJson();
		try {
			emStandardService.updateEmStandard(emStandard);
			json.put("success", true);
		} catch (AiidcException e) {
			e.printStackTrace();
			return ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="更新标准规范库",access=06,index=6)
	@RequestMapping(value="getEmStandardId")
	@ResponseBody	
	public String getEmStandardId(){
		int EmStandardId = emStandardService.getEmStandardId();
		return String.valueOf(EmStandardId);
	}
	
}














