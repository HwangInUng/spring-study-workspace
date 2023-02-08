<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.mvc.domain.Board"%>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<p class="display-2 text-center">게시물 목록</p>
		<table class="table">
			<thead>
				<tr>
					<th>고유번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < boardList.size(); i++) {
					Board board = boardList.get(i);
				%>
				<tr>
					<td><%=board.getBoard_idx()%></td>
					<td>
						<a href="/board/detail.do?board_idx=<%=board.getBoard_idx() %>"><%=board.getTitle()%></a>
					</td>
					<td><%=board.getWriter()%></td>
					<td><%=board.getContent()%></td>
					<td><%=board.getHit()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#registModal">글쓰기</button>

		<!-- The Modal -->
		<div class="modal" id="registModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">게시물 등록</h4>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form id="registForm">
							<div class="mb-3 mt-3">
								<label for="title" class="form-label">Title:</label> <input type="text" class="form-control" name="title">
							</div>
							<div class="mb-3 mt-3">
								<label for="writer" class="form-label">Writer:</label> <input type="text" class="form-control" name="writer">
							</div>
							<div class="mb-3 mt-3">
								<label for="content" class="form-label">Content:</label>
								<textarea class="form-control" rows="5" name="content"></textarea>
							</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" id="regist">등록</button>
						<button type="button" class="btn btn-dark" data-bs-dismiss="modal">목록</button>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function regist() {
		$("#registForm").attr({
				action: "/board/regist.do",
				method: "post"
		});
		$("#registForm").submit();
	}

	$(function() {
		$("#regist").on("click", function() {
			regist();
		});
	});
</script>
</html>