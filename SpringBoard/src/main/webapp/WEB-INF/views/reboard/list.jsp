<%@page import="com.edu.springboard.domain.ReBoard"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<ReBoard> reBoardList = (List)request.getAttribute("reBoardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		  <table class="table">
    <thead>
      <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
			<%
				for(ReBoard reBoard : reBoardList){
			%>
      <tr>
        <td><%=reBoard.getReboard_idx() %></td>
        <td>
        	<a href="/reboard/detail?reboard_idx=<%=reBoard.getReboard_idx() %>"><%=reBoard.getTitle() %></a>
        </td>
        <td><%=reBoard.getWriter() %></td>
        <td><%=reBoard.getRegdate() %></td>
        <td><%=reBoard.getHit() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>
  <button class="btn btn-dark" type="button" id="regist">글등록</button>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#regist").on("click", function(){
			location.href="/reboard/registform";
		});
	});
</script>
</html>