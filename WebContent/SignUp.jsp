<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${emailError}
	<form name="myform" action="UserSignUp" method="post"
		onsubmit="return validateEmail()">
		Name: <input type="text" id="uname" name="name"> Email: <input
			type="text" id="txtEmail" name="email"> Password: <input
			type="password" id="pass" name="pwd"> <input type="submit"
			id="btn" value="signUp">
	</form>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		
	</script>
	<script>
		/* 
		 $(document).ready(function(e) {
		 $('#btn').click(function() {
		 var sEmail = $('#txtEmail').val();
		 var uname=$('#uname').val();
		 var pass=$('#pass').val();
		 if ((sEmail==null || sEmail=="") && (user == null || user == "")&&(pass==null || pass=="") ) {
		 alert('All fields are mandatory');
		 e.preventDefault();
		 }
		 else if (validateEmail(sEmail)) {
		
		 }
		 else {
		 alert('Invalid Email Address');
		 e.preventDefault();
		 }
		 });
		 }); */

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