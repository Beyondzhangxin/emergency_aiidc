package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.EmParkLawUnit;
import com.aiidc.sps.ep.entity.EmParkLawsRegulations;
import com.aiidc.sps.ep.parameter.EmParkLawParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/25 at 14:50.
 */
@Mapper
public interface EmParkLawsMapper
{
    @Select("SELECT * FROM (  " +
            "SELECT a.*,ROWNUM rn     " +
            "FROM EM_PARK_LAWS_REGULATIONS a WHERE NAME like #{nameF} AND PUBLISH_DEPARTMENT LIKE #{publishDepartmentF})  " +
            "WHERE rn BETWEEN #{start} AND #{end}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "publish_department", property = "publishDepartment"),
            @Result(column = "publish_date", property = "pubDate"),
            @Result(column = "implement_date", property = "impDate"),
            @Result(column = "content", property = "content")
    })
    List<EmParkLawUnit> search(EmParkLawParam emParkLawParam);

    @Select("SELECT count(*)  " +
            "FROM EM_PARK_LAWS_REGULATIONS a WHERE NAME like #{nameF} AND PUBLISH_DEPARTMENT LIKE #{publishDepartmentF}")
    int searchCount(EmParkLawParam emParkLawParam);

    @Select("select * from em_park_laws_regulations where name like #{nameF}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "publish_department", property = "publishDepartment"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "implement_date", property = "implementDate"),
            @Result(column = "content", property = "content")
    })
    List<EmParkLawsRegulations> findByName(EmParkLawParam emParkLawParam);

    @Select("select * from em_park_laws_regulations where id=#{id}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "publish_department", property = "publishDepartment"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "implement_date", property = "implementDate"),
            @Result(column = "content", property = "content")
    })
    EmParkLawsRegulations getById(int id);

    @Insert("INSERT INTO em_park_laws_regulations (  " +
            "            id,  " +
            "            name,  " +
            "            publish_department,  " +
            "            publish_date,  " +
            "            implement_date,  " +
            "            content  " +
            "        ) VALUES (  " +
            "            #{id,jdbcType=NUMERIC},  " +
            "            #{name},  " +
            "            #{publishDepartment},  " +
            "            #{publishDate,jdbcType=DATE},  " +
            "            #{implementDate,jdbcType=DATE},  " +
            "            #{content}  " +
            "        )")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void insert(EmParkLawsRegulations emParkLawsRegulations);

    @Update("UPDATE em_park_laws_regulations  " +
            "        set  " +
            "           name = #{name}, " +
            "     publish_department = #{publishDepartment},  " +
            "             publish_date = #{publishDate,jdbcType=DATE},  " +
            "            implement_date = #{implementDate,jdbcType=DATE},  " +
            "            content = #{content} where  id = #{id}   ")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void update(EmParkLawsRegulations emParkLawsRegulations);

    @Delete("DELETE EM_PARK_LAWS_REGULATIONS WHERE ID=#{id}")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void delete(long id);

    @Select("SELECT SEQ_EM_PLR.nextval from dual")
    long getId();
}
