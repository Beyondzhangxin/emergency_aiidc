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
            <span class="content_title_form">法律法规库列表</span>
            <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.do" target="_blank">添加</a>
                    <a class="btn2 btn_edit" target="_blank" onclick="javascript:edit()">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:delect()">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh()">刷新</a>
                </span>
            <br class="clearfix" />
        </p>

        <!--搜索栏-->
        <div class="searchbox">
            <div class="search_item">
                <span class="search_name">名称</span>
                <input type="text" class="txtinput name" name="name">
            </div>
            <div class="search_item">
                <span class="search_name">颁布部门</span>
                <input type="text" class="txtinput publishDepartment" name="publishDepartment">
            </div>

            <br class="clearfix" />
            <div style="text-align:center;">
                <input type="button" class="btn btn_rules" value="搜索">
            </div>
        </div>

        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                    <th>序号</th>
                    <th>名称</th>
                    <th>颁布部门</th>
                    <th>颁布日期</th>
                    <th>施行日期</th>
                </tr>
                </thead>
                <tbody>
                <!-- <tr>
                    <td><input type="checkbox"></td>
                    <td>1</td>
                    <td><a class="link_wz" href="法律法规库_detail.html" target="_blank">安全帽111</a></td>
                    <td>600</td>
                    <td>600</td>
                    <td>600</td>
                </tr> -->
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">总计<span>151</span>条
                        &nbsp;每页<input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input
                                type="text" value="1" class="shuzhi page" value="1" >页
                        <input type="button" class="btn btn_go" value="Go">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<script>
    function refresh() {
        var dataList = {
            pageSize: $('.rows').val(),
            pageNum: $('.page').val(),
        }
        $.ajax({
            type: 'post',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                console.log(data)
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.id + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?id=' + n.id + '" target="_blank">'
                            + n.name + '</a></td><td>' + n.publishDepartment + '</td><td>' + n.pubDate +
                            '</td><td>' + n.impDate + '</td></tr>'
                    })
                    $("tbody").html(html);
                } else {
                    alert(data.message);
                }
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
    function pageList() {
        var dataList = {
            pageSize: $('.rows').val(),
            pageNum: $('.page').val(),
            name: $(".name").val(),
            publishDepartment: $(".publishDepartment").val()
        }
        $.ajax({
            type: 'post',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                console.log(data)
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.id + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?id=' + n.id + '" target="_blank">'
                            + n.name + '</a></td><td>' + n.publishDepartment + '</td><td>' + n.pubDate +
                            '</td><td>' + n.impDate + '</td></tr>'
                    })
                    $("tbody").html(html);
                } else {
                    alert(data.message);
                }
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
    pageList();
    $(".btn_go").click(pageList);
    $(".btn_rules").click(pageList);
    function delect() {//删除
        var ids = new Array;
        $("tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            ids.push(id);
        });
        if (confirm("确定删除该信息？")) {
            $.ajax({
                type: 'get',
                url: 'delete.do',
                data: {"ids": ids.toString()},
                contentType: "application/json",
                success: function () {
                    refresh();
                    alert("删除成功");
                    $("thead input").prop("checked", false);
                }
            })
        } else {
            return
        }
        ;
    }
    function edit() {
        var editId = new Array;
        $("tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            editId.push(id);
        });
        if (editId.length == 1) {
            window.open("details.do?=" + editId);
        } else {
            alert("请选择一条数据进行编辑")
        }
    }
</script>
</body>
</html>