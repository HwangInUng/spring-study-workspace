<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<%@ include file="../inc/header_link.jsp"%>
<style type="text/css">
.box-style {
	width: 90px;
	height: 95px;
	border: 1px solid #ccc;
	display: inline-block;
	margin: 5px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<%@ include file="../inc/preloader.jsp"%>

		<!-- Navbar -->
		<%@ include file="../inc/navbar.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../inc/sidebar_left.jsp"%>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">카테고리 관리</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품관리> 상품등록</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">

					<!-- Main row -->
					<div class="row">
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">
									<div class="card-tools">
										<div class="input-group input-group-sm" style="width: 150px;">
											<input type="text" name="category_name" class="form-control float-right" placeholder="등록할 카테고리">
											<div class="input-group-append">
												<button type="button" class="btn btn-default" id="bt_regist">등록</button>
											</div>
										</div>
									</div>
								</div>

								<div class="card-body table-responsive p-0">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>카테고리 고유번호</th>
												<th>카테고리명</th>
												<th></th>
											</tr>
										</thead>
										<tbody id="tbody">
										</tbody>
									</table>
								</div>
							</div>
						</div>
						
						<div class="col-md-4">
							<div class="card">
								<div class="card-header">
									<div class="float-left">
										<div class="input-group input-group-sm" style="width: 250px;">
											<input type="text" name="category_name2" class="form-control float-right">
											<div class="input-group-append">
												<button type="button" class="btn btn-default">수정</button>
												<button type="button" class="btn btn-default">삭제</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.row (main row) -->
					</div>
					<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->


		<%@ include file="../inc/footer.jsp"%>

		<!-- Control Sidebar -->
		<%@ include file="../inc/sidebar_right.jsp"%>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp"%>
	<script type="text/babel">
		const tbody = ReactDOM.createRoot(document.getElementById("tbody"));

		function Row({list}){
			const [categoryList, setCategoryList] = React.useState([]);
			React.useEffect(() => {
				setCategoryList(list);
			}, [list]);
			return (
				<>
					{categoryList && categoryList.map((category, index) => {
					return(
						<tr key={index}>
							<td>{category.category_idx}</td>
							<td>{category.category_name}</td>
							<td>
								<button className="btn-sm btn-dark">보기</button>
							</td>
						</tr>
					)
					})}
				</>
			)	
		}

		function regist(){
			$.ajax({
				type: "POST",
				url: "/admin/rest/category",
				data:{
					category_name: $("input[name='category_name']").val()
				},
				success: function(result, status, xhr){
					getList();
				},
				error: function(xhr, status, err){
					alert("에러발생" + err);
				}
			});
		}
		
		function getList(){
			$.ajax({
				type: "GET",
				url: "/admin/rest/category",
				async: false,
				success: function(result, status, xhr){
					tbody.render(<Row list={result}/>);
				}
			});
		}
	
		$(function(){
			getList();

			$("#bt_regist").on("click", function(){
				regist();
			});
			
			$("#bt_detail").on("click", function(){
				$("input[name='edit-name']").val(this.value);
			});
		});
	</script>
</body>
</html>









