$(document).ready(function(e) {
	//页面布局调整
	$("#main_leftDiv").height(document.body.offsetHeight- $("#main_topDiv").height()	);
	$("#main_frameDiv").height(document.body.offsetHeight- $("#main_topDiv").height())
	$("#mainIFrame").height($("#main_frameDiv").height());
	$("#mainIFrame").width($("#main_frameDiv").width());
	$("#main_leftMenuIconDiv").height($("#main_leftMenuListUl").height());
	//左侧菜单处理
	// $("#main_menuTopButton div").mouseover(function(e) {
     //    $(this).css("background-image","url(./mtb_over.gif)");
    // });
	// $("#main_menuTopButton div").mouseout(function(e) {
     //    $(this).css("background-image","url(./mtb.gif)");
    // });
	
	$("#main_leftMenuListUl li").mouseover(function(e) {
        if($(this).hasClass("active")){
			return;
		}
		$(this).addClass("over");
    });
	$("#main_leftMenuListUl li").mouseout(function(e) {
        if($(this).hasClass("active")){
			return;
		}
		$(this).removeClass("over");
    });
	$("#main_leftMenuListUl li").click(function(){
		$("#mainIFrame").attr("src",$(this).find("a").get(0).href);
		$("#main_leftMenuListUl li").removeClass("active");
		$("#main_leftMenuListUl li").removeClass("over");
		$(this).addClass("active");
	});
	//表格偶数行与鼠标移动时的样式设置
	$(".grid tr:even").addClass("even");
	$(".grid tr").mouseover(function(e) {
        $(this).addClass("active");
    });
	$(".grid tr").mouseout(function(e){
		$(this).removeClass("active");
	});
	//input=text的提示内容
	$("input[type=text]").val(function(){
		if(this.value==""){
			this.value = this.title;
			$(this).addClass("grey");
			return this.value;
			}
		return this.value;
	});
	
	$("input[type=text]").focus(function(){
		if(this.value==this.title){
			this.value = "";
			$(this).removeClass("grey");
			return this.value;
		}
		return this.value;
	});
	
	$("input[type=text]").blur(function(){
  		if(this.value==""){
			this.value = this.title;
			$(this).addClass("grey");
			return this.value;
			}
		return this.value;
	});
});