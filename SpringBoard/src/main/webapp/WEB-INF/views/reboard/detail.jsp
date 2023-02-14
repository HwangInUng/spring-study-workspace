<%@page import="com.edu.springboard.domain.ReBoard"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	ReBoard reBoard = (ReBoard)request.getAttribute("reBoard");
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
		<div class="row">
		<div class="col-md">
		<form id="detailForm">
			<input type="hidden" name="reboard_idx" value="<%=reBoard.getReboard_idx()%>">
 			<div class="form-group">
				<label for="title">제목:</label>
				<input type="text" class="form-control" value="<%=reBoard.getTitle()%>" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자:</label>
				<input type="text" class="form-control" value="<%=reBoard.getWriter()%>" name="writer">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="content"><%=reBoard.getContent()%></textarea>
			</div>
			<button type="button" class="btn btn-dark" id="update">수정</button>
			<button type="button" class="btn btn-danger" id="del">삭제</button>
			<button type="button" class="btn btn-secondary float-right" id="list">목록</button>
			<button type="button" class="btn btn-secondary float-right" id="reply">답변하기</button>
		</form>
		</div>
		</div>
		<div class="row mt-5" id="reply_section">
		<div class="col-md">
		<form id="replyForm">
			<input type="hidden" name="reboard_idx" value="">
 			<div class="form-group">
				<label for="title">제목:</label>
				<input type="text" class="form-control" value="" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자:</label>
				<input type="text" class="form-control" value="" name="writer">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-dark" id="regist">등록</button>
		</form>
		</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function updateNdelete(url){
		$("#detailForm").attr({
			action: "/reboard/"+url,
			method: "post"
		});
		$("#detailForm").submit();
	}
	
	$(function(){
		$("#update").on("click", function(){
			if(confirm("수정하시겠습니까?")){
				updateNdelete("update");
			}
		});
		$("#del").on("click", function(){
			if(confirm("삭제하시겠습니까?")){
				updateNdelete("delete");
			}
		});
		$("#list").on("click", function(){
			location.href="/reboard/list";
		});
		$("#reply").on("click", function(){
			$("#reply_section").show();
		});
		
		$("#reply_section").hide();
	});
</script>
</html>