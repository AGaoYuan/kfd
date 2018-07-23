/*
 * 1.图片轮播
 */
//先获取到整个图片轮播区的div

//定义全局图片的index
var num1;
//定义轮播数量变量
var num=0;
$(document).ready(function(){
	
	 //固定定位
	 $("#right").css({"position":"fixed","right":"30px","top":"50px"});
	 $("#dd_close").click(function(){
		 $("#right").remove();
	 });
	 //无缝滚动
	 rolling();
	 //图片轮播
	 $('#scroll_number li:nth-of-type(1)').siblings().css("background","#333333");
	 $('#scroll_number li:nth-of-type(1)').css("background","orange");
	 var temp = setInterval(goNextIndex,2000);
	 $('#scroll_number li').hover(function(){
		 clearInterval(temp);
		 num1 = $(this).html();
		 $("#scroll_img li img").attr("src","images/scroll-0"+num1+".jpg");
		 $('#scroll_number li:nth-of-type('+ num1 +')').siblings().css("background","#333333");
		 $('#scroll_number li:nth-of-type('+ num1 +')').css("background","orange");
	 },function(){
		 num = num1;
		 temp = setInterval(goNextIndex,2000);
		 
	 });
	 
	 //图片放大
	 $(".book ul li img").mousemove(function(){
			$(this).css("width","250px");
		}).mouseout(function(){
			$(this).css("width","190px");
	});
	 
	 //悬浮
	 Fold();
	 
	 
});

//把选中的元素显示，其他的隐藏
function Fold(){
	//悬浮显示
	$(".tab ol li:eq(1)").mouseenter(function(){
		$(".tab ul:eq(0)").hide();
		$(".tab ul:eq(1)").show();
		$(this).css({"background":"#ffffff","border":"0px"});
		$(".tab ol li:eq(0)").css({"background":"#efefef","border":"1px"});
	});
	
	$(".tab ol li:eq(0)").mouseenter(function(){
		$(".tab ul:eq(1)").hide();
		$(".tab ul:eq(0)").show();
		$(this).css({"background":"#ffffff","border":"1px"});
		$(".tab ol li:eq(1)").css({"background":"#efefef","border":"1px"});
	});
	
	$(".tab ul li").hover(function(){
		$(this).find("p").show();
		$(this).find("dl").show();
	},function(){
		if ($(this).index()==$(this).parent().children().length-1) {
			$(this).siblings().find("p").hide();
			return;
		}
		$(this).siblings().find("p").show();
		$(this).find("dl").hide();
	});
	
}

//无缝滚动
function rolling(){
	var i = 0;
	var stop=false;
    $("#dome").scrollTop(i);
    var myul = $("#dome").html();
    myul += myul;
    $("#dome").html(myul);
    
    setInterval(function () {
		if(stop)
		return;
        $("#dome").scrollTop(i++);
        if (i == $("#dome").height()) {
            i = 0;
            $("#dome").scrollTop(i);
        }
    }, 50);
	$("#dome").mouseover(function(){
		stop=true;
	}).mouseout(function(){
		stop=false;
	});
}


//图片轮播
function goNextIndex(){
	if (num==4) {
		num=0;
	}
	num++;
	if (num>0) {
		$('#scroll_img li img').attr("src","images/scroll-0"+num+".jpg");
		$('#scroll_number li:nth-of-type('+ num +')').siblings().css("background","#333333");
		$('#scroll_number li:nth-of-type('+ num +')').css("background","orange");
		
	}
	
}


