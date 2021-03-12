<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty Customers}">
	<c:redirect url="/ShowCustomer"/>
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<!-- ... Your content goes here ... -->
<div class="container-fluid">
<div class="row">
	<div class="col-md-10">
		<h1 class="page-header">จัดการข้อมูลผู้ใช้</h1>
	</div>
</div>

<!-- ... Your content goes here ... -->
<table class="table table-striped table-bordered table-hover" >
		<thead>
			<tr>
				<th>ID</th>
				<th>ชื่อผู้ใช้</th>
				<th>ชื่อ</th>
				<th>ที่อยู่</th>
				<th>Email</th>
				<th>เบอร์โทร</th>
				<th>สถานะ</th>
				<th>แก้ไข</th>
				<th>ลบ</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach items="${Customers}" var="Customer">
		<tr>
			<td>${Customer.id}</td>
			<td>${Customer.username}</td>
			<td>${Customer.name}</td>
			<td>${Customer.address}</td>
			<td>${Customer.email}</td>
			<td>${Customer.tel}</td>
			<td>${Customer.status}</td>
			<td><a class="btn btn-warning" href="EditCustomer?id=${Customer.id}"role="button">แก้ไข</a></td>
			<td><a class="btn btn-danger" href="DeleteCustomer?id=${Customer.id}" role="button" onclick="return confirmDelete()">ลบ</a></td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
</div>
<jsp:include page="script.jsp"></jsp:include>
	<script >
		function confirmDelete() {
			if(confirm("ต้องการลบข้อมูลหรือไม่")){
		return true;
		}
		return false;
		}
	</script>