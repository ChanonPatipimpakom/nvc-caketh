<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty Depart }">
	<c:redirect url="/ShowDepartment" />
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">จัดการข้อมูลแผนกวิชา</h1>
		<div style="margin-bottom: 5px;">
			<a class="btn btn-primary" href="adddepart.jsp"
				role="button">เพิ่มแผนกวิชา</a>
		</div>
	</div>
</div>
		<table class="table table-striped table-bordered table-hover" style="width:100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>ชื่อแผนก</th>
					<td>แก้ไข</td>
					<td>ลบ</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Depart}" var="Depart">
					<tr>
						<td>${Depart.id}</td>
						<td>${Depart.name}</td>
						<td><a class="btn btn-warning" href="EditDepartment?id=${Depart.id}"
							role="button">แก้ไข</a></td>
						<td><a class="btn btn-danger" href="DeleteDepartment?id=${Depart.id}"
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