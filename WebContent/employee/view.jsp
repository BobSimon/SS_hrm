<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
	<div class="row viewPage">
		<div class="col-md-8">
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>工号：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="employeeNo" value="${employee.employeeNo }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>姓名：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empName" value="${employee.empName }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>性别：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empSex" value="${employee.empSex }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>身份证号：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empIdcard" value="${employee.empIdcard }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>所属部门：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="deptName" value="${employee.deptName }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>民族：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empNation" value="${employee.empNation }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>政治面貌：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empZzmm" value="${employee.empZzmm }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>学历：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empRecord" value="${employee.empRecord }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>学位：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empDegree" value="${employee.empDegree }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>毕业院校：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="school" value="${employee.school }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>专业：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="major" value="${employee.major }" readonly/>
				</div>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-3">
					<label>备注：</label>
				</div>
				<div class="col-md-7">
					<input class="form-control" type="text" id="empDesc" value="${employee.empDesc }" readonly/>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div style="margin-top: 10px;margin-left: 10px;"><span class="glyphicon glyphicon-picture"></span><label>个人图片</label></div>
			<div style="margin-top: 10px;">
				<img width="220" height="299" src="${pageContext.request.contextPath}/userImage/${employee.empPic}">
			</div>
			<div style="margin-top: 150px;">
				<button type="button" class="btn btn-info" onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/preSave.do?id=${employee.employeeId }'">修改</button>
				<button type="button" class="btn btn-info" onclick="javascript:history.back(-1)">返回</button>
			</div>
		</div>
	</div>
	
  </div>
</div>