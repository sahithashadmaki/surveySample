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
	
	<jsp:include page="AdminHeader.jsp"></jsp:include><br>
	<br>
	<!-- 
<form action="AddQuestion.jsp">
<input type="submit" value="Add Questions"></form> -->
	<button onclick="addQuestion('${form.formId}')">Add Question</button>
	<c:if test="${not empty(list)}">
	<br>form Id: ${form.formId}
	<h3>List of questions</h3>
	<br>
	<table>
		<tr>
			<th>Question Id</th>
			<th>Question</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.questionId}" /></td>
				<td><c:out value="${list.question}" /></td>
				<td><button onclick="deleteQues('${list.questionId}')"
						id="delete">Delete</button></td>


			</tr>
		</c:forEach>
	</table>
	</c:if>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script>
	function deleteQues(id){
		var que="que";
		 $.ajax({
		        url: 'DeleteServlet',
		        type: 'POST',
		        data: {
		        	id: id,
		        	value: que
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
	<script>
	function addQuestion(fId){
		 document.location.href="AddQHelperServlet?fid="+fId;
	
	   
	}
	</script>
</body>
</html>