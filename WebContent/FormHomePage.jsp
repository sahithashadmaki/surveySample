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
	<form action="CreateForm.jsp">
		<input type="submit" value="createForm">
	</form>
	<br>
	<h3>List of Forms</h3>
	<br> admin Id: ${admin.id}
	<br> admin Name: ${admin.name}
	<br>
	<form action="EditFormServlet" method="post">
		<table>
			<c:forEach items="${mylist}" var="list">
				<tr>
					<td><c:out value="${list.formId}" /></td>
					<td><c:out value="${list.formTitle}" /></td>
					<td><button
							onclick="send('${list.formId}','${list.formTitle}')" name="edit">Edit</button></td>
					<td><input type="button" value="Delete" name="delete"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		
	</script>
	<script>
		function send(id, title) {

		}
	</script>
</body>
</html>