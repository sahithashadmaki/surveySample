<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

body {
	background: #555;
}

.content {
	max-width: 400px;
	margin: auto;
	background: white;
	padding: 100px;
	border-radius: 5px;
	background-color: #f2f2f2;
}

input[type=submit] {
	width: 60%;
	background-color: #555;
	color: white;
	padding: 7px 12px;
	margin: 20px 50px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		${emailError}
		<form name="myform" action="UserSignUp" method="post"
			onsubmit="return validateEmail()">
			Name: <input type="text" id="uname" name="name" placeholder="Name...">
			<br> Email: <input type="text" id="txtEmail" name="email"
				placeholder="Email..."> <br> Password: <input
				type="password" id="pass" name="pwd" placeholder="password...">
			<input type="submit" id="btn" value="signUp">
		</form>
		Already have an account? <a href="UserLogin.jsp">Login</a>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		
	</script>
	<script>
		function validateEmail() {
			var name = document.forms["myform"]["name"].value;
			var pass = document.forms["myform"]["pwd"].value;
			var email = document.forms["myform"]["email"].value;
			var pattern = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			if ((email == null || email == "") && (name == null || name == "")
					&& (pass == null || pass == "")) {
				alert('All fields are mandatory');
				return false;
			} else if (pattern.test(email)) {
				return true;
			} else {
				alert('Invalid Email Address');
				return false;
			}
		}
	</script>
</body>
</html>