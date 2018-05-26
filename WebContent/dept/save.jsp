<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	
	function checkForm(){
		var deptName=$("#deptName").val();
		if(deptName==null || deptName==""){
			$("#error").html("部门名称不能为空！");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#deptName").val("");
	}
</script>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/dept/save.do" onsubmit="return checkForm()">
	  <div class="form-group">
	    <label class="col-sm-3 control-label">部门名称：</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="deptName" name="deptName" value="${dept.deptName }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-3 col-sm-9">
	      <input type="hidden" id="deptId" name="deptId" value="${dept.deptId }"/>
	      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1)">返回</button>&nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
  </div>
</div>