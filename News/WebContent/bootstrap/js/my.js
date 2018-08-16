function collapseSide(){
	
	var page = document.getElementById("page-wrapper");
	var sideNav = document.getElementById("sideNav");
	var side = sideNav.parentNode;
	
	//获取中心内容的侧边距
	var pageMarginLeft = parseInt(page.style.marginLeft);
	
	if(pageMarginLeft == 0){
		page.style.marginLeft = '260px';
		side.style.marginLeft = '0px';
		
	}else{
		page.style.marginLeft = '0px';
		side.style.marginLeft = '-260px';
	}
}