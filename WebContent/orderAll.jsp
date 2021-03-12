<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<!-- ... Your content goes here ... -->
<div class="container-fluid">
<div class="row">
	<div class="col-md-12">
		<h1 class="page-header">ใบสั่งจองเค้กทั้งหมด</h1>
		<hr>
	</div>
</div>
	<div class="col-md-12">
		<form action="ShowOrderAll" method="post">
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
					<c:forEach items="${orders}" var="order">
						<tr>
							<td>${order.orderId}</td>
							<td>${order.customerId}</td>
							<td>${order.teamName}</td>
							<td><fmt:formatDate type="date" value="${order.orderDate}" /></td>
							<td><fmt:formatDate type="date" value="${order.receiveDate}" /></td>
							<td>${order.getTotalPound()}</td>
							<c:choose>
								<c:when test="${order.statusName=='ชำระเงินแล้ว'}">
									<td><button type="button" class="btn btn-success">${order.statusName}</button></td>
								</c:when>
								<c:when test="${order.statusName=='ยังไม่ได้ชำระเงิน'}">
									<td><button type="button" class="btn btn-danger">${order.statusName}</button></td>
								</c:when>
								<c:otherwise>
      				Noting
    		</c:otherwise>
							</c:choose>
							<td><a href="ViewAllOrder?id=${order.orderId}"
								class="btn btn-primary">รายละเอียด</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>

</div>
<jsp:include page="script.jsp"></jsp:include>
