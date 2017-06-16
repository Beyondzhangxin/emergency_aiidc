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
    <title>法律法规详细</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="http://validform.rjboy.cn/Validform/v5.1/Validform_v5.1_min.js"></script>
    <style>
        .rulesID, .ueRulesId {
            width: 0;
            height: 0;
            }
    </style>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <form class="registerform" action="">
        <input type="text" name="id" class="rulesID">
        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">法律法规库详细</span>
                <span class="btnbox">
             <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_saveC" value="保存并关闭">
            <a class="btn2 btn_refresh" href="javascript:history.go(0)">刷新</a>
            </span>
                <br class="clearfix" />
            </p>
            <!--物资详细页-->
            <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>名称
                    </td>
                    <td width="30%">
                        <input type="text" datatype="*" nullmsg="请输入名称" class="txtinput name" name="name">
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>颁布部门
                    </td>
                    <td width="30%">
                        <input type="text" datatype="*" nullmsg="请输入颁布部门" class="txtinput publishDepartment"
                               name="publishDepartment">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>颁布日期
                    </td>
                    <td width="30%">

                        <input type="text" datatype="date" nullmsg="请选择颁布日期！" id="publishDate"
                               class="txtinput publishDate" name="publishDate">
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>施行日期
                    </td>
                    <td width="30%">
                        <input type="text" datatype="date" nullmsg="请选择施行日期！" id="implementDate"
                               class="txtinput implementDate" name="implementDate">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>正文
                    </td>
                    <td width="60%" colspan="3" style="padding-right:13.5%">
                        <textarea id="editor" datatype="*" nullmsg="请填写文章内容" style="width:100%;" class="content"
                                  name="content"></textarea>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script>
    laydate({
        elem: '#publishDate',
        event: 'focus'
    });
    laydate({
        elem: '#implementDate',
        event: 'focus'
    });
</script>
<script>
    var ue = UE.getEditor('editor');
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function (action) {
        var rulesId = $(".rulesID").val();
        if (action == 'uploadimage') {
            //图片上传
            return 'http://localhost:8080/em/pub/uploadImage.do?libraryCode=1008&standardId=' + rulesId;
        }
        if (action == 'uploadfile') {
            //附件上传
            return 'http://localhost:8080/em/pub/uploadfile.do?libraryCode=1008&standardId=' + rulesId;
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    }
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
                //var data = JSON.parse( json );
                if (data.status = "0000000") {
                    $(".name").val(data.data.name);
                    $(".publishDepartment").val(data.data.publishDepartment);
                    $(".publishDate").val(data.data.publishDate);
                    $(".implementDate").val(data.data.implementDate);
                    $(".rulesID").val(data.data.id);
                    var content = data.data.content;
                    $("form").attr('action', "update.do");
                    ue.ready(function () {
                        ue.setContent(content);
                    });
                    $(".registerform:eq(0)").Validform({
                        ajaxPost: true,
                        datatype: {
                            "email": /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
                            "num": /^\+?[1-9][0-9]*$/,
                            "phone": /^1[34578]\d{9}$/,
                            "tel": /^0\d{2,3}-\d{7,8}(-\d{1,6})?$/,
                            "date": /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
                        },
                        callback: function (data) {
                            if (data.status == "0000000") {
                                setTimeout(function () {
                                    $.Hidemsg();
                                    $.Showmsg("保存成功");
                                    if (flag == 1) window.close();
                                    flag = 1;
                                    ue.setContent(' ');
                                    $('.formtable input').val(" ");
                                }, 1000);
                            }
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

    } else {
        $(".content_title_form").html("法律法规库添加");
        //id
        $.ajax({
            type: 'post',
            url: 'sequenceId.do',
            success: function (data) {
                $('.rulesID').val(data);
            },
            error: function (data) {
                alert(data.message);
            }
        });
        //添加页处理js
        $("form").attr('action', "save.do");
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            datatype: {
                "email": /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
                "num": /^\+?[1-9][0-9]*$/,
                "phone": /^1[34578]\d{9}$/,
                "tel": /^0\d{2,3}-\d{7,8}(-\d{1,6})?$/,
                "date": /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
            },
            tiptype: 1,
            callback: function (data) {
                if (data.status == "0000000") {
                    setTimeout(function () {
                        $.Hidemsg();
                        $.Showmsg("保存成功");
                        if (flag == 1) window.close();
                        flag = 1;
                    }, 1000);
                }
            }
        });
    }
</script>
</body>
</html>