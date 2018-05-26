<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	
	function checkForm(){
		var name=$("#name").val();
		var sex=$("#sex").val();
		var idcard=$("#idcard").val();
		var recruitFrom=$("#recruitFrom").val();
		if(name==null || name==""){
			$("#error").html("姓名不能为空！");
			return false;
		}
		if(sex==null || sex==""){
			$("#error").html("性别不能为空！");
			return false;
		}
		if(idcard==null || idcard==""){
			$("#error").html("身份证号不能为空！");
			return false;
		}
		if(recruitFrom==null || recruitFrom==""){
			$("#error").html("招聘来源不能为空！");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#name").val("");
		$("#sex").val("");
		$("#idcard").val("");
		$("#recruitFrom").val("");
	}
</script>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/recruit/save.do" onsubmit="return checkForm()">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">姓名：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="name" name="name" value="${recruit.name }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">性别：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="sex" name="sex" value="${recruit.sex }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">身份证号：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="idcard" name="idcard" value="${recruit.idcard }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">招聘来源：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="recruitFrom" name="recruitFrom" value="${recruit.recruitFrom }" style="width: 300px">
	    </div>
	  </div>
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="hidden" id="id" name="id" value="${recruit.id }"/>
	      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1)">返回</button>&nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
  </div>
</div>