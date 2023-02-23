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
										<form id="detailForm">
											<input type="hidden" name="category_idx">
											<input type="hidden" name="_method">
											<div class="input-group input-group-sm" style="width: 250px;">
												<input type="text" name="category_name" class="form-control float-right">
												<div class="input-group-append">
													<button type="button" class="btn btn-default" id="bt_edit">수정</button>
													<button type="button" class="btn btn-default" id="bt_del">삭제</button>
												</div>
											</div>
										</form>
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
		let isRun = false; //ajax 중복실행 방지

		/*-------------------------------------테이블 레코드 컴포넌트*/
		function Row({list}){
			const [categoryList, setCategoryList] = React.useState([]);
			React.useEffect(() => {
				setCategoryList(list);
			}, [list]);
			const onClick = (category) => {
				$("#detailForm input[name='category_name']").val(category.category_name);
				$("#detailForm input[name='category_idx']").val(category.category_idx);
				console.log(category.category_idx);
			}
			return (
				<>
					{categoryList && categoryList.map((category, index) => {
					return(
						<tr key={index}>
							<td>{category.category_idx}</td>
							<td>{category.category_name}</td>
							<td>
								<button className="btn-sm btn-dark" onClick={() => onClick(category)}>보기</button>
							</td>
						</tr>
					)
					})}
				</>
			)	
		}

		/*-------------------------------------수정*/
		function edit(){
			if(isRun == true){
				return;
			}
			/*form 사용 제한으로 문자열화 시키기 위한 json 선언*/
			let json = {};
			json['category_idx'] = $("#detailForm input[name='category_idx']").val();
			json['category_name'] = $("#detailForm input[name='category_name']").val();

			isRun = true;  //논리값 변경

			$.ajax({
				url: "/admin/rest/category",
				type: "PUT",  //html의 form은 GET, POST만 표현
				contentType: "application/json; charset=utf-8", //헤더 설정
				data: JSON.stringify(json), //웹의 데이터 교환 시 데이터 형태는 문자열화
				processData: false, //쿼리 스트링화(문자열화) 방지
				success: function(result, status, xhr){
					isRun = false;
					getList();
				},
				error: function(xhr, status, err){
					alert("에러발생" + err);
				},
			});
		}

		/*-------------------------------------삭제*/
		function del(){
			if(isRun == true){
				return;
			}
			
			isRun = true;

			$.ajax({
				url: "/admin/rest/category/" + $("#detailForm input[name='category_idx']").val(),
				type: "DELETE",
				success: function(result, status, xhr){
					isRun = false;
					getList();
				},
				error: function(xhr, status, err){
					alert("에러발생" + err);
				},
			});
		}

		/*-------------------------------------등록*/
		function regist(){
			if(isRun == true){
				return;
			}
			isRun = true;			

			$.ajax({
				type: "POST",
				url: "/admin/rest/category",
				data:{
					category_name: $("input[name='category_name']").val()
				},
				success: function(result, status, xhr){
					isRun = false;
					getList();
				},
				error: function(xhr, status, err){
					alert("에러발생" + err);
				}
			});
		}
		
		/*-------------------------------------리스트 호출*/
		function getList(){
			$.ajax({
				type: "GET",
				url: "/admin/rest/category",
				success: function(result, status, xhr){
					tbody.render(<Row list={result}/>);
				},
			});
		}
		/*-------------------------------------로드*/
		$(function(){
			getList();

			$("#bt_regist").on("click", function(){
				regist();
			});
			
			$("#bt_edit").on("click", function(){
				if(confirm("수정하시겠습니까?")){
					edit();
				}
			});

			$("#bt_del").on("click", function(){
				if(confirm("삭제하시겠습니까?")){
					del();
				}
			});
		});
	</script>
</body>
</html>









