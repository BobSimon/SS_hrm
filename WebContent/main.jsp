<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>人力资源管理系统</title>
</head>
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<body>

<%
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}

	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="/common/default.jsp";
	}
%>
<div style="margin-top: 20px;"></div>
<div class="container">
  <div class="row">
	  <div class="col-md-12">
	  	<jsp:include page="/common/head.jsp"/>
	  </div>
  </div>
  <div class="row" style="padding-top: 45px">
	  <div class="col-md-3">
	  	<jsp:include page="/common/menu.jsp"/>
	  </div>
	  <div class="col-md-9">
	  	<div>
			<ol class="breadcrumb">
			  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
			  <li class="active">${modeName }</li>
			</ol>
		</div>
		<jsp:include page="<%=mainPage %>"/>
	  </div>
  </div>
  <div class="row">
	  <div class="col-md-12">
	  	<jsp:include page="/common/foot.jsp"/>
	  </div>
  </div>
</div>

</body>
</html>