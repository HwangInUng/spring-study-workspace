<%@ page contentType="text/html;charset=UTF-8"%>
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
		<form id="registForm">
			<div class="form-group">
				<label for="title">제목:</label>
				<input type="text" class="form-control" placeholder="제목" name="title">
			</div>
			<div class="form-group">
				<label for="writer">작성자:</label>
				<input type="text" class="form-control" placeholder="작성자" name="writer">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-dark" id="regist">등록</button>
			<button type="button" class="btn btn-dark" id="list">목록</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	function regist(){
		$("#registForm").attr({
			action: "/board/regist",
			method: "post"
		});
		$("#registForm").submit();
	}

	$(function(){
		$("#regist").on("click", function(){
			regist();
		});
		$("#list").on("click", function(){
			location.href="/board/list";
		});
	});
</script>
</html>