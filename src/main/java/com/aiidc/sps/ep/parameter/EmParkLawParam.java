package com.aiidc.sps.ep.parameter;

import com.aiidc.sps.ep.entity.EmParkLawsRegulations;

/**
 * Created by Zhangx on 2017/5/25 at 14:40.
 */
public class EmParkLawParam extends EmParkLawsRegulations
{
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer start;
    private Integer end;
    private String nameF;
    private String publishDepartmentF;

    public Integer getStart()
    {
        return (pageNum - 1) * pageSize + 1;
    }

    public Integer getEnd()
    {
        return (pageNum * pageSize);
    }

    public String getNameF()
    {
        if(getName()!=null)
        return "%" + getName() + "%";
        else return "%%";
    }

    public String getPublishDepartmentF()
    {
        if (getPublishDepartment()!=null)
        return "%" + getPublishDepartment() + "%";
        else return "%%";
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
