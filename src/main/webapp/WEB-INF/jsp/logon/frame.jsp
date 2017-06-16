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
</head>
<body>
  <div class="headbox">
        <img class="logo_pt" src="../images/logo.png" alt="logo"/>
        <div class="link_box">
            <a class="nav_link" href="">首页</a>
            <a class="nav_link nav_link_center" href="">系统中心</a>
            <a class="nav_link nav_link_user" href="javascript:void(0)">个人中心</a>
        </div>
        <div class="title_sys">应急资源管理系统</div>
        <div class="navbox">
         	<c:forEach var="navigation" items="${navList}" >
	            <a class="nav_item" data-href="../${navigation.funcid}/${navigation.action}.do" onClick="javascript:getUrl(this)">${navigation.text}</a>
   		</c:forEach>
        </div>   
        <br class="clearfix"/>
    </div>
    <iframe src="../em_material/list.do" frameborder="0" width="100%" height="100%">
    
    </iframe>
</body>
</html>
