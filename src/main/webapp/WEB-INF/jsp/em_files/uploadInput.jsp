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
	<title>应急平台</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script>
	
	
	function uploadFile(){
		frmFileUpload.submit();
	}
	
	
</script>
</head>
<body>
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">应急物资装备详细</span>
            <span class="btnbox">
            <a class="btn2 btn_save" href="javascript:uploadFile()">保存</a>
            
            <br class="clearfix"/>
        </p>
        
        <form action="upload.do" method="post" enctype="multipart/form-data" name="frmFileUpload">  
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>选择文件
                </td>
                <td width="30%">
                    <input type="file" name="file">
                </td>
            </tr>
        </table>
        </form>
    </div>
</div>
    
 </body>
 </html>