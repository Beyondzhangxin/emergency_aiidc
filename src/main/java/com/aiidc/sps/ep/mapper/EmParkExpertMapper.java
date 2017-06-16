package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.EmParkExperUnit;
import com.aiidc.sps.ep.entity.EmParkExpert;
import com.aiidc.sps.ep.entity.EmParkExpertType;
import com.aiidc.sps.ep.parameter.EmParkExpertParam;
import com.aiidc.sps.ep.sqlProvider.EmParkExpertProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/23 at 10:49.
 */
@Mapper
public interface EmParkExpertMapper
{
    @SelectProvider(type = EmParkExpertProvider.class, method = "searchSql")
    @Results({
            @Result(column = "expert_id", property = "expertId"),
            @Result(column = "expert_type_name", property = "expertType"),
            @Result(column = "name", property = "name"),
            @Result(column = "area_nm", property = "areaId"),
            @Result(column = "event_type_name", property = "eventTypeId"),
            @Result(column = "work_unit", property = "workUnit"),
            @Result(column = "change_date", property = "changeDate"),
    })
    List<EmParkExperUnit> search(EmParkExpertParam emParkExpertParam);

    @SelectProvider(type = EmParkExpertProvider.class, method = "searchCountSql")
    int searchCount(EmParkExpertParam emParkExpertParam);

    @Select("select * from em_park_expert where expert_id=#{id}")
    @Results({
            @Result(column = "expert_id", property = "expertId"),
            @Result(column = "expert_type", property = "expertType"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "nation_code", property = "nationCode"),
            @Result(column = "area_id", property = "areaId"),
            @Result(column = "event_type_id", property = "eventTypeId"),
            @Result(column = "political_outlook", property = "politicalOutlook"),
            @Result(column = "place_of_origin", property = "placeOfOrigin"),
            @Result(column = "domicile", property = "domicile"),
            @Result(column = "major", property = "major"),
            @Result(column = "highest_education", property = "highestEducation"),
            @Result(column = "work_unit", property = "workUnit"),
            @Result(column = "unit_addr", property = "unitAddr"),
            @Result(column = "university", property = "university"),
            @Result(column = "working_time", property = "workingTime"),
            @Result(column = "post", property = "post"),
            @Result(column = "title", property = "title"),
            @Result(column = "specialty", property = "specialty"),
            @Result(column = "office_phone", property = "officePhone"),
            @Result(column = "email", property = "email"),
            @Result(column = "fax", property = "fax"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "home_phone", property = "homePhone"),
            @Result(column = "home_addr", property = "homeAddr"),
            @Result(column = "change_date", property = "changeDate"),
            @Result(column = "part_in_inci_handling", property = "partInInciHandling")
    })
    EmParkExpert getById(String id);


    @Delete("DELETE FROM em_park_expert WHERE expert_id = #{arg0}")
    @Options(useGeneratedKeys = false, keyColumn = "expert_id", keyProperty = "expertId")
    void deleteById(int expertId);


    @UpdateProvider(type = EmParkExpertProvider.class, method = "updateSql")
    @Options(useGeneratedKeys = false, keyColumn = "expert_id", keyProperty = "expertId")
    void update(EmParkExpert emParkExpert);

    @InsertProvider(type = EmParkExpertProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = false, keyColumn = "expert_id", keyProperty = "expertId")
    void save(EmParkExpert emParkExpert);

    @Select("SELECT  * FROM EM_PARK_EXPERT_TYPE")
    @Results({
            @Result(column = "EXPERT_ID", property = "expertId"),
            @Result(column = "EXPERT_TYPE_NAME", property = "expertTypeName")
    })
    List<EmParkExpertType> getAllExpertTypes();

    @Select("SELECT SEQ_EM_PE.nextval FROM dual")
    long getExpertId();

    @Select("select * from em_park_expert_type where expert_id=#{expertId}")
    @Results({
            @Result(column = "expert_id", property = "expertId"),
            @Result(column = "expert_type_name", property = "expertTypeName")
    })
    EmParkExpertType getExpertTypeById(short expertId);

}
