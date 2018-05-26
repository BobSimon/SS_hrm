<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function trainDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/train/delete.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/train/list.do";
					}
				}
			);
		}
	}
</script>
<div class="row search">
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/train/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="name"  value="${s_train.name }" placeholder="请输入...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/train/preSave.do'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-top: 10px;">
	  <tr>
	  	<th>序号</th>
	  	<th>培训名称</th>
	  	<th>参加日期</th>
	  	<th>培训内容</th>
	  	<th>员工</th>
	  	<th>是否合格</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="train" items="${trainList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${train.name }</td>
	  		<td><fmt:formatDate value="${train.joinTime }" type="date" pattern="yyyy-MM-dd"/></td>
	  		<td>${train.content }</td>
	  		<td>${train.empName }</td>
	  		<td>${train.isOk==1? '<font color="green">合格</font>':'<font color="red">不合格</font>'}</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/train/preSave.do?id=${train.id }'">修改</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="trainDelete(${train.id })">删除</button>
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
