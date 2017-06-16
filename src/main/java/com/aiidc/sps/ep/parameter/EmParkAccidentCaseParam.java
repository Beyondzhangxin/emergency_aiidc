package com.aiidc.sps.ep.parameter;

import com.aiidc.sps.ep.entity.EmParkAccidentCase;

/**
 * Created by Zhangx on 2017/5/25 at 17:06.
 */
public class EmParkAccidentCaseParam extends EmParkAccidentCase
{
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Integer start;
    private Integer end;
    private String accidentNameF;
    private String accidentTimeF;
    private String accidentTypeF;

    public Integer getPageNum()
    {
        return pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public Integer getStart()
    {
        return (pageNum - 1) * pageSize + 1;
    }

    public Integer getEnd()
    {
        return (pageSize * pageNum);
    }

    public String getAccidentNameF()
    {
        if (getAccidentName() != null)
            return "%" + getAccidentName() + "%";
        else return "%%";
    }

    public String getAccidentTimeF()
    {
        if (getAccidentTime() != null)
            return "%" + getAccidentTime() + "%";
        else return "%%";
    }

    public String getAccidentTypeF()
    {
        if (getAccidentType() != null)
            return "%" + getAccidentType() + "%";
        else return "%%";
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
}
