<%@page import="java.util.Enumeration"%>
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

function loadRoleAuthz(){
	$("#function_tab").datagrid({
     	url:'../authz_manager/authzdata.do'
     });
       
}
</script>
<div id="authzframe" class="easyui-layout" style="width:100%;height:100%;">
	<div data-options="region:'west'" id="roleListDiv" class="easyui-accordion" title="角色列表" style="width:220px;">
	  <ul id="tt" class="easyui-tree" data-options="onClick:loadRoleAuthz">
        <li><span>普通用户</span></li>
        <li><span>超级用户</span></li>
    </ul>
	</div>
	<div data-options="region:'center',href:'../authz_manager/authzlist.do'" id="authzListDiv" class="easyui-panel" title="功能权限" />
	
	</div>
</div>