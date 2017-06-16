<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<head>
	<title>企业通讯录详细</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
</head>

<!--内容区-->
<div class="mainbox">
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">企业通讯录详细</span>
            <span class="btnbox">
                <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>
        <!--物资详细页-->
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright">
                    部门
                </td>
                <td width="30%">
                    <input type="text" class="txtinput department" name="department">
                </td>
                
                <td width="20%" class="txtright">
                    部门职责
                </td>
                <td width="30%">
                    <input type="text" class="txtinput departmentDuty" name="departmentDuty">
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                负责人
                </td>
                <td width="30%">
                    <input type="text" class="txtinput header" name="header">
                </td>
                
                <td width="20%" class="txtright">
                    职务
                </td>
                <td width="30%">
                    <input type="text" class="txtinput post" name="post">
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    办公电话
                </td>
                <td width="30%">
                    <input type="text" class="txtinput telephone" name="telephone">
                </td>
                
                <td width="20%" class="txtright">
                    移动电话
                </td>
                <td width="30%">
                    <input type="text" class="txtinput mobilePhone" name="mobilePhone">
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    传真
                </td>
                <td width="30%">
                	<input type="text" class="txtinput fax" name="fax">
                </td>
                
                <td width="20%" class="txtright">
                	电子邮箱
                </td>
                <td width="30%">
                	<input type="text" class="txtinput email" name="email">
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">
                    微信
                </td>
                <td width="30%">
                	<input type="text" class="txtinput wechat" name="wechat">
                </td>
                
                <td width="20%" class="txtright">QQ</td>
                <td width="30%">
                	<input type="text" class="txtinput QQ" name="QQ">
                </td>
            </tr>       
        </table>
    </div>
</div>

<script>
var detailsUrl=window.location.search;
if(detailsUrl.indexOf("=")>0){    //这里是详情页的处理js
	var companyId = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	$.ajax({
		type:'get',
		url:'emResourceContact.do',
		data:{companyId:companyId},
		success:function(data){
			var json = JSON.parse( data );	
			if(data.status="0000000"){
					$(".department").val(json.data.department);
					$(".departmentDuty").val(json.data.departmentDuty);
					$(".header").val(json.data.header);
					$(".post").val(json.data.post);
					$(".telephone").val(json.data.telephone);
					$(".mobilePhone").val(json.data.mobilePhone);
					$(".fax").val(json.data.fax);
					$(".email").val(json.data.email);
					$(".wechat").val(json.data.wechat);
					$(".QQ").val(json.data.qq);
			}else{
				alert(data.message);
			};
		},
		error:function(data){
			alert(data.message);
		}
	})
}else{
	//添加页处理js
} 
</script>