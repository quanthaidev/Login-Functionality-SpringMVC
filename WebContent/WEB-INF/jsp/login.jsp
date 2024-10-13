<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.login-form {
	width: 500px;
	margin: 50px auto;
	font-size: 15px;
}

.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h2 {
	margin: 0 0 15px;
}

.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}

.btn {
	font-size: 15px;
	font-weight: bold;
}

 body {
     background-image: url('https://img.freepik.com/free-vector/gradient-dynamic-blue-lines-background_23-2148995756.jpg?w=996&t=st=1728719346~exp=1728719946~hmac=b63e34322993c13534be14630a7981d96cbe805a4f8173cac3b899e5af65f45f');
	 background-size: cover;      /* Ảnh bao phủ toàn bộ màn hình */
     background-repeat: no-repeat; /* Không lặp lại ảnh */
     background-position: center;  /* Ảnh ở giữa */
}
</style>
</head>
<body>
	<div class="login-form">
		<form action="${pageContext.request.contextPath}/login.html" method="post">
			
			<h2 class="text-center">Welcome login page</h2>

			<div class="form-group">
				<input type="text" class="form-control" placeholder="Username"
					name="username" value="${param.username}" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="Password"
					name="password" value="${param.password}" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">
					Submit</button>
			</div>

		</form>
		
		<h5 class="text-center" style="color: red">${error}</h5>
	</div>
</body>
</html>