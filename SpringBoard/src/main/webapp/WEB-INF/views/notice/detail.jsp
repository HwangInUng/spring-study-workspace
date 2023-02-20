<%@ page contentType="text/html;charset=UTF-8"%>
<%
	int notice_idx = (Integer) request.getAttribute("notice_idx");
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
			<input type="hidden" name="reboard_idx" id="reboard_idx">
 			<div class="form-group">
				<label for="title">제목:</label>
				<input type="text" class="form-control" name="title" id="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자:</label>
				<input type="text" class="form-control" name="writer" id="writer">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="content" id="content"></textarea>
			</div>
			<button type="button" class="btn btn-dark" id="update">수정</button>
			<button type="button" class="btn btn-danger" id="del">삭제</button>
			<button type="button" class="btn btn-secondary float-right" id="list">목록</button>
		</form>
		</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	//레코드 1건 완료
	function detail(){
		$.ajax({
			url: "/rest/notices/<%=notice_idx%>",
			type: "GET",
			success: function(result){
				$("#title").val(result.title);
				$("#writer").val(result.writer);
				$("#content").val(result.content);
			}
		});
	}
	
	$(function(){
		$("#update").on("click", function(){
			if(confirm("수정하시겠습니까?")){
			}
		});
		
		$("#del").on("click", function(){
			if(confirm("삭제하시겠습니까?")){
			}
		});
		
		$("#list").on("click", function(){
			location.href="/notice/list";
		});
		
		$("#regist").on("click", function(){
			regist();
		});
		
		detail();
	});
</script>
</html>