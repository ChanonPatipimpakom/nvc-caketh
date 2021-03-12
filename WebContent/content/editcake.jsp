<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../head.jsp"></jsp:include>
<c:if test="${empty cake}">
	<c:redirect url="/ShowCake"/>
</c:if>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">แก้ไขข้อมูลสินค้า</h1>
	</div>
</div>
<!-- ... Your content goes here ... -->
<form action="SaveCake" method="post">
		<p>
			ชื่อทีม
			<input type="text" name="name" class="form-control"  value="${cake.name}"  required="required">
		</p>
		<p>
			ราคาต่อปอนด์
			<input type="text" name="pricePerPound" class="form-control"  value="${cake.pricePerPound}"  required="required">
		</p>
		<p>
			ส่วนลด
			<input type="text" name="discountRate" class="form-control"  value="${cake.discountRate}"  required="required">
		</p>
		<p>
		<input type="hidden" name="id" value="${cake.id}">
			<button class="btn btn-primary"  type="submit">Save</button>
		</p>
	</form>
</div>
<jsp:include page="../script.jsp"></jsp:include>