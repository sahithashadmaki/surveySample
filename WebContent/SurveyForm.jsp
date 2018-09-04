<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	 %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- var answer=$('input[name=${list.questionId}]:checked').val(); --%>
</head>
<body>
 
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

<form action="StoreAnswersServlet?id=${form.formId}" method="post" >


	<h3>${form.formTitle}</h3>
	<c:forEach items="${list}" var="list" varStatus="loop">
		<c:choose>

			<c:when test="${list.queType eq 'Multiple Choice'}">
				${loop.count}. <c:out value="${list.question}" /><br>
				<br>
				<c:forEach items="${list.questionOptions}" var="options">
					<input type="radio" id="${list.questionId}"
						name="${list.questionId}" value="${options}">${options}<br>
						
						<br>
				</c:forEach>
			</c:when>
			<c:when test="${list.queType eq 'Text Type'}">
				${loop.count}. <c:out value="${list.question}" /><br>
				<br>
				<input type="text" id="${list.questionId}" name="${list.questionId}"><br>
				<br>
			</c:when>
		</c:choose>
	</c:forEach>
	<input type="submit" value="submit">
</form>

</body>
</html>