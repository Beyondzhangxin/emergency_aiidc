package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.aiidc.sps.ep.entity.EmHazardChenical;
import com.aiidc.sps.ep.parameter.EmHazardChenicalQueryEntity;
import com.aiidc.sps.ep.sqlProvider.EmHazardSqlProvider;

@Mapper
public interface EmHazardChenicalMapper {

	@SelectProvider(type=EmHazardSqlProvider.class,method="findEmHazardChenicalListSql")
	@Results({
		@Result(property="chineseName",column="chinese_name"),
		@Result(property="englishName",column="english_name"),
		@Result(property="casCode",column="cas_code")
	})
	public List<EmHazardChenical> findEmHazardChenicalList(EmHazardChenicalQueryEntity queryEntity);
	
	@SelectProvider(type=EmHazardSqlProvider.class,method="getEmHazardChenicalCount")
	public Integer findCountForEmHazardChenical(EmHazardChenicalQueryEntity queryEntity);
	
	@Select("select * from em_park_hazard_chemical where id =#{id}")
	@Results({
		@Result(property="chineseName",column="chinese_name"),
		@Result(property="englishName",column="english_name"),
		@Result(property="casCode",column="cas_code"),
		@Result(property="content",column="content")
	})
	public EmHazardChenical findEmHazardById(int id);
	
	@Delete("delete from em_park_hazard_chemical where id =#{id}")
	public void deleteEmHazardById(int id);
	
	@Select("select SEQ_EM_PHC.nextval from dual")
	public int getEmHazardId();
	
	@Insert("insert into em_park_hazard_chemical(id,chinese_name,english_name,cas_code,content)"
			+ "values(#{id},#{chineseName},#{englishName},#{casCode},#{content})")
	@Options(useGeneratedKeys=false,keyColumn="id",keyProperty="id")
	public void addEmHazard(EmHazardChenical emHazard);
	
	@Update("update em_park_hazard_chemical set chinese_name=#{chineseName},english_name=#{englishName},"
			+ "content=#{content},cas_code=#{casCode} where id=#{id}")
	@Options(useGeneratedKeys=false)
	public void updateEmHazard(EmHazardChenical emHazard);
}
