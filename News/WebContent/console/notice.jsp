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
    
    <title>控制台-通知详情</title>
    
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
     		<h3>查看通知</h3>
     		<hr/>
     		
     		<div class="text-center">
     			<h2>
     				<c:out value="${notice.title}"></c:out>
     			</h2>
     			<br/>
     		</div>
     			
     		<div class="text-center">
     			<ul class="list-inline">
     				<li>
     					发送者：
     					<c:out value="${notice.sender }"></c:out>
     				</li>
     				<li>
     					时间：
     					<c:out value="${notice.time }"></c:out>
     				</li>
     			</ul>
     		</div>
     		
     		<hr/>
     		
     		<div>
     			${notice.content }
     		</div>
     		
    	</div>
    </div>
    
  </body>
</html>
