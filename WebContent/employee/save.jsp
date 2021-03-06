<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	
	function checkForm(){
		var empName=$("#empName").val();
		if(empName==null || empName==""){
			alert("姓名不能为空！");
			return false;
		}
		//其他的前端验证暂时不写
		return true;
	}
	
</script>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form method="post" action="${pageContext.request.contextPath}/employee/save.do" onsubmit="return checkForm()" enctype="multipart/form-data">
		<div class="row viewPage">
			<div class="col-md-8">
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>工号：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="employeeNo" name="employeeNo" value="${employee.employeeNo }" placeholder="工号由系统生成" readonly/>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>姓名：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="empName" name="empName" value="${employee.empName }"/>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>性别：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="empSex" name="empSex">
						    <option value="">请选择性别...</option>
							<c:forEach var="sexData" items="${sexDataDicList }">
								<option value="${sexData.ddValue }" ${employee.empSex==sexData.ddValue?'selected':'' }>${sexData.ddValue }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>身份证号：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="empIdcard" name="empIdcard" value="${employee.empIdcard }"/>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>所属部门：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="deptId" name="deptId">
							<option value="">请选择部门...</option>
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptId }" ${employee.deptId==dept.deptId?'selected':'' }>${dept.deptName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>民族：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="empNation" name="empNation">
							<option value="">请选择民族...</option>
							<c:forEach var="nationData" items="${nationDataDicList }">
								<option value="${nationData.ddValue }" ${employee.empNation==nationData.ddValue?'selected':'' }>${nationData.ddValue }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>政治面貌：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="empZzmm" name="empZzmm">
						    <option value="">请选择政治面貌...</option>
							<c:forEach var="zzmmData" items="${zzmmDataDicList }">
								<option value="${zzmmData.ddValue }" ${employee.empZzmm==zzmmData.ddValue?'selected':'' }>${zzmmData.ddValue }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>学历：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="empRecord" name="empRecord">
						    <option value="">请选择学历...</option>
							<c:forEach var="recordData" items="${recordDataDicList }">
								<option value="${recordData.ddValue }" ${employee.empRecord==recordData.ddValue?'selected':'' }>${recordData.ddValue }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>学位：</label>
					</div>
					<div class="col-md-7">
						<select class="form-control" id="empDegree" name="empDegree">
						    <option value="">请选择学位...</option>
							<c:forEach var="degreeData" items="${degreeDataDicList }">
								<option value="${degreeData.ddValue }" ${employee.empDegree==degreeData.ddValue?'selected':'' }>${degreeData.ddValue }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>毕业院校：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="school" name="school" value="${employee.school }"/>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>专业：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="major" name="major" value="${employee.major }"/>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<div class="col-md-3">
						<label>备注：</label>
					</div>
					<div class="col-md-7">
						<input class="form-control" type="text" id="empDesc" name="empDesc" value="${employee.empDesc }"/>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div style="margin-top: 10px;margin-left: 10px;"><span class="glyphicon glyphicon-picture"></span><label>个人图片</label></div>
				<div style="margin-top: 10px;">
						<img width="220" height="299" src="${pageContext.request.contextPath}/userImage/${employee.empPic}">
						<div style="margin-top: 10px;margin-left: 10px;">
							<input type="file" id="file" name="file"/>
						</div>
						<input type="hidden" id="empPic" name="empPic" value="${employee.empPic }"/>
				</div>
				<div style="margin-top: 120px;">
					<input type="hidden" id="employeeId" name="employeeId" value="${employee.employeeId }"/>
					<button type="submit" class="btn btn-info">保存</button>
					<button type="button" class="btn btn-info" onclick="javascript:history.back(-1)">返回</button>
				</div>
			</div>
		</div>
	</form>
  </div>
</div>