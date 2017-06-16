package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.parameter.EmResourceContactsParam;

/**
 * Created by Zhangx on 2017/6/4 at 16:48.
 */
public class EnResourceContactsProvider
{
    public String searchSql(EmResourceContactsParam emResourceContactsParam)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT  " +
                "  a.*,b.NAME  " +
                "  FROM EM_RESOURCE_CONTACTS a LEFT JOIN EM_ENTERPRISE_INFO b ON a.COMPANY_ID=b.ID  " +
                "where 1=1");
        if (emResourceContactsParam.getCompanyId()!= null && emResourceContactsParam.getCompanyId().length()>0)
        {
            stringBuilder.append("   and a.company_id =" + emResourceContactsParam.getCompanyId());
        }
        if (emResourceContactsParam.getHeader() != null && emResourceContactsParam.getHeader().length() > 0)
        {
            stringBuilder.append("   and a.header like '%" + emResourceContactsParam.getHeader() + "%'");
        }
        if (emResourceContactsParam.getMobilePhone() != null && emResourceContactsParam.getMobilePhone().length() > 0)
        {
            stringBuilder.append("   and a.mobile_phone like '%" + emResourceContactsParam.getMobilePhone() + "%'");
        }
        if (emResourceContactsParam.getEmail() != null && emResourceContactsParam.getEmail().length() > 0)
        {
            stringBuilder.append("   and a.email like '%" + emResourceContactsParam.getEmail() + "%'");
        }
        String result = "select * from (select t.*,rownum rn from (" +
                stringBuilder.toString() + " ORDER BY a.edit_time DESC )t) a where a.rn between " + emResourceContactsParam.getStart() +
                " and " + emResourceContactsParam.getEnd();
        return result;
    }

    public String searchCountSql(EmResourceContactsParam emResourceContactsParam)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(*) " +
                "  FROM EM_RESOURCE_CONTACTS a LEFT JOIN EM_ENTERPRISE_INFO b ON a.COMPANY_ID=b.ID  " +
                "where 1=1");
        if (emResourceContactsParam.getCompanyId() != null && emResourceContactsParam.getCompanyId().length()>0)
        {
            stringBuilder.append("   and a.company_id =" + emResourceContactsParam.getCompanyId());
        }
        if (emResourceContactsParam.getHeader() != null && emResourceContactsParam.getHeader().length() > 0)
        {
            stringBuilder.append("   and a.header like '%" + emResourceContactsParam.getHeader() + "%'");
        }
        if (emResourceContactsParam.getMobilePhone() != null && emResourceContactsParam.getMobilePhone().length() > 0)
        {
            stringBuilder.append("   and a.mobile_phone like '%" + emResourceContactsParam.getMobilePhone() + "%'");
        }
        if (emResourceContactsParam.getEmail() != null && emResourceContactsParam.getEmail().length() > 0)
        {
            stringBuilder.append("   and a.email like '%" + emResourceContactsParam.getEmail() + "%'");
        }
        return stringBuilder.toString();
    }
}
