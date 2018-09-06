<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:choose>
		<c:when test="${not empty(admin.name)}">

			<jsp:include page="AdminHeader.jsp"></jsp:include><br>
		</c:when>
		<c:otherwise>

			<jsp:include page="GeneralHeader.jsp"></jsp:include><br>
		</c:otherwise>
	</c:choose>
	Form Title: ${form.formTitle}
	<br> No of users : ${count}
</body>
</html>