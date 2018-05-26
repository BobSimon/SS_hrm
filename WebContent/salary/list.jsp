<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function salaryDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/salary/delete.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/salary/list.do";
					}
				}
			);
		}
	}
</script>

<div class="row">
<div class="col-md-12">
	<button class="btn btn-info btn-sm">计算月薪</button>
</div>
</div>

<div class="row search" style="margin-top:10px;">
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/salary/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="employeeNo"  value="${s_salary.employeeNo }" placeholder="请输入工号...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/salary/preSave.do'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-top: 10px;">
	  <tr>
	  	<th>序号</th>
	  	<th>G1</th>
	  	<th>G2</th>
	  	<th>G3</th>
	  	<th>年</th>
	  	<th>病</th>
	  	<th>事</th>
	  	<th>旷</th>
	  	<th>月薪</th>
	  	<th>月份</th>
	  	<th>工号</th>
	  	<th>姓名</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="salary" items="${salaryList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${salary.hoursOfG1 }</td>
	  		<td>${salary.hoursOfG2 }</td>
	  		<td>${salary.hoursOfG3 }</td>
			<td>${salary.hoursOfAnnualLeave }</td>
			<td>${salary.hoursOfSickLeave }</td>
			<td>${salary.hoursOfPersonalLeave }</td>
			<td>${salary.absenteeism }</td>
			<td>${salary.monthlyPay }</td>
			<td>${salary.month }</td>
			<td>${salary.employeeNo }</td>
			<td>${salary.empName }</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/salary/preSave.do?id=${salary.id }'">修改</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="salaryDelete(${salary.id })">删除</button>
	  			<button class="btn btn-info btn-xs">生成工资单</button>
	  		</td>
	  	</tr>
	  </c:forEach>
	</table>
	<!-- list后的分页 -->
	<nav aria-label="Page navigation" class="text-center">
	  	<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>
