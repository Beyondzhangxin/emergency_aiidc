package com.aiidc.sps.ep.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.entity.EmEnterpriseInfo;
import com.aiidc.sps.ep.parameter.EmMaterialParameter;
import com.aiidc.sps.ep.services.EmMaterialService;

@Controller
@RequestMapping("em_material")
@ControllerInfo(order=10,value="应急物资装备")
public class EmMaterialController {
	
	@Autowired
	private EmMaterialService emMaterialService;
	
	@Autowired
	private PublicController pubController;

	@RequestMapping("list")
	@ActionInfo(name="应急物资装备列表页(政府端)",access=06,index=0)
	public ModelAndView listPage()
	throws Exception
	{
		ModelAndView m = new ModelAndView();
		m.setViewName("em_material/list");
		return m;
	}
	
	@ActionInfo(name="应急物资装备列表",access=06,index=1)
	@RequestMapping(value="getEmMaterials",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmMaterials(@ModelAttribute EmMaterialParameter emMaterialParameter) 
	throws Exception{
		if(emMaterialParameter.getPage()==null){
			emMaterialParameter.setPage(1);
		}
		if(emMaterialParameter.getRows() ==null){
			emMaterialParameter.setRows(10);
		}
		return emMaterialService.getEmMaterialListToString(emMaterialParameter);
	}
	
	@ActionInfo(name="物资装备分类数据",access=06,index=2)
	@RequestMapping(value="getEmMaterialClassifys",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmMaterialClassifys() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return emMaterialService.getEmMaterialClassifyListToString();
	}
	
	
	@ActionInfo(name="物资装备类别数据",access=06,index=3)
	@RequestMapping(value="getEmMaterialTypes",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmMaterialTypes() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		return emMaterialService.getEmMaterialTypListToString();
	}
	
	@ActionInfo(name="应急物资装备来源",access=06,index=4)
	@RequestMapping(value="getMaterialSources",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getMaterialSources() 
	throws JSONException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONObject json = ControllerUtils.buildSuccessJson();
		json.put("rows", emMaterialService.getEmMaterialSourceJson());
		return json.toString();
	}
	
	@RequestMapping("details")
	@ActionInfo(name="应急物资装备详情页（政府端）",access=06,index=5)
	public String DetailsPage()
	throws Exception
	{		
		return "em_material/details";
	}
	
	@ActionInfo(name="应急物资装备详情信息",access=06,index=6)
	@RequestMapping(value="getEmMaterialById",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmMaterialById(String materialId) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException 
	{
		JSONObject json = ControllerUtils.buildSuccessJson();
		try {
			JSONArray jarr = emMaterialService.findEmMaterialByMaterialId(materialId);
			json.put("rows", jarr);
		} catch (AiidcException e) {
			e.printStackTrace();
			return  ControllerUtils.buildFailureJson(e).toString();
		}
		return json.toString();
	}
	
	@ActionInfo(name="江苏镇江市下的所有区县",access=06,index=7)
	@RequestMapping(value="getAreaForJiangsuZhenjiang",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getAreaForJiangsuZhenjiang() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		String provId="32";
		String cityId="11";
		String countyId=null;
		return pubController.getArea(provId, cityId, countyId);
	}

	
	@RequestMapping("companyList")
	@ActionInfo(name="应急物资装备列表页（企业端）",access=06,index=8)
	public String companyPage()
	throws Exception
	{		
		return "em_material/conpList";
	}
	
	@RequestMapping(value="conpEmDetails")
	@ActionInfo(name="应急物资装备详情页（企业端）",access=06,index=9)
	public String conpEmDetails()
	throws Exception
	{		
		return "em_material/conpEmDetails";
	}
	
	@RequestMapping("conpDetails")
	@ActionInfo(name="企业详情信息页(企业端)",access=06,index=10)
	public ModelAndView conpDetails(String companyId)
	throws Exception
	{
		EmEnterpriseInfo emEnterpriseInfo = emMaterialService.findEnterpriseById(companyId);
		ModelAndView m = new ModelAndView();
		Map<String,Object> model =  m.getModel();
		model.put("enterprise", emEnterpriseInfo);
		m.setViewName("em_material/conpDetails");
		return m;
	}
}








