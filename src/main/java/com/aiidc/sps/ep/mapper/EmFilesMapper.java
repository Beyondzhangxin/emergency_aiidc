package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aiidc.sps.ep.entity.EmFileContent;
import com.aiidc.sps.ep.entity.EmFileForSave;
import com.aiidc.sps.ep.entity.EmParkImportantLibrary;

@Mapper
public interface EmFilesMapper{
		
	@Select( "select * from EM_PARK_IMPORTANT_LIBRARY")
	@Results({
		@Result(property="fileId",column="FILE_ID"),
		@Result(property="fileName",column="FILE_NAME"),
		@Result(property="fileSize",column="FILE_SIZE"),
		@Result(property="uploadDate",column="UPLOAD_DATE")
	})
	public List<EmParkImportantLibrary> getAllEmParkImportantLibrary();
	
	@Select( "select * from (select rownum rn,t.* from EM_PARK_IMPORTANT_LIBRARY t) a where a.rn> #{arg0} and a.rn<=#{arg1}")
	@Results({
		@Result(property="fileId",column="FILE_ID"),
		@Result(property="fileName",column="FILE_NAME"),
		@Result(property="fileSize",column="FILE_SIZE"),
		@Result(property="uploadDate",column="UPLOAD_DATE")
	})
	public List<EmParkImportantLibrary> getEmFilePagelist(int start,int end);
	
	@Select( "select * from (select rownum rn,t.* from EM_PARK_IMPORTANT_LIBRARY t where file_name like '%'||#{arg0}||'%') a where a.rn> #{arg1} and a.rn<=#{arg2}")
	@Results({
		@Result(property="fileId",column="FILE_ID"),
		@Result(property="fileName",column="FILE_NAME"),
		@Result(property="fileSize",column="FILE_SIZE"),
		@Result(property="uploadDate",column="UPLOAD_DATE")
	})
	public List<EmParkImportantLibrary> getEmFilePagelistByFileName(String fileName,int start,int end);
	
	@Select( "select count(*) from  EM_PARK_IMPORTANT_LIBRARY")
	public int getEmFilesTotal();
	
	@Select( "select count(*) from  EM_PARK_IMPORTANT_LIBRARY where file_name like '%'||#{fileName}||'%'")
	public int getEmFilesTotalByFileName(String fileName );
	
	@Select( "select file_id,file_name,content from  EM_PARK_IMPORTANT_LIBRARY where file_id=#{fileId}")
	@Results({
		@Result(property="fileId",column="FILE_ID"),
		@Result(property="fileName",column="FILE_Name")
		
	})
	public EmFileContent getFileContent(int fileId);
	
	@Select("select SEQ_EM_FILE.nextval from dual")
	public int genEmFileId();
	
	@Insert("insert into EM_PARK_IMPORTANT_LIBRARY(file_id,file_name,file_size,uploader,upload_date,content) values(#{fileId},#{fileName},#{fileSize},#{uploader},#{uploadDate},#{content})")
	@Options(useGeneratedKeys=false,keyColumn="FILE_ID",keyProperty="fileId")
	public void addEmFile(EmFileForSave emFile);
}
