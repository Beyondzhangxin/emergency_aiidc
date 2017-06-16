<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
	<title>企业信息详细</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script type="text/javascript" src="../laydate/laydate.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">企业信息详细</span>
            <span class="btnbox">
            <a class="btn2 btn_close" href="javascript:window.close();"">关闭</a>
            <a class="btn2 btn_refresh" href="">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>
        <!--物资详细页-->
        <form class="registerform">
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
   			<tr>
                <td width="20%" class="txtright"><b class="must">*</b>企业名称：</td>
                <td width="30%"><input type="text" class="txtinput conpName" value="${enterprise.name}"></td>
            </tr>
        </table>
        </form>
    </div>
</div>
</body>
</html>