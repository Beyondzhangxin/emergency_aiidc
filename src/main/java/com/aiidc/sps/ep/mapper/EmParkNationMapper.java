package com.aiidc.sps.ep.mapper;

import com.aiidc.sps.ep.entity.EmParkNation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/26 at 16:12.
 */
@Mapper
public interface EmParkNationMapper
{
    @Select("SELECT  * FROM EM_PARK_NATION")
    @Results({@Result(column = "NATION_ID", property = "nationId"),
            @Result(column = "NATION_NAME", property = "nationName")})
    List<EmParkNation> findAll();

    @Select("select * from em_park_nation where nation_id = #{nationId}")
    @Results({@Result(column = "NATION_ID", property = "nationId"),
            @Result(column = "NATION_NAME", property = "nationName")})
    EmParkNation getById(String nationId);

}
