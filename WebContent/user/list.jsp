<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function userDelete(userId){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/user/delete.do",{userId:userId},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/user/list.do";
					}
				}
			);
		}
	}
</script>
<div class="row search">
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/user/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="trueName"  value="${s_user.trueName }" placeholder="请输入要查询的用户名...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/preSave.do'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-top: 10px;">
	  <tr>
	  	<th>序号</th>
	  	<th>用户名</th>
	  	<th>密码</th>
	  	<th>真实姓名</th>
	  	<th>角色</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="user" items="${userList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${user.userName }</td>
	  		<td>${user.password }</td>
	  		<td>${user.trueName }</td>
	  		<td>${user.role }</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/user/preSave.do?userId=${user.userId }'">修改</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="userDelete(${user.userId })">删除</button>
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
