package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhangx on 2017/6/2 at 20:58.
 */
public class EmParkExperUnit implements Serializable
{
    private static final long serialVersionUID = 339691882070989768L;
    private String expertType;
    private String name;
    private String workUnit;
    private String areaId;
    private String eventTypeId;
    private Date changeDate;
    private long expertId;

    public long getExpertId()
    {
        return expertId;
    }

    public void setExpertId(long expertId)
    {
        this.expertId = expertId;
    }

    public String getExpertType()
    {
        return expertType;
    }

    public void setExpertType(String expertType)
    {
        this.expertType = expertType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getWorkUnit()
    {
        return workUnit;
    }

    public void setWorkUnit(String workUnit)
    {
        this.workUnit = workUnit;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getEventTypeId()
    {
        return eventTypeId;
    }

    public void setEventTypeId(String eventTypeId)
    {
        this.eventTypeId = eventTypeId;
    }

    public String getChangeDate()
    {
        return new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(changeDate);

    }

    public void setChangeDate(Date changeDate)
    {
        this.changeDate = changeDate;
    }
}
