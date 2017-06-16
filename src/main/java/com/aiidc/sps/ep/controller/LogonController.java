package com.aiidc.sps.ep.controller;
/**
 * 
 */
import com.aiidc.base.ActionInfo;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.entity.Navigation;
import com.aiidc.sps.ep.services.LogonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("logon")
@ControllerInfo(order=10,value="登录成功页面")
public class LogonController 
{
	
	@Autowired
	private LogonService longonService;

	@RequestMapping("frame")
	@ActionInfo(name="框架页面",access=06,index=0)
	public ModelAndView frame()
	throws Exception
	{
		ModelAndView m = new ModelAndView();
		List<Navigation> list = longonService.getNavigation();
		m.getModel().put("navList", list);
		m.setViewName("logon/frame");
		
		return m;
	}
	
	@RequestMapping(value="navigation",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ActionInfo(name="导航窗口",access=06,index=1)
	public String navigation(Authentication p)
	throws Exception
	{
		JSONObject json =  ControllerUtils.buildSuccessJson(longonService.getNavigationForJson());
		return json.toString();
	}
}