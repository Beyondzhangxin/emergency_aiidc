package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmParkLawsRegulations;
import com.aiidc.sps.ep.parameter.EmParkLawParam;
import com.aiidc.sps.ep.services.EmParkLawService;
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
import java.text.SimpleDateFormat;

/**
 * Created by Zhangx on 2017/5/25 at 14:46.
 */
@Controller
@RequestMapping("em_rules")
@ControllerInfo(order = 7, value = "法律法规库页面")
public class EmParkLawController
{
    @Autowired
    private EmParkLawService emParkLawService;

    @RequestMapping("list")
    @ActionInfo(name = "法律法规库列表页面", access = 06, index = 0)
    public ModelAndView listPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_rules/list");
        return m;
    }

    @RequestMapping(value = "listdata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "法律法规库列表（包括搜索功能）", index = 1)
    public String getData(EmParkLawParam emParkLawParam) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ParseException
    {
        JSONObject json = ControllerUtils.buildSuccessJson();
        JSONArray jsonArray = BeanUtils.describeToJson(emParkLawService.getData(emParkLawParam));
        int count = emParkLawService.getCount(emParkLawParam);
        json.put("total", count).put("rows", jsonArray);
        return json.toString();

    }

    @RequestMapping(value = "id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID找法律法规", index = 2)
    public String getById(Integer id) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emParkLawService.getById(id));
        if (jsonObject.get("publishDate") != null)
        {
            jsonObject.put("publishDate", new SimpleDateFormat("yyyy-MM-dd").format(jsonObject.get("publishDate")));
        }
        if (jsonObject.get("implementDate") != null)
        {
            jsonObject.put("implementDate", new SimpleDateFormat("yyyy-MM-dd").format(jsonObject.get("implementDate")));
        }
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping("details")
    @ActionInfo(name = "法律法规库详情页面", access = 06, index = 3)
    public ModelAndView detailsPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_rules/details");
        return m;
    }

    @RequestMapping(value = "save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "添加法律法规", index = 4)
    public String insert(EmParkLawsRegulations emParkLawsRegulations)
    {
        try
        {
            emParkLawService.insert(emParkLawsRegulations);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "修改法律法规", index = 5)
    public String update(EmParkLawsRegulations emParkLawsRegulations)
    {
        try
        {
            emParkLawService.update(emParkLawsRegulations);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "删除法律法规", index = 6)
    public String delete(long[] ids)
    {

        try
        {
            emParkLawService.delete(ids);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping("sequenceId")
    @ResponseBody
    @ActionInfo(name = "获取添加序列ID号", index = 7)
    public String getSequenceId()
    {
        return String.valueOf(emParkLawService.getId());
    }
}

