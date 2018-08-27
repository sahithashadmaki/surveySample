<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Choose the form for SURVEY</h3>
	<table>
		<tr>
			<th>Form Id</th>
			<th>Form Title</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.formId}" /></td>
				<td><c:out value="${list.formTitle}" /></td>
				<td><button onclick="send('${list.formId}')" name="choose">Choose</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>