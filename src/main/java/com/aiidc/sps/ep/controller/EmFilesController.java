package com.aiidc.sps.ep.controller;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aiidc.base.ActionInfo;
import com.aiidc.base.ControllerInfo;
import com.aiidc.sps.ep.entity.EmFileContent;
import com.aiidc.sps.ep.services.EmFilesService;

@Controller
@RequestMapping("em_files")
@ControllerInfo(order=100,value="重要文件库")
public class EmFilesController 
{
	
	@Autowired
	private EmFilesService emFileService;
	
	@RequestMapping("list")
	@ActionInfo(name="重要文件列表",access=06,index=0)
	public ModelAndView list(
			@RequestParam(value="fileName",required=false) String fileName,
			@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
			@RequestParam(value="rows",required=false,defaultValue="10") int rows)
	throws Exception
	{
		ModelAndView mv = new ModelAndView();
		int start = rows * (pageNum-1);
		int end   = rows   * pageNum;
		Map<String,Object> model = mv.getModel();
		if(fileName!=null&&fileName.length()>0)
		{
			model.put("total", emFileService.getFileTotal(fileName));
			model.put("emFileList", emFileService.getFilesPageList(fileName,start,end));
		}else{
			model.put("total", emFileService.getFileTotal());
			model.put("emFileList", emFileService.getFilesPageList(start,end));
		}
		mv.setViewName("em_files/list");
		return mv;
	}
	
	
	
	@RequestMapping(value="downloadFile",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	@ActionInfo(name="下载文件内容",access=06,index=1)
	public ResponseEntity<byte[]> downloadFile(@RequestParam("fileId") int fileId)
	throws Exception
	{
		HttpHeaders headers = new HttpHeaders();    
        EmFileContent fileContent = emFileService.getFileContent(fileId);
        String fileName = fileContent.getFileName();
        fileName = new String(fileName.getBytes(),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(fileContent.getContent(),    
                                          headers, HttpStatus.CREATED); 
		
	}
	
	@RequestMapping("uploadInput")
	@ActionInfo(name="涮串文件录入页面",access=06,index=2)
	public String uploadInput()
	{
		return "em_files/uploadInput";
	}
	
	@RequestMapping("upload")
	@ActionInfo(name="文件上传",access=06,index=3)
	public ModelAndView upload(@RequestParam(name="file") MultipartFile file,Authentication p)
	throws Exception
	{
		emFileService.saveFile(p.getName(), file);
		return list(null,1, 10);
	}
	
	@RequestMapping(value="downloadMutiFile",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	@ActionInfo(name="下载文件内容",access=06,index=4)
	public ResponseEntity<byte[]> downloadMutiFile(@RequestParam("fileId") int fileId[])
	throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(bos);
		
		for (int i = 0; i < fileId.length; i++) {
			
			EmFileContent fileContent = emFileService.getFileContent(fileId[i]);
			ZipEntry ze = new ZipEntry(fileContent.getFileName());
			zos.putNextEntry(ze);
			zos.write(fileContent.getContent());
			
			zos.closeEntry();
		}
        zos.close();
        String fileName = "重要文件.zip";
        fileName = new String(fileName.getBytes(),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(bos.toByteArray(),    
                                          headers, HttpStatus.CREATED); 
		
	}
	
	@RequestMapping(value="dispImage")
	@ResponseBody
	@ActionInfo(name="下载文件内容",access=06,index=6)
	public ResponseEntity<byte[]> dispImage(@RequestParam("fileId") int fileId)
	throws Exception
	{
		HttpHeaders headers = new HttpHeaders();    
        EmFileContent fileContent = emFileService.getFileContent(fileId);
//        String fileName = fileContent.getFileName();
//        fileName = new String(fileName.getBytes(),"ISO-8859-1");
//        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.parseMediaType("image/jpeg"));   
        return new ResponseEntity<byte[]>(fileContent.getContent(),    
                                          headers, HttpStatus.CREATED); 
		
	}
}