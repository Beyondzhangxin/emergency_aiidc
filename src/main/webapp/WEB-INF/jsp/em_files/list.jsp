<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@
        page language="java"
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
        function pageList() {
            frmSearch.pageNum.value = $('.page').val();
            frmSearch.rows.value = $('.rows').val();
            frmSearch.submit();
        }

        function downloadFile(fileId) {
            location.href = "downloadFile.do?fileId=" + fileId;
        }

        function downloadMutiFile() {
            var flag = false;
            for (i = 0; i < frmFiles.fileId.length; i++) {
                if (frmFiles.fileId[i].checked) {
                    flag = true;
                    break;

            }
            if (flag)
                frmFiles.submit();
            else
                alert('至少选择一个需要下载的文件。');

        }

    </script>
</head>
<!-- <body onload="pageList()"> -->
<body>
<!--内容区-->
<div class="mainbox">


    <!--数据表格-->
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">重要文件库列表</span>
            <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_upload" href="uploadInput.do">上传</a>
                <!-- <a class="btn2 btn_download" href="javascript:downloadMutiFile()">下载</a> -->
                    <a class="btn2 btn_refresh" href="javascript:pageList()">刷新</a>
                </span>
            <br class="clearfix" />
        </p>
        <!--搜索栏-->
        <form action="list.do" name="frmSearch" method="post">
            <div class="searchbox">
                <div class="search_item">
                    <span class="search_name">文件名称</span>
                    <input type="text" name="fileName" class="txtinput fileName" value="${fileName}">
                </div>
                <input type="hidden" name="rows" value="<c:out value="${param.rows}" default="10"/>">
                <input type="hidden" name="pageNum" value="<c:out value="${param.pageNum}" default="1"/>">
                <br class="clearfix" />
                <div style="text-align:center;">
                    <input type="submit" class="btn" value="搜索">
                </div>
            </div>
        </form>
        <!--表格数据-->
        <div class="tablebox">
            <form name="frmFiles" action="downloadMutiFile.do" method="post">
                <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                        <th>序号</th>
                        <th>文件名称</th>
                        <th>文件大小</th>
                        <th>上传者</th>
                        <th>上传时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="index" value="0"></c:set>
                    <c:forEach var="emFile" items="${emFileList}">
                        <c:set var="index" value="${index+1}"></c:set>
                        <tr>
                            <td><input type="checkbox" name="fileId" value="${emFile.fileId}"></td>
                            <td>${index}</td>
                            <td>${emFile.fileName }</td>
                            <td>${emFile.fileSize }</td>
                            <td>${emFile.uploader }</td>
                            <td><fmt:formatDate value="${emFile.uploadDate }" pattern="yyyy-MM-dd" /></td>
                            <td><img onclick="javascript:downloadFile(${emFile.fileId})"
                                     style="display:inline;cursor:pointer;" src="../images/download.png"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>

                    <tr>
                        <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                            总计<span>${total}</span>条
                            &nbsp;每页
                            <input type="text" class="shuzhi rows"
                                   value='<c:out value="${param.rows}" default="10"></c:out>'>条&nbsp;&nbsp;&nbsp;跳转到第
                            <input type="text" class="shuzhi page"
                                   value="<c:out value="${param.pageNum}" default="1"></c:out>">页
                            <input type="button" class="btn go" value="GO" onclick="pageList()">
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>