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
Hello:  ${admin.name} <br>
<jsp:include page="AdminHeader.jsp"></jsp:include><br>
<br>
	<!-- 
<form action="AddQuestion.jsp">
<input type="submit" value="Add Questions"></form> -->
		<button  onclick="addQuestion('${form.formId}')">Add
		Question</button>
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
				<td><button onclick="addParameterToURL('${list.questionId}','${list.question}')"
							id="delete">Delete</button></td>
				

			</tr>
		</c:forEach>
	</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script>
	function addParameterToURL(id,que){
	   $(document).ready(function(){
        $.post("EditQueServlet",
        {
          id: id,
          que: que
        }
        );
});
	}
	function addQuestion(fId){
		 document.location.href="AddQHelperServlet?fid="+fId;
	 /*   $(document).ready(function(){
		        $.post("AddQHelperServlet",
		        {
		          fid: fId
		        },function(data,status){
		           if(status=='success'){
		        	   document.location.href="AddQHelperServlet";
		           }
		        });
		}); */
	   
	}
	</script>
</body>
</html>