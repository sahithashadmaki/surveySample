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

	<%-- <c:if test="${not empty(admin.name)}">
Hello:  ${admin.name} <br>
<jsp:include page="AdminHeader.jsp"></jsp:include><br>
</c:if> --%>
	<c:choose>
		<c:when test="${not empty(admin.name)}">
Hello:  ${admin.name} <br>
			<jsp:include page="AdminHeader.jsp"></jsp:include><br>
		</c:when>
		<c:otherwise>
Hello: ${user.name} <br>
			<jsp:include page="GeneralHeader.jsp"></jsp:include><br>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${userinfo == 'userinfo' }">
			<h4>choose the form for user information</h4>
		</c:when>
		<c:otherwise>
			<h4>Choose the form for SURVEY</h4>
		</c:otherwise>
	</c:choose>

	<table>
		<tr>
			<th></th>
			<th>Form Id</th>
			<th>Form Title</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<c:choose>
					<c:when test="${userinfo == 'userinfo' }">
						<td><input type="checkbox"
							onclick="userinfo('${list.formId}','${list.formTitle}')"></td>
					</c:when>
					<c:otherwise>
						<td><input type="checkbox"
							onclick="send('${list.formId}','${list.formTitle}')"></td>
					</c:otherwise>
				</c:choose>


				<td><c:out value="${list.formId}" /></td>
				<td><c:out value="${list.formTitle}" /></td>
				
			</tr>
		</c:forEach>
	</table>
	<script>
		function userinfo(id, name){
			document.location.href = "UserInfoServlet?id=" + id + "&&name="
			+ name;
		}
	</script>
	<script>
		function send(id, name) {
			document.location.href = "DisplayQuesServlet?id=" + id + "&&name="
					+ name;
		}
	</script>
</body>
</html>