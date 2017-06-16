package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aiidc.sps.ep.entity.EmStandard;

@Mapper
public interface EmStandardMapper {

	@Select("select * from ("
			+ " select rownum rn,t.* from ("
			+ " select * from em_park_standard_spec order by publis_date desc)t) "
			+ "where rn between #{arg0} and #{arg1}")
	@Results({@Result(property="pubDepartment",column="publish_department"),
		@Result(property="impDate",column="implement_date"),
		@Result(property="pubDate",column="publis_date")})
	public List<EmStandard> findEmStandList(int begin,int end);
	
	@Select("select count(*) from em_park_standard_spec ")
	public Integer getTotalToEmStandList();
	
	
	@Select("select * from ("
			+ " select rownum rn,t.* from ("
			+ " select * from em_park_standard_spec where name like '%'||#{arg2}||'%' order by publis_date desc)t) "
			+ " where rn between #{arg0} and #{arg1}")
	@Results({@Result(property="pubDepartment",column="publish_department"),
		@Result(property="impDate",column="implement_date"),
		@Result(property="pubDate",column="publis_date")})
	public List<EmStandard> findEmStandListByName(int begin,int end,String name);
	
	@Select("select count(*) from em_park_standard_spec t where t.name like '%'||#{arg0}||'%' ")
	public Integer getTotalToEmStandListByName(String name);
	
	@Select("select * from ("
			+ " select rownum rn,t.* from("
			+ " select * from em_park_standard_spec where publish_department like '%'||#{arg2}||'%' order by publis_date desc)t) "
			+ " where rn between #{arg0} and #{arg1}")
	@Results({@Result(property="pubDepartment",column="publish_department"),
		@Result(property="impDate",column="implement_date"),
		@Result(property="pubDate",column="publis_date")})
	public List<EmStandard> findEmStandListByDepartment(int begin,int end,String pubDepartment);
	
	@Select("select count(*) from em_park_standard_spec t where t.publish_department like '%'||#{arg0}||'%' ")
	public Integer getTotalToEmStandListByDepartment(String pubDepartment);
	
	@Select("select * from ("
			+ " select rownum rn,t.* from ("
			+ " select * from em_park_standard_spec where name like '%'||#{arg2}||'%' and publish_department like '%'||#{arg3}||'%' "
			+ " order by publis_date desc)t) "
			+ " where rn between #{arg0} and #{arg1}")
	@Results({@Result(property="pubDepartment",column="publish_department"),
		@Result(property="impDate",column="implement_date"),
		@Result(property="pubDate",column="publis_date")})
	public List<EmStandard> findEmStandListByNameAndDepartment(int begin,int end,String name,String pubDepartment);
	
	@Select("select count(*) from em_park_standard_spec t where t.name like '%'||#{arg0}||'%' and t.publish_department like '%'||#{arg1}||'%' ")
	public Integer getTotalToEmStandListByNameAndDepartment(String name,String pubDepartment);
	
	@Select("select * from em_park_standard_spec where id=#{id} ")
	@Results({
		@Result(property="pubDepartment",column="publish_department"),
		@Result(property="impDate",column="implement_date"),
		@Result(property="pubDate",column="publis_date")})
	public EmStandard findEmStandardById(int id);
	
	
	@Delete("delete from em_park_standard_spec where id =#{id}")
	public void deleteEmStandardById(Integer id);
	
	@Update("update em_park_standard_spec set name=#{name},publish_department=#{pubDepartment},"
			+ "publis_date=#{pubDate},implement_date=#{impDate},content=#{content}"
			+ "where id=#{id}")
	@Options(useGeneratedKeys=false)
	public void updateEmStandard(EmStandard emStandard);
	
	@Insert("insert into em_park_standard_spec(name,publish_department,publis_date,implement_date,content,id)"
			+ " values(#{name},#{pubDepartment},#{pubDate},#{impDate},#{content},#{id})")
	@Options(useGeneratedKeys=false,keyColumn="id",keyProperty="id")
	public void addEmStandard(EmStandard emStandard);
	
	@Select("select SEQ_EM_PSS.nextval from dual")
	public Integer getEmStandardId();
	
}











