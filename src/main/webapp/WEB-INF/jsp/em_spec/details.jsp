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
    <title>应急专家库详细</title>
    <link rel="stylesheet" type="text/css" href="../css/currency.css">
    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/all.js"></script>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="http://validform.rjboy.cn/Validform/v5.1/Validform_v5.1_min.js"></script>
    <style>
        .specID {
            width: 0;
            height: 0;
            }
    </style>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <form class="registerform" action="">
        <input type="text" name="expertId" class="specID">
        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">应急专家库详细</span>
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
                        <b class="must">*</b>专家类别
                    </td>
                    <td width="30%">
                        <select class="formselect expertType" name="expertType" datatype="*" nullmsg="请选择专家类别！">
                        </select>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>姓名
                    </td>
                    <td width="30%">
                        <input type="text" maxlength="4" class="txtinput name" name="name" datatype="*" nullmsg="请输入姓名">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>性别
                    </td>
                    <td width="30%">
                        <select class=" formselect sex" name="sex" datatype="*" nullmsg="请选择性别！">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>

                    <td width="20%" class="txtright">
                        出生年月
                    </td>
                    <td width="30%">
                        <input type="text" class="txtinput birthday" datatype="date" ignore="ignore" name="birthday"
                               id="laydate">
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        民族编码
                    </td>
                    <td width="30%">
                        <select class="formselect nationCode" name="nationCode">
                        </select>
                    </td>

                    <td width="20%" class="txtright">
                        <b class="must">*</b>所属地区
                    </td>
                    <td width="30%">
                        <select class="formselect areaId" name="areaId" datatype="*" nullmsg="请选择所属地区！">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b>适用事件类
                    </td>
                    <td width="30%">
                        <select class="formselect eventTypeId" name="eventTypeId" datatype="*" nullmsg="请选择事件类型！">
                        </select>
                    </td>

                    <td width="20%" class="txtright">政治面貌</td>
                    <td width="30%"><input type="text" class="txtinput politicalOutlook" name="politicalOutlook"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        籍贯
                    </td>
                    <td width="30%"><input type="text" class="txtinput placeOfOrigin" name="placeOfOrigin"></td>

                    <td width="20%" class="txtright">户籍所在地</td>
                    <td width="30%"><input type="text" class="txtinput domicile" name="domicile"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        所学专业
                    </td>
                    <td width="30%"><input type="text" class="txtinput major" name="major"></td>

                    <td width="20%" class="txtright">最高学历</td>
                    <td width="30%"><input type="text" class="txtinput highestEducation" name="highestEducation"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        <b class="must">*</b> 工作单位
                    </td>
                    <td width="30%"><input type="text" datatype="*" class="txtinput workUnit" name="workUnit"></td>

                    <td width="20%" class="txtright">单位地址</td>
                    <td width="30%"><input type="text" class="txtinput workAddr" name="unitAddr"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">
                        毕业院校
                    </td>
                    <td width="30%"><input type="text" class="txtinput university" name="university"></td>

                    <td width="20%" class="txtright">
                        参加工作时间
                    </td>
                    <td width="30%"><input type="text" id="workingTime" datatype="date" ignore="ignore"
                                           class="txtinput workingTime" name="workingTime"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">职务</td>
                    <td width="30%"><input type="text" class="txtinput post" name="post"></td>

                    <td width="20%" class="txtright">职称</td>
                    <td width="30%"><input type="text" class="txtinput title" name="title"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">专业特长</td>
                    <td width="30%">
                        <textarea class="formarea specialty" name="specialty"></textarea>
                    </td>

                    <td width="20%" class="txtright">参与事故处理经历</td>
                    <td width="30%">
                        <textarea class="formarea partInInciHandling" name="partInInciHandling"></textarea>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="txtright"><b class="must">*</b>办公电话</td>
                    <td width="30%"><input type="text" class="txtinput officePhone" datatype="tel" nullmsg="办公电话格式不正确"
                                           name="officePhone"></td>

                    <td width="20%" class="txtright">电子邮箱</td>
                    <td width="30%"><input type="text" datatype="email" nullmsg="邮箱格式不正确" ignore="ignore"
                                           class="txtinput email" name="email"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">传真</td>
                    <td width="30%"><input type="text" class="txtinput fax" name="fax"></td>

                    <td width="20%" class="txtright">移动电话</td>
                    <td width="30%"><input type="text" class="txtinput mobilePhone" datatype="phone" ignore="ignore"
                                           name="mobilePhone"></td>
                </tr>
                <tr>
                    <td width="20%" class="txtright">家庭电话</td>
                    <td width="30%"><input type="text" class="txtinput homePhone" name="homePhone"></td>

                    <td width="20%" class="txtright">家庭地址</td>
                    <td width="30%"><input type="text" class="txtinput homeAddr" name="homeAddr"></td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script>
    laydate({
        elem: '#laydate',
        event: 'focus'
    });
    laydate({
        elem: '#workingTime',
        event: 'focus'
    })
    //公用

</script>
<script>
    var flag = 1;
    $('.btn_save').click(function () {
        flag = 0;
    });
    //编辑
    var detailsUrl = window.location.search;
    if (detailsUrl.indexOf("=") > 0) {    //这里是详情页的处理js
        var expertId = detailsUrl.substring(detailsUrl.lastIndexOf('=') + 1, detailsUrl.length);
        $.ajax({
            type: 'get',
            url: 'emParkExpert.do',
            data: {expertId: expertId},
            success: function (data) {
                console.log(data.data.eventTypeId)
                //var data = JSON.parse( json );
                if (data.status = "0000000") {
                    var areaIds = data.data.areaId;
                    var expertTypes = data.data.expertType;
                    var nationCodes = data.data.nationCode;
                    var eventTypeIds = data.data.eventTypeId;
                    //$(".expertType").find("option[value="+data.data.expertType+"]").prop("selected",true);
                    //$(".nationCode").find("option[value="+data.data.nationCode+"]").prop("selected",true);
                    //$(".areaId").find("option[value="+data.data.areaId+"]").prop("selected",true);
                    //$(".eventTypeId").find("option[value="+data.data.eventTypeId+"]").prop("selected",true);
                    $(".name").val(data.data.name);
                    $(".birthday").val(data.data.birthday);
                    $(".politicalOutlook").val(data.data.politicalOutlook);
                    $(".placeOfOrigin").val(data.data.placeOfOrigin);
                    $(".domicile").val(data.data.domicile);
                    $(".major").val(data.data.major);
                    $(".highestEducation").val(data.data.highestEducation);
                    $(".workUnit").val(data.data.workUnit);
                    $(".workAddr").val(data.data.workAddr);
                    $(".university").val(data.data.university);
                    $(".workingTime").val(data.data.workingTime);
                    $(".post").val(data.data.post);
                    $(".title").val(data.data.title);
                    $(".specialty").val(data.data.specialty);
                    $(".partInInciHandling").val(data.data.partInInciHandling);
                    $(".officePhone").val(data.data.officePhone);
                    $(".email").val(data.data.email);
                    $(".fax").val(data.data.fax);
                    $(".mobilePhone").val(data.data.mobilePhone);
                    $(".homePhone").val(data.data.homePhone);
                    $(".homeAddr").val(data.data.homeAddr);
                    $(".specID").val(expertId);
                    $(".sex").val(data.data.sex);
                    $.ajax({
                        type: 'post',
                        url: '../em_material/getAreaForJiangsuZhenjiang.do',
                        dataType: "json",
                        success: function (data) {
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.countyId + '">' + n.areaName + '</option>';
                                });
                                $('.areaId').append(html);
                                $(".areaId").find("option[value=" + areaIds + "]").prop("selected", true);
                            } else {
                                alert(data.message)
                            }
                        },
                        err: function (data) {
                            alert(data.message);
                        }
                    });
                    $.ajax({//民族编码
                        type: 'post',
                        url: '/em/nations/list.do',
                        dataType: "json",
                        success: function (data) {
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.nationId + '">' + n.nationName + '</option>';
                                })
                                $('.nationCode').append(html);
                                $(".nationCode").find("option[value=" + nationCodes + "]").prop("selected", true);
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
                                $(".eventTypeId").find("option[value=" + eventTypeIds + "]").prop("selected", true);
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
                            if (data.status == "0000000") {
                                var html = "";
                                $.each(data.data, function (m, n) {
                                    html += '<option value="' + n.expertId + '">' + n.expertTypeName + '</option>';
                                })
                                $(".expertType").append(html);
                                $(".expertType").find("option[value=" + expertTypes + "]").prop("selected", true);
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
        });
        //编辑
        $("form").attr('action', "update.do");
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
                        $('.formtable input').val(" ");
                    }, 1000);
                }
            }
        });
    } else {
        $(".content_title_form").html("应急专家库添加");
        //添加
        $("form").attr('action', "save.do");
        $(".specID").remove();
        $(".registerform:eq(0)").Validform({
            ajaxPost: true,
            tiptype: 1,
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
                        $('.formtable input').val(" ");
                    }, 1000);
                }
            }
        });
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
        $.ajax({//民族编码
            type: 'post',
            url: '/em/nations/list.do',
            dataType: "json",
            success: function (data) {
                if (data.status == "0000000") {
                    var html = "";
                    $.each(data.data, function (m, n) {
                        html += '<option value="' + n.nationId + '">' + n.nationName + '</option>';
                    })
                    $('.nationCode').append(html);
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
    }
</script>
</body>
</html>