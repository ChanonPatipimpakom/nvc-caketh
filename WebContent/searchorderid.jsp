<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="head.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">ค้นหารายการสั่งจอง</h1>
	</div>
</div>

<!-- ... Your content goes here ... -->
 <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" action="ShowResult" method="get">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="เลขที่ใบสั่งซื้อ" name="orderId" >
          <div class="input-group-append">
            <button class="btn btn-primary" type="submit">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
        <div class="col-xs-12" style="text-align:center;color:red;font-size: 16px;">
						${msg} 
					</div>
      </form>
     </div>
    <jsp:include page="script.jsp"></jsp:include>