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
    background-color:#555 ;
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
	${errorMsg}
	<form name="myform" action="AdminServlet" method="post"
		onsubmit="return validation()">
		UserName: <input type="text" name="uname" placeholder="Name"> 
		<br>
		<br>
		Password: <input
			type="password" name="pass" placeholder="password"> <input type="submit"
			value="login" >
	</form>
	<br>
	New User? <a href="SignUp.jsp">signUp</a>
	</div>
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