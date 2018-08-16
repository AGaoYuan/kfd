<%@page import="cn.news.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>控制台-新闻管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 配置文件 -->
<script type="text/javascript" src="./ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="./ueditor/ueditor.all.js"></script>
<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
<script type="text/javascript" src="./ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="bootstrap/js/ajax.js"></script>
<jsp:include page="/console/common/css.jsp" />
<jsp:include page="/console/common/js.jsp" />
<script type="text/javascript" src="/js/jQuery1.11.1.js"></script>
<script type="text/javascript" src="/js/fenye.js"></script>


<script type="text/javascript">
		
		function listCondition(pageindex){
			location.href="/News/UserInfoServlet?action=list&curPage="+pageindex+"&Uname=${UserName}";
			
		}
		
		
	 	function del(id){
	 		 $('#url').val(id);
			 $('#delcfmModel').modal();
	 	}
	 	
	 	function update(id){
	 		location.href="/News/UserInfoServlet?action=modify&uid="+id;
	 		/* alert(id); */
	 	}
	 	
	 	function urlSubmit(){
			var  id=$('#url').val();
		    location.href="${pageContext.request.contextPath}/UserInfoServlet?action=del&id="+id;
	 	}
	 	
	 	window.onload=function(){
	 		$("#myAlert").hide();
	 		if($("#msg").val()!=""){
	 			$("#myAlert").show();
	 			$("#myAlert").hide(5000);
	 		}
	 		
	 	}
	 	
	 </script>
<script type="text/javascript">
	 var totalRecords=${pageutil.totalRecords}
	 var pageSize=${pageutil.pageSize}
	 var totalPages=${pageutil.totalPages}
	 var prevtotal = ${pageutil.totalPages-1}
	 
	 layui.use(['laypage', 'layer'], function(){
		  var laypage = layui.laypage
		  ,layer = layui.layer;
	 	laypage.render({
		    elem: 'demo7'
		    ,count: totalRecords
		    ,limit:pageSize
		    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
		    ,jump: function(obj){
		      console.log(obj.count);
		      console.log(obj.limit);
		      
		    }
		  });
	 });
	 
	 </script>


<style type="text/css">
#save {
	float: right;
}
#export{
float: laft;
}
</style>
</head>

<body>
	<jsp:include page="/console/common/console-header.jsp" />
	<!-- 内容 -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div>
				<ol class="breadcrumb">
					<li class="active">Home</li>
					<li class="active">Manage</li>
					<li class="active">NewsManage</li>
				</ol>
			</div>
			<hr />
			
			<a id="export" href="/News/UserInfoServlet?action=export"
				class="btn btn-info">导出报表</a>
				
				<div>
				<form action="/News/UserInfoServlet?action=list" method="post">
              		<label for="title">请输入用户名：</label>
                	<input type="text" name="Uname" value="${UserName }" >
                	<input type="submit" class="btn btn-info" value="查询"/>
                	</form>
            	</div>
				
			<!-- 新闻管理 -->
			<a id="save" href="/News/UserInfoServlet?action=oper"
				class="btn btn-info">添加</a>
				
				<div id="myAlert" class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert">&times;</a>
					<strong>${MSG }</strong>
				</div>
				<input type="hidden" id="msg" value="${MSG }" />
				
			<div id="myNotice" class="text-center">
				<table class="table table-bordered table-striped">
					<!-- 表头  -->
					<tr class="active">
						<th>用户编号</th>
						<th>用户名称</th>
						<th colspan="2" class="text-center">操作</th>
					</tr>

					<c:forEach items="${pageutil.list }" var="user">
						<tr>
							<td>${user.uid }</td>
							<td>${user.uname }</td>
							<td><input type="hidden" id="url" value="${user.uid }" />
								<button class="btn btn-danger" onclick="del(${user.uid })">
									删除</button></td>
							<td>
								<button class="btn btn-info" onclick="update(${user.uid })">编辑</button>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<!-- /用户管理 -->
			<!-- 页码导航 -->
			<div id="pageNavication" class="text-center">

			<table class="layui-hide" id="LAY_table_user" lay-filter="useruv"></table>

				<div id="demo7"></div>

				<ul class="list-inline">
					<li><a href="/News/UserInfoServlet?action=list&curPage=1">
							<button class="btn btn-default">首页</button>
					</a></li>
					<c:if test="${pageutil.pageIndex>1}">
						<li><a
							href="/News/UserInfoServlet?action=list&curPage=${pageutil.pageIndex-1}">
								<button class="btn btn-default">前一页</button>
						</a></li>
					</c:if>

					<c:forEach var="i" begin="${pageutil.pageIndex }"
						end="${pageutil.totalPages}">
						<li><c:if test="${i!=curPage}">
								<a href="/News/UserInfoServlet?action=list&curPage=${i}">
									<button class="btn btn-default">
										<c:out value="${i}"></c:out>
									</button>
								</a>
							</c:if></li>
					</c:forEach>
					<c:if test="${pageutil.pageIndex<pageutil.totalPages }">
						<li><a
							href="javascript:listCondition(${pageutil.pageIndex+1})">
								<button class="btn btn-default">后一页</button>
						</a></li>
					</c:if>
					<li><a
						href="/News/UserInfoServlet?action=list&curPage=${pageutil.totalPages}">
							<button class="btn btn-default">尾页</button>
					</a></li>
				</ul>
			</div>
			<!-- /页码导航 -->
		</div>
	</div>

	<div class="modal fade" id="delcfmModel">
		<div class="modal-dialog">
			<div class="modal-content message_align">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body">
					<p>您确认要删除吗？</p>
				</div>
				<div class="modal-footer">
					<input type="hidden" id="url" />
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<a onclick="urlSubmit()" class="btn btn-success"
						data-dismiss="modal">确定</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



</body>
</html>
