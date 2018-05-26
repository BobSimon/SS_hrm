<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="list-group">
  <a href="#" class="list-group-item active">系统菜单</a>
  <a href="${pageContext.request.contextPath}/user/list.do" class="list-group-item">用户管理</a>
  <a href="${pageContext.request.contextPath}/dataDicType/list.do" class="list-group-item">数据字典类型管理</a>
  <a href="${pageContext.request.contextPath}/dataDic/list.do" class="list-group-item">数据字典管理</a>
  <a href="${pageContext.request.contextPath}/recruit/list.do" class="list-group-item">招聘管理</a>
  <a href="${pageContext.request.contextPath}/contract/list.do" class="list-group-item">面试管理</a>
  <a href="${pageContext.request.contextPath}/dept/list.do" class="list-group-item">部门管理</a>
  <a href="${pageContext.request.contextPath}/employee/list.do" class="list-group-item">雇员管理</a>
  <a href="${pageContext.request.contextPath}/train/list.do" class="list-group-item">培训管理</a>
  <a href="${pageContext.request.contextPath}/attendanceDetail/list.do" class="list-group-item">考勤管理</a>
  <a href="${pageContext.request.contextPath}/salary/list.do" class="list-group-item">薪资管理</a>
  <a href="${pageContext.request.contextPath}/user/logout.do" class="list-group-item">安全退出</a>
</div>