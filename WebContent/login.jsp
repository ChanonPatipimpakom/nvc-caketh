<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Bootstrap core CSS-->
<link href="vendor1/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor1/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body style="background-image:url(' https://scontent.fbkk17-1.fna.fbcdn.net/v/t1.0-9/80376012_2835118186512682_2025276929187250176_o.jpg?_nc_cat=108&ccb=1-3&_nc_sid=cdbe9c&_nc_eui2=AeHO1t8-Z8oVYWde1fwdG5RV3DV75-AZjv3cNXvn4BmO_Q1-t2sZuIcOY-pzownMOIHlS7cURUaWUCiqAiqQG_KS&_nc_ohc=E85Hsj_XmPoAX_QlFjH&_nc_ht=scontent.fbkk17-1.fna&oh=06f220672dd608b184aec5f257939af1&oe=606BF8A5')
					;background-size:cover">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">ลงชื่อเข้าใช้</div>
			<div class="card-body">
				<form action="Login" method="post">
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="inputUsername" name="username"
								class="form-control" placeholder="Username"
								required="required" autofocus="autofocus"> <label
								for="inputUsername">Username</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="inputPassword" name="password"
								class="form-control" placeholder="Password" required="required">
							<label for="inputPassword">Password</label>
						</div>
					</div>

					
						<button type="submit" class="btn btn-primary btn-block">Login</button>
						<div class="form-group">
					<div class="col-xs-12" style="text-align:center;color:red;font-size: 16px;">
						${sessionScope.errorMessage} 
					</div>
					</div>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="register.jsp">สมัครสมาชิก</a>

				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor1/jquery/jquery.min.js"></script>
	<script src="vendor1/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor1/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
