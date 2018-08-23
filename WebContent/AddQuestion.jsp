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
	<%-- <jsp:useBean id="form" class="SurveyApplication.Forms" scope="session" />
	Adding questions in :
	<jsp:getProperty property="formTitle" name="form" /> --%>
	Adding questions in form with ID: ${form.formId}
	<br>
	<h4>Below are the Questions added already</h4>
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

			</tr>
		</c:forEach>
	</table>
	<jsp:useBean id="id" class="SurveyApplication.Forms" scope="request" />
	<jsp:setProperty property="formId" name="id" value="${form.formId}" />

	---------------------------------------------------------------------------------------------------------
	<form action="AddQueServlet" method="post">
		<jsp:include page="TypeOfQuestion.jsp"></jsp:include><br> <br>
		Question: <input type="text" name="question">

		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
			
		</script>
		<script>
			$(document).ready(function() {
				$('#typeId').on('change', function() {
					if (this.value == 'Multiple Choice') {
						$("#addBtn").show();
					} else {
						$("#addBtn").hide();
					}
				});
			});
		</script>


		<button style="display: none" id="addBtn" onclick="myFunction()"
			type="button">Add Option</button>


		<div id="options"></div>

		<script>
			var spanTotal = document.createElement("span");
			function myFunction() {
				spanTotal.innerHTML += "<input style=\"width:50px\" type=\"text\" name=\"array\">";
				document.getElementById('options').appendChild(spanTotal);
			}

			function send(id) {
				var options = new Array();
				for (i = 0; i < spanTotal.childNodes.length; i++) {
					options.push(spanTotal.childNodes[i].value);
					/*  $(document).ready(function(){
					        $.post("EditQueServlet",
					        {
					          id: id,
					          que: que
					        }
					        );
					}); */
				}

			};
		</script>
		<%-- 		<c:set var="formId" value="${form.formId}" scope="request"/> --%>
		<%-- <jsp:useBean id="id" class="SurveyApplication.Forms" scope="request"></jsp:useBean>
	<jsp:setProperty property="formId" name="id" value="${form.formId}"/> --%>
		<button onclick="send('${form.formId}')" name="add">Add</button>
		<input type="submit" name="addStop" value="Add&Stop">
	</form>
</body>
</html>