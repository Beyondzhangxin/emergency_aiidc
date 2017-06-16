<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
	<title>应急物资装备详细</title>
	<link rel="stylesheet" type="text/css" href="../css/currency.css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/all.js"></script>
	<script type="text/javascript" src="../laydate/laydate.js"></script>
</head>
<body>
<!--内容区-->
<div class="mainbox">
	<div class="contentbox">
        <p class="content_head_form">
            <span class="content_title_form">应急物资装备详细</span>
            <span class="btnbox">
            <a class="btn2 btn_close" href="javascript:window.close();">关闭</a>
            <a class="btn2 btn_refresh" href="">刷新</a>
            </span>
            <br class="clearfix"/>
        </p>
        <!--物资详细页-->
         <form class="registerform">
        <table class="formtable" border="0" cellpadding="0" cellspacing="0" width="95%">
            <tr>
                <td width="20%" class="txtright"><b class="must">*</b>物资装备名称</td>
                <td width="30%"><input type="text" class="txtinput materialName" datatype="*" name="materialName"></td>
                
                <td width="20%" class="txtright"><b class="must">*</b>所属队伍</td>
                <td width="30%"><input type="text" class="txtinput  teamId" name="teamId"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright"><b class="must">*</b>所属地区</td>
                <td width="30%">
                    <select class="formselect" id="areaId" name="areaId">
                        <!-- <option>--请选择--</option> -->
                    </select>
                </td>
                
                <td width="20%" class="txtright"><b class="must">*</b>物资装备分类</td>
                <td width="30%">
                    <select class="formselect " id="sect" name="sect">
                        <!-- <option>--请选择--</option> -->
                    </select>
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright"><b class="must">*</b>物资装备类别</td>
                <td width="30%">
                    <select class="formselect " id="materialId" name="materialId">
                        <!-- <option>--请选择--</option> -->
                    </select>
                </td>
                
                <td width="20%" class="txtright"><b class="must">*</b>物资装备来源</td>
                <td width="30%">
                    <select class="formselect" id="materialSourceId" name="materialSourceId">
                       <!--  <option>--请选择--</option> -->
                    </select>
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright"><b class="must">*</b>数量</td>
                <td width="30%"><input type="text" class="txtinput num" name="num"></td>
           
                <td width="20%" class="txtright">型号</td>
                <td width="30%"><input type="text" class="txtinput type" name="type"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright"> 规格</td>
                <td width="30%"><input type="text" class="txtinput spec" name="spec"></td>
                
                <td width="20%" class="txtright">计量单位</td>
                <td width="30%"><input type="text" class="txtinput manufacturer" name="manufacturer"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">当前状况</td>
                <td width="30%"><input type="text" class="txtinput currentStatus" name="currentStatus"></td>
                
                <td width="20%" class="txtright">存放场所</td>
                <td width="30%"><input type="text" class="txtinput storagePlace" name="storagePlace"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">生产厂家</td>
                <td width="30%"><input type="text" class="txtinput manufacturer" name="manufacturer"></td>
                
                <td width="20%" class="txtright">购买日期</td>
                <td width="30%"><input type="text" id="purchaseDate" class="txtinput purchaseDate" name="purchaseDate"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">出厂日期</td>
                <td width="30%"><input type="text" id="createTime" class="txtinput createTime" name="createTime"></td>
                
                <td width="20%" class="txtright"><b class="must">*</b>有效期</td>
                <td width="30%"><input type="text" id="expiryDate" class="txtinput expiryDate" name="expiryDate"></td>
            </tr>
            <tr>
                <td width="20%" class="txtright">使用年限</td>
                <td width="30%">
                    <input type="text" class="txtinput materialSourceId" name="materialSourceId">
                </td>
                
                <td width="20%" class="txtright">性能</td>
                <td width="30%">
                    <input type="text" class="txtinput performance" name="performance">
                </td>
            </tr>
            <tr>
                <td width="20%" class="txtright">用途</td>
                <td colspan="3">
                    <input type="text" class="txtinput purpose" name="purpose">
                </td>
            </tr>
        </table>
        </form>
    </div>
</div>
<script>
laydate({
	  elem: '#purchaseDate', 
	  event: 'focus'
});
laydate({
	  elem: '#createTime', 
	  event: 'focus'
});
laydate({
	  elem: '#expiryDate', 
	  event: 'focus'
});
</script>

<script type="text/javascript">
function getUrlParam(name) {
	 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	 var r = window.location.search.substr(1).match(reg); 
	 if (r != null) return decodeURIComponent(r[2]); return null;
}
var detailsUrl=window.location.search;
getUrlParam(detailsUrl);
if(detailsUrl.indexOf("=")>0){    //这里是详情页的处理js
	var materialIdNum = detailsUrl.substring(detailsUrl.lastIndexOf('=')+1, detailsUrl.length); 
	$.ajax({
		type:'post',
		url:'getEmMaterialById.do',
		data:{materialId:materialIdNum},
		success:function(data){
			if(data.status="0000000"){
				var materialClassifyId="";
				var materialTypeId="";
				var materialSourceId="";
				var areaId="";
				$.each(data.rows,function(m,n){
					materialClassifyId=n.materialClassifyId;
					materialTypeId=n.materialTypeId;
					materialSourceId=n.materialSourceId;
					areaId=n.areaId;
					$(".materialName").val(n.materialName);
					$(".teamId").val(n.teamId);
					$(".num").val(n.num);
					$(".type").val(n.type);
					$(".spec").val(n.spec);
					$(".manufacturer").val(n.manufacturer);
					$(".currentStatus").val(n.currentStatus);
					$(".storagePlace").val(n.storagePlace);
					$(".manufacturer").val(n.manufacturer);
					$(".purchaseDate").val(n.productDateStr);
					$(".createTime").val(n.purchaseDateStr);
					$(".expiryDate").val(n.expiryDateStr);
					$(".materialSourceId").val(n.materialSourceId);
					$(".performance").val(n.performance);
					$(".purpose").val(n.purpose);
				});
				//物资装备分类
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
			 				$('#sect').append(html);
			 				$("#sect").find("option[value="+materialClassifyId+"]").prop("selected",true); 
			 			}else{
			 				alert(data.message);
			 			}
			 		},
			 		err:function(data){
			 			alert(data.message);
			 		}
		 		});
				//物质装备类别
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
							$('#materialId').append(html);
							$("#materialId").find("option[value="+materialTypeId+"]").prop("selected",true); 
						}else{
							alert(data.message)
						}
					},
					err:function(data){
						alert(data.message);
					}
				});
				//物资装备来源
				$.ajax({
					type:'post',
					url:'getMaterialSources.do',
					dataType:"json",
					success:function(data){	
						if(data.status=="0000000"){
							var html="";
							$.each(data.rows,function(m,n){
								html+='<option value="'+n.sourceId+'">'+n.sourceName+'</option>';
							})
							$('#materialSourceId').append(html);
							$("#materialSourceId").find("option[value="+materialSourceId+"]").prop("selected",true); 
						}else{
							alert(data.message)
						}
					},
					err:function(data){
						alert(data.message);
					}
				});
				//获取地区
				$.ajax({
					type:'post',
					url:'getAreaForJiangsuZhenjiang.do',
					dataType:"json",
					success:function(data){	
						if(data.status=="0000000"){
							var html="";
							$.each(data.data,function(m,n){
								html+='<option value="'+n.countyId+'">'+n.areaName+'</option>';
							})
							$('#areaId').append(html);
							$("#areaId").find("option[value="+areaId+"]").prop("selected",true); 
						}else{
							alert(data.message)
						}
					},
					err:function(data){
						alert(data.message);
					}
				});
			}else{
				alert(data.message);
			};
		},
		error:function(data){
			alert(data.message);
		}
	})
}
</script>
</body>
</html>