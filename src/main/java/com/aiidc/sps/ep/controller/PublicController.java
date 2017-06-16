package com.aiidc.sps.ep.controller;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.AiidcException;
import com.aiidc.base.ControllerInfo;
import com.aiidc.base.ControllerUtils;
import com.aiidc.sps.ep.entity.EmAttcahment;
import com.aiidc.sps.ep.entity.EmImage;
import com.aiidc.sps.ep.services.PublicService;

@Controller
@RequestMapping("pub")
@ControllerInfo(order=10,value="公共方法")
public class PublicController {
	
	@Autowired
	private PublicService pubService;

	@ActionInfo(name="获取全国的所有身份",access=07,index=0)
	@RequestMapping(value="getAllProvince",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getAllProvince() 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		JSONArray jarr =pubService.findAllProvince();
		JSONObject json = ControllerUtils.buildSuccessJson();
		return json.put("data", jarr).toString();
	}
	
	
	/**
	 * 查询指定省份下：市、区、县
	 * 前端：省、市、区（县）的选择必须是级联操作
	 * @param provId
	 * @param cityId
	 * @param countyId
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@ActionInfo(name="获取指定省份下的市、区、县",access=07,index=1)
	@RequestMapping(value="getArea",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getArea(String provId ,String cityId ,String countyId) 
	throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		JSONArray jarr;
		try {
			jarr = pubService.findArea(provId, cityId, countyId);
		} catch (AiidcException e) {
			return  ControllerUtils.buildFailureJson(e).toString();
		}
		JSONObject json = ControllerUtils.buildSuccessJson();
		return json.put("data", jarr).toString();
	}
	
	
	@ActionInfo(name="获取指定省份下的市、区、县",access=07,index=2)
	@RequestMapping(value="error")
	public String error() 
	throws Exception
	{
		return "error";
	}
	
	/**
	 * 上传图片至数据库
	 * @param upfile
	 * 		upfile是config.json中图片提交的表单名称
	 * @param request
	 * @throws Exception 
	 */
	@ActionInfo(name="图片上传",access=07,index=3)
	@RequestMapping(value="uploadImage",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String uploadImage(@RequestParam("upfile")  CommonsMultipartFile upfile,
			@RequestParam("libraryCode") String libraryCode,@RequestParam("standardId") int standardId) 
	throws Exception
	{
		JSONObject json = new JSONObject();
		EmImage emImage = new EmImage();
		int emImageId = pubService.getImageId();
		emImage.setImageId(emImageId);
		emImage.setImageContent(upfile.getBytes());
		emImage.setDocId(standardId);
		emImage.setLibraryCode(libraryCode);
		pubService.addImage(emImage);
		//是否上传成功
		json.put("state", "SUCCESS");
        //现在文件名称
		json.put("title", upfile.getOriginalFilename());
        //文件原名称 
		json.put("original", upfile.getOriginalFilename());
		//文件路径
		json.put("url", "../pub/dispImage.do?imageId="+emImageId);
		return json.toString();
	}
	
	@RequestMapping(value="dispImage")
	@ResponseBody
	@ActionInfo(name="展现图片",access=07,index=4)
	public ResponseEntity<byte[]> dispImage(@RequestParam("imageId") int imageId) 
	throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		EmImage emImage = pubService.findEmImageById(imageId);
		headers.setContentType(MediaType.parseMediaType("image/jpeg"));
		return new ResponseEntity<byte[]>(emImage.getImageContent(),headers,HttpStatus.CREATED);
	}
	
	@ActionInfo(name="附件上传",access=07,index=5)
	@RequestMapping(value="uploadfile",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String uploadfile(@RequestParam("upfile")  CommonsMultipartFile upfile,
			@RequestParam("libraryCode") String libraryCode,@RequestParam("standardId") int standardId) 
	throws Exception
	{
		JSONObject json = new JSONObject();
		EmAttcahment emAtt = new EmAttcahment();
		int emAttId = pubService.getAttcahmentId();
		emAtt.setAttachmentId(emAttId);
		emAtt.setAttachmentContent(upfile.getBytes());
		emAtt.setAttachmentName(upfile.getOriginalFilename());
		emAtt.setLibraryCode(libraryCode);
		emAtt.setDocId(standardId);
		pubService.addAttachment(emAtt);
		//是否上传成功
		json.put("state", "SUCCESS");
        //现在文件名称
		json.put("title", upfile.getOriginalFilename());
        //文件原名称 
		json.put("original", upfile.getOriginalFilename());
		//文件路径
		json.put("url", "../pub/downloadFile.do?fileId="+emAttId);
		return json.toString();
	}
	
	@RequestMapping(value="downloadFile",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	@ActionInfo(name="下载附件",access=07,index=6)
	public ResponseEntity<byte[]> downloadFile(@RequestParam("fileId") int fileId)
	throws Exception
	{
		HttpHeaders headers = new HttpHeaders();    
		EmAttcahment emAtt  = pubService.findAttachmentById(fileId);
        String fileName = emAtt.getAttachmentName();
        fileName = new String(fileName.getBytes(),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(emAtt.getAttachmentContent(),headers, HttpStatus.CREATED); 
		
	}
	
}
