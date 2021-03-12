<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty teach }">
	<c:redirect url="/ShowTeacher"/>
</c:if>
<jsp:include page="/head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">แก้ไขข้อมูลอาจารย์</h1>
	</div>
</div>
<!-- ... Your content goes here ... -->
<form action="SaveTeacher" method="post">
		<p>
			ชื่ออาจารย์
			<input type="text" name="name" class="form-control"  value="${teach.name}"  required="required">
		</p>
		<p>
		<input type="hidden" name="id" value="${teach.id}">
			<button class="btn btn-primary"  type="submit">Save</button>
		</p>
	</form>
</div>
<jsp:include page="../script.jsp"></jsp:include>