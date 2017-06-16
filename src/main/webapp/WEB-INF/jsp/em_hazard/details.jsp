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
	<title>园区危险化学品库详情页</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script type="text/javascript" src="../js/Validform_v5.3.2.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
<form class="registerform" action="" >
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">危险化学品库详细</span>
            <span class="btnbox">
             <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_save" value="保存并关闭">
                <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>
        <!--危险化学品详细页-->
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>中文名称
                </td>
                <td width="30%">
                    <input type="text" class="txtinput chineseName" name="chineseName"  datatype="zh"  nullmsg="请输入中文名称"  errormsg="请输入汉字！" >
                </td>
                
                <td width="20%" class="txtright">
                    <b class="must">*</b>英文名称
                </td>
                <td width="30%">
                    <input type="text" class="txtinput englishName" name="englishName"  datatype="en"  nullmsg="请输入英文名称"  errormsg="请输入英文！" >  
                      <input type="text" name="id" class="hazardId"  readonly="readonly">  
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>CAS号
                </td>
                <td width="30%"><input type="text" class="txtinput casCode" name="casCode" datatype="n"  nullmsg="请输入CAS号"  errormsg="请输入数字！" ></td>
                
                <td width="20%" class="txtright">
                    <b class="must">*</b>内容
                </td>
                <td width="30%"><input type="text" class="txtinput content" name="content" datatype="*"  nullmsg="请输入内容"  errormsg="请输入内容！" ></td>
            </tr>
        </table>
    </div>
    </form>
</div>

<script>
//编辑
var detailsUrl=window.location.search;
if(detailsUrl.indexOf("=")>0){    //这里是详情页的处理js
	var id = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	$.ajax({
		type:'get',
		url:'getEmHazardChenicalByCasCode.do',
		data:{id:id},
		success:function(data){
			if(0000000==data.status){
				var innerContatc = data.rows[0];
				$('.chineseName').val(innerContatc.chineseName);
				$('.englishName').val(innerContatc.englishName);
				$('.casCode').val(innerContatc.casCode);
				$('.content').val(innerContatc.content);
				$('.hazardId').val(innerContatc.id);
			}else{
				alert(data.message);
			}
		},
		error:function(data){
			alert(data.message);
		}
	});
	
	//编辑
	$("form").attr('action',"updateEmHazard.do");
	$(".registerform:eq(0)").Validform({
		ajaxPost:true,
		datatype:{
			"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
			"en":/^[A-Za-z]{1,20}$/

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
	$(".content_title_form").html("危险化学品库添加");
	//添加
	$("form").attr('action',"addEmHazard.do");
			$(".hazardId").remove();
			$(".registerform:eq(0)").Validform({
				ajaxPost:true,
				tiptype:1,
				datatype:{
					"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
					"en":/^[A-Za-z]{1,20}$/
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


</script>
</body>
</html>