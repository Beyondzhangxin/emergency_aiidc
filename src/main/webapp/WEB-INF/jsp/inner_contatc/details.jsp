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
	<title>企业内部通讯录详情页</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script type="text/javascript" src="../js/Validform_v5.3.2.js"></script>
</head>
<!--内容区-->
<body>
<div class="mainbox">
  <!--内部通讯录详细页-->
<form class="innerForm" action="" >
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">内部通讯录详细</span>
            <span class="btnbox">
            <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_save" value="保存并关闭">
            <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>联系人
                </td>
                <td width="30%">
                    <input type="text" class="txtinput contacts" name="contacts"  datatype="zh"  tip="请输入联系人姓名"  errormsg="请输入汉字！" >
                </td>
                
                <td width="20%" class="txtright">
                   <b class="must">*</b> 单位名称
                </td>
                <td width="30%">
                    <input type="text" class="txtinput companyName" name="companyName"  datatype="*"  tip="请输入单位名称"  errormsg="请输入单位名称！" >
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                	<b class="must">*</b>部门
                </td>
                <td width="30%"><input type="text" class="txtinput department" name="department"  datatype="*"  tip="请输入部门"  errormsg="请输入部门！" ></td>
                
                <td width="20%" class="txtright">
                   <b class="must">*</b> 职务
                </td>
                <td width="30%"><input type="text" class="txtinput post" name="post"  datatype="*"  tip="请输入职务"  errormsg="请输入职务！"  ></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>办公电话
                </td>
                <td width="30%"><input type="text" class="txtinput telephone" name="telephone"  datatype="tel"  tip="请输入办公电话"  errormsg="格式有误，正确格式：000-12345678！" ></td>
                
                <td width="20%" class="txtright">
                    <b class="must">*</b>移动电话
                </td>
                <td width="30%"><input type="text" class="txtinput mobilePhone" name="mobilePhone" datatype="phone"  tip="请输入移动电话"  errormsg="请输入正确的手机号码！" ></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    家庭电话
                </td>
                <td width="30%"><input type="text" class="txtinput homePhone" name="homePhone"  ></td>
                
                <td width="20%" class="txtright">传真</td>
                <td width="30%"><input type="text" class="txtinput fax" name="fax"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>电子邮箱
                </td>
                <td width="30%"><input type="text" class="txtinput email" name="email" datatype="e"  tip="请输入电子邮箱"  errormsg="电子邮箱格式有误！" ></td>
                
                <td width="20%" class="txtright">微信</td>
                <td width="30%"><input type="text" class="txtinput wechat" name="wechat"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    QQ
                </td>
                <td width="30%" colspan="3">
                	<input type="text" class="txtinput qq" name="qq">
                	<input type="text" class="innerId" name="id" readonly="readonly">
                
                </td>
            </tr>
        </table>
  
    </div>
       </form>
</div>

<script>
var detailsUrl=window.location.search;
if(detailsUrl.indexOf("=")>0){    //这里是详情页的处理js
	var id = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	$.ajax({
		type:'get',
		url:'findInnerContatcById.do',
		data:{id:id},
		success:function(data){
			if(0000000==data.status){
				var innerContatc = data.rows[0];
				$('.companyName').val(innerContatc.companyName);
				$('.qq').val(innerContatc.qq);
				$('.contacts').val(innerContatc.contacts);
				$('.department').val(innerContatc.department);
				$('.email').val(innerContatc.email);
				$('.fax').val(innerContatc.fax);
				$('.homePhone').val(innerContatc.homePhone);
				$('.mobilePhone').val(innerContatc.mobilePhone);
				$('.post').val(innerContatc.post);
				$('.telephone').val(innerContatc.telephone);
				$('.wechat').val(innerContatc.wechat);
				$('.innerId').val(innerContatc.id);
			}else{
				alert(data.message);
			}
		},
		error:function(data){
			alert(data.message);
		}
	});
	
	//编辑
	$("form").attr('action',"updateInnerContatc.do");
	$(".innerForm:eq(0)").Validform({
		ajaxPost:true,
		datatype:{
			"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
			"tel":/^(0\d{2,3}-\d{7,8})$/,
			"phone":/^(1[3458]\d{9})$/

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
	//添加
	$("form").attr('action',"saveInnerContatc.do");
			$(".innerId").remove();
			$(".innerForm:eq(0)").Validform({
				ajaxPost:true,
				tiptype:1,
				datatype:{
					"zh" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{1,10}$/,
					"tel":/^(0\d{2,3}-\d{7,8})$/,
					"phone":/^(1[3458]\d{9})$/
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