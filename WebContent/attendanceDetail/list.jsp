<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkAttendanceDetail() {
		if(confirm("确定要刷新考勤吗?")){
			$.post("${pageContext.request.contextPath}/attendanceDetail/check.do",
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("刷新成功");
						window.location.href="${pageContext.request.contextPath}/attendanceDetail/list.do";
					}
				}
			);
		}
	}
</script>

<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/attendanceDetail/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <!--input type="text" class="form-control" name="day"  value="${s_attendanceDetail.day }" placeholder="请输入日期..."-->
		      <input type="text" class="form-control" name="empId"  value="${s_attendanceDetail.empId }" placeholder="请输入员工(员工ID)...">
		      <input type="text" class="form-control" name="adState"  value="${s_attendanceDetail.adState }" placeholder="请输入状态(0或1)...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="checkAttendanceDetail()">刷新考勤记录表</button>
  </div>
</div>
<div>
	<table class="table table-hover table-bordered table-striped table-condensed" style="margin-top: 10px;">
	  <tr>
	  	<th>编号</th>
	  	<th>日期</th>
	  	<th>上班打卡</th>
	  	<th>下班打卡</th>
	  	<th>上班提报</th>
	  	<th>下班提报</th>
	  	<th>年</th>
	  	<th>病</th>
	  	<th>事</th>
	  	<th>员</th>
	  	<th>状态</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="attendanceDetail" items="${attendanceDetailList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td><fmt:formatDate value="${attendanceDetail.day }" type="date" pattern="yyyy-MM-dd"/></td>
	  		<td><fmt:formatDate value="${attendanceDetail.recordComeTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	  		<td><fmt:formatDate value="${attendanceDetail.recordLeaveTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	  		<td><fmt:formatDate value="${attendanceDetail.reportComeTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	  		<td><fmt:formatDate value="${attendanceDetail.reportLeaveTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	  		<td>${attendanceDetail.isAnnualLeave }</td>
	  		<td>${attendanceDetail.isSickLeave }</td>
	  		<td>${attendanceDetail.isAPersonalLeave }</td>
	  		<td>${attendanceDetail.empId }</td>
	  		<td>${attendanceDetail.adState==1? '<font color="green">OK</font>':'<font color="red">Error</font>' }</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/attendanceDetail/edit.do?id=${attendanceDetail.id }'">操作</button>
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



