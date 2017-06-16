package com.aiidc.sps.ep.parameter;

import com.aiidc.sps.ep.entity.EmResourceTeam;

/**
 * Created by Zhangx on 2017/5/24 at 14:35.
 */
public class EmResourceTeamParam extends EmResourceTeam
{
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer start;
    private Integer end;
    private String  companyName;

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public Integer getStart()
    {
        return (pageNum - 1) * pageSize + 1;
    }

    public Integer getEnd()
    {
        return (pageNum * pageSize);
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
