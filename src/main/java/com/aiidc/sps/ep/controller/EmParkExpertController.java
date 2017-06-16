package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.base.util.DateUtil;
import com.aiidc.sps.ep.entity.EmParkExperUnit;
import com.aiidc.sps.ep.entity.EmParkExpert;
import com.aiidc.sps.ep.parameter.EmParkExpertParam;
import com.aiidc.sps.ep.services.EmParkExpertService;
import com.aiidc.sps.ep.services.EmResourceTeamService;
import com.aiidc.sps.ep.services.PublicService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Zhangx on 2017/5/23 at 16:16.
 */
@Controller
@ControllerInfo(order = 4, value = "应急专家库")
@RequestMapping("em_spec")
public class EmParkExpertController
{
    @Autowired
    private EmParkExpertService emParkExpertService;
    @Autowired
    private PublicService publicService;
    @Autowired
    private EmResourceTeamService emResourceTeamService;

    @RequestMapping("list")
    @ActionInfo(name = "应急专家库页面", access = 06, index = 0)
    public ModelAndView listPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_spec/list");
        return m;
    }

    @RequestMapping(value = "emParkExpert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID查找专家数据", index = 1)
    public String getById(String expertId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        EmParkExpert emParkExpert = emParkExpertService.getById(expertId);
        Map<String,Object> map=BeanUtils.describe(emParkExpert);
        map.put("workingTime", DateUtil.getStringByDate(emParkExpert.getWorkingTime(),"yyyy-MM-dd"));
        map.put("birthday", DateUtil.getStringByDate(emParkExpert.getBirthday(),"yyyy-MM-dd"));
        map.put("changeDate", DateUtil.getStringByDate(emParkExpert.getChangeDate(),"yyyy-MM-dd"));
        JSONObject json = ControllerUtils.buildSuccessJson(new JSONObject(map));
        return json.toString();
    }

    @RequestMapping(value = "listdata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "应急专家列表（包括搜索）", index = 2)
    public String listdata(EmParkExpertParam emParkExpertParam) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject json = ControllerUtils.buildSuccessJson();
        List<EmParkExperUnit> emParkExperts = emParkExpertService.search(emParkExpertParam);
        JSONArray jsonArray = BeanUtils.describeToJson(emParkExperts);
        json.put("rows", jsonArray);
        json.put("total", emParkExpertService.doSearchCount(emParkExpertParam));

        return json.toString();
    }

    @RequestMapping(value = "save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "添加专家信息", index = 3)
    public String save(EmParkExpert emParkExpert)
    {
        try
        {
            emParkExpertService.save(emParkExpert);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "修改专家信息", index = 4)
    public String update(EmParkExpert emParkExpert)
    {
        try
        {
            emParkExpertService.update(emParkExpert);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping("details")
    @ActionInfo(name = "应急专家库详情页", index = 5)
    public ModelAndView detailPage()
    {
        return new ModelAndView("em_spec/details");
    }

    @RequestMapping(value = "expertTypes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "返回所有专家类别信息", index = 6)
    public String allExpertTypes() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emParkExpertService.getAllExpertTypes());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return json.toString();
    }

    @RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "删除专家信息", index = 7)
    @ResponseBody
    public String delete(@RequestParam int[] expertIds)
    {
        try
        {
            emParkExpertService.deleteByIds(expertIds);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

}
