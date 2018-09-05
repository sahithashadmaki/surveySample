<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include><br>

<form name="myform" action="ServletCreateForm" method="post" onsubmit="return validation()">
Form Title: <input type="text" name="formName">
<input type="submit" value="next"></form>
<script>
function validation() {
	   var formName = document.forms["myform"]["formName"].value;
	    if ((formName == null || formName == "")) {
	        alert("Entries cannot be empty..!!");
	        return false;
	    }
	}</script>
</body>
</html>