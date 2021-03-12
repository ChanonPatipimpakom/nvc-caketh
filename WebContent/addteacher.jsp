<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">เพิ่มแผนก</h1>
	</div>
</div>

<!-- ... Your content goes here ... -->
<form action="AddTeacher" method="post">
	<p>
		ชื่ออาจารย์
		<input type="text" name="name" class="form-control"  required="required">
	</p>
	<p>
		<button class="btn btn-primary"  type="submit">Save</button>
	</p>
</form>
</div>
<jsp:include page="script.jsp"></jsp:include>