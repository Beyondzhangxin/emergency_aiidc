<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html>
<head>
	<title>应急预案</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
    <!--用户端选择tab-->
    <p class="content_tab_box">
        <a class="content_tab content_tab1" >政府端</a>
        <a class="content_tab">企业端</a>
    </p>

    <!--数据表格-->
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">应急预案</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="应急预案（企业端）_detail.html" target="_blank">添加</a>
                    <a class="btn2 btn_edit" href="应急预案（企业端）_detail.html" target="_blank">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:void(0)">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
                </span>
            <br class="clearfix"/>
        </p>
        <!--搜索栏-->
        <!--搜索栏-->
        <div class="searchbox">
            <div class="search_item">
                <span class="search_name">单位名称</span>
                <input type="text" class="txtinput companyName" name="companyName">
            </div>
            <div class="search_item">
                <span class="search_name">预案名称</span>
                <input type="text" class="txtinput planName" name="planName">
            </div>
            <div class="search_item">
                <span class="search_name">预案类别</span>
                <input type="text" class="txtinput planTypeName" name="planTypeName">
            </div>
            <div class="search_item">
                <span class="search_name">适用领域</span>
                <input type="text" class="txtinput usageName" name="usageName">
            </div>

            <br class="clearfix"/>
            <div style="text-align:center;">
                <input type="button" class="btn btn_emPlans"  value="搜索">
            </div>
        </div>

        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                    <th>序号</th>
                    <th>预案名称</th>
                    <th>预案类别</th>
                    <th>适用领域</th>
                    <th>填报时间</th>
                    <th>填报单位</th>
                </tr>
                </thead>
                <tbody>
              <!--   <tr>
                    <td><input type="checkbox"></td>
                    <td>1</td>
                    <td><a class="link_wz" href="应急预案（企业端）_detail.html" target="_blank">111</a></td>
                    <td>600</td>
                    <td>600</td>
                    <td>600</td>
                    <td>600</td>
                </tr>
                   -->
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">                            总计<span>151</span>条
                        &nbsp;每页
                        <input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第
                        <input type="text" class="shuzhi page" value="1">页
                         <input type="button" class="btn btn_go" value="go">
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>

  <script>
	function pageList(){
		var pagerRows=$('.rows').val();
		var pageNum=$('.page').val();
		var planName=$(".planName").val();
		var planTypeName=$(".planTypeName").val();
		var usageName=$(".usageName").val();
		var companyName=$(".companyName").val();
		var eeportingTimeStr=$(".eeportingTimeStr").val();
		$.ajax({
			type:'post',
			url:'getEmPlans.do',
			dataType:"json",
			data:{page:pageNum,rows:pagerRows,'planName':planName,'planTypeName':planTypeName,'usageName':usageName,'eeportingTimeStr':eeportingTimeStr,'companyName':companyName},
			success:function(data){		
				if(data.status=="0000000"){
					$("tfoot").find("span").html(data.total);
					var html="";
					$.each(data.rows,function(m,n){	
						html+='<tr><td><input type="checkbox"></td><td>'+
						((pageNum-1)*pagerRows+m+1)+'</td><td> <a class="link_wz" href="" target="_blank">'
						+n.planName+'</a></td><td>'+n.planTypeName+'</td><td>'+n.usageName+
						'</td><td>'+n.eeportingTimeStr+'</td><td>'+n.companyName+'</td></tr>'
					})		
					$("tbody").html(html);
				}else{
					alert(data.message)
				}
			},
			err:function(data){
				alert(data.message);
			}
		})
	}
	pageList();
	$(".btn_go").click(pageList);
	//$(".page").blur(pageList);
	//$(".rows").blur(pageList);
	$(".btn_emplans").click(pageList);
    </script>
</body>
</html>