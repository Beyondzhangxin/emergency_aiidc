<%@page import="java.util.Enumeration"%>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html>
<head>
	<title>出错了</title>
</head>
<body>
	<h1>${AIIDC_LAST_EXCEPTION.errCode}</h1>
	<p>${AIIDC_LAST_EXCEPTION.message}</p>
</body>
</html>
