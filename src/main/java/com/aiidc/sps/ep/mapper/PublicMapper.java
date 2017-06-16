package com.aiidc.sps.ep.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.aiidc.sps.ep.entity.Area;
import com.aiidc.sps.ep.entity.EmAttcahment;
import com.aiidc.sps.ep.entity.EmImage;
import com.aiidc.sps.ep.sqlProvider.PublicSqlProvider;

@Mapper
public interface PublicMapper {
	
	/**
	 * 	查询全国所有省份
	 * @return
	 */
	@Select("select * from area where county_id=00 and city_id=00")
	@Results({
		@Result(property="areaId",column="area_id"),
		@Result(property="areaName",column="area_nm"),
		@Result(property="fullName",column="full_nm"),
		@Result(property="provId",column="prov_id"),
		@Result(property="cityId",column="city_id"),
		@Result(property="countyId",column="county_id")
	})
	public List<Area> findAllPro();
	
	/**
	 * 查询某省份下的所有市区县
	 * @param cityId
	 * @param countyId
	 * @param provId
	 * 		省份provId不能为null
	 * @return
	 */
	@SelectProvider(type=PublicSqlProvider.class,method="findAreaSql")
	@Results({
		@Result(property="areaId",column="area_id"),
		@Result(property="areaName",column="area_nm"),
		@Result(property="fullName",column="full_nm"),
		@Result(property="provId",column="prov_id"),
		@Result(property="cityId",column="city_id"),
		@Result(property="countyId",column="county_id")
	})
	public List<Area> findArea(Map<String, Object> map);
	
	
	@Select("select SEQ_EM_I.nextval from dual")
	public int getImageId();
	
	@Insert("insert into em_image(image_id,image_content,library_code,doc_id) "
			+ " values(#{imageId},#{imageContent},#{libraryCode},#{docId})")
	@Options(useGeneratedKeys=false,keyColumn="image_id",keyProperty="imageId")
	public void addImage(EmImage emImage);
	
	@Select("select * from em_image where image_id= #{imageId}")
	@Results({
		@Result(property="imageId",column="IMAGE_ID"),
		@Result(property="libraryName",column="LIBRARY_NAME"),
		@Result(property="docId",column="DOC_ID"),
		@Result(property="imageContent",column="IMAGE_CONTENT")
	})
	public EmImage findImageById(int imageId);
	
	@Select("select SEQ_EM_A.nextval from dual")
	public int getAttcahmentId();
	
	@Insert("insert into em_attachment(attachment_id,attachment_content,attachment_name,library_code,doc_id) "
			+ " values(#{attachmentId},#{attachmentContent},#{attachmentName},#{libraryCode},#{docId})")
	@Options(useGeneratedKeys=false,keyColumn="attachment_id",keyProperty="attachmentId")
	public void addAttachment(EmAttcahment emAttachment);
	
	@Select("select * from em_attachment where attachment_id= #{attachmentId}")
	@Results({
		@Result(property="attachmentId",column="attachment_id"),
		@Result(property="libraryName",column="library_name"),
		@Result(property="docId",column="doc_id"),
		@Result(property="attachmentContent",column="attachment_content"),
		@Result(property="attachmentName",column="attachment_name")
	})
	public EmAttcahment findAttachmentById(int attachmentId);
	
	@Delete("delete from em_image where LIBRARY_CODE =#{arg0} and DOC_ID=#{arg0}")
	public void deleteEmImage(String libraryCode,int standardId);
	
	@Delete("delete from em_attachment where LIBRARY_CODE =#{arg0} and DOC_ID=#{arg0}")
	public void deleteEmAttachment(String libraryCode,int standardId);
}















