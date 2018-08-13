<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="FormHomePage.jsp"></jsp:include><br>
<br>
<jsp:useBean id="form" class="SurveyApplication.Forms" scope="session" />
Adding questions in : <jsp:getProperty property="formTitle" name="form"/>

<form action="AddQueServlet" method="post">
Question: <input type="text" name="question">
</form>
<button id="demo" onclick="myFunction()">Click me</button>
<button id="demo" onclick="send()">Send</button>

<div id="options">
</div>

<script>

var spanTotal = document.createElement("span");
function myFunction() {
spanTotal.innerHTML += "<input style=\"width:50px\" type=\"text\"  name=\"array\">";
document.getElementById('options').appendChild(spanTotal);
}

function send() {
	var options=new Array();
    for(i=0; i < spanTotal.childNodes.length; i++)
    {
      options.push(spanTotal.childNodes[i].value);
      //document.getElementById("options").innerHTML=options;
    }
};
</script>

</body>
</html>