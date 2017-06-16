<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html lang="en">  
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/currency.css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/all.js"></script>
</head>
<body>
    <header id="header"></header>  
    <!--内容区-->
    <div class="mainbox">
        <!--数据表格-->
        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">企业通讯录列表</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_check" href="" target="_blank">查看</a>
                    <a class="btn2 btn_refresh" href="">刷新</a>
                </span>
                <br class="clearfix"/>
            </p>
            
            <!--搜索栏-->
            <div class="searchbox">
                <div class="search_item">
                    <span class="search_name">单位名称</span>
                    <input type="text" class="txtinput">
                </div>
                <div class="search_item">
                    <span class="search_name">联系人</span>
                    <input type="text" class="txtinput">
                </div>
                <div class="search_item">
                    <span class="search_name">移动电话</span>
                    <input type="text" class="txtinput">
                </div>
                <div class="search_item">
                    <span class="search_name">电子邮箱</span>
                    <input type="text" class="txtinput">
                </div>
                
                <br class="clearfix"/>
                <div style="text-align:center;">
                    <input type="button" class="btn" value="搜索">
                </div>
            </div>
            
            <!--表格数据-->
            <div class="tablebox">
                <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>序号</th>
                        <th>部门</th>
                        <th>负责人</th>
                        <th>职务</th>
                        <th>移动电话</th>
                        <th>电子邮箱</th>
                        <th>填报时间</th>
                        <th>填报单位</th>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>1</td>
                        <td><a class="link_wz" href="" target="_blank">部门111</a></td>
                        <td>600</td>
                        <td>600</td>
                        <td>600</td>
                        <td>600</td>
                        <td>600</td>
                        <td><a class="link_wz" href="" target="_blank">600</a></td>
                    </tr>
                    
                    <tr>
                        <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">
                            总计<span>151</span>条	&nbsp;每页<input type="text" class="shuzhi">条&nbsp;&nbsp;&nbsp;跳转到第<input type="text" class="shuzhi">页
                        </td>
                    </tr>
            </table>
      </div>
    </div>
    </div>
</body>
</html>
