package com.aiidc.sps.ep.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhangx on 2017/6/4 at 14:28.
 */
public class EmParkLawUnit implements Serializable
{
    private static final long serialVersionUID = 4298077232798583862L;
    private String id;
    private String name;
    private String publishDepartment;
    private Date pubDate;
    private Date impDate;
    public String content;

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPublishDepartment()
    {
        return publishDepartment;
    }

    public void setPublishDepartment(String publishDepartment)
    {
        this.publishDepartment = publishDepartment;
    }

    public String getPubDate()
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(pubDate);
    }

    public void setPubDate(Date pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getImpDate()
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(impDate);
    }

    public void setImpDate(Date impDate)
    {
        this.impDate = impDate;
    }
}
