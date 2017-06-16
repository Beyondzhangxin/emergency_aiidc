<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<script>

function formatActions(value)
{
	
	var ret = "";
	for(i in value){
		val = "<input type='checkbox' value='"+value[i]["actionId"]+"'>";
		ret += val + value[i]["actionName"] + " ";
	}
	
	return ret;
}
</script>

<table id="function_tab" style="width:100%;height:100%" class="easyui-datagrid" 
	data-options="collapsible:false,
				  method:'get',
				  rownumbers:true,
				  loadFilter:dataLoadFilter">
    <thead>
        <tr>
            <th data-options="field:'funcId'" width="150" align="center">功能代码</th>
            <th data-options="field:'funcName',editor:'text'" width="240" align="center">功能名称</th>
            <th data-options="field:'actions',formatter:formatActions" width="400" align="center">操作列表</th>
        </tr>
    </thead>
</table>


