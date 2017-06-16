<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<script language="javascript">

function leaveAppSubmit() {
	 $('#leaveAppForm').form('submit',{
		url : "<%=request.getContextPath()%>/leaveapp/apply.json",
		dataType:'json', 
		onSubmit: function () {
			var isValid = $(this).form('validate'); 
	        if (!isValid) { 
	        	$.messager.alert('提交','请假申请提交失败,请检查输入项。','error');
	        } 
	        return isValid; // 如果验证不通过，返回false终止表单提交 
        }, 
		success : function(result) 
		{
			var json = JSON.parse(result);
			if(json.status=="0000000")
			{
				$.messager.alert('请假申请',"申请成功",'info');
				$('#leaveapptab').datagrid('reload'); 
			}else{
				$.messager.alert('申请失败',json.message,'error');
			}
			$('#leaveAppWin').window('close');
		}
	});
	
}

</script>
<div id="leaveAppWin" class="easyui-window" title="请假申请" data-options="iconCls:'icon-man',closed:true" style="width:400px;height:330px;padding:10px; text-align: center;">
		
		<form id="leaveAppForm" class="easyui-form" method="post" action="<%=request.getContextPath()%>/leaveapp/apply.json">
		<div style="margin-bottom: 10px">
			<select class="easyui-combobox" id="leaveType" name="leaveType" label="请假类型" 
				data-options="iconWidth:28,required:true,url:'<%=request.getContextPath()%>/pub/leavetype.json',valueField:'statusId',textField:'statusDesc'" style="width: 90%; height: 30px; padding: 5px">
				
			</select>
		</div>
		
		<div style="margin-bottom: 10px">
			<input class="easyui-datebox" id="startDate" name="startDate"
				type="text" style="width: 90%; height: 30px; padding: 5px"
				data-options="label:'开始日期',required:true">
		</div>
		<div style="margin-bottom: 10px">
			<input class="easyui-datebox" id="endDate" name="endDate"
				type="text" style="width: 90%; height: 30px; padding: 5px"
				data-options="label:'结束日期',required:true">
		</div>
		<div style="margin-bottom: 10px">
			<input class="easyui-textbox" id="leaveReason" name="leaveReason"
				type="text" style="width: 90%; height: 100px; padding: 5px"
				data-options="multiline:true,label:'原因说明',required:true">
		</div>
		
		
		<div>
			<a href="javascript:leaveAppSubmit()" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'"
				style="padding: 5px 0px; width: 90%;"> <span
				style="font-size: 14px;">申请</span>
			</a>
		</div>
		</form>
</div>

