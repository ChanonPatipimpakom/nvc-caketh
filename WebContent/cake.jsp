<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty Cakes }">
	<c:redirect url="/ShowCake" />
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">จัดการข้อมูลเค้ก</h1>
		<div style="margin-bottom: 5px;">
			<a class="btn btn-primary" href="addcake.jsp"
				role="button">เพิ่มสินค้า</a>
		</div>
	</div>
</div>
		<table class="table table-striped table-bordered table-hover" style="width:100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>ชื่อ</th>
					<th>ราคาต่อปอนด์</th>
					<th>ส่วนลด</th>
					<th>แก้ไข</th>
					<th>ลบ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Cakes}" var="Cake">
					<tr>
						<td>${Cake.id}</td>
						<td>${Cake.name}</td>
						<td>${Cake.pricePerPound}</td>
						<td>${Cake.discountRate}</td>
						<td><a class="btn btn-warning" href="EditCake?id=${Cake.id}"
							role="button">แก้ไข</a></td>
						<td><a class="btn btn-danger" href="DeleteCake?id=${Cake.id}"
							role="button" onclick="return confirmDelete()">ลบ</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<jsp:include page="script.jsp"></jsp:include>
<script>
	function confirmDelete() {
		if (confirm("ต้องการลบข้อมูลหรือไม่")) {
			return true;
		}
		return false;
	}
</script>