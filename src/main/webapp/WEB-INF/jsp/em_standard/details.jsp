<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html>
<head>
	<title>标准规范库详情</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="../js/Validform_v5.3.2.js"></script>
</head>
<body>

    <!-- 实例化编辑器 -->
    <script type="text/javascript">
	    var ue = UE.getEditor('myEditor', {
	        autoHeightEnabled: true,
	        autoFloatEnabled: true
	    });
	    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	    UE.Editor.prototype.getActionUrl = function(action) {
	    	var standardId=$(".standardId").val();
	    	if (action == 'uploadimage') {
	    		 //图片上传
	             return 'http://localhost:8080/em/pub/uploadImage.do?libraryCode=1001&standardId='+standardId;
	         }if(action == 'uploadfile'){
	        	//附件上传
	        	 return 'http://localhost:8080/em/pub/uploadfile.do?libraryCode=1001&standardId='+standardId;
	         }else {
	             return this._bkGetActionUrl.call(this, action);
	         }
	    }
    </script>
<!--内容区-->
        <!--标准规范库详细页-->
<div class="mainbox">
<form class="standardForm" action="" >
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">标准规范库详细</span>
            <span class="btnbox">
             <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_save" value="保存并关闭">
                <a class="btn2 btn_refresh" href="">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>

        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
               <td width="20%" class="txtright">
                    <b class="must">*</b>名称
                </td>
                <td width="30%">
                    <input type="text" class="txtinput name" name="name" datatype="*"  nullmsg="请输入名称"  errormsg="请输入名称！"  >
                    <input type="text" class="standardId" name="id"  readonly="readonly">
                </td>
                
                <td width="20%" class="txtright">
                    <b class="must">*</b>颁布部门
                </td>
                <td width="30%">
                    <input type="text" class="txtinput pubDepartment" name="pubDepartment" datatype="*"  nullmsg="请输入颁布部门"  errormsg="请输入颁布部门！"  >
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>颁布日期
                </td>
                <td width="30%">
                	<input type="text" class="txtinput pubDateStr" name="pubDate" id="publishDate" datatype="date" nullmsg="日期格式不正确" >
                </td>
                
                <td width="20%" class="txtright">
                    <b class="must">*</b>施行日期
                </td>
                <td width="30%">
                	<input type="text" class="txtinput impDateStr" name="impDate" id="implementDate" datatype="date" nullmsg="日期格式不正确" >
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    正文
                </td>
                <td width="60%" colspan="3" style="padding-right:13.5%">
                		<textarea id="myEditor" style="width:100%" name="content" class="content"  datatype="*" nullmsg="请填写文章内容" >
								
						</textarea>
                </td>
             </tr>
                             
        </table>
     
        </div>
           </form>
</div>    
 <script>
 //日期
laydate({
	  elem: '#publishDate', 
	  event: 'focus'
});
laydate({
	  elem: '#implementDate', 
	  event: 'focus'
});
</script>
    <script type="text/javascript">
     //显示详情   
       var detailsUrl=window.location.search;
if(detailsUrl.indexOf("=")>0){    //这里是详情页的处理js
	var id = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	$.ajax({
		type:'get',
		url:'findEmStandardById.do',
		data:{id:id},
		success:function(data){
			if(0000000==data.status){
				var innerContatc = data.data[0];
				$('.name').val(innerContatc.name);
				$('.pubDepartment').val(innerContatc.pubDepartment);
				$('.pubDateStr').val(innerContatc.pubDateStr);
				$('.impDateStr').val(innerContatc.impDateStr);
				$('.standardId').val(innerContatc.id);
				var content=innerContatc.content;
				ue.ready(function() {
					ue.setContent(content);
					var ueContent=ue.getContentTxt();
					console.log(ueContent);
				})
	
			}else{
				alert(data.message);
			}
		},
		error:function(data){
			alert(data.message);
		}
	});

	//编辑
	$("form").attr('action',"updateEmStandard.do");
	$(".standardForm:eq(0)").Validform({
		ajaxPost:true,
		datatype:{
			"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
			"date":/^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/
		},
		callback:function(data){
			if(data.status=="0000000"){
				setTimeout(function(){
					$.Hidemsg();
					$.Showmsg("保存成功");
				},1000);
			}
		}
	});
}else{
	$(".content_title_form").html("内部通讯录添加");
	$.ajax({
		type:'post',
		url:'getEmStandardId.do',
		success:function(data){
			$('.standardId').val(data);
		},
		error:function(data){
			alert(data.message);
		}
	});
	//添加
	$("form").attr('action',"saveEmStandard.do");
			$(".standardForm:eq(0)").Validform({
				ajaxPost:true,
				tiptype:1,
				datatype:{
					"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
					"date":/^((?:19|20)\d\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/
				},
				callback:function(data){
					if(data.status=="0000000"){
						setTimeout(function(){
							$.Hidemsg();
							$.Showmsg("保存成功");
						},1000);
					}
				}
			});
}	
	
	/*
	//编辑
	$(".btn_save").click(function(){
	//	var id = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	//	var dataList =$.param({'id':id}) + '&' + $('form').serialize();
	var dataList=$('form').serialize();
		console.log(dataList);
		$.ajax({
			type:"post",
			url:'updateEmStandard.do',
			data:dataList,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		})
	})
}else{
	$(".content_title_form").html("标准规范库添加")
	$.ajax({
			type:'post',
			url:'getEmStandardId.do',
			success:function(data){
				$('.id').val(data);
			},
			error:function(data){
				alert(data.message);
			}
		});
	//添加
	function savaSpec(){
		var dataList =$('form').serialize();
		console.log(dataList);
		$.ajax({
			type:'post',
			url:'saveEmStandard.do',
			dataType:'json',
			data:dataList,
			success:function(data){
				console.log(data);
			}
		})
	}
}
	*/
    </script>
                		


</body>
</html>
