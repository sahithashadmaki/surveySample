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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	Hello: ${admin.name}
	<br>
	<jsp:include page="AdminHeader.jsp"></jsp:include><br>
	<br> Adding questions in form with ID: ${form.formId}
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
					</c:if> </td>
					<td><button type="button" onclick="deleteQues('${list.questionId}')"
							id="delete">Delete</button></td>
				
			</tr>
		</c:forEach>
	</table>

	<div class="container mt-3">

		<button type="button" class="btn btn-primary" id="myBtn">Add
			Question</button>

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Adding Question</h4>
						<!-- 						<button type="button" class="close" data-dismiss="modal">&times;</button> -->
					</div>
					<div class="modal-body">
						<h4>Select type of question</h4>
						<select id="typeId" name="questionType">
							<option value="default">--Select questionType--</option>
							<option>Multiple Choice</option>
							<option>Text Type</option>

						</select> <br> <br>
						<h4>Question:</h4>
						<input type="text" id="question" name="que"><br> <br>
						<br>
						<button style="display: none" id="addBtn" onclick="myFunction()"
							type="button">Add Option</button>

						<div id="options"></div>
						<br> <br>
						<button type="button" class="btn btn-primary"
							onclick="send('${form.formId}')" id="add">Add</button>

						<!-- <button type="button" class="btn btn-primary" id="AddStop">Add-Stop</button> -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
	</div>

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

	<script>

	$(document).ready(function() {
		$("#myBtn").click(function() {
			$("#myModal").modal("show");
		});
	});
	</script>
	<script>
		
		function send(id) {
			var options = new Array();

			for (i = 0; i < spanTotal.childNodes.length; i++) {
				options.push(spanTotal.childNodes[i].value);
			}

			var str = options.toString();
			console.log(id);
			console.log(str);
			var type=$('.modal-body #typeId').val();
			console.log(type);
		
    $.ajax({
        url: 'AddQueServlet',
        type: 'POST',
        data: {
        	id: id,
            str: str,
        	question: $('.modal-body #question').val(),
        	type: $('.modal-body #typeId').val(),
             
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
function deleteQues(quesId){
	var sql=sql="delete from questions where q_id="+quesId+";";
	console.log(sql);
	  $.ajax({
	        url: 'DeleteServlet',
	        type: 'POST',
	        data: {
	        	id: quesId,
	        	sql: sql
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
		var spanTotal = document.createElement("span");
		function myFunction() {
			spanTotal.innerHTML += "<input style=\"width:50px\" type=\"text\" name=\"array\">";
			document.getElementById('options').appendChild(spanTotal);
			
		}
	</script>
</body>
</html>