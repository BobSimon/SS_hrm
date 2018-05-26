<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	
	function checkForm(){
		var name=$("#name").val();
		var empName=$("#empName").val();
		if(name==null || name==""){
			$("#error").html("培训项目名称不能为空！");
			return false;
		}
		if(empName==null || empName==""){
			$("#error").html("员工不能为空！");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#name").val("");
		$("#empName").val("");
	}
</script>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/train/save.do" onsubmit="return checkForm()">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">培训名称：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="name" name="name" value="${train.name }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">培训内容：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="content" name="content" value="${train.content }" style="width: 300px">
	    </div>
	  </div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label">员工：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="empName" name="empName" value="${train.empName }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">状态：</label>
	    <div class="col-sm-10">
	    	<select class="form-control" id="isOk" name="isOk" style="width: 300px">
				<option value="">请选择状态...</option>
				<option value="1">合格</option>
				<option value="0">不合格</option>
			</select>
	     </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="hidden" id="id" name="id" value="${train.id }"/>
	      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1)">返回</button>&nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
  </div>
</div>