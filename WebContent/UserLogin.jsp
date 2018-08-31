<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	${errorMsg}
	<form name="myform" action="AdminServlet" method="post"
		onsubmit="return validation()">
		UserName: <input type="text" name="uname"> Password: <input
			type="password" name="pass"> <input type="submit"
			value="login">
	</form>
	New User? <a href="SignUp.jsp">signUp</a>
	<script>
		function validation() {
			var user = document.forms["myform"]["uname"].value;
			var pass = document.forms["myform"]["pass"].value;
			if ((user == null || user == "") && (pass == null || pass == "")) {
				alert("Entries cannot be empty..!!");
				return false;
			}
		}
	</script>
</body>
</html>