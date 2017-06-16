package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmParkAccidentCase;
import com.aiidc.sps.ep.parameter.EmParkAccidentCaseParam;
import com.aiidc.sps.ep.services.EmParkAccidentCaseService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

/**
 * Created by Zhangx on 2017/5/25 at 17:22.
 */
@Controller
@RequestMapping("em_events")
@ControllerInfo(order = 9, value = "事故案例库页面")
public class EmAccidentCaseController
{
    @Autowired
    private EmParkAccidentCaseService emParkAccidentCaseService;

    @RequestMapping("list")
    @ActionInfo(name = "事故案例库列表页面", access = 06, index = 0)
    public ModelAndView listPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_events/list");
        return m;
    }

    @RequestMapping(value = "listdata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "获取列表数据（包括搜索）", index = 1)
    public String getData(EmParkAccidentCaseParam emParkAccidentCaseParam) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ParseException
    {
        JSONObject json = ControllerUtils.buildSuccessJson();
        JSONArray jsonArray = BeanUtils.describeToJson(emParkAccidentCaseService.getData(emParkAccidentCaseParam));
        int count = emParkAccidentCaseService.getCount(emParkAccidentCaseParam);
        json.put("total", count).put("rows", jsonArray);
        return json.toString();
    }

    @RequestMapping(value = "id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID获取详情数据", index = 2)
    public String getById(long id) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emParkAccidentCaseService.getById(id));
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping("details")
    @ActionInfo(name = "事故案例库列表页面", access = 06, index = 3)
    public ModelAndView detailsPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_events/details");
        return m;
    }

    @RequestMapping(value = "save",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "事故案例添加",access = 06,index = 4)
    public String save(EmParkAccidentCase emParkAccidentCase) throws ParseException
    {
        try
        {
            emParkAccidentCaseService.insert(emParkAccidentCase);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping(value = "update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "事故案例修改",index = 5)
    public String update(EmParkAccidentCase emParkAccidentCase) throws Exception{
        
            emParkAccidentCaseService.update(emParkAccidentCase);
            return ControllerUtils.buildSuccessJson().toString();
       
    }

    @RequestMapping(value = "delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "事故案例删除",index = 6)
    public String delete(int[] ids){
        try
        {
            emParkAccidentCaseService.delete(ids);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

}
