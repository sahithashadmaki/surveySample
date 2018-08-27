<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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