package com.aiidc.sps.ep.services;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.EmFileContent;
import com.aiidc.sps.ep.entity.EmFileForSave;
import com.aiidc.sps.ep.entity.EmParkImportantLibrary;
import com.aiidc.sps.ep.mapper.EmFilesMapper;




@Service
public class EmFilesService {

	
	
	
	@Autowired
	private EmFilesMapper mapper;
	
	
	public List<EmParkImportantLibrary> getAllFiles(){
		return mapper.getAllEmParkImportantLibrary();
	}
	
	
	public List<EmParkImportantLibrary> getFilesPageList(int start,int end)
	{
		return mapper.getEmFilePagelist(start, end);
	}
	
	public List<EmParkImportantLibrary> getFilesPageList(String fileName,int start,int end)
	{
		return mapper.getEmFilePagelistByFileName(fileName, start, end);
	}
	
	public int getFileTotal()
	{
		return mapper.getEmFilesTotal();
	}
	
	public int getFileTotal(String fileName)
	{
		return mapper.getEmFilesTotalByFileName(fileName);
	}
	
	public JSONArray getAllFilesJson()
	throws Exception
	{
		return BeanUtils.describeToJson(getAllFiles());
	}
	
	public JSONArray getFilesPageListJson(int start,int end)
	throws Exception
	{
		return BeanUtils.describeToJson(getFilesPageList(start,end));
	}
	
	public JSONArray getFilesPageListJson(String fileName,int start,int end)
	throws Exception
	{
		return BeanUtils.describeToJson(getFilesPageList(fileName,start,end));
	}
	
	
	public EmFileContent getFileContent(int fileId)
	throws Exception
	{
		return mapper.getFileContent(fileId);
	}
	
	
	public void saveFile(String userName,MultipartFile file)
	throws Exception
	{
		EmFileForSave emFile = new EmFileForSave();
		emFile.setFileId(mapper.genEmFileId());
		emFile.setFileName(file.getOriginalFilename());
		emFile.setFileSize(file.getSize());
		emFile.setUploadDate(new Date());
		emFile.setContent(file.getBytes());
		emFile.setUploader(userName);
		mapper.addEmFile(emFile);
	}
	
	
}
