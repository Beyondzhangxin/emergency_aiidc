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
    <title>应急队伍</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <!--用户端选择tab-->
    <p class="content_tab_box">
        <a class="content_tab content_tab1">政府端</a>
        <a class="content_tab">企业端</a>
    </p>

    <div class="databox">
        <!--政府端数据表格-->
        <div class="contentbox gov " style="display: block">
            <p class="content_head_form">
                <span class="content_title_form">应急队伍列表</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.do" target="_blank">添加</a>
                    <a class="btn2 btn_edit"    target="" onclick="javascript:edit()">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:delect()">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh()">刷新</a>
                </span>
                <br class="clearfix" />
            </p>
            <!--搜索栏-->
            <div class="searchbox">
                <div class="search_item">
                    <span class="search_name">队伍名称</span>
                    <input type="text" class="txtinput teamName" name="teamName">
                </div>
                <div class="search_item">
                    <span class="search_name ">适用事件类别</span>
                    <select class="formselect eventTypeId">
                        <option value="">--请选择--</option>
                    </select>
                </div>
                <div class="search_item">
                    <span class="search_name">所属地区</span>
                    <select class="formselect areaId">
                        <option value="">--请选择--</option>
                    </select>
                </div>

                <br class="clearfix" />
                <div style="text-align:center;">
                    <input type="button" class="btn btn_team gov" value="搜索">
                </div>
            </div>
            <!--表格数据-->
            <div class="tablebox">
                <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>序号</th>
                        <th>队伍名称</th>
                        <th>队伍人数</th>
                        <th>适用事件类</th>
                        <th>应急值班电话</th>
                        <th>负责人联系电话</th>
                        <th>填报时间</th>
                    </tr>
                    </thead>
                    <tbody class="gov">

                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                            总计<span>151</span>条 &nbsp;每页<input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input
                                type="text" value="1" class="shuzhi page">页
                            <input type="button" class="btn btn_go gov" value="Go">
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <!--企业端数据表格-->
        <div class="contentbox ent" style="display: none">
            <p class="content_head_form">
                <span class="content_title_form">应急队伍列表</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_check" href="" target="_blank">查看</a>
                    <a class="btn2 btn_refresh" href="javascript:refresh_ent()">刷新</a>
                </span>
                <br class="clearfix" />
            </p>
            <!--搜索栏-->
            <div class="searchbox">
                <div class="search_item">
                    <span class="search_name">单位名称</span>
                    <input type="text" class="txtinput companyName ent" name="companyName">
                </div>
                <div class="search_item">
                    <span class="search_name">队伍名称</span>
                    <input type="text" class="txtinput teamName ent" name="teamName">
                </div>
                <div class="search_item">
                    <span class="search_name ">适用事件类别</span>
                    <select class="formselect eventTypeId ent">
                        <option value="">--请选择--</option>
                    </select>
                </div>
                <div class="search_item">
                    <span class="search_name ">所属地区</span>
                    <select class="formselect areaId ent">
                        <option value="">--请选择--</option>
                    </select>
                </div>

                <br class="clearfix" />
                <div style="text-align:center;">
                    <input type="button" class="btn btn_team ent" value="搜索">
                </div>
            </div>
            <!--表格数据-->
            <div class="tablebox">
                <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>序号</th>
                        <th>队伍名称</th>
                        <th>队伍人数</th>
                        <th>适用事件类</th>
                        <th>应急值班电话</th>
                        <th>负责人联系电话</th>
                        <th>填报时间</th>
                        <th>填报单位</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                            总计<span>151</span>条 &nbsp;每页<input type="text" class="shuzhi rows ent" value="10">条&nbsp;&nbsp;&nbsp;跳转到第<input
                                type="text" value="1" class="shuzhi page ent">页
                            <input type="button" class="btn btn_go ent" value="Go">
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    $(".content_tab").click(function () {
        $('.contentbox').eq($(this).index()).show().siblings().hide();
    })
    function pageList() {
        var pageSize = $('.rows').val();
        var pageNum = $('.page').val();
        var teamName = $(".teamName").val();
        var eventTypeId = $(".eventTypeId").val();
        var areaId = $(".areaId").val();
        console.log(eventTypeId, teamName)
        /*政府端获取数据*/
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: {
                pageSize: pageSize,
                pageNum: pageNum,
                teamName: teamName,
                eventTypeId: eventTypeId,
                areaId: areaId
            },
            success: function (data) {
                console.log(data);
                if (data.status == "0000000") {
                    $(".gov tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num='+n.teamId+'></td><td>' +
                            ((pageNum - 1) * pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?teamId=' + n.teamId + '" target="_blank">'
                            + n.teamName + '</a></td><td>' + n.peopleNum + '</td><td>' + n.eventTypeName +
                            '</td><td>' + n.dutyTel + '</td><td>' + n.headMobile + '</td><td>' + n.createTime + '</td></tr>';
                    })
                    $(".gov tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
    }
    function refresh() {
        var pageSize = $('.rows').val();
        var pageNum = $('.page').val();
        /*政府端获取数据*/
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: {
                pageSize: pageSize,
                pageNum: pageNum
            },
            success: function (data) {
                console.log(data);
                if (data.status == "0000000") {
                    $(".gov tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox" data-num=' + n.teamId + '></td><td>' +
                            ((pageNum - 1) * pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?teamId=' + n.teamId + '" target="_blank">'
                            + n.teamName + '</a></td><td>' + n.peopleNum + '</td><td>' + n.eventTypeName +
                            '</td><td>' + n.dutyTel + '</td><td>' + n.headMobile + '</td><td>' + n.createTime + '</td></tr>';
                    })
                    $(".gov tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
    }
    function pageList_ent() {
        var pageSize = $('.rows.ent').val();
        var pageNum = $('.page.ent').val();
        var teamName = $(".teamName.ent").val();
        var eventTypeId = $(".eventTypeId.ent").val();
        var areaId = $(".areaId.ent").val();
        var companyName= $(".companyName.ent").val();
        console.log(eventTypeId, teamName)
        /*企业端获取数据*/
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: {
                pageSize: pageSize,
                pageNum: pageNum,
                teamName: teamName,
                eventTypeId: eventTypeId,
                areaId: areaId,
                companyName:companyName
            },
            success: function (data) {
                console.log(data);
                if (data.status == "0000000") {
                    $(".ent tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox"></td><td>' +
                            ((pageNum - 1) * pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?teamId=' + n.teamId + '" target="_blank">'
                            + n.teamName + '</a></td><td>' + n.peopleNum + '</td><td>' + n.eventTypeName +
                            '</td><td>' + n.dutyTel + '</td><td>' + n.headMobile + '</td><td>' + n.createTime +
                            '</td><td><a class="link_wz" href="entDetails.do?companyId=' + n.companyId + '" target="_blank">'
                            + n.companyName + '</a></td></tr>';
                    })
                    $(".ent tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
    }
    function refresh_ent() {
        var pageSize = $('.rows.ent').val();
        var pageNum = $('.page.ent').val();
        /*企业端获取数据*/
        $.ajax({
            type: 'get',
            url: 'listdata.do',
            dataType: "json",
            data: {
                pageSize: pageSize,
                pageNum: pageNum
            },
            success: function (data) {
                console.log(data);
                if (data.status == "0000000") {
                    $(".ent tfoot").find("span").html(data.total);
                    var html = "";
                    $.each(data.rows, function (m, n) {
                        html += '<tr><td><input type="checkbox"></td><td>' +
                            ((pageNum - 1) * pageSize + m + 1) + '</td><td> <a class="link_wz" href="details.do?teamId=' + n.teamId + '" target="_blank">'
                            + n.teamName + '</a></td><td>' + n.peopleNum + '</td><td>' + n.eventTypeName +
                            '</td><td>' + n.dutyTel + '</td><td>' + n.headMobile + '</td><td>' + n.createTime +
                            '</td><td><a class="link_wz" href="entDetails.do?companyId=' + n.companyId + '" target="_blank">'
                            + n.companyName + '</a></td></tr>';
                    })
                    $(".ent tbody").html(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
    }


    pageList();
    pageList_ent();
    $(".btn_go.ent").click(pageList_ent);
    $(".btn_team.ent").click(pageList_ent);
    $(".btn_go.gov").click(pageList);
    $(".btn_team.gov").click(pageList);
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

    function edit() {
        var teamId = new Array;
        $(".gov tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            teamId.push(id);
        });
        if (teamId.length == 1) {
            window.open("details.do?teamId=" + teamId);
        } else {
            alert("请选择一条数据进行编辑")
        }
    }
    function delect() {//删除
        var teamIds = new Array;
        $(".gov tbody input:checked").each(function () {
            var id = $(this).attr("data-num");
            teamIds.push(id);
        });
        if (confirm("确定删除该信息？")) {
            $.ajax({
                type: 'get',
                url: 'delete.do',
                data: {"teamIds": teamIds.toString()},
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
</script>
</body>
</html>