package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhangx on 2017/6/3 at 15:11.
 */
public class EmResourceTeamUnit implements Serializable
{

    private static final long serialVersionUID = -6620455164079996663L;
    private  String teamName;
    private   Short peopleNum;
    private  String eventTypeName;
    private String dutyTel;
    private String headMobile;
    private Date createTime;
    private String companyName;
    private String teamId;
    private String companyId;

    public String getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(String companyId)
    {
        this.companyId = companyId;
    }

    public String getTeamId()
    {
        return teamId;
    }

    public void setTeamId(String teamId)
    {
        this.teamId = teamId;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getEventTypeName()
    {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName)
    {
        this.eventTypeName = eventTypeName;
    }

    public String getDutyTel()
    {
        return dutyTel;
    }

    public void setDutyTel(String dutyTel)
    {
        this.dutyTel = dutyTel;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public Short getPeopleNum()
    {
        return peopleNum;
    }

    public void setPeopleNum(Short peopleNum)
    {
        this.peopleNum = peopleNum;
    }

    public String getCreateTime()
    {
        return new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(createTime);
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getHeadMobile()
    {
        return headMobile;
    }

    public void setHeadMobile(String headMobile)
    {
        this.headMobile = headMobile;
    }
}
