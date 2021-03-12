<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty ex || empty ex2 }">
	<c:redirect url="/ExportFile"/>
</c:if> 
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="excelexportjs.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="page-top">
	<jsp:include page="head.jsp"></jsp:include>
	<!-- ... Your content goes here ... -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">ยอดการสั่งเค้กทั้งหมด</h1>
				<hr>
			</div>
			<table id="tableData"
				class="table table-striped table-bordered table-hover col-md-12"
				style="text-align: center">
				<tr>
					<th>ลำดับ</th>
					<th>ชื่อเค้ก</th>
					<th>จำนวนที่สั่งซื้อ(ปอนด์)</th>
				</tr>
				<c:forEach items="${ex}" var="p">
					<c:choose>
						<c:when test="${p.cake.id == '1'}">
							<c:set var="total" value="${p.pound * p.quantity}" />
							<c:set var="totalall1" value="${totalall1+total}" />
						</c:when>
						<c:when test="${p.cake.id == '2'}">
							<c:set var="total2" value="${p.pound * p.quantity}" />
							<c:set var="totalall2" value="${totalall2+total2}" />
						</c:when>
						<c:when test="${p.cake.id == '3'}">
							<c:set var="total3" value="${p.pound * p.quantity}" />
							<c:set var="totalall3" value="${totalall3+total3}" />
						</c:when>
						<c:when test="${p.cake.id == '4'}">
							<c:set var="total4" value="${p.pound * p.quantity}" />
							<c:set var="totalall4" value="${totalall4+total4}" />
						</c:when>
						<c:otherwise>
							<c:set var="total5" value="${p.pound * p.quantity}" />
							<c:set var="totalall5" value="${totalall5+total5}" />
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<tr>
					<td>1</td>
					<td>เค้กแยมผลไม้</td>
					<td>${totalall1}</td>
				</tr>
				<tr>
					<td>2</td>
					<td>เค้กกาแฟ</td>
					<td>${totalall2}</td>
				</tr>
				<tr>
					<td>3</td>
					<td>เค้กช็อกโกแลต</td>
					<td>${totalall3}</td>
				</tr>
				<tr>
					<td>4</td>
					<td>เค้กเนยสด</td>
					<td>${totalall4}</td>
				</tr>
				<tr>
					<td>5</td>
					<td>เค้กบัตเตอร์</td>
					<td>${totalall5}</td>
				</tr>
				<tr>
					<td></td>
					<td style="font-weight: bolder">ยอดรวมทั้งหมด</td>
					<td>${totalall1+totalall2+totalall3+totalall4+totalall5}</td>
				</tr>
			</table>
			<button id="DLtoExcel" class="btn btn-primary">Export Excel</button>
		</div>
	</div>
		<script type="text/javascript">
				var $btnDLtoExcel = $('#DLtoExcel');
				$btnDLtoExcel.on('click', function() {
					$("#tableData").excelexportjs({
						containerid : "tableData",
						datatype : 'table'
					});
				});
		</script>
		
		
			<!-- ... Your content goes here ... -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">ยอดการสั่งเค้กรายวัน</h1>
				<hr>
			</div>
			<table id="tableData2"
				class="table table-striped table-bordered table-hover col-md-12"
				style="text-align: center">
				<tr>
					<th>ลำดับ</th>
					<th>วันที่</th>
					<th>จำนวนที่สั่งซื้อ(ปอนด์)</th>
				</tr>
							<c:set var="p1" value="${0}" />
                        	<c:set var="p2" value="${0}" />
                        	<c:set var="p3" value="${0}" />
                        	<c:set var="p4" value="${0}" />
                        	<c:set var="p5" value="${0}" />
                        	<c:set var="p6" value="${0}" />
                        	<c:set var="p7" value="${0}" />
                        	<c:forEach items="${ex2}" var="order">	
							<c:choose>
								<c:when test="${order.receiveDate == '2020-12-25'}">
											<c:set var="p1" value="${p1+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-26'}">
											<c:set var="p2" value="${p2+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-27'}">
											<c:set var="p3" value="${p3+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-28'}">
											<c:set var="p4" value="${p4+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-29'}">
											<c:set var="p5" value="${p5+order.getTotalPound()}" />
								</c:when>
								<c:when test="${order.receiveDate == '2020-12-23'}">
											<c:set var="p6" value="${p6+order.getTotalPound()}" />
								</c:when>
								<c:otherwise>
											<c:set var="p7" value="${p7+order.getTotalPound()}" />
					         	</c:otherwise>
							</c:choose>
						</c:forEach>
				<tr>
					<td>1</td>
					<td>25 December</td>
					<td>${p1}</td>
				</tr>
				<tr>
					<td>2</td>
					<td>26 December</td>
					<td>${p2}</td>
				</tr>
				<tr>
					<td>3</td>
					<td>27 December</td>
					<td>${p3}</td>
				</tr>
				<tr>
					<td>4</td>
					<td>28 December</td>
					<td>${p4}</td>
				</tr>
				<tr>
					<td>5</td>
					<td>29 December</td>
					<td>${p5}</td>
				</tr>
				<tr>
					<td>6</td>
					<td>30 December</td>
					<td>${p6}</td>
				</tr>
				<tr>
					<td>7</td>
					<td>31 December</td>
					<td>${p7}</td>
				</tr>
				<tr>
					<td></td>
					<td style="font-weight: bolder">ยอดรวมทั้งหมด</td>
					<td>${p1+p2+p3+p4+p5+p6+p7}</td>
				</tr>
			</table>
			<button id="DLtoExcel2" class="btn btn-primary">Export Excel</button>
		</div>
	</div>
		<script type="text/javascript">
				var $btnDLtoExcel2 = $('#DLtoExcel2');
				$btnDLtoExcel2.on('click', function() {
					$("#tableData2").excelexportjs({
						containerid : "tableData2",
						datatype : 'table'
					});
				});
		</script>
</body>
</html>
