<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<!--内容区-->
<div class="mainbox">
    <!--数据表格-->
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">企业通讯录列表</span>
            <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_check" href="" target="_blank">查看</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh()">刷新</a>
                </span>
            <br class="clearfix" />
        </p>

        <!--搜索栏-->
        <div class="searchbox">
            <div class="search_item">
                <span class="search_name ">单位名称</span>
                <select class="formselect companyName" name="companyName">
                    <option value="">--请选择--</option>
                </select>
            </div>
            <div class="search_item">
                <span class="search_name">联系人</span>
                <input type="text" class="txtinput header" name="header">
            </div>
            <div class="search_item">
                <span class="search_name">移动电话</span>
                <input type="text" class="txtinput mobilePhone" name="mobilePhone">
            </div>
            <div class="search_item">
                <span class="search_name">电子邮箱</span>
                <input type="text" class="txtinput email" name="email">
            </div>

            <br class="clearfix" />
            <div style="text-align:center;">
                <input type="button" class="btn btn_contact" value="搜索">
            </div>
        </div>

        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                    <th>序号</th>
                    <th>部门</th>
                    <th>负责人</th>
                    <th>职务</th>
                    <th>移动电话</th>
                    <th>电子邮箱</th>
                    <th>填报时间</th>
                    <th>填报单位</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                        总计<span>151</span>条 &nbsp;每页<input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input
                            type="text" value="1" class="shuzhi page">页
                        &nbsp;&nbsp;&nbsp;<input type="button" class="btn btn_go" value="Go">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<script>
    function pageList() {
        var dataList = {
            pageSize: $('.rows').val(),
            pageNum: $('.page').val(),
            companyId: $(".companyName").val(),
            header: $(".header").val(),
            mobilePhone: $(".mobilePhone").val(),
            email: $(".email").val()
        }
        $.ajax({
            type: 'get',                                                            
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                $("tfoot").find("span").html(data.total);
                var html = "";
                $.each(data.rows, function (m, n) {
                    html += '<tr><td><input type="checkbox"></td><td>' +
                        ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?companyId=' + n.companyId + '" target="_blank">'
                        + n.department + '</a></td><td>' + n.header + '</td><td>' + n.departmentDuty +
                        '</td><td>' + n.mobilePhone + '</td><td>' + n.email + '</td><td>' + n.editTime + '</td><td>' + n.companyName + '</td></tr>'
                })
                $("tbody").html(html);
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
    ;
    function refresh() {
        var dataList = {
            pageSize: $('.rows').val(),
            pageNum: $('.page').val(),
        }
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                $("tfoot").find("span").html(data.total);
                var html = "";
                $.each(data.rows, function (m, n) {
                    html += '<tr><td><input type="checkbox"></td><td>' +
                        ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?companyId=' + n.companyId + '" target="_blank">'
                        + n.department + '</a></td><td>' + n.header + '</td><td>' + n.departmentDuty +
                        '</td><td>' + n.mobilePhone + '</td><td>' + n.email + '</td><td>' + n.editTime + '</td><td>' + n.companyName + '</td></tr>'
                })
                $("tbody").html(html);
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
    pageList();
    $(".btn_go").click(pageList);
    $(".btn_contact").click(pageList);
    $.ajax({
        type: 'post',
        url: 'enterpriseInfos.do',
        success: function (data) {
            if (data.status == "0000000") {
                var html = "";
                $.each(data.data, function (m, n) {
                    html += '<option value="' + n.id + '">' + n.name + '</option>';
                })
                $(".companyName").append(html);
            }

        },
        err: function (data) {
            alert(data.message);
        }
    });
</script>
</body>
</html>