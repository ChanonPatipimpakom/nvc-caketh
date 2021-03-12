<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty depart }">
	<c:redirect url="/ShowDepartment"/>
</c:if>
<jsp:include page="/head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">แก้ไขข้อมูลแผนก</h1>
	</div>
</div>
<!-- ... Your content goes here ... -->
<form action="SaveDepartment" method="post">
		<p>
			ชื่อแผนกวิชา
			<input type="text" name="name" class="form-control"  value="${depart.name}"  required="required">
		</p>
		<p>
		<input type="hidden" name="id" value="${depart.id}">
			<button class="btn btn-primary"  type="submit">Save</button>
		</p>
	</form>
</div>
<jsp:include page="../script.jsp"></jsp:include>