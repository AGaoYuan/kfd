<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	 <script type="text/javascript">
	 	function update(id){
	 		alert(id);
	 		if (id!=null) {
				location.href="/News/CategoryInfoServlet?action=UpAll&cid="+id;
			}
	 	}
	 
	 </script>
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
    			<hr/>
     			<!-- 新闻管理 -->
        		<div id="myNotice" class="text-center">
        			<table class="table table-bordered table-striped">
        				<!-- 表头  -->
        				<tr class="active">
        					<th>新闻类型编号</th>
        					<th>新闻类型名称</th>
        					<th colspan="2" class="text-center">操作</th>
        				</tr>
        				<c:forEach items="${pageutil.list }" var="cate">
        					<tr>
        						<td>${cate.cateid }</td>
        						<td>${cate.catename }</td>
        						<td>
        							<a href="/News/CategoryInfoServlet?action=del&cateid=${cate.cateid }">
        								<button class="btn btn-danger">
        									删除
        								</button>
        							</a>
        						</td>
        						<td>
        							<button class="btn btn-info" onclick="update(${cate.cateid })">编辑</button>
        						</td>
        					</tr>
        				</c:forEach>
        				<%-- <c:forEach items="${allNews}" var="list">
        					<tr >
        						<td><c:out value="${list.type}"/></td>
        						<td><c:out value="${list.title}"/></td>
        						<td><c:out value="${list.name}"/></td>
        						<td><c:out value="${list.time}"/></td>
        						<td>
        							<a href="/NewsRelease/servlet/NewsDeleteServlet?newsid=${list.newsid}">
        								<button class="btn btn-danger">
        									删除
        								</button>
        							</a>
        						</td>
        						<td>
        							<button class="btn btn-info">更新</button>
        						</td>
        					</tr>
        				</c:forEach> --%>
        			</table>	
        		</div>
        		<!-- /新闻管理 -->	
        		<!-- 页码导航 -->
        		<div id="pageNavication" class="text-center">
        			<ul class="list-inline">
        				<li>
        					<a href="/News/CategoryInfoServlet?action=categorylist&curPage=1">
        						<button class="btn btn-default">	
        						首页
        						</button>
        					</a>
        				</li>
        				
        				<!-- 判断临界值，大于1则可以前进到下一页数据 begin -->
        				<c:if test="${pageutil.pageIndex>1}">
        				<li>
        					<a href="/News/CategoryInfoServlet?action=categorylist&curPage=${pageutil.pageIndex-1}">
        						<button class="btn btn-default">	
        						前一页
        						</button>
        					</a>
        				</li>
        				</c:if>
        				<!-- 判断临界值，大于1则可以前进到下一页数据 end -->
        				
        				<c:forEach var="i" begin="${pageutil.pageIndex}" end="${pageutil.totalPages}">
        					<li>
        					  <c:if test="${i!=curPage}">
        						<a href="/News/CategoryInfoServlet?action=categorylist&curPage=${i}">
        							<button class="btn btn-default">	
        								<c:out value="${i}"></c:out> 
        							</button>
        						</a>
        					  </c:if>
        					</li>
        				</c:forEach>
        				
        				<!-- 判断页数是否大于总页数 begin -->
        				<c:if test="${pageutil.pageIndex<pageutil.totalPages }">
        				<li>
        					<a href="/News/CategoryInfoServlet?action=categorylist&curPage=${pageutil.pageIndex+1}">
        						<button class="btn btn-default">	
        						后一页
        						</button>
        					</a>
        				</li>
        				</c:if>
        				<!-- 判断页数是否大于总页数 end -->
        				
        				<li>
        					<a href="/News/CategoryInfoServlet?action=categorylist&curPage=${pageutil.totalPages}">
        						<button class="btn btn-default">	
        						尾页
        						</button>
        					</a>
        				</li>
        			</ul>
        		</div>
        		<!-- /页码导航 -->	
    		</div>
    	</div>
  </body>
</html>
