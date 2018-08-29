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
<h3>${form.formTitle}</h3>
	<c:forEach items="${list}" var="list" varStatus="loop">
		<c:choose>
		
			<c:when test="${list.queType eq 'Multiple Choice'}">
				${loop.count}. <c:out value="${list.question}" />
				<br>
				<c:forEach items="${list.questionOptions}" var="options">
			<input type="radio" id="${list.questionId}" name="${list.questionId}" value="${options}">${options}<br>
			</c:forEach>
			</c:when>
			<c:when test="${list.queType eq 'Text Type'}">
				<c:out value="${list.question}" />
				<br>
				<input type="text" name="textBox">
				<br>
			</c:when>
		</c:choose>
	</c:forEach>


</body>
</html>