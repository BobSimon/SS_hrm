<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function employeeDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/employee/delete.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/employee/list.do";
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/employee/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="empName"  value="${s_employee.empName }" placeholder="请输入...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/preSave.do'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-top: 10px;">
	  <tr>
	  	<th>编号</th>
	  	<th>工号</th>
	  	<th>姓名</th>
	  	<th>性别</th>
	  	<th>民族</th>
	  	<th>政治面貌</th>
	  	<th>部门</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="employee" items="${employeeList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${employee.employeeNo }</td>
	  		<td>${employee.empName }</td>
	  		<td>${employee.empSex }</td>
	  		<td>${employee.empNation }</td>
	  		<td>${employee.empZzmm }</td>
	  		<td>${employee.deptName }</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/view.do?id=${employee.employeeId }'">查看详情</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="employeeDelete(${employee.employeeId })">删除</button>
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

