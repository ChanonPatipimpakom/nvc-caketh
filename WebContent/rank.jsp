<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">อันดับ</h1>
	</div>
</div>

<!-- ... Your content goes here ... -->
<div class="row">
	<div class="col-md-4">
		<table class="table table-striped table-bordered table-hover"
			style="text-align: center;">
			<thead>
				<tr>
					<th style="text-align: center;">ลำดับ</th>
					<th style="text-align: center;">ชื่อทีม</th>
					<th style="text-align: center;">จำนวนปอนด์</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${teams}" var="team">
					<tr>
						<c:set var="i" value="${i + 1}" />
						<td>${i}</td>
						<td>${team.name}</td>
						<td>${team.totalPound}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
<jsp:include page="script.jsp"></jsp:include>