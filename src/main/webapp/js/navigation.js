function buildNavigation(contextRoot,navDataUrl){
	$.ajax({
		url:contextRoot+"/" +navDataUrl,
		type:"post",
		dataType:"json",
		success:function(result)
		{
			
			if(result.status!="0000000"){
				$.messager.alert(result.status,result.message,"error");
				return;
			}
			for(var o in result.data){
				treeMenuId = "menu_" +  result.data[o].id;
				
				$('#menuDiv').accordion('add',{
					id:treeMenuId,
					title:result.data[o].text,
					iconCls:result.data[o].iconCls,
					content:'<div style="padding:10px"></div>'
				});
				
				var mid = '#' + treeMenuId;
				$(mid).tree({
					data:  result.data[o].children,
					onClick:function (node) {
						
						if (node.children)
				        {
				        	if(node.state=='open')
				        		$(mid).tree('collapse',node.target);
				        	else
				        		$(mid).tree('expand',node.target);
				        }else{
				        	if ($("#mainTabs").tabs('exists', node.text)) {
					            $('#mainTabs').tabs('select', node.text);
				        	}else{
				        		$('#mainTabs').tabs('add',{
									title:node.text,
									closable:true,
									iconCls:node.iconCls,
									href:contextRoot + "/"+node.funcid+"/" + node.action +".do"
								});
				        	}
				        }
				    }
				});
			}
			$('#menuDiv').accordion({
				active:0
			});
			
		}
	});
}

function crtNewTab(funcId,funName,action,iconCls)
{
	if ($("#mainTabs").tabs('exists', funName)) {
        $('#mainTabs').tabs('select', funName);
	}else{
		$('#mainTabs').tabs('add',{
			title:funName,
			closable:true,
			iconCls:iconCls,
			href: "../"+funcId+"/" + action +".do"
		});
	}
}

function ShowObjProperty(Obj) 
{ 
var PropertyList=''; 
var PropertyCount=0; 
for(i in Obj){ 
if(Obj.i !=null) 
PropertyList=PropertyList+i+'属性：'+Obj.i+'\r\n'; 
else 
PropertyList=PropertyList+i+'方法\r\n'; 
} 
alert(PropertyList); 
} 