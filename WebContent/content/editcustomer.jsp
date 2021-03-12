<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty customer}">
	<c:redirect url="/ShowCustomer"/>
</c:if>
<jsp:include page="../head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">แก้ไขข้อมูลผู้ใช้</h1>
	</div>
</div>
<!-- ... Your content goes here ... -->
<form action="SaveCustomer" method="post">
		<p>
			ชื่อผู้ใช้
			<input type="text" name="username" class="form-control"  value="${customer.username}"  required="required" readonly>
		</p>
		<p>
			ชื่อ
			<input type="text" name="name" class="form-control"  value="${customer.name}"  required="required">
		</p>
		<p>
			ที่อยู่
			<input type="text" name="address" class="form-control"  value="${customer.address}"  required="required">
		</p>
		<p>
			Email
			<input type="text" name="email" class="form-control"  value="${customer.email}"  required="required">
		</p>
		<p>
			เบอร์โทร
			<input type="text" name="tel" class="form-control"  value="${customer.tel}"  required="required">
		</p>
		<p>
			สถานะ
		<c:if test="${customer.status=='user'}">
     <c:set var="chk1" value="checked"/>
	</c:if>
	<c:if test="${customer.status=='admin'}">
     <c:set var="chk2" value="checked"/>
	</c:if>
	    <input type="radio" name="status"  value="user"  ${chk1}>user
 		<input type="radio" name="status"  value="admin"  ${chk2}>admin
		</p>
		
		<p>
		<input type="hidden" name="id" value="${customer.id}">
			<button class="btn btn-primary"  type="submit">Save</button>
		</p>
	</form>
</div>
<jsp:include page="../script.jsp"></jsp:include>