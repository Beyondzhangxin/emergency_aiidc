package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmResourceTeam;
import com.aiidc.sps.ep.parameter.EmResourceTeamParam;
import com.aiidc.sps.ep.services.EmResourceTeamService;
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
import java.text.SimpleDateFormat;

/**
 * Created by Zhangx on 2017/5/19 at 16:02.
 */
@Controller
@RequestMapping("em_team")
@ControllerInfo(order = 2, value = "应急队伍页面")
public class EmResourceTeamController
{
    @Autowired
    private EmResourceTeamService emResourceTeamService;

    @RequestMapping("list")
    @ActionInfo(name = "应急队伍列表页面", access = 06, index = 0)
    public ModelAndView listPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_team/list");
        return m;
    }

    @RequestMapping(value = "listdata", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "应急队伍列表（包括搜索）", index = 1)
    public String getData(EmResourceTeamParam emResourceTeamParam) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {

        JSONArray jsonArray = BeanUtils.describeToJson(emResourceTeamService.search(emResourceTeamParam));
        int count = emResourceTeamService.searchCount(emResourceTeamParam);
        JSONObject json = ControllerUtils.buildSuccessJson();
        json.put("total", count).put("rows", jsonArray);
        return json.toString();
    }


    @RequestMapping(value = "emTeam", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID获取应急队伍", index = 2)
    public String getEmResourceTeam(String teamId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emResourceTeamService.getByTeamId(teamId));
        if (jsonObject.get("createTime") != null)
        {
            jsonObject.put("createTime", new SimpleDateFormat("yyyy-MM-dd").format(jsonObject.get("createTime")));
        }
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping(value = "emTeamEventType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID获取队伍事件类型", index = 3)
    public String getTeamEventType(@RequestParam int eventTypeId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emResourceTeamService.getByEventTypeId(eventTypeId));
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping(value = "emTeamLevel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID获取队伍级别", index = 4)
    public String getTeamLevel(String levelId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emResourceTeamService.getByLevelId(levelId));
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping(value = "emTeamType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "根据ID获取队伍类型", index = 5)
    public String getTeamType(String typeId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONObject jsonObject = BeanUtils.describeToJson(emResourceTeamService.getByTypeId(typeId));
        JSONObject json = ControllerUtils.buildSuccessJson(jsonObject);
        return json.toString();
    }

    @RequestMapping(value = "allEventTypes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "获取所有事件类型", index = 6)
    @ResponseBody
    public String getAllEventTypes() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emResourceTeamService.getAllEventTypes());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return json.toString();
    }

    @RequestMapping("details")
    @ActionInfo(name = "应急队伍详情页面", access = 06, index = 7)
    public ModelAndView detailsPage()
            throws Exception
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("em_team/details");
        return m;
    }

    @RequestMapping(value = "teamTypes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "获取所有队伍类型列表", index = 8)
    @ResponseBody
    public String getAllTeamTypes() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emResourceTeamService.getAllTeamTypes());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return json.toString();
    }

    @RequestMapping(value = "teamLevels", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "获取所有队伍级别列表", index = 9)
    @ResponseBody
    public String getAllTeamLevels() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emResourceTeamService.getAllTeamLevels());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return json.toString();
    }

    @RequestMapping("entDetails")
    @ActionInfo(name = "应急队伍详情页面", access = 06, index = 10)
    public ModelAndView entdetailsPage(@RequestParam(name = "companyId") String companyId)
            throws Exception
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("entInfo", emResourceTeamService.getEntInfoById(companyId));
        mv.setViewName("em_team/entinfo");
        return mv;
    }

    @RequestMapping(value = "save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "添加应急队伍", index = 11)
    @ResponseBody
    public String insert(EmResourceTeam emResourceTeam)
    {
        try
        {
            emResourceTeamService.insert(emResourceTeam);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }


    @RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ActionInfo(name = "更新应急队伍", index = 12)
    @ResponseBody
    public String update(EmResourceTeam emResourceTeam)
    {
        try
        {
            emResourceTeamService.update(emResourceTeam);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }

    @RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "删除应急队伍", index = 13)
    public String delete(int[] teamIds)
    {
        try
        {
            emResourceTeamService.delete(teamIds);
            return ControllerUtils.buildSuccessJson().toString();
        } catch (AiidcException e)
        {
            return ControllerUtils.buildFailureJson(e).toString();
        }
    }


}
