<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>控制台主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="/console/common/css.jsp" />
	<jsp:include page="/console/common/js.jsp" />
  </head>
  
  <body>
	<jsp:include page="/console/common/console-header.jsp" />
    <!-- 内容 -->
	<div id="page-wrapper">
    	<div id="page-inner">
     		<h2>欢迎来到新闻发布系统控制台</h2>
     		<hr/>
    	</div>
    </div>
    
  </body>
</html>
