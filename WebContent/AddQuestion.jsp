<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>

<script>
			var spanTotal = document.createElement("span");
			function myFunction() {
				spanTotal.innerHTML += "<input style=\"width:50px\" type=\"text\" name=\"array\">";
				document.getElementById('options').appendChild(spanTotal);
			}

			function send(id) {
				var button1=document.forms["myform"]["add"].value;
				var button2=document.forms["myform"]["addStop"].value;
				var type = document.forms["myform"]["questionType"].value;
				var question = document.forms["myform"]["question"].value;
				var options = new Array();
				var value;
				console.log(type);
				console.log(question);
				for (i = 0; i < spanTotal.childNodes.length; i++) {
					options.push(spanTotal.childNodes[i].value);
				}
				//var json = JSON.stringify(options);
				var str=options.toString();
				 var questioninfo=question+"       "+str;
				 //request.setAttribute("questioninfo",questioninfo);
				 document.getElementById("que").innerHTML =questioninfo;
				// $("#button").click(function(){
					 $(document).ready(function(){
				    $("#pageid").load("AddQueServlet" + " #pageid" ,
				    		{
				    	id: id,
				          type: type,
				          question: question,
				          str: str,
				          button1: button1,
				          button2: button2
				    		} /* ,function(responseTxt, statusTxt, xhr){
				        if(statusTxt == "success")
				            alert("External content loaded successfully!");
				        if(statusTxt == "error")
				            alert("Error: " + xhr.status + ": " + xhr.statusText);
				    }  */);
				}
			); 
				}	
				 /* $(document).ready(function(){
			        $.post("AddQueServlet",
			        {
			          id: id,
			          type: type,
			          question: question,
			          str: str,
			          button1: button1,
			          button2: button2
			        }/* ,function(data,status){
				           if(status=='success'){
				        	   value='success';
				        	  // window.location.href="AddQueServlet";
				           }
				        });
			       
			});  
			 if(value=='success'){
					document.location.href="AddQueServlet";
				} */
			
		</script>
</head>
<body>
Hello:  ${admin.name} <br>
<jsp:include page="AdminHeader.jsp"></jsp:include><br>
	<br>
	Adding questions in form with ID: ${form.formId}
	<br>
	<h4>Below are the Questions added already</h4>
	<br>
	<table>
		<tr>
			<th>Question Id</th>
			<th>Question</th>
			<th>Options</th>
		</tr>
		<c:forEach items="${list}" var="list">

			<tr>
				<%-- <td><c:out value="${list.questionId}" /></td> --%>
				<td><c:out value="${list.question}" /></td>
			<td><c:if test="${not empty(list.questionOptions)}">
				<c:forEach items="${list.questionOptions}" var="options">
					<c:out value="${options}"></c:out>,
				</c:forEach>
			</c:if></td>

			</tr>
		</c:forEach>
	</table>
	<p id="que"></p>
<div id="pageid">

	---------------------------------------------------------------------------------------------------------

	<form id="form" name="myform" action="AddQueServlet" method="post">
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

		<button type="button" id="button" onclick="send('${form.formId}')" name="add">Add</button>
		<input type="button" name="addStop" value="Add&Stop">
	</form>
	</div>
</body>
</html>
