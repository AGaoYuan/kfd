<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>控制台-添加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <jsp:include page="/console/common/css.jsp" />
	<jsp:include page="/console/common/js.jsp" /> 
	<script type="text/javascript">
		
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
 						<li class="active">Notice</li>
  						<li class="active">Release</li>
					</ol>
    			</div>
    			<hr/>
     			<form  action="${pageContext.request.contextPath}/UserInfoServlet?action=${oper}" method="post">
     				
	      			<!-- 通知标题 -->
     				<div>
              			<label for="title">用户名</label>
                		<input type="text" class="form-control" id="title" name="userName" value="${item.uname }" placeholder="请输入通知标题" required>
            		</div>
            		
            		<input type="hidden" name="uid" value="${item.uid }">
            		
            		<!-- 通知接收者 -->
            		<div>
            			<label for="receiver">密码</label>
            			<input type="password" class="form-control" id="title" name="userPwd" value="${item.upwd }" placeholder="请输入通知标题" required>
            			 
            		</div>
	      			
	       			<hr/>
	       			<!-- 按钮 -->
	       			<div class="text-right"><!-- noticeRelease() -->
	       				<button class="btn btn-default btn-danger" type="reset">重置</button>
	       				<button class="btn btn-default btn-info" type="submit" >提交</button>
	       			</div>
	       					
        		</form>
        				
    		</div>
    	</div>
  </body>
</html>
