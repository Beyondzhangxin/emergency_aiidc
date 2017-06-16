package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.*;
import com.aiidc.sps.ep.parameter.EmResourceTeamParam;
import com.aiidc.sps.ep.sqlProvider.EmResourceTeamProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/24 at 14:33.
 */
@Mapper
public interface EmResourceTeamMapper
{
    @Select("SELECT *  " +
            "FROM (SELECT  " +
            "t.*,  " +
            "ROWNUM rn  " +
            "FROM EM_RESOURCE_TEAM t) a  " +
            "WHERE a.rn BETWEEN  #{start}  " +
            "AND #{end}")
    @Results({
            @Result(column = "team_id", property = "teamId"),
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "team_name", property = "teamName"),
            @Result(column = "team_addr", property = "teamAddr"),
            @Result(column = "area_id", property = "areaId"),
            @Result(column = "team_type_id", property = "teamTypeId"),
            @Result(column = "team_level_id", property = "teamLevelId"),
            @Result(column = "event_type_id", property = "eventTypeId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "qualifications", property = "qualifications"),
            @Result(column = "qualifications_num", property = "qualificationsNum"),
            @Result(column = "people_num", property = "peopleNum"),
            @Result(column = "funding_sources", property = "fundingSources"),
            @Result(column = "squadron_num", property = "squadronNum"),
            @Result(column = "team_num", property = "teamNum"),
            @Result(column = "expertise", property = "expertise"),
            @Result(column = "main_material", property = "mainMaterial"),
            @Result(column = "team_head", property = "teamHead"),
            @Result(column = "leader", property = "leader"),
            @Result(column = "head_tel", property = "headTel"),
            @Result(column = "leader_tel", property = "leaderTel"),
            @Result(column = "head_mobile", property = "headMobile"),
            @Result(column = "leader_mobile", property = "leaderMobile"),
            @Result(column = "duty_tel", property = "dutyTel"),
            @Result(column = "duty_fax", property = "dutyFax")
    })
    List<EmResourceTeam> findAll(EmResourceTeamParam emResourceTeamParam);

    @SelectProvider(type = EmResourceTeamProvider.class, method = "searchSql")
    @Results({
            @Result(column = "team_name", property = "teamName"),
            @Result(column = "people_num", property = "peopleNum"),
            @Result(column = "event_type_name", property = "eventTypeName"),
            @Result(column = "duty_tel", property = "dutyTel"),
            @Result(column = "head_mobile", property = "headMobile"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "name", property = "companyName"),
            @Result(column = "team_id", property = "teamId"),
            @Result(column = "company_id", property = "companyId")
    })
    List<EmResourceTeamUnit> search(EmResourceTeamParam emResourceTeamParam);

    @SelectProvider(type = EmResourceTeamProvider.class, method = "searchCountSql")
    int searchCount(EmResourceTeamParam emResourceTeamParam);


    @InsertProvider(type = EmResourceTeamProvider.class, method = "insertTeam")
    @Options(useGeneratedKeys = false, keyColumn = "team_id", keyProperty = "teamId")
    void insert(EmResourceTeam emResourceTeam);

    @UpdateProvider(type = EmResourceTeamProvider.class, method = "updateTeam")
    @Options(useGeneratedKeys = false, keyColumn = "team_id", keyProperty = "teamId")
    void update(EmResourceTeam emResourceTeam);

    @Select("SELECT * FROM EM_RESOURCE_TEAM WHERE TEAM_ID =#{id}")
    @Results({
            @Result(column = "team_id", property = "teamId"),
            @Result(column = "company_id", property = "companyId"),
            @Result(column = "team_name", property = "teamName"),
            @Result(column = "team_addr", property = "teamAddr"),
            @Result(column = "area_id", property = "areaId"),
            @Result(column = "team_type_id", property = "teamTypeId"),
            @Result(column = "team_level_id", property = "teamLevelId"),
            @Result(column = "event_type_id", property = "eventTypeId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "qualifications", property = "qualifications"),
            @Result(column = "qualifications_num", property = "qualificationsNum"),
            @Result(column = "people_num", property = "peopleNum"),
            @Result(column = "funding_sources", property = "fundingSources"),
            @Result(column = "squadron_num", property = "squadronNum"),
            @Result(column = "team_num", property = "teamNum"),
            @Result(column = "expertise", property = "expertise"),
            @Result(column = "main_material", property = "mainMaterial"),
            @Result(column = "team_head", property = "teamHead"),
            @Result(column = "leader", property = "leader"),
            @Result(column = "head_tel", property = "headTel"),
            @Result(column = "leader_tel", property = "leaderTel"),
            @Result(column = "head_mobile", property = "headMobile"),
            @Result(column = "leader_mobile", property = "leaderMobile"),
            @Result(column = "duty_tel", property = "dutyTel"),
            @Result(column = "duty_fax", property = "dutyFax")
    })
    EmResourceTeam getByTeamId(String id);


    @Select("SELECT * FROM EM_RESOURCE_TEAM_TYPE WHERE TEAM_TYPE_ID=#{teamTypeId}")
    @Results({
            @Result(column = "team_type_id", property = "teamTypeId"),
            @Result(column = "team_type_name", property = "teamTypeName")
    })
    EmResourceTeamType getByTypeId(String teamTypeId);

    @Select("SELECT * FROM EM_RESOURCE_TEAM_EVENT_TYPE WHERE EVENT_TYPE_ID= #{eventTypeId}")
    @Results({
            @Result(column = "event_type_id", property = "eventTypeId"),
            @Result(column = "event_type_name", property = "eventTypeName")
    })
    EmResourceTeamEventType getByEventTypeId(int eventTypeId);

    @Select("SELECT * FROM  EM_RESOURCE_TEAM_LEVEL WHERE LEVEL_ID=#{levelId}")
    @Results({
            @Result(column = "level_id", property = "levelId"),
            @Result(column = "level_name", property = "levelName")
    })
    EmResourceTeamLevel getByLevelId(String levelId);

    @Select("select * from EM_RESOURCE_TEAM_EVENT_TYPE")
    @Results({
            @Result(column = "event_type_id", property = "eventTypeId"),
            @Result(column = "event_type_name", property = "eventTypeName")
    })
    List<EmResourceTeamEventType> getAllEventTypes();

    @Select("select * from EM_RESOURCE_TEAM_TYPE")
    @Results({
            @Result(column = "TEAM_TYPE_ID", property = "teamTypeId"),
            @Result(column = "TEAM_TYPE_NAME", property = "teamTypeName")
    })
    List<EmResourceTeamType> getAllTeamTypes();

    @Select("select * from em_resource_team_level")
    @Results({
            @Result(column = "level_id", property = "levelId"),
            @Result(column = "level_name", property = "levelName")
    })
    List<EmResourceTeamLevel> getAllTeamLevels();

    @Select("SELECT * FROM EM_ENTERPRISE_INFO WHERE ID=#{companyId}")
    EmEnterpriseInfo getEntInfoById(String companyId);

    @Select("SELECT SEQ_EM_RT.nextval FROM dual")
    int getSequnceId();

    @Delete("DELETE FROM EM_RESOURCE_TEAM WHERE TEAM_ID=#{teamId}")
    void delete(int teamId);

}
