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
    
    <title>控制台-我的通知</title>
    
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
  </head>
  
  <body>
    <jsp:include page="/console/common/console-header.jsp" />
    	<!-- 内容 -->
		<div id="page-wrapper">
    		<div id="page-inner">
    			<div>
    				<ol class="breadcrumb">
 						<li class="active">Home</li>
 						<li class="active">Notice</li>
  						<li class="active">MyNotice</li>
					</ol>
    			</div>
    			<hr/>
     			<!-- 我的通知 -->
        		<div id="myNotice" class="text-center">
        			<table class="table table-bordered table-striped">
        				<!-- 表头  -->
        				<tr class="active">
        					<th>标题</th>
        					<th>发送者</th>
        					<th>接收者</th>
        					<th>时间</th>
        				</tr>
        				<c:forEach items="${notices}" var="list">
        					<tr >
        						<td>
        							<a href="/NewsRelease/servlet/NoticeDetailServlet?noticeid=${list.noticeid}">
        								<c:out value="${list.title}"/>
        							</a>
        						</td>
        						<td><c:out value="${list.sender}"/></td>
        						<td><c:out value="${list.receiver}"/></td>
        						<td><c:out value="${list.time}"/></td>
        					</tr>
        				</c:forEach>
        			</table>	
        		</div>
        		<!-- /我的通知 -->	
        		<!-- 页码导航 -->
        		<div id="pageNavication" class="text-center">
        			<ul class="list-inline">
        				<li>
        					<a href="/NewsRelease/servlet/MyNoticeServlet?curPage=1">
        						<button class="btn btn-default">	
        						首页
        						</button>
        					</a>
        				</li>
        				<li>
        					<a href="/NewsRelease/servlet/MyNoticeServlet?curPage=${curPage-1}">
        						<button class="btn btn-default">	
        						前一页
        						</button>
        					</a>
        				</li>
        				
        				<c:forEach var="i" begin="${beginPage}" end="${endPage}">
        					<li>
        					  <c:if test="${i==curPage}">	
        							<c:out value="${i}" ></c:out> 
        					  </c:if>
        					  
        					  <c:if test="${i!=curPage}">
        						<a href="/NewsRelease/servlet/MyNoticeServlet?curPage=${i}">
        							<button class="btn btn-default">	
        								<c:out value="${i}"></c:out> 
        							</button>
        						</a>
        					  </c:if>
        					</li>
        				</c:forEach>
        				
        				<li>
        					<a href="/NewsRelease/servlet/MyNoticeServlet?curPage=${curPage+1}">
        						<button class="btn btn-default">	
        						后一页
        						</button>
        					</a>
        				</li>
        				<li>
        					<a href="/NewsRelease/servlet/MyNoticeServlet?curPage=${noticePage}">
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
