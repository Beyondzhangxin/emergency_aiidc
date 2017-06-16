package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.parameter.EmParkAccidentCaseParam;

/**
 * Created by Zhangx on 2017/6/15 at 16:37.
 */
public class EmParkAccidentCaseProvider
{
    public String searchSql(EmParkAccidentCaseParam emParkAccidentCase)
    {
        StringBuilder stringBuilder = new StringBuilder(
                "SELECT   " +
                        "  a.ACCIDENT_TYPE,a.ACCIDENT_NAME,to_char(a.ACCIDENT_TIME,'yyyy-MM-dd hh24:mm:ss') as accident_time,a.ID,a.CONTENT,b.EVENT_TYPE_NAME,   " +
                        "  ROWNUM rn     " +
                        "FROM EM_PARK_ACCIDENT_CASE a,EM_RESOURCE_TEAM_EVENT_TYPE b WHERE a.ACCIDENT_TYPE=b.EVENT_TYPE_ID"
        );
        if (emParkAccidentCase.getAccidentName() != null && emParkAccidentCase.getAccidentName().trim().length() > 0)
        {
            stringBuilder.append(" and accident_name like '%" + emParkAccidentCase.getAccidentName() + "%'");
        }
        if (emParkAccidentCase.getAccidentTime() != null && emParkAccidentCase.getAccidentTime().length() > 0)
        {
            stringBuilder.append("  and  to_char(ACCIDENT_TIME,'yyyy-MM-dd') like '%" + emParkAccidentCase.getAccidentTime()+"%'");
        }
        if (emParkAccidentCase.getAccidentType() != null&&emParkAccidentCase.getAccidentType().length()>0)
        {
            stringBuilder.append(" and ACCIDENT_TYPE =" + emParkAccidentCase.getAccidentType());
        }
        String result = "select * from ( "
                + stringBuilder.toString() +
                " ) t where t.rn between " + emParkAccidentCase.getStart()
                + " and " + emParkAccidentCase.getEnd();
        return result;
    }
    public String searchCountSql(EmParkAccidentCaseParam emParkAccidentCase){
        StringBuilder stringBuilder = new StringBuilder("SELECT count(*)"+
                "FROM EM_PARK_ACCIDENT_CASE a,EM_RESOURCE_TEAM_EVENT_TYPE b WHERE a.ACCIDENT_TYPE=b.EVENT_TYPE_ID");
        if (emParkAccidentCase.getAccidentName() != null && emParkAccidentCase.getAccidentName().trim().length() > 0)
        {
            stringBuilder.append(" and accident_name like '%" + emParkAccidentCase.getAccidentName() + "%'");
        }
        if (emParkAccidentCase.getAccidentTime() != null && emParkAccidentCase.getAccidentTime().length() > 0)
        {
            stringBuilder.append("  and  to_char(ACCIDENT_TIME,'yyyy-MM-dd') like '%" + emParkAccidentCase.getAccidentTime() + "%'");
        }
        if (emParkAccidentCase.getAccidentType() != null&&emParkAccidentCase.getAccidentType().length()>0)
        {
            stringBuilder.append(" and ACCIDENT_TYPE =" + emParkAccidentCase.getAccidentType());
        }
        return stringBuilder.toString();
    }
}
