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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include><br>
<br>
	<form action="CreateForm.jsp">
		<input type="submit" value="createForm">
	</form>
	<br> admin Id: ${admin.id}
	<br> admin Name: ${admin.name}
	<c:if test="${not empty(list)}">
	<h3>List of Forms</h3>
	<br>
	<table>
		<tr>
			<th>FormId</th>
			<th>FormTitle</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.formId}" /></td>
				<td><c:out value="${list.formTitle}" /></td>
				<td><button
						onclick="addParameterToURL('${list.formId}')"
						name="edit">Edit</button></td>
				<td><button
						onclick="deleteForm('${list.formId}')"
						name="delete">Delete</button></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	<script>
		function addParameterToURL(id) {
			
			document.location.href = "EditFormServlet?id=" + id; 

		}
		</script>
		<script>
		function deleteForm(id){
			var form="form";
			 $.ajax({
			        url: 'DeleteServlet',
			        type: 'POST',
			        data: {
			        	id: id,
			        	value: form
			              },
			        success: function(response) {
			        	//  alert("success");
			           location.reload();
			        },
			        error: function(jqXHR, e) {
			            alert('error'+e);
			        }
			      });
		}
	</script>
</body>
</html>
