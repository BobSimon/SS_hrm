<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	
	function checkForm(){
		var hoursOfG1=$("#hoursOfG1").val();
		var month=$("#month").val();
		var employeeNo=$("#employeeNo").val();
		if(hoursOfG1==null || hoursOfG1==""){
			$("#error").html("正常工作时数不能为空！");
			return false;
		}
		if(month==null || month==""){
			$("#error").html("月份不能为空！");
			return false;
		}
		if(employeeNo==null || employeeNo==""){
			$("#error").html("工号不能为空！");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#hoursOfG1").val("");
		$("#month").val("");
		$("#employeeNo").val("");
		//其他重置表单JS代码暂时不写
	}
</script>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/salary/save.do" onsubmit="return checkForm()">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">正常工作时数(G1)：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfG1" name="hoursOfG1" value="${salary.hoursOfG1 }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">加班工作时数(G2)：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfG2" name="hoursOfG2" value="${salary.hoursOfG2 }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">非工作日加班(G3)：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfG3" name="hoursOfG3" value="${salary.hoursOfG3 }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">年休时数：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfAnnualLeave" name="hoursOfAnnualLeave" value="${salary.hoursOfAnnualLeave }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">病假时数：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfSickLeave" name="hoursOfSickLeave" value="${salary.hoursOfSickLeave }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">事假时数：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="hoursOfPersonalLeave" name="hoursOfPersonalLeave" value="${salary.hoursOfPersonalLeave }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">旷工时数：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="absenteeism" name="absenteeism" value="${salary.absenteeism }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">月份：</label>
	    <div class="col-sm-10">
		    <select class="form-control" id="month" name="month" style="width: 300px">
					<option value="">请选择月份...</option>
					<c:forEach begin="1" end="12" varStatus="status">
						<option value="${status.index }" ${salary.month==status.index?'selected':'' }>${status.index }月份</option>
					</c:forEach>
			</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">员工工号：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="employeeNo" name="employeeNo" value="${salary.employeeNo }" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">员工姓名：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="empName" name="empName" value="${salary.empName }" style="width: 300px">
	    </div>
	  </div>

	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="hidden" id="id" name="id" value="${salary.id }"/>
	      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
	      <button type="button" class="btn btn-primary" onclick="javascript:history.back(-1)">返回</button>&nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
  </div>
</div>