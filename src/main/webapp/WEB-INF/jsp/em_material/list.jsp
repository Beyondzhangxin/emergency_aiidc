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
	<title>应急平台</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>

</head>
<body>
     <!--内容区-->
    <div class="mainbox">
        <!--用户端选择tab-->
        <p class="content_tab_box">
            <a class="content_tab content_tab1" href="list.do">政府端</a>
            <a class="content_tab" href="companyList.do">企业端</a>
        </p>
        
        <!--数据表格-->
        <div class="contentbox">
            <p class="content_head_form">
                <span class="content_title_form">应急物资装备列表</span>
                <span class="btnbox">
                    <a class="btn2 btn_search" href="javascript:void(0)">搜索</a>
                    <a class="btn2 btn_add" href="details.jsp" target="">添加</a>
                    <a class="btn2 btn_edit" href="" target="">编辑</a>
                    <a class="btn2 btn_delete" href="javascript:void(0)">删除</a>
                    <a class="btn2 btn_refresh" href="">刷新</a>
                </span>
                <br class="clearfix"/>
            </p>            
            <!--搜索栏-->
            <div class="searchbox">
                <div class="search_item">
                    <span class="search_name">物资装备名称</span>
                    <input type="text" class="materialName txtinput" name="materialName">
                </div>
                <div class="search_item">
                    <span class="search_name">所属地区</span>
                    <input type="text" class="areaId txtinput" name="areaId">
                </div>
                <div class="search_item">
                    <span class="search_name">物资装备分类</span>
                    <select class="formselect materialClassifyId" name="materialClassifyId">
                    	<option value="">全部</option>
                    </select>
                </div>
                <div class="search_item">
                    <span class="search_name">物资装备类别</span>
                    <select class="formselect materialTypeId" name="materialTypeId">
                    	<option value="">全部</option>
                    </select>
                </div>
                <div class="search_item">
                    <span class="search_name">是否过期</span>
                    <label for="search_item_all">
                        <span class="danxuan_item">
                            <input type="radio" class="danxuan" name="isExpire" id="search_item_all" value="1" checked/>全部
                        </span>
                    </label>
                    <label for="search_item_Notexpired">
                        <span class="danxuan_item">
                            <input type="radio" class="danxuan" name="isExpire" id="search_item_Notexpired" value="2"/>未过期
                        </span>
                    </label>
                    <label for="search_item_expired">
                        <span class="danxuan_item">
                            <input type="radio" class="danxuan" name="isExpire" id="search_item_expired" value="3"/>已过期
                        </span>
                    </label>
                </div>      
                <br class="clearfix"/>
                <div style="text-align:center;">
                    <input type="button" class="btn btn_material" value="搜索">
                </div>
            </div>           
            <!--表格数据-->
            <div class="tablebox">
                <table class="datetable" border="0" cellpadding="0" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th><input type="checkbox" onClick="javascript:selectAll(this)"></th>
                            <th>序号</th>
                            <th>物资装备名称</th>
                            <th>物资装备分类</th>
                            <th>物资装备类别</th>
                            <th>数量</th>
                            <th>有效期</th>
                            <th>更新时间</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!--     <tr>
                            <td><input type="checkbox"></td>
                            <td>1</td>
                            <td>
                                <a class="link_wz" href="" target="_blank">安全帽111</a>
                            </td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                        </tr>  
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>1</td>
                            <td>
                                <a class="link_wz" href="" target="_blank">安全帽111</a>
                            </td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                            <td>600</td>
                        </tr>   -->
                    </tbody>
                    <tfoot>              
                        <tr>
                            <td colspan="9" class="tiaoye_td" style="line-height:34px; background:#f0f4fa;">总计<span></span>条  
                                &nbsp;每页
                                <input type="text" class="shuzhi rows" value="10">条&nbsp;&nbsp;&nbsp;跳转到第
                                <input type="text" class="shuzhi page" value="1">页&nbsp;&nbsp;&nbsp;
                                <input type="button" class="btn btn_go" value="Go">
                            </td>
                        </tr>
                    </tfoot>   
            </table>
      </div>
    </div>
    </div>
    <script>
	function pageList(){
		var dataList={
				rows:$('.rows').val(),
				page:$('.page').val(),
				materialName:$(".materialName").val(),
				areaId:$(".areaId").val(),
				materialClassifyId:$(".materialClassifyId").val(),
				materialTypeId:$(".materialTypeId").val(),
				isExpire:$("input[type=radio]:checked").val()
		}
		$.ajax({
			type:'post',
			url:'getEmMaterials.do',
			dataType:"json",
			data:dataList,
			success:function(data){	
				if(data.status=="0000000"){
					$("tfoot").find("span").html(data.total);
					var html="";
					$.each(data.rows,function(i,n){	
						expirys = n.expiryDateStr.replace(/-/g,"");
						nowDate=n.nowDate.replace(/-/g,"");
						var sub=expirys-nowDate;
						html+='<tr data-sub='+sub+'><td><input type="checkbox"></td><td>'+
						((dataList.page-1)*dataList.rows+i+1)+
						'</td><td> <a class="link_wz" href="details.do?materialId='+n.materialId+'" target="_blank">'
						+n.materialName+'</a></td><td>'+n.classifyName+'</td><td>'+n.typeName+
						'</td><td>'+n.num+'</td><td class="expiryDate">'+n.expiryDateStr+'</td><td class="changeTime">'+n.changeTimeStr+'</td></tr>'
					})		
					$("tbody").html(html);
			 		$("tbody tr").each(function(){		 			
			 			var sub=$(this).attr("data-sub");
						if(sub<1){
							$(this).css("background","#f78565")
						}			 			
			 		});
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
	$(".btn_material").click(pageList);
	$.ajax({
		type:'post',
		url:'getEmMaterialClassifys.do',
		dataType:"json",
		success:function(data){	
			if(data.status=="0000000"){
				var html="";
				$.each(data.rows,function(m,n){
					html+='<option value="'+n.classifyId+'">'+n.classifyName+'</option>';
				})
				$('.materialClassifyId').append(html);
			}else{
				alert(data.message);
			}
		},
		err:function(data){
			alert(data.message);
		}
	})
	$.ajax({
			type:'post',
			url:'getEmMaterialTypes.do',
			dataType:"json",
			success:function(data){	
				if(data.status=="0000000"){
					var html="";
					$.each(data.rows,function(m,n){
						html+='<option value="'+n.typeId+'">'+n.typeName+'</option>';
					})
					$('.materialTypeId').append(html);
				}else{
					alert(data.message)
				}
			},
			err:function(data){
				alert(data.message);
			}
	})
</script>
</body>
</html>