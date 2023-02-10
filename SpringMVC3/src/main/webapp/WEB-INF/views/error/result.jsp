<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background:yellow">
에러 발생
<br>
<%
	RuntimeException e = (RuntimeException) request.getAttribute("e");
	String msg = e.getMessage();
%>
<p><%=msg %></p>
</body>
</html>