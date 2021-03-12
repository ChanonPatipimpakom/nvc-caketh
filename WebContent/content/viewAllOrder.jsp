<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-md-12">
		<h1 class="page-header">Bill</h1><hr>
	</div>
</div>
	<div class="col-md-12">
		<form action="" method="post"class="row">
				<div class="form-group col-md-4">
					<label class="control-label" for="fname"> ชื่อ : </label> 
					<p>${order.reciveName}</p>
				</div>
				<div class="form-group col-md-4">
					<label class="control-label " for="fname">ทีม : </label> 
					<p>${order.team.name}</p>
				</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="fname"> ระดับชั้น : </label>
				<p>${order.class_num}</p>
				</div>
			<div class="form-group col-md-4">
				<label class="control-label" for="fname">ห้อง : </label> 
				<p>${order.room_num}</p>
				</div>
			<div class="form-group col-md-4">
					<label class="control-label " for="fname">แผนกวิชา : </label> 
				<p>${order.depart.name}</p>
				</div>
			<div class="form-group col-md-4">
					<label class="control-label " for="fname">อาจารย์ที่ปรึกษา : </label>
				<p>${order.teach.name}</p>
			</div>

			<div class="form-group col-md-4">
					<label class="control-label " for="fname">เบอร์โทรศัพท์ :</label> 
					<p>${order.reciveTel}</p>
				</div>
				
				<div class="form-group col-md-4">
					<label class="control-label " for="fname">วันที่รับเค้ก	:</label>
					<p> <fmt:formatDate type="date" value="${order.receiveDate}" /></p>
				</div>
				
				<div class="form-group col-md-4">
					<label class="control-label " for="fname">เวลารับเค้ก : </label>
					<p>${order.reciveTime}</p>
				</div>
			
			<h3 class=" col-md-12">รายการการสั่งจองเค้ก</h3>
			<hr>

			<table class="table table-striped table-bordered table-hover col-md-12">
				<thead>
					<tr>
						<th style="width: 20%">เนื้อเค้ก (ราคา/ปอนด์)</th>
						<c:forEach var="p" begin="1" end="5">
							<th style="width: 10%">${p} ปอนด์</th>
						</c:forEach>
						<th style="width: 10%">รวม (ปอนด์)</th>
						<th style="width: 15%">ราคารวม</th>
					</tr>
				</thead>
				<jsp:useBean id="cakes" class="data.CakeService" scope="page"/>
				<tbody>
					<c:set var="totalDiscount" value="${0}"/>
					<c:forEach items="${cakes.getLstCakes()}" var="cake">
						<tr>
							<td style="width: 20%;">${cake.name} (${cake.pricePerPound})</td>
							<c:set var="totalPound"  value="0"/>
							<c:forEach var="p" begin="1" end="5">
								<c:forEach items="${order.details}"  var="detail">
									<c:if test="${detail.cake.id == cake.id && detail.pound == p}">
										<td style="width: 10%;text-align:right;">
											${detail.quantity==0?"-":detail.quantity}
										</td>
										<c:set var="totalPound"  value="${totalPound+(detail.quantity*p)}"/>
									</c:if>
								</c:forEach>
							</c:forEach>
							<td style="width: 10%;text-align:right;">${totalPound}
							</td>
							<td style="width: 15%;text-align:right;">${totalPound*cake.pricePerPound}
							</td>
							<c:set var="discount"  value="${totalPound*cake.discountRate} "></c:set>
							<c:set var="totalDiscount"  value="${totalDiscount+discount}"></c:set>
							
							<c:set var="total"  value="${totalPound*cake.pricePerPound}"></c:set>
							<c:set var="sumtotal"  value="${sumtotal+total}"></c:set>
							<c:set var="NetPrice"  value="${sumtotal-totalDiscount}"></c:set>
						</tr>
					</c:forEach>		
				<tr>
							<td colspan="7" style="text-align: right;">ราคารวม</td>
							<td style="text-align: right;">${sumtotal}</td>
						</tr>
							<tr>
							<td colspan="7" style="text-align: right;">ส่วนลด</td>
							<td style="text-align: right;">${totalDiscount}</td>
						</tr>
						<tr>
							<td colspan="7" style="text-align: right;">ราคาสุทธิ</td>
							<td style="text-align: right;">${NetPrice}</td>
						</tr>
				</tbody>
			</table>
			<div class="form-group col-md-3">
			<label class="control-label" for="fname"> ยอดเงินมัดจำ : </label> "${order.deposit_money}"
			<c:set var="deposit_m" value="${order.deposit_money}"></c:set>
			<c:set var="deposit" value="${NetPrice-deposit_m}"></c:set>
			</div>
			<div class="form-group col-md-3">
			<label class="control-label" for="fname"> ยอดค้างมัดจำ : </label>
			<c:choose>
				<c:when test="${deposit_m <= 0.0 }">
					"-"
				</c:when>
				<c:when test="${deposit_m > 0.0 }">
					"${deposit}"
				</c:when>
			</c:choose>
			</div>
			<div class="form-group col-md-3">
			<label class="control-label" for="fname"> ชื่อผู้มัดจำ : </label> "${order.deposit_name}"
			</div>
			<div class="form-group col-md-3" style="text-align:center">
				<a href="SaveOrderUpdate?orderId=${order.orderId}" class="btn btn-primary" onclick="return confirmUpdate()">ยืนยันการชำระเงิน</a>
			</div>
		</form>
	</div>


</div>
<jsp:include page="../script.jsp"></jsp:include>
<script >
		function confirmUpdate() {
			if(confirm("ต้องการยืนยันการชำระเงินหรือไม่")){
		return true;
		}
		return false;
		}
	</script>