<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../inc/header_link.jsp"%>

<!-- JQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
function loginCheck(){
	//비동기로 전송하기 
	$.ajax({
		url:"/admin/rest/login-admin",
		type:"POST",
		data:$("#loginForm").serialize(),
		success:function(result, status , xhr){
			alert(result.msg);
			location.href="/admin/main";
		},
		error: function(xhr, status, err){
			let json = JSON.parse(xhr.responseText);
			alert(json.msg);
		},
	});
}

$(function(){
	//버튼에 이벤트 연결 
	$("#bt_login").click(function(){
		loginCheck();
	});

});
</script>
</head>
<body>
<div class="wrapper">

	
	<div class="card card-info m-5">
		<div class="card-header">
			<h3 class="card-title">관리자 로그인</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<form class="form-horizontal" id="loginForm">
			<div class="card-body">
			
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="admin_id"
							placeholder="Your ID...">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="admin_pass"
							placeholder="Password">
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck2"> <label class="form-check-label"
								for="exampleCheck2">Remember me</label>
						</div>
					</div>
				</div>
			</div>
			<!-- /.card-body -->
			<div class="card-footer">
				<button type="button" class="btn btn-info" id="bt_login">Login</button>
				<button type="button" class="btn btn-default float-right">Cancel</button>
			</div>
			<!-- /.card-footer -->
		</form>
	</div>
</div>	
</body>
</html>