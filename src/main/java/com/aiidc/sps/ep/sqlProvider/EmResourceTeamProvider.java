package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.entity.EmResourceTeam;
import com.aiidc.sps.ep.parameter.EmResourceTeamParam;

/**
 * Created by Zhangx on 2017/5/25 at 10:27.
 */
public class EmResourceTeamProvider
{
    public String searchSql(EmResourceTeamParam emResourceTeamParam)
    {
        StringBuilder stringBuilder =
                new StringBuilder("SELECT a.team_id,a.company_id, a.TEAM_NAME,a.PEOPLE_NUM,b.EVENT_TYPE_NAME,a.DUTY_TEL,a.HEAD_MOBILE,a.CREATE_TIME,c.NAME  " +
                        "FROM EM_RESOURCE_TEAM a LEFT JOIN EM_RESOURCE_TEAM_EVENT_TYPE b ON a.EVENT_TYPE_ID = b.EVENT_TYPE_ID  " +
                        "  LEFT JOIN EM_ENTERPRISE_INFO c ON a.COMPANY_ID = c.ID  " +
                        "WHERE 1 = 1  ");

        if (emResourceTeamParam.getTeamName() != null && emResourceTeamParam.getTeamName().length() > 0)
        {
            stringBuilder.append("   AND a.TEAM_NAME LIKE '%" + emResourceTeamParam.getTeamName() + "%'");
        }
        if (emResourceTeamParam.getCompanyName() != null)
        {
            stringBuilder.append("   AND c.name LIKE '%" + emResourceTeamParam.getCompanyName() + "%'");
        }else {
            stringBuilder.append("  and COMPANY_ID is NULL  ");
        }
        if (emResourceTeamParam.getAreaId() != null && emResourceTeamParam.getAreaId().length() > 0)
        {
            stringBuilder.append("   AND a.AREA_ID = " + emResourceTeamParam.getAreaId());
        }
        if (emResourceTeamParam.getEventTypeId() != null)
        {
            stringBuilder.append("   AND a.event_type_id =" + emResourceTeamParam.getEventTypeId());
        }


        String result = "select * from (select t.*,rownum rn from ( "
                + stringBuilder.toString() +
                " ORDER BY a.CREATE_TIME DESC) t) a where a.rn between " + emResourceTeamParam.getStart()
                + " and " + emResourceTeamParam.getEnd();
        return result;
    }

    public String searchCountSql(EmResourceTeamParam emResourceTeamParam)
    {
        StringBuilder stringBuilder =
                new StringBuilder("SELECT  " +
                        "     count(*)  " +
                        "  FROM EM_RESOURCE_TEAM a LEFT JOIN EM_ENTERPRISE_INFO c on a.COMPANY_ID=c.ID WHERE 1=1");

        if (emResourceTeamParam.getTeamName() != null && emResourceTeamParam.getTeamName().length() > 0)
        {
            stringBuilder.append("   AND a.TEAM_NAME LIKE '%" + emResourceTeamParam.getTeamName() + "%'");
        }
        if (emResourceTeamParam.getCompanyName() != null && emResourceTeamParam.getCompanyName().length() > 0)
        {
            stringBuilder.append("   AND c.name LIKE '%" + emResourceTeamParam.getCompanyName() + "%'");
        }
        if (emResourceTeamParam.getAreaId() != null && emResourceTeamParam.getAreaId().length() > 0)
        {
            stringBuilder.append("   AND a.AREA_ID = " + emResourceTeamParam.getAreaId());
        }
        if (emResourceTeamParam.getEventTypeId() != null)
        {
            stringBuilder.append("   AND a.event_type_id =" + emResourceTeamParam.getEventTypeId());
        }
        return stringBuilder.toString();
    }

    public String updateTeam(EmResourceTeam emResourceTeam)
    {
        String str= "UPDATE em_resource_team  " +
                "        set  " +
                "           team_id = #{teamId},   " +
                "            company_id = #{companyId,jdbcType=VARCHAR},   " +
                "             team_name = #{teamName},   " +
                "            team_addr = #{teamAddr},   " +
                "             area_id = #{areaId},  " +
                "             team_type_id = #{teamTypeId},  " +
                "             team_level_id = #{teamLevelId},  " +
                "            event_type_id = #{eventTypeId},   " +
                "          create_time = #{createTime,jdbcType=DATE},   " +
                "       qualifications = #{qualifications},   " +
                "          qualifications_num = #{qualificationsNum},   " +
                "        people_num = #{peopleNum,jdbcType=NUMERIC},   " +
                "            funding_sources = #{fundingSources},   " +
                "        squadron_num = #{squadronNum,jdbcType=NUMERIC},   " +
                "      team_num = #{teamNum,jdbcType=NUMERIC},   " +
                "         expertise = #{expertise},  " +
                " main_material = #{mainMaterial},   " +
                "     team_head = #{teamHead},   " +
                "      leader = #{leader},   " +
                "          head_tel = #{headTel},  " +
                "      leader_tel = #{leaderTel},   " +
                "   head_mobile = #{headMobile},   " +
                "         leader_mobile = #{leaderMobile},   " +
                "         duty_tel = #{dutyTel},   " +
                "            duty_fax = #{dutyFax}  " +
                "        WHERE team_id = #{teamId}";
        return str;
    }

    public String insertTeam(EmResourceTeam emResourceTeam)
    {
        String str = "INSERT INTO em_resource_team (  " +
                "            team_id,  " +
                "            company_id,  " +
                "            team_name,  " +
                "            team_addr,  " +
                "            area_id,  " +
                "            team_type_id,  " +
                "            team_level_id,  " +
                "            event_type_id,  " +
                "            create_time,  " +
                "            qualifications,  " +
                "            qualifications_num,  " +
                "            people_num,  " +
                "            funding_sources,  " +
                "            squadron_num,  " +
                "            team_num,  " +
                "            expertise,  " +
                "            main_material,  " +
                "            team_head,  " +
                "            leader,  " +
                "            head_tel,  " +
                "            leader_tel,  " +
                "            head_mobile,  " +
                "            leader_mobile,  " +
                "            duty_tel,  " +
                "            duty_fax  " +
                "        ) VALUES (  " +
                "            #{teamId,jdbcType=NUMERIC},  " +
                "            #{companyId,jdbcType=VARCHAR},  " +
                "            #{teamName},  " +
                "            #{teamAddr},  " +
                "            #{areaId},  " +
                "            #{teamTypeId,jdbcType=CHAR},  " +
                "            #{teamLevelId,jdbcType=CHAR},  " +
                "            #{eventTypeId,jdbcType=SMALLINT},  " +
                "            #{createTime,jdbcType=DATE},  " +
                "            #{qualifications},  " +
                "            #{qualificationsNum},  " +
                "            #{peopleNum,jdbcType=NUMERIC},  " +
                "            #{fundingSources},  " +
                "            #{squadronNum,jdbcType=NUMERIC},  " +
                "            #{teamNum,jdbcType=NUMERIC},  " +
                "            #{expertise},  " +
                "            #{mainMaterial},  " +
                "            #{teamHead},  " +
                "            #{leader},  " +
                "            #{headTel},  " +
                "            #{leaderTel},  " +
                "            #{headMobile},  " +
                "            #{leaderMobile},  " +
                "            #{dutyTel},  " +
                "            #{dutyFax}  " +
                "        )";
        return str;
    }
}
