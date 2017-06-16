<%@page import="java.util.Enumeration"%>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/themes/icon.css">
	<title>出错了</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		function showError(){
			$.messager.alert('${sessionScope.AIIDC_LAST_EXCEPTION.errCode}','${sessionScope.AIIDC_LAST_EXCEPTION.message}').panel("options").top = $(document).scrollTop() + 80;;
		}
	</script>
</head>
<body>
	<h1>${sessionScope.AIIDC_LAST_EXCEPTION.errCode}</h1>
	<p>${sessionScope.AIIDC_LAST_EXCEPTION.message}</p>
</body>


</html>
