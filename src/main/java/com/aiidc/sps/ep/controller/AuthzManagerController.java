package com.aiidc.sps.ep.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.Function;
import com.aiidc.base.util.BeanUtils;

@Controller
@RequestMapping("authz_manager")
@ControllerInfo(order=10,value="权限管理")
public class AuthzManagerController 
{
	
	

	@RequestMapping("authzframe")
	@ActionInfo(name="授权管理首页",access=06,index=0)
	public String frame()
	throws Exception
	{
		return "authz_manager/authzframe";
	}
	
	
	@RequestMapping("authzlist")
	@ActionInfo(name="角色列表",access=06,index=1)
	public String authzlist()
	throws Exception
	{
		return "authz_manager/authzlist";
	}
	
	@RequestMapping(value="authzdata",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ActionInfo(name="授权列表数据",access=06,index=2)
	public String authzdata()
	throws Exception
	{
		List<Function> list = ControllerUtils.getAllFunctions();
		JSONObject json =  ControllerUtils.buildSuccessJson();
		json.put("rows", BeanUtils.describeToJson(list));
		return json.toString();
	}
}