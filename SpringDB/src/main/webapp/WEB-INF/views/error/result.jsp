<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>에러</p>
	<%
		RuntimeException e = (RuntimeException)request.getAttribute("e");
		out.print(e.getMessage());
	%>
	<a href="/board/list"></a>
</body>
</html>