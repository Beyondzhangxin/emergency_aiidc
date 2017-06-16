package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.EmEnterpriseInfo;
import com.aiidc.sps.ep.entity.EmResourceContacts;
import com.aiidc.sps.ep.parameter.EmResourceContactsParam;
import com.aiidc.sps.ep.sqlProvider.EnResourceContactsProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/24 at 11:51.
 */
@Mapper
public interface EmResourceContactsMapper
{

    @SelectProvider(type = EnResourceContactsProvider.class, method = "searchSql")
    @Results({
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "name", property = "companyName"),
            @Result(column = "department", property = "department"),
            @Result(column = "department_duty", property = "departmentDuty"),
            @Result(column = "header", property = "header"),
            @Result(column = "post", property = "post"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "fax", property = "fax"),
            @Result(column = "email", property = "email"),
            @Result(column = "wechat", property = "wechat"),
            @Result(column = "qq", property = "qq"),
            @Result(column = "edit_time", property = "editTime")
    })
    List<EmResourceContacts> search(EmResourceContactsParam emResourceContactsParam);

    @SelectProvider(type = EnResourceContactsProvider.class, method = "searchCountSql")
    int searchCount(EmResourceContactsParam emResourceContactsParam);


    @Select("SELECT * FROM EM_RESOURCE_CONTACTS WHERE COMPANY_ID=#{arg0}")
    @Results({
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "company_name", property = "companyName"),
            @Result(column = "department", property = "department"),
            @Result(column = "department_duty", property = "departmentDuty"),
            @Result(column = "header", property = "header"),
            @Result(column = "post", property = "post"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "fax", property = "fax"),
            @Result(column = "email", property = "email"),
            @Result(column = "wechat", property = "wechat"),
            @Result(column = "qq", property = "qq"),
            @Result(column = "edit_time", property = "editTime")
    })
    EmResourceContacts getById(String id);

    @Select("select * from em_enterprise_info")
    List<EmEnterpriseInfo> getEpInfos();
}
