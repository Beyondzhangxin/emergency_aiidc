
/**
 * 数据过滤器
 * 判断服务器端返回数据是否包含错误
 * @param data
 * @returns
 */
function dataLoadFilter(data)
{
	
	if("0000000"==data.status){
		return data;
	}else{
		$.messager.alert(data.status,data.message,'error');
		return null;
	}
}




/**
 * 显示对象的属性和方法
 * 主要用于调试
 * @param Obj
 * @returns
 */
function showObjProperty(Obj) 
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