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
	<title>园区危险化学品库</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
</head>
<!--内容区-->
<body>
<div class="mainbox">
    
    <!--数据表格-->
    <div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">危险化学品库列表</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.do"  target="_blank">添加</a>
                    <a class="btn2 btn_edit" target="" onclick="javascript:edit()">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:delect()">删除</a>
                    <a class="btn2 btn_refresh" href="javascript:void(0)">刷新</a>
                </span>
            <br class="clearfix"/>
        </p>
        <!--搜索栏-->
      
        <div class="searchbox">
            <div class="search_item">
                    <span class="search_name">中文名称</span>
                    <input type="text" class="txtinput chineseName" name="chineseName">
                </div>
                <div class="search_item">
                    <span class="search_name">英文名称</span>
                    <input type="text" class="txtinput englishName" name="englishName">
                </div>
                <div class="search_item">
                    <span class="search_name">CAS号</span>
                    <input type="text" class="txtinput casCode" name="casCode">
                </div>
                
                <br class="clearfix"/>
                <div style="text-align:center;">
                    <input type="button" class="btn btn_hazard" value="搜索">
                </div>
        </div>
  <!--搜索栏-->
        <!--表格数据-->
        <div class="tablebox">
            <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                <tr>
                     <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                        <th>序号</th>
                        <th>中文名称</th>
                        <th>英文名称</th>
                        <th>CAS号</th>
                </tr>
                </thead>
                <tbody>
              <!--   <tr>
                    <td><input type="checkbox"></td>
                        <td>1</td>
                        <td><a class="link_wz" href="" target="_blank">安全帽111</a></td>
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
		var chineseName=$(".chineseName").val();
		var englishName=$(".englishName").val();
		var casCode=$(".casCode").val();
		$.ajax({
			type:'post',
			url:'getEmHazardChenicalList.do',
			dataType:"json",
			data:{page:pageNum,rows:pagerRows,'chineseName':chineseName,'englishName':englishName,'casCode':casCode},
			success:function(data){		
				if(data.status=="0000000"){
					$("tfoot").find("span").html(data.total);
					var html="";
					$.each(data.rows,function(m,n){	
						html+='<tr><td><input type="checkbox" data-num='+n.id+'></td><td>'+
						((pageNum-1)*pagerRows+m+1)+'</td><td> <a class="link_wz" href="details.do?id='+n.id+'" target="_blank">'
						+n.chineseName+'</a></td><td>'+n.englishName+'</td><td>'+n.casCode+
						'</td></tr>'
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
	$(".btn_hazard").click(pageList);
	//删除	
	function delect(){
		var ids=new Array;
		$("tbody input:checked").each(function(){
			var id=$(this).attr("data-num");
			ids.push(id);
		});
		if(confirm("确定删除该信息？")){
			$.ajax({
				type:'get',
				url:'deleteEmHazardByCasCode.do',
				data:{"ids":ids.toString()},
				contentType:"application/json", 
				success:function(){
					pageList();		
				}
			})
	    }else{return};
	}
function edit(){
		var editId=new Array;
		$("tbody input:checked").each(function(){
			var id=$(this).attr("data-num");
			editId.push(id);
		});
		if(editId.length==1){
			window.open("details.do?="+editId);
		}
	}
    </script>
</body>
</html>