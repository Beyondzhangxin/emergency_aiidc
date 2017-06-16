$(function(){	
	$(".nav_item").first().css("margin-left","10px");
	$(".nav_item").click(function(){
		$(this).addClass("nav_item1").siblings().removeClass("nav_item1");
	})
	//tab
	$(".tabtitle").click(function(){
		$(this).addClass("tabtitle1").siblings().removeClass("tabtitle1");
	})	
	//tab
	$(".table_tab").click(function(){
		$(this).addClass("table_tab1").siblings().removeClass("table_tab1");
	})	
	$(".content_tab").click(function(){
		$(this).addClass("content_tab1").siblings().removeClass("content_tab1");
	})
	$(".nav_item").mouseenter(function(){
		$(this).children(".menubox").show();
	}).mouseleave(function(){
		$(this).children(".menubox").hide();
	})
	$(".menubox>li").click(function(){
		$(".menubox").hide();
	})
	$(".btn_search").click(function(){
		$(".searchbox").slideToggle();
	})
})
function getUrl(url){
	 var url=url.getAttribute("data-href");
	 document.getElementsByTagName('iframe')[0].setAttribute("src",url);
};
function selectAll(e){
	if($(e).prop("checked")){
		$('tbody').find('input').prop("checked",true);
	}else{
		$('tbody').find('input').prop("checked",false);
	}
};
/*var dto = new Object();
function search(e1,e2,e3,e4){
	var key = $(e1).attr("name");
	dto[key] = $(e1).val();
	var key2=$(e2).attr('name');
	dto[key2]=$(e2).val();
	var key3=$(e3).attr('name');
	dto[key3]=$(e3).val();
	var key4=$(e4).attr('name');
	dto[key4]=$(e4).val();
	console.log(dto)
	searchContent();
};*/