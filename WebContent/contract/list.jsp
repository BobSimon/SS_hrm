<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function contractDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/contract/delete.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/contract/list.do";
					}
				}
			);
		}
	}
	
	function beginContract(){
		var x=$("#selectOne").val();
		$('#selectInterviewer').modal('show');
		$("#chooseInte").submit(function() {
			//取面试官ID，求情后台
			var y=$("#chooseInterviewer").val();
			$.post("${pageContext.request.contextPath}/contract/begin.do",{recruitId:x,userId:y},function(){
	            //window.location.href="${pageContext.request.contextPath}/contract/list.do";
	        });
			window.location.href="${pageContext.request.contextPath}/contract/list.do";
		});
	}

	function pass(id){
		if(confirm("确定通过面试吗?")){
			$.post("${pageContext.request.contextPath}/contract/setPass.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("更新成功");
						window.location.href="${pageContext.request.contextPath}/contract/list.do";
					}
				}
			);
		}
	}
	function notPass(id){
		if(confirm("确定淘汰面试者吗?")){
			$.post("${pageContext.request.contextPath}/contract/setNotPass.do",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.errorInfo){
						alert(result.errorInfo)
					}else{
						alert("更新成功");
						window.location.href="${pageContext.request.contextPath}/contract/list.do";
					}
				}
			);
		}
	}
</script>

<div class="row">
	<div class="col-md-6">
		<form class="form-inline">
		  <div class="form-group">
		    <label for="exampleInputName2">选择应聘者</label>
		    <select class="form-control" id="selectOne" name="selectOne">
		      <option value="">请选择...</option>
		      <c:forEach var="recruit" items="${recruitList }">
		      	<option value="${recruit.id }">${recruit.name }&nbsp;&nbsp;${recruit.idcard }&nbsp;&nbsp;${recruit.recruitFrom }</option>
		      </c:forEach>
			</select>
		  </div>
		</form>	
	</div>
	<div class="col-md-6">
		<button class="btn btn-default" id="beginCon" onclick="beginContract()">面试开始</button>
	</div>
</div>


<div class="row search" style="margin-top: 20px;">
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/contract/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="name"  value="${s_contract.name }" placeholder="请输入...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-top: 10px;">
	  <tr>
	  	<th>序号</th>
	  	<th>姓名</th>
	  	<th>性别</th>
	  	<th>身份证号</th>
	  	<th>合同期限</th>
	  	<th>面试官</th>
	  	<th>合同状态</th>
	  	<th>错失原因</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="contract" items="${contractList }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${contract.name }</td>
	  		<td>${contract.sex }</td>
	  		<td>${contract.idcard }</td>
	  		<td>${contract.contractLength }年</td>
	  		<td>${contract.interviewer }</td>
	  		<td>${contract.isOk }</td>
	  		<td>${contract.missReason }</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="pass(${contract.id })">通过</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="notPass(${contract.id })">不通过</button>
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


<div id="selectInterviewer" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">选择面试官</h4>
      </div>
      <div class="modal-body">
        <form class="form-inline" id="chooseInte">
		  <div class="form-group">
		    <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
		    <div class="input-group">
		        <select class="form-control" id="chooseInterviewer" name="chooseInterviewer">
		        	<option value="">请选择...</option>
			        <c:forEach var="userRole1" items="${userListRole1 }">
			        	<option value="${userRole1.userId }">${userRole1.trueName }</option>
			        </c:forEach>
				</select>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary">选择</button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->