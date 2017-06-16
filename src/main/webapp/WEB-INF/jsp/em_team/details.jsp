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
    <title>应急队伍详情页</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="http://validform.rjboy.cn/Validform/v5.1/Validform_v5.1_min.js"></script>
    <style>
        .teamID {
            width: 0;
            height: 0;
            }
    </style>
</head>
<!--内容区-->
<div class="mainbox">
    <form class="registerform" action="" method="post">
        <input type="text" name="teamId" class="teamID">
        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">应急队伍详细</span>
                <span class="btnbox">
            <input type="submit" class="btn2 btn_save" value="保存">
            <input type="submit" class="btn2 btn_saveC" value="保存并关闭">
            <a class="btn2 btn_refresh" href="javascript:history.go(0)">刷新</a>
            </span>
                <br class="clearfix" />
            </p>
            <!--详细页-->
            <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>队伍名称
                    </td>
                    <td width="30%">
                        <input type="text" datatype="*" class="txtinput teamName" name='teamName'>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>队伍所在地址
                    </td>
                    <td width="30%">
                        <input type="text" datatype="*" class="txtinput teamAddr" name='teamAddr'>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>所属地区
                    </td>
                    <td width="30%">
                        <select class="formselect areaId" name="areaId"> </select>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>队伍类别
                    </td>
                    <td width="30%">
                        <select class="formselect teamTypeId" name="teamTypeId"> </select>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        队伍级别
                    </td>
                    <td width="30%">
                        <select class="formselect teamLevelId" name="teamLevelId">

                        </select>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>适用事件类别
                    </td>
                    <td width="30%">
                        <select class="formselect eventTypeId" name="eventTypeId">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        成立时间
                    </td>
                    <td width="30%">
                        <input type="text" class="txtinput createTime" datatype="date"
                               name="createTime" id="createTime">
                    </td>

                    <td width="20%" class="txtright">队伍资质等级</td>
                    <td width="30%"><input type="text" class="txtinput qualifications" name="qualifications"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        队伍资质证书编号
                    </td>
                    <td width="30%"><input type="text" class="txtinput qualificationsNum" name="qualificationsNum"></td>

                    <td width="20%" class="txtright"><b class="must">*</b>队伍人数</td>
                    <td width="30%"><input type="text" class="txtinput peopleNum" datatype="num" name="peopleNum"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        队伍经费来源
                    </td>
                    <td width="30%"><input type="text" class="txtinput fundingSources" name="fundingSources"></td>

                    <td width="20%" class="txtright">中队个数</td>
                    <td width="30%"><input type="text" class="txtinput squadronNum" name="squadronNum"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        小队个数
                    </td>
                    <td width="30%"><input type="text" class="txtinput teamNum" name="teamNum"></td>

                    <td width="20%" class="txtright">
                        负责人
                    </td>
                    <td width="30%"><input type="text" class="txtinput teamHead" name="teamHead"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">专长</td>
                    <td width="30%">
                        <textarea class="formarea expertise" name="expertise"></textarea>
                    </td>

                    <td width="20%" class="txtright">
                        主要装备
                    </td>
                    <td width="30%">
                        <textarea class="formarea mainMaterial" name="mainMaterial"></textarea>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">分管领导</td>
                    <td width="30%">
                        <input type="text" class="txtinput teamLeader" name="leader">
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>负责人联系电话
                    </td>
                    <td width="30%">
                        <input type="text" class="txtinput headTel" datatype="tel" name="headTel">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        分管领导电话
                    </td>
                    <td width="30%"><input type="text" class="txtinput leaderTel" name="leaderTel"></td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>负责人手机
                    </td>
                    <td width="30%"><input type="text" class="txtinput headMobile" datatype="phone" name="headMobile"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        分管领导手机
                    </td>
                    <td width="30%"><input type="text" class="txtinput leaderMobile" name="leaderMobile"></td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>应急值班电话
                    </td>
                    <td width="30%"><input type="text" class="txtinput dutyTel" datatype="tel" name="dutyTel"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">应急值班传真</td>
                    <td colspan="3">
                        <input type="text" class="txtinput dutyFax" name="dutyFax">
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script>
    laydate({
        elem: '#createTime',
        event: 'focus'
    })
</script>

<script>
    var flag=1 ;
    $('.btn_save').click(function () {
              flag=0;
    });
    var detailsUrl = window.location.search;
    if (detailsUrl.indexOf("=") > 0) {    //这里是详情页的处理js
        var id = detailsUrl.substring(detailsUrl.lastIndexOf('=') + 1, detailsUrl.length);
        $.ajax({
            type: 'get',
            url: 'emTeam.do',
            data: {teamId: id},
            success: function (data) {
                console.log(data)
                if (0000000 == data.status) {
                    var innerContatc = data.data;
                    var teamTypeId = innerContatc.teamTypeId;
                    var eventTypeIds = innerContatc.eventTypeId;
                    var teamLevelId = innerContatc.teamLevelId;
                    var areaId = innerContatc.areaId;
                    console.log(innerContatc.teamName)
                    $('.teamName').val(innerContatc.teamName);
                    $('.teamAddr').val(innerContatc.teamAddr);
                    $('.areaId').val(innerContatc.areaId);
                    $('.teamTypeId').val(innerContatc.teamTypeId);
                    $('.mainMaterial').val(innerContatc.mainMaterial);
                    $('.teamLeader').val(innerContatc.leader);
                    $('.leaderMobile').val(innerContatc.leaderMobile);
                    $('.leaderTel').val(innerContatc.leaderTel);
                    $('.expertise').val(innerContatc.expertise);
                    $('.qualifications').val(innerContatc.qualifications);
                    $('.dutyTel').val(innerContatc.dutyTel);
                    $('.dutyFax').val(innerContatc.dutyFax);
                    $('.teamHead').val(innerContatc.teamHead);
                    $('.teamNum').val(innerContatc.teamNum);
                    $('.headMobile').val(innerContatc.headMobile);
                    $('.qualificationsNum').val(innerContatc.qualificationsNum);
                    $('.squadronNum').val(innerContatc.squadronNum);
                    $('.fundingSources').val(innerContatc.fundingSources);
                    $('.peopleNum').val(innerContatc.peopleNum);
                    $('.headTel').val(innerContatc.headTel);
                    $('.createTime').val(innerContatc.createTime);
                    $('.teamLevelId').val(innerContatc.teamLevelId);
                    $('.teamID').val(innerContatc.teamId);
                    //适用事件类别
                    $.ajax({
                        type: 'post',
                        url: 'allEventTypes.do',
                        success: function (data) {
                            //var json = JSON.parse( data );
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.eventTypeId + '">' + n.eventTypeName + '</option>';
                                })
                                $(".eventTypeId").append(html);
                                $(".eventTypeId").find("option[value=" + eventTypeIds + "]").prop("selected", true);
                            }

                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                    //队伍级别
                    $.ajax({
                        type: 'post',
                        url: 'teamLevels.do',
                        success: function (data) {
                            //var json = JSON.parse( data );
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.levelId + '">' + n.levelName + '</option>';
                                })
                                $(".teamLevelId").append(html);
                                $(".teamLevelId").find("option[value=" + teamLevelId + "]").prop("selected", true);
                            }

                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                    //所属地区
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
                                $(".areaId").find("option[value=" + areaId + "]").prop("selected", true);
                            } else {
                                alert(data.message)
                            }
                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                    //队伍类别
                    $.ajax({
                        type: 'post',
                        url: 'teamTypes.do',
                        dataType: "json",
                        success: function (data) {
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.teamTypeId + '">' + n.teamTypeName + '</option>';
                                })
                                $('.teamTypeId').append(html);
                                $(".teamTypeId").find("option[value=" + teamTypeId + "]").prop("selected", true);
                            } else {
                                alert(data.message)
                            }
                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                } else {
                    alert(data.message);
                }
            },
            error: function (data) {
                alert(data.message);
            }
        });
        //编辑
        $("form").attr('action', "update.do");
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            datatype: {
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
                    }, 1000);
                }
            }
        });
    } else {
        $(".content_title_form").html("应急队伍添加");
        //添加
        $('form').attr('action', "save.do");
        $(".teamID").remove();
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            tiptype: 1,
            datatype: {
                "num":/^\+?[1-9][0-9]*$/,
                "phone":/^1[34578]\d{9}$/,
                "tel": /^0\d{2,3}-\d{7,8}(-\d{1,6})?$/,
                "date": /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
            },
            callback: function (data) {
                if (data.status == "0000000") {
                    setTimeout(function () {
                        $.Hidemsg();
                        $.Showmsg("保存成功");
                        console.log(flag);
                        if (flag == 1) window.close();
                        flag=1;
                        $('.formtable input').val(" ");
                    }, 1000);
                }
            }
        });
        //所属地区
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
        //适用事件类型
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
        //队伍级别
        $.ajax({
            type: 'post',
            url: 'teamLevels.do',
            dataType: "json",
            success: function (data) {
                if (data.status == "0000000") {
                    var html = "";
                    $.each(data.data, function (m, n) {
                        html += '<option value="' + n.levelId + '">' + n.levelName + '</option>';
                    })
                    $('.teamLevelId').append(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });
        //队伍类别
        $.ajax({
            type: 'post',
            url: 'teamTypes.do',
            dataType: "json",
            success: function (data) {
                if (data.status == "0000000") {
                    var html = "";
                    $.each(data.data, function (m, n) {
                        html += '<option value="' + n.teamTypeId + '">' + n.teamTypeName + '</option>';
                    })
                    $('.teamTypeId').append(html);
                } else {
                    alert(data.message)
                }
            },
            err: function (data) {
                alert(data.message);
            }
        });

    }
</script>