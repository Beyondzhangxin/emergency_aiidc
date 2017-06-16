package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmResourceContacts;
import com.aiidc.sps.ep.parameter.EmResourceContactsParam;
import com.aiidc.sps.ep.services.EmResourceContactsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Zhangx on 2017/5/20 at 19:10.
 */
@Controller
@RequestMapping("ent_contact")
@ControllerInfo(order = 5, value = "企业通讯录页面")
public class EmResourceContactsController
{
    @Autowired
    private EmResourceContactsService emResourceContactsService;

    @RequestMapping("list")
    @ActionInfo(name = "企业通讯录列表页面", access = 06, index = 0)
    public ModelAndView listPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("ent_contact/list");
        return m;
    }

    @RequestMapping(value = "listdata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "企业通讯录列表（包括搜索列表）", access = 06, index = 1)
    public String getData(EmResourceContactsParam emResourceContactsParam) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject json = ControllerUtils.buildSuccessJson();
        JSONArray jsonArray = BeanUtils.describeToJson(emResourceContactsService.search(emResourceContactsParam));
        int count = emResourceContactsService.doSearchCount(emResourceContactsParam);
        json.put("total", count).put("rows", jsonArray);
        return json.toString();
    }


    @RequestMapping(value = "emResourceContact")
    @ResponseBody
    @ActionInfo(name = "根据id获取企业通讯录详情", index = 2)
    public String getEmResourceContactById(@RequestParam String companyId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        EmResourceContacts emResourceContact = emResourceContactsService.getById(companyId);
        JSONObject jsonObject = BeanUtils.describeToJson(emResourceContact);
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping("details")
    @ActionInfo(name = "企业通讯录详情页面", index = 3)
    public String getDatailsPage()
    {
        return "ent_contact/details";
    }

    @RequestMapping(value = "enterpriseInfos",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "获取所有企业信息列表",index = 4)
    @ResponseBody
    public String getAllEpInfos() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emResourceContactsService.getAllEpInfo());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return json.toString();
    }
}
