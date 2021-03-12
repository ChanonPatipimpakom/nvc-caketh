<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty Teach }">
	<c:redirect url="/ShowTeacher" />
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">จัดการข้อมูลอาจารย์</h1>
		<div style="margin-bottom: 5px;">
			<a class="btn btn-primary" href="addteacher.jsp"
				role="button">เพิ่มรายชื่อ</a>
		</div>
	</div>
</div>
		<table class="table table-striped table-bordered table-hover" style="width:100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>ชื่ออาจารย์</th>
					<td>แก้ไข</td>
					<td>ลบ</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Teach}" var="Teach">
					<tr>
						<td>${Teach.id}</td>
						<td>${Teach.name}</td>
						<td><a class="btn btn-warning" href="EditTeacher?id=${Teach.id}"
							role="button">แก้ไข</a></td>
						<td><a class="btn btn-danger" href="DeleteTeacher?id=${Teach.id}"
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