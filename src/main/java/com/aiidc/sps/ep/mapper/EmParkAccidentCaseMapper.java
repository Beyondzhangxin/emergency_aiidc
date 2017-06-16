package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.EmParkAccidentCase;
import com.aiidc.sps.ep.parameter.EmParkAccidentCaseParam;
import com.aiidc.sps.ep.sqlProvider.EmParkAccidentCaseProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/25 at 17:13.
 */
@Mapper
public interface EmParkAccidentCaseMapper
{
    @SelectProvider(type = EmParkAccidentCaseProvider.class,method = "searchSql")
    @Results({
            @Result(column = "accident_name", property = "accidentName"),
            @Result(column = "accident_time", property = "accidentTime"),
            @Result(column = "EVENT_TYPE_NAME", property = "accidentType")
    })
    List<EmParkAccidentCase> search(EmParkAccidentCaseParam emParkAccidentCaseParam);
    @SelectProvider(type = EmParkAccidentCaseProvider.class,method = "searchCountSql")
    int searchCount(EmParkAccidentCaseParam emParkAccidentCaseParam);

    @Select("select a.ACCIDENT_TYPE,a.ACCIDENT_NAME,to_char(a.ACCIDENT_TIME,'yyyy-MM-dd hh24:mm:ss') " +
            "as accident_time,a.ID,a.CONTENT from em_park_accident_case a where id= #{id}")
    @Results({
            @Result(column = "accident_name", property = "accidentName"),
            @Result(column = "accident_time", property = "accidentTime"),
            @Result(column = "accident_type", property = "accidentType"),
            @Result(column = "content",property = "content")
    })
    EmParkAccidentCase getById(long id);

    @Insert(" INSERT INTO em_park_accident_case (   " +
            "id,   " +
            "accident_name,   " +
            "accident_time,   " +
            "accident_type,   " +
            "content   " +
            ") VALUES (   " +
            "#{id,jdbcType=NUMERIC},   " +
            "#{accidentName},   " +
            "to_date(#{accidentTime,jdbcType=DATE}, 'yyyy-mm-dd hh24:mi:ss'),   " +
            "#{accidentType},   " +
            "#{content}   " +
            ")")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void insert(EmParkAccidentCase emParkAccidentCase);

    @Update("UPDATE em_park_accident_case   " +
            "set   " +
            "accident_name = #{accidentName},    " +
            "accident_time = to_date(#{accidentTime,jdbcType=DATE}, 'yyyy-mm-dd hh24:mi:ss'),    " +
            "accident_type = #{accidentType},   " +
            "content = #{content}   " +
            "WHERE id = #{id}")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void update(EmParkAccidentCase emParkAccidentCase);

    @Delete("delete from em_park_accident_case where id = #{id}")
    @Options(useGeneratedKeys = false, keyColumn = "ID", keyProperty = "id")
    void delete(int id);

    @Select("SELECT SEQ_EM_PAC.nextval FROM dual")
    long getId();

}
