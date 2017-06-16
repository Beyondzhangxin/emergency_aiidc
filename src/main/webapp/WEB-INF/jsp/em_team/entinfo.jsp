<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@
        page language="java"
             contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"
             isELIgnored="false"
%>
<head>
    <title>单位详情页</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
</head>
<!--内容区-->
<div class="mainbox">
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">单位详细信息</span>
            <span class="btnbox">
                <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
            </span>
            <br class="clearfix" />
        </p>
        <!--详细页-->
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright">
                    <b class="must">*</b>单位ID
                </td>
                <td width="30%">
                    <input type="text" class="txtinput companyId" name='companyId' readonly="readonly"
                           value="${param.companyId}">
                </td>

                <td width="20%" class="txtright">
                    <b class="must">*</b>单位名称
                </td>
                <td width="30%">
                    <input type="text" class="txtinput companyName" name='companyName' readonly="readonly"
                           value="<c:out value="${entInfo.name}"/>">
                </td>
            </tr>
        </table>
    </div>
</div>