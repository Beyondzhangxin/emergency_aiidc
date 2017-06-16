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
    <title>事故案例详细</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="http://validform.rjboy.cn/Validform/v5.1/Validform_v5.1_min.js"></script>
    <style>
        .eventID {
            width: 0;
            height: 0;
            }
    </style>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <!--物资详细页-->
    <form class="registerform">
        <input type="text" name="id" class="eventID">

        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">事故案例库详细</span>
                <span class="btnbox">
            <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_saveC btn_save_close" value="保存并关闭">
            <a class="btn2 btn_refresh" href="javascript:history.go(0)">刷新</a>
            </span>
                <br class="clearfix" />
            </p>
            <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>事故名称
                    </td>
                    <td width="30%">
                        <input type="text" datatype="*" nullmsg="请输入事故名称！" class="txtinput accidentName"
                               name="accidentName">
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>事故时间
                    </td>
                    <td width="30%">
                        <input type="text" datatype="date" nullmsg="请选择事故时间！" class="txtinput accidentTime"
                               name="accidentTime" id="accidentTime">
                    </td>
                    <td>
                        <div class="Validform_checktip"></div>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>事故类别
                    </td>
                    <td width="30%">
                        <select class="formselect accidentType" datatype="*" nullmsg="请选择事故类别" name="accidentType">
                        </select>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>正文
                    </td>
                    <td width="60%" colspan="3" style="padding-right:13.5%">
                        <textarea class="formarea content" datatype="*" nullmsg="请输入正文！" name="content"
                                  style="width:90%"></textarea>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script>
    laydate({
        elem: '#accidentTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        istime: true,
        event: 'focus'
    });
</script>
<script>
    var flag = 1;
    $('.btn_save').click(function () {
        flag = 0;
    });
    var detailsUrl = window.location.search;
    if (detailsUrl.indexOf("=") > 0) {    //这里是详情页的处理js
        var id = detailsUrl.substring(detailsUrl.lastIndexOf('=') + 1, detailsUrl.length);
        $.ajax({
            type: 'get',
            url: 'id.do',
            data: {id: id},
            success: function (data) {
                if (data.status = "0000000") {
                    var eventTypeId = data.data.accidentType;
                    $(".accidentName").val(data.data.accidentName);
                    $(".accidentTime").val(data.data.accidentTime);
                    $(".content").val(data.data.content);
                    $(".eventID").val(data.data.id);
//                    事故类别下拉菜单选择
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
                                $(".accidentType").find("option[value=" + eventTypeId + "]").prop("selected", true);

                            }

                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                } else {
                    alert(data.message);
                }
                ;
            },
            error: function (data) {
                alert(data.message);
            }
        })
        //编辑
        $("form").attr('action', "update.do");
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            datatype: {
                "tele": /^([0-9]{3,4}-)?[0-9]{7,8}$/,
                "date": /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\s+(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d$/
            },
            callback: function (data) {
                if (data.status == "0000000") {
                    setTimeout(function () {
                        $.Hidemsg();
                        $.Showmsg("保存成功");
                        if (flag == 1) window.close();
                        flag = 1;
                        $('.formtable input').val(" ");
                        $("textarea").val(' ');
                    }, 1000);
                }
            }
        });

    } else {
        //添加页处理js
        $(".content_title_form").html("事故案例库添加");
        //添加
        $("form").attr('action', "save.do");
        $(".eventID").remove();
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            datatype: {
                "tele": /^([0-9]{3,4}-)?[0-9]{7,8}$/,
                "date": /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\s+(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d$/
            },
            callback: function (data) {
                if (data.status == "0000000") {
                    setTimeout(function () {
                        $.Hidemsg();
                        $.Showmsg("保存成功");
                        if (flag == 1) window.close();
                        flag = 1;
                        $('.formtable input').val(" ");
                        $("textarea").val(' ');
                    }, 1000);
                }
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
                    $(".accidentType").append(html);
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
    }
</script>
</body>
</html>