<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty team }">
	<c:redirect url="/ShowTeam"/>
</c:if>
<jsp:include page="/head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">แก้ไขข้อมูลทีม</h1>
	</div>
</div>
<!-- ... Your content goes here ... -->
<form action="SaveTeam" method="post">
		<p>
			ชื่อทีม
			<input type="text" name="name" class="form-control"  value="${team.name}"  required="required">
		</p>
		<p>
		<input type="hidden" name="id" value="${team.id}">
			<button class="btn btn-primary"  type="submit">Save</button>
		</p>
	</form>
</div>
<jsp:include page="../script.jsp"></jsp:include>