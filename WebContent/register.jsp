<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/jquery.validate.min.js"></script>
    <!-- Bootstrap core CSS-->
    <link href="vendor1/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor1/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/style2.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">สมัครสมาชิก</div>
        <div class="card-body">
          <form action="AddCustomer" method="post" id="frmRegister">
          
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6"> 
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username"  autofocus="autofocus">
                </div>
              </div>
            </div>
             <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                </div>
                 <div class="col-md-6">
                    <input type="password" id="re-password" name="re-password" class="form-control" placeholder="Re-Password" >
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                    <input type="text" id="inputname" name="name" class="form-control" placeholder="Full Name">
                </div>
              </div>
            </div>
            
            <div class="form-group">
                <input type="text" id="inputAddress" name="address" class="form-control" placeholder="Address" >
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                    <input type="text" id="inputEmail" name="email" class="form-control" placeholder="Email" > 
                </div>
                <div class="col-md-6">
                    <input type="text" id="inputTel" name="tel" class="form-control" placeholder="Telephone" >
                </div>
                <input type="hidden" name="status" value="user">
              </div>
            </div>
            <button type="submit" class="btn btn-primary btn-block">ลงทะเบียน</button>
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    
    <script src="vendor1/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor1/jquery-easing/jquery.easing.min.js"></script>

  </body>
<script>
	$(document).ready(function(){
		$("#frmRegister").validate({
			rules:{
				"username":"required",
				"password":"required",
				"name":"required",
				"address":"required",
				"tel":"required",
				"email":{"required":true,"email":true},
				"re-password":{"required":true,equalTo:"#password"}
				
			},
			messages:{
				"username":"กรุณาใส่ชื่อผู้ใช้",
				"password":"กรุณาใส่รหัสผ่าน",
				"name":"กรุณาชื่อ-นามสกุล",
				"address":"กรุณาใส่ที่อยุ่",
				"tel":"กรุณากรอกเบอร์โทร",
				"email":{"required":"กรุณากรอกอีเมล" ,"email":"รูปแบบอีเมลไม่ถูกต้อง"},
				"re-password":{"required":"กรุณายืนยันรหัสผ่าน",equalTo:"รหัสผ่านไม่ตรงกัน"}
			},
			highlight : function(element) {
				$(element).parent(element).removeClass('has-success').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).parent(element).removeClass('has-error').addClass('has-success');
			},
		     errorClass:'help-block'
		});
		
		
	});
</script>
<jsp:include page="script.jsp"></jsp:include>
</html>
