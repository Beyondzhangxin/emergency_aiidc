package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.entity.EmParkExpert;
import com.aiidc.sps.ep.parameter.EmParkExpertParam;

/**
 * Created by Zhangx on 2017/5/23 at 10:52.
 */
public class EmParkExpertProvider
{

    public String searchSql(EmParkExpertParam emParkExpertParam)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT  " +
                "  a.NAME,  " +
                "  a.expert_id,  " +
                "  a.WORK_UNIT,  " +
                "  a.CHANGE_DATE,  " +
                "  c.AREA_NM,  " +
                "  b.EXPERT_TYPE_NAME,  " +
                "  d.EVENT_TYPE_NAME  " +
                "FROM EM_PARK_EXPERT a LEFT JOIN EM_PARK_EXPERT_TYPE b ON a.EXPERT_TYPE = b.EXPERT_ID  " +
                "LEFT JOIN AREA c on a.AREA_ID=c.COUNTY_ID and c.PROV_ID=32 and c.CITY_ID=11  " +
                "LEFT JOIN EM_RESOURCE_TEAM_EVENT_TYPE d on a.EVENT_TYPE_ID=d.EVENT_TYPE_ID WHERE 1=1");
        if (emParkExpertParam.getExpertType() != null)
        {
            stringBuilder.append("   and a.expert_type =" + emParkExpertParam.getExpertType());
        }
        if (emParkExpertParam.getName() != null && emParkExpertParam.getName().length() > 0)
        {
            stringBuilder.append("   and a.name like '%" + emParkExpertParam.getName() + "%'");
        }
        if (emParkExpertParam.getAreaId() != null && emParkExpertParam.getAreaId().length() > 0)
        {
            stringBuilder.append("    and a.area_id =" + emParkExpertParam.getAreaId());
        }
        if (emParkExpertParam.getEventTypeId() != null)
        {
            stringBuilder.append("    and a.event_type_id =" + emParkExpertParam.getEventTypeId());
        }

        String result = "select * from (select t.*,rownum rn from (" +
                stringBuilder.toString() + " ORDER BY a.CHANGE_DATE DESC )t) a where a.rn between " + emParkExpertParam.getStart() +
                " and " + emParkExpertParam.getEnd();
        return result;
    }

    public String searchCountSql(EmParkExpertParam emParkExpertParam)
    {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(*) FROM EM_PARK_EXPERT WHERE 1=1");
        if (emParkExpertParam.getExpertType() != null)
        {
            stringBuilder.append("   and expert_type =" + emParkExpertParam.getExpertType());
        }
        if (emParkExpertParam.getName() != null && emParkExpertParam.getName().length() > 0)
        {
            stringBuilder.append("   and name like '%" + emParkExpertParam.getName() + "%'");
        }
        if (emParkExpertParam.getAreaId() != null && emParkExpertParam.getAreaId().length() > 0)
        {
            stringBuilder.append("    and area_id =" + emParkExpertParam.getAreaId());
        }
        if (emParkExpertParam.getEventTypeId() != null)
        {
            stringBuilder.append("    and event_type_id =" + emParkExpertParam.getEventTypeId());
        }

        return stringBuilder.toString();

    }


    public String updateSql(EmParkExpert emParkExpert)
    {
        return "UPDATE em_park_expert  " +
                "        set  " +
                "           expert_type = #{expertType,jdbcType=SMALLINT},  " +
                "            name = #{name},  " +
                "            sex = #{sex},  " +
                "            birthday = #{birthday,jdbcType=DATE},  " +
                "             nation_code = #{nationCode},   " +
                "            area_id = #{areaId},   " +
                "            event_type_id = #{eventTypeId,jdbcType=SMALLINT},  " +
                "             political_outlook = #{politicalOutlook},  " +
                "            place_of_origin = #{placeOfOrigin},   " +
                "         domicile = #{domicile},   " +
                "          major = #{major},   " +
                "           highest_education = #{highestEducation},  " +
                "         work_unit = #{workUnit},   " +
                "           unit_addr = #{unitAddr},  " +
                "           university = #{university},  " +
                "           working_time = #{workingTime,jdbcType=DATE},  " +
                "           post = #{post},   " +
                "            title = #{title},   " +
                "            specialty = #{specialty},   " +
                "           office_phone = #{officePhone},  " +
                "             email = #{email},   " +
                "           fax = #{fax},  " +
                "           mobile_phone = #{mobilePhone},   " +
                "           home_phone = #{homePhone},   " +
                "            home_addr = #{homeAddr},   " +
                "             change_date = sysdate,   " +
                "            part_in_inci_handling = #{partInInciHandling}   " +
                "        " +
                "        WHERE expert_id = #{expertId}";
    }


    public String saveSql(EmParkExpert emParkExpert)
    {
        return "INSERT INTO em_park_expert (" +
                " expert_id," +
                "  expert_type," +
                "  name," +
                "  sex," +
                "  birthday," +
                "  nation_code," +
                "  area_id," +
                "  event_type_id," +
                "  political_outlook," +
                "  place_of_origin," +
                "  domicile," +
                "  major," +
                "  highest_education," +
                "  work_unit," +
                "  unit_addr," +
                "  university," +
                "  working_time," +
                "  post," +
                "  title," +
                "  specialty," +
                "  office_phone," +
                "  email," +
                "  fax," +
                "  mobile_phone," +
                "  home_phone," +
                "  home_addr," +
                "  change_date," +
                "  part_in_inci_handling" +
                ") VALUES (" +
                " #{expertId}," +
                "  #{expertType,jdbcType=SMALLINT}," +
                "  #{name}," +
                "  #{sex}," +
                "  #{birthday,jdbcType=DATE}," +
                "  #{nationCode}," +
                "  #{areaId}," +
                "  #{eventTypeId,jdbcType=SMALLINT}," +
                "  #{politicalOutlook}," +
                "  #{placeOfOrigin}," +
                "  #{domicile}," +
                "  #{major}," +
                "  #{highestEducation}," +
                "  #{workUnit}," +
                "  #{unitAddr}," +
                "  #{university}," +
                "  #{workingTime,jdbcType=DATE}," +
                "  #{post}," +
                "  #{title}," +
                "  #{specialty}," +
                "  #{officePhone}," +
                "  #{email}," +
                "  #{fax}," +
                "  #{mobilePhone}," +
                "  #{homePhone}," +
                "  #{homeAddr}," +
                "  sysdate," +
                "  #{partInInciHandling}" +
                ")";
    }


}
