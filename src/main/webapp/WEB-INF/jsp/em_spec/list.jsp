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
            <span class="content_title_form">应急专家库列表</span>
            <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.do" target="_blank">添加</a>
                    <a class="btn2 btn_edit" target="" onclick="javascript:edit()">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:delect()">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh()">刷新</a>
                </span>
            <br class="clearfix" />
        </p>

        <!--搜索栏-->
        <div class="searchbox">
            <div class="search_item">
                <span class="search_name">专家类别</span>
                <select class="formselect expertType">
                    <option value="">全部</option>
                </select>
            </div>
            <div class="search_item">
                <span class="search_name">姓名</span>
                <input type="text" class="txtinput name">
            </div>
            <div class="search_item">
                <span class="search_name">所属地区</span>
                <select class="formselect areaId">
                    <option value="">全部</option>
                </select>
            </div>
            <div class="search_item">
                <span class="search_name">适用事件类别</span>
                <select class="formselect eventTypeId">
                    <option value="">全部</option>
                </select>
            </div>

            <br class="clearfix" />
            <div style="text-align:center;">
                <input type="button" class="btn btn_spec" value="搜索">
            </div>
        </div>

        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                    <th>序号</th>
                    <th>专家类别</th>
                    <th>姓名</th>
                    <th>工作单位</th>
                    <th>所属地区</th>
                    <th>适用事件类别</th>
                    <th>更新时间</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                        总计<span>151</span>条 &nbsp;每页<input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input
                            type="text" value="1" class="shuzhi page">页
                        <input type="button" class="btn btn_go" value="Go">
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
            expertType: $(".expertType").val(),
            name: $(".name").val(),
            areaId: $(".areaId").val(),
            eventTypeId: $(".eventTypeId").val()
        };  
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.expertId + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td><a class="link_wz" href="details.do?expertId=' + n.expertId + '" target="_blank">'
                            + n.expertType + '</a></td><td>' + n.name + '</td><td>' + n.workUnit +
                            '</td><td>' + n.areaId + '</td><td>' + n.eventTypeId + '</td><td>' + n.changeDate + '</td></tr>';
                    });
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
        };
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: dataList,
            success: function (data) {
                if (data.status == "0000000") {
                    $("tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.expertId + '></td><td>' +
                            ((dataList.pageNum - 1) * dataList.pageSize + m + 1) + '</td><td><a class="link_wz" href="details.do?expertId=' + n.expertId + '" target="_blank">'
                            + n.expertType + '</a></td><td>' + n.name + '</td><td>' + n.workUnit +
                            '</td><td>' + n.areaId + '</td><td>' + n.eventTypeId + '</td><td>' + n.changeDate + '</td></tr>';
                    });
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
    $(".btn_spec").click(pageList);
    $.ajax({
        type: 'post',
        url: '../em_material/getAreaForJiangsuZhenjiang.do',
        dataType: "json",
        success: function (data) {
            if (data.status == "0000000") {
                var html = "";
                $.each(data.data, function (m, n) {
                    html += '<option value="' + n.countyId + '">' + n.areaName + '</option>';
                })
                $('.areaId').append(html);
            } else {
                alert(data.message)
            }
        },
        err: function (data) {
            alert(data.message);
        }
    });
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
                $(".eventTypeId").append(html);
            }

        },
        err: function (data) {
            alert(data.message);
        }
    });
    $.ajax({
        type: 'post',
        url: 'expertTypes.do',
        success: function (data) {
            //var json = JSON.parse( data );
            if (data.status == "0000000") {
                var html = "";
                $.each(data.data, function (m, n) {
                    html += '<option value="' + n.expertId + '">' + n.expertTypeName + '</option>';
                })
                $(".expertType").append(html);
            }

        },
        err: function (data) {
            alert(data.message);
        }
    });
    function delect() {//删除
        var expertIds = new Array;
        $("tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            expertIds.push(id);
        });
        if (confirm("确定删除该信息？")) {
            $.ajax({
                type: 'get',
                url: 'delete.do',
                data: {"expertIds": expertIds.toString()},
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
    function edit() {
        var editId = new Array;
        $("tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            editId.push(id);
        });
        if (editId.length == 1) {
            window.open("details.do?expertId=" + editId);
        } else {
            alert("请选择一条数据进行编辑")
        }
    }
</script>
</body>
</html>