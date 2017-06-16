package com.aiidc.sps.ep.parameter;

import com.aiidc.sps.ep.entity.EmParkExpert;

/**
 * Created by Zhangx on 2017/5/25 at 13:14.
 */
public class EmParkExpertParam extends EmParkExpert
{
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer start;
    private Integer end;
    private String expertType;
    private String areaId;
    private String eventTypeId;
    public Integer getStart()
    {
        return (pageNum-1)*pageSize+1;
    }

    public Integer getEnd()
    {
        return (pageNum*pageSize);
    }

    public Integer getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
}
