<%@page import="com.edu.springdb.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Board> boardList = (List) request.getAttribute("boardList");
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
				for(int i = 0; i < boardList.size(); i++){
				Board board = boardList.get(i);
			%>
      <tr>
        <td><%=i %></td>
        <td>
        	<a href="/board/detail?board_idx=<%=board.getBoard_idx() %>"><%=board.getTitle() %></a>
        </td>
        <td><%=board.getWriter() %></td>
        <td><%=board.getRegdate() %></td>
        <td><%=board.getHit() %></td>
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
			location.href="/board/registform";
		});
	});
</script>
</html>