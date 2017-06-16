package com.aiidc.sps.ep.controller;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.services.EmParkNationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Zhangx on 2017/5/26 at 16:11.
 */
@Controller
@ControllerInfo(value = "名族编码信息")
@RequestMapping("nations")
public class EmParkNationController
{
    @Autowired
    private EmParkNationService emParkNationService;

    @RequestMapping(value = "list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ActionInfo(name = "获得所有名族编码",index = 0)
    public String  getAll() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        JSONArray jsonArray = BeanUtils.describeToJson(emParkNationService.findAll());
        JSONObject json = ControllerUtils.buildSuccessJson(jsonArray);
        return  json.toString();
    }
}
