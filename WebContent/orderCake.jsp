<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp"></jsp:include>
<!-- ... Your content goes here ... -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 class="page-header">กรอกข้อมูลสั่งซื้อเค้ก</h1>
			<hr>
		</div>
	</div>
	<form action="ConfirmOrder" method="post" class="row">
		<div class="form-group col-md-6">
			<label class="control-label " for="fname"> ชื่อ : </label> <input
				class="form-control " name="reciveName" autocomplete="off">
			<input type="hidden" name="customerId"
				value="${sessionScope.customer.id}">
		</div>
		<div class="form-group col-md-6">
			<label class="control-label " for="fname">ทีม: </label>
			<jsp:useBean id="teams" class="data.TeamService" scope="page" />
			<select name="teamId" class="form-control ">
				<c:forEach items="${teams.getAllTeams()}" var="team">
					<option value="${team.id}">${team.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group col-md-6">
			<label class="control-label " for="fname">แผนกวิชา: </label>
			<jsp:useBean id="departall" class="data.DepartmentService"
				scope="page" />
			<select name="depart_id" class="form-control ">
				<c:forEach items="${departall.getAllDepart()}" var="depart">
					<option value="${depart.id}">${depart.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group col-md-6">
			<label class="control-label " for="fname">อาจารย์ที่ปรึกษา: </label>
			<jsp:useBean id="teacherall" class="data.TeacherService" scope="page" />
			<input id="answerInput" list="suggestionList" class="form-control "
				autocomplete="off">
			<datalist id="suggestionList">
				<c:forEach items="${teacherall.getAllTeach()}" var="teacher">
					<option data-values="${teacher.id}">${teacher.name}</option>
				</c:forEach>
			</datalist>
			<input type="hidden" name="teacher_id" id="answerInput-hidden">
		</div>

		<div class="form-group col-md-6">
			<label class="control-label " for="fname">วันที่รับเค้ก: </label> <select
				name="receiveDate" class="form-control ">
				<option value="2563-12-25">25 ธันวาคม 2563</option>
				<option value="2563-12-26">26 ธันวาคม 2563</option>
				<option value="2563-12-27">27 ธันวาคม 2563</option>
				<option value="2563-12-28">28 ธันวาคม 2563</option>
				<option value="2563-12-29">29 ธันวาคม 2563</option>
				<option value="2563-12-30">30 ธันวาคม 2563</option>
				<option value="2563-12-31">31 ธันวาคม 2563</option>
			</select>
		</div>

		<div class="form-group col-md-6">
			<label class="control-label " for="fname">เวลารับเค้ก: </label> <select
				name="reciveTime" class="form-control ">
				<option value="08.00 - 12.00">(เช้า) 08.00 - 12.00 น.</option>
				<option value="13.00 - 18.00">(บ่าย) 13.00 - 18.00 น.</option>
			</select>
		</div>

		<div class="form-group col-md-4">
			<label class="control-label " for="fname"> เบอร์โทรศัพท์ : </label> <input
				class="form-control " name="reciveTel">
		</div>

		<div class="form-group col-md-4">
			<label class="control-label " for="fname"> ชั้น : </label> <select
				name="class_num" class="form-control ">
				<option value="ปวช.1">ปวช.1</option>
				<option value="ปวช.2">ปวช.2</option>
				<option value="ปวช.3">ปวช.3</option>
				<option value="ปวส.1">ปวส.1</option>
				<option value="ปวส.2">ปวส.2</option>
			</select>
		</div>

		<div class="form-group col-md-4">
			<label class="control-label " for="fname"> ห้อง : </label> <input
				class="form-control " name="room_num">
		</div>

		<h3 class="col-md-12">รายการการสั่งจองเค้ก</h3>
		<hr>
		<table
			class="table table-striped table-bordered table-hover col-md-12">
			<thead>
				<tr>
					<th style="width: 25%">เนื้อเค้ก (ราคา/ปอนด์)</th>
					<c:forEach var="p" begin="1" end="5">
						<th style="width: 15%">${p}ปอนด์</th>
					</c:forEach>
				</tr>
			</thead>
			<jsp:useBean id="cakes" class="data.CakeService" scope="page" />
			<tbody>
				<c:forEach items="${cakes.getLstCakes()}" var="cake">
					<tr>
						<td style="width: 20%;">${cake.name}(${cake.pricePerPound})</td>
						<c:forEach var="p" begin="1" end="5">
							<td style="width: 15%"><input type="text"
								class="form-control" name="qty-${cake.id}-${p}"
								style="text-align: right" OnKeyPress="return chkNumber(this)"></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="form-group col-md-6">
			<label class="control-label " for="fname">จำนวนเงินมัดจำ : </label> <input
				class="form-control " name="deposit_money" value="0.0">
		</div>
		<div class="form-group col-md-6">
			<label class="control-label " for="fname"> ชื่อผู้มัดจำ : </label> <input
				class="form-control " name="deposit_name" value="-">
		</div>
		<div class="form-group col-md-12" style="text-align: center">
			<button type="reset" class="btn btn-danger">reset</button>
			<button type="submit" class="btn btn-primary">ยืนยันการสั่งจอง</button>
		</div>
	</form>
</div>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript">
	document
			.querySelector('input[list]')
			.addEventListener(
					'input',
					function(e) {
						var input = e.target, list = input.getAttribute('list'), options = document
								.querySelectorAll('#' + list + ' option'), hiddenInput = document
								.getElementById(input.getAttribute('id')
										+ '-hidden'), inputValue = input.value;

						hiddenInput.value = inputValue;

						for (var i = 0; i < options.length; i++) {
							var option = options[i];

							if (option.innerText === inputValue) {
								hiddenInput.value = option
										.getAttribute('data-values');
								break;
							}
						}
					});
</script>