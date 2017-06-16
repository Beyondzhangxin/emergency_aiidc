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
    <script type="text/javascript" src="../laydate/laydate.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <!--数据表格-->
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">事故案例库列表</span>
            <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.do" target="_blank">添加</a>
                    <a class="btn2 btn_edit" onclick="javascript:edit()" target="_blank">编辑</a>
                    <a class="btn2 btn_delete" onclick="javascript:delect()" href="javascript:void(0)">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh()">刷新</a>
                </span>
            <br class="clearfix" />
        </p>
        <!--搜索栏-->
        <div class="searchbox">
            <div class="search_item">
                <span class="search_name">事故名称</span>
                <input type="text" class="txtinput accidentName">
            </div>
            <div class="search_item">
                <span class="search_name">事故时间</span>
                <input type="text" class="txtinput accidentTime" id="accidentTime">
            </div>
            <div class="search_item">
                <span class="search_name">事故类别</span>
                <select class="formselect accidentType" name="accidentType" >
                    <option value="">--请选择--</option>
                </select>
            </div>

            <br class="clearfix" />
            <div style="text-align:center;">
                <input type="button" class="btn btn_events" value="搜索">
            </div>
        </div>

        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                    <th>序号</th>
                    <th>事故名称</th>
                    <th>事故时间</th>
                    <th>事故类别</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">总计<span>151</span>条&nbsp;每页<input
                            type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input type="text"
                                                                                                     value="1"
                                                                                                     class="shuzhi page">页
                        <input type="button" class="btn btn_go" value="Go">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
<script>
    laydate({
        elem: '#accidentTime',
    });
</script>
<script>
    function pageList() {
        var dataList = {
            pageSize: $('.rows').val(),
            pageNum: $('.page').val(),
            accidentName: $(".accidentName").val(),
            accidentTime: $(".accidentTime").val(),
            accidentType: $(".accidentType").val()
        }
        $.ajax({
            type: 'post',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.id + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?id=' + n.id + '" target="_blank">'
                            + n.accidentName + '</a></td><td>' + n.accidentTime + '</td><td>' + n.accidentType + '</td></tr>'
                    })
                    $("tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
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
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.id + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?id=' + n.id + '" target="_blank">'
                            + n.accidentName + '</a></td><td>' + n.accidentTime + '</td><td>' + n.accidentType + '</td></tr>'
                    })
                    $("tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        })
    }
    pageList();
    $(".btn_go").click(pageList);
    $(".btn_events").click(pageList);
    function edit() {
        var editId = new Array;
        $("tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            editId.push(id);
        });
        if (editId.length == 1) {
            window.open("details.do?id=" + editId);
        } else {
            alert("请选择一条数据进行编辑");
        }
    }
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
                    pageList();
                    alert("删除成功");
                    $("thead input").prop("checked", false);
                }
            })
        } else {
            return
        }
        ;
    }
    $.ajax({
        type: 'post',
        url: '../em_team/allEventTypes.do',
        success: function (data) {
            //var json = JSON.parse( data );
            if (data.status == "0000000") {
                var html = "";
                $.each(data.data, function (m, n) {
                    html += '<option value="' + n.eventTypeId + '">' + n.eventTypeName + '</option>';
                })
                $(".accidentType").append(html);
            }

        },
        err: function (data) {
            alert(data.message);
        }
    });
</script>
</body>
</html>