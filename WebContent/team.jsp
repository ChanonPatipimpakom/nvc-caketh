<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty Teams }">
	<c:redirect url="/ShowTeam" />
</c:if>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">จัดการข้อมูลทีม</h1>
		<div style="margin-bottom: 5px;">
			<a class="btn btn-primary" href="addteam.jsp"
				role="button">เพิ่มทีม</a>
		</div>
	</div>
</div>

<!-- ... Your content goes here ... -->
<div class="row">
	<div class="col-md-12">
		<table class="table table-striped table-bordered table-hover" >
			<thead>
				<tr>
					<th>ID</th>
					<th>ชื่อทีม</th>
					<th>แก้ไข</th>
					<th>ลบ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Teams}" var="Team">
					<tr>
						<td>${Team.id}</td>
						<td>${Team.name}</td>
						<td><a class="btn btn-warning" href="EditTeam?id=${Team.id}"
							role="button">แก้ไข</a></td>
						<td><a class="btn btn-danger" href="DeleteTeam?id=${Team.id}"
							role="button" onclick="return confirmDelete()">ลบ</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
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