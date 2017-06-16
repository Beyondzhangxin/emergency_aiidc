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

import com.aiidc.sps.ep.entity.InnerContatc;
import com.aiidc.sps.ep.parameter.InnerContatcQueryEntity;
import com.aiidc.sps.ep.sqlProvider.InnerContatcSqlProvider;

@Mapper
public interface InnerContatcMapper {
	
	@SelectProvider(type=InnerContatcSqlProvider.class,method="getInnerContaticCountSql")
	public Integer getInnerContaticCount(InnerContatcQueryEntity innerContatcQueryEntity);
	
	@SelectProvider(type=InnerContatcSqlProvider.class,method="getInnerContatcListSql")
	@Results({
		@Result(property="companyName",column="company_name"),
		@Result(property="mobilePhone",column="mobile_phone"),
		@Result(property="homePhone",column="home_phone"),
		@Result(property="changeTime",column="change_time"),
	})
	public List<InnerContatc> getInnerContatcList(InnerContatcQueryEntity innerContatcQueryEntity);
	
	@Select("select * from em_park_contacts where id=#{id}")
	@Results({
		@Result(property="companyName",column="company_name"),
		@Result(property="mobilePhone",column="mobile_phone"),
		@Result(property="homePhone",column="home_phone"),
		@Result(property="changeTime",column="change_time"),
	})
	public List<InnerContatc> getInnerContatcById(int id);
	
	@Delete("delete from em_park_contacts where id =#{id}")
	public void deleteInnerContatcById(int id);
	
	@Select("select SEQ_EM_PC.nextval from dual")
	public int getInnerContatcId();
	
	@Insert("insert into em_park_contacts"
			+ " (id,contacts,company_name,department,post,telephone,mobile_phone,home_phone,fax,email,wechat,qq,change_time)"
			+ " values"
			+ " (#{id},#{contacts},#{companyName}, #{department},#{post,jdbcType=VARCHAR},#{telephone},"
			+ " #{mobilePhone},#{homePhone,jdbcType=VARCHAR},#{fax,jdbcType=VARCHAR},"
			+ " #{email},#{wechat,jdbcType=VARCHAR},#{qq,jdbcType=VARCHAR},#{changeTime})")
	@Options(useGeneratedKeys=false,keyColumn="id",keyProperty="id")
	public void addInnerContatc(InnerContatc innerContatc);
	
	@Update("update em_park_contacts set contacts=#{contacts},company_name=#{companyName},department=#{department},"
			+ "post=#{post,jdbcType=VARCHAR},telephone=#{telephone},mobile_phone=#{mobilePhone},"
			+ "home_phone=#{homePhone,jdbcType=VARCHAR},fax=#{fax,jdbcType=VARCHAR},email=#{email},"
			+ "wechat=#{wechat,jdbcType=VARCHAR},qq=#{qq,jdbcType=VARCHAR},change_time=sysdate where id=#{id}")
	@Options(useGeneratedKeys=false)
	public void updateContatc(InnerContatc innerContatc);
	
	
	
	
	
	
	
	
	
	
	
}
