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
	<br> admin Id: ${admin.id}
	<br> admin Name: ${admin.name}
	<h3>List of Forms</h3>
	<br>
	<table>
		<tr>
			<th>FormId</th>
			<th>FormTitle</th>
		</tr>
		<c:forEach items="${mylist}" var="list">
			<tr>
				<td><c:out value="${list.formId}" /></td>
				<td><c:out value="${list.formTitle}" /></td>
				<td><button
						onclick="addParameterToURL('${list.formId}','${list.formTitle}','edit')"
						name="edit">Edit</button></td>
				<td><button
						onclick="addParameterToURL('${list.formId}','${list.formTitle}','delete')"
						name="delete">Delete</button></td>
			</tr>
		</c:forEach>
	</table>

	<script>
		function addParameterToURL(id, name, btn) {
			document.location.href = "EditFormServlet?id=" + id + "&&name="
					+ name + "&&btn=" + btn;

		}
	</script>
</body>
</html>

<%-- 					<c:set var="id" scope="request" value="${list.formId}"></c:set> --%>
<%-- <td><button onclick="<c:set var="id" scope="request" value="${list.formId}"></c:set>" name="edit">Edit</button></td> --%>
<%-- <c:url value = "/EditFormServlet" var = "myURL">
  					 <c:param name = "id" value = "${list.formId}"/>
						</c:url> --%>