<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-md-12">
		<h1 class="page-header">ผลลัพธ์</h1>
	</div>
</div>

<!-- ... Your content goes here ... -->
<div class="row">
	<div class="col-md-12">
		<form action="ShowResult" method="post">
			<table class="table table-striped table-bordered table-hover ">
				<thead>
					<tr style="align-content: center;">
						<th style="width: 10%">เลขที่ใบสั่งซื้อ</th>
						<th style="width: 10%">รหัสลูกค้า</th>
						<th style="width: 10%">ทีม</th>
						<th style="width: 15%">วันที่สั่งเค้ก</th>
						<th style="width: 15%">วันที่รับเค้ก</th>
						<th style="width: 10%">รวมปอนด์</th>
						<th style="width: 15%">สถานะการชำระเงิน</th>
						<th style="width: 15%">รายละเอียด</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td>${resultorder.orderId}</td>
							<td>${resultorder.customerId}</td>
							<td>${resultorder.teamName}</td>
							<td><fmt:formatDate type="date" value="${resultorder.orderDate}" /></td>
							<td><fmt:formatDate type="date" value="${resultorder.receiveDate}" /></td>
							<td>${resultorder.getTotalPound()}</td>
							<c:choose>
								<c:when test="${resultorder.statusName=='ชำระเงินแล้ว'}">
									<td><button type="button" class="btn btn-success">${resultorder.statusName}</button></td>
								</c:when>
								<c:when test="${resultorder.statusName=='ยังไม่ได้ชำระเงิน'}">
									<td><button type="button" class="btn btn-danger">${resultorder.statusName}</button></td>
								</c:when>
								<c:otherwise>
      				Noting
    		</c:otherwise>
							</c:choose>
							<td><a href="ViewAllOrder?id=${resultorder.orderId}"
								class="btn btn-primary">รายละเอียด</a></td>

						</tr>
					
				</tbody>
			</table>
		</form>
	</div>
<jsp:include page="../script.jsp"></jsp:include>
</div>
</div>
