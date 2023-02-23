<%@page import="com.edu.springshop.domain.Product"%>
<%@page import="com.edu.springshop.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Category> categoryList = (List)request.getAttribute("categoryList");
	Product product = (Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<%@ include file="../inc/header_link.jsp"%>
<style type="text/css">
.box-style{
	width:90px;
	height:95px;
	border:1px solid #ccc;
	display:inline-block;
	margin:5px;
}
.box-style img{
	width: 75px;
	height: 75px;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<!-- Preloader -->
		<%@ include file="../inc/preloader.jsp" %>
		
		<!-- Navbar -->
		<%@ include file="../inc/navbar.jsp" %>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../inc/sidebar_left.jsp" %>
		
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">상세보기</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">상품관리> 상세보기</li>
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
			<section class="content" id="app1">
				<div class="container-fluid">
				
					<!-- Main row -->
					<div class="row">
						<div class="col">
							
							<div class="form-group row">
								<div class="col">
									<select class="form-control" name="category_idx">
											<option value="<%=product.getCategory().getCategory_idx()%>">
												<%=product.getCategory().getCategory_name() %>
											</option>
											<%
												for(int i = 0; i < categoryList.size(); i++){
													Category category = categoryList.get(i);
													if(category.getCategory_idx() != product.getCategory().getCategory_idx()){
											%>
													<option value="<%=category.getCategory_idx()%>"><%=category.getCategory_name() %></option>
											<%
													}
												}
											%>
									</select>
								</div>
							</div>							
							
							<div class="form-group row">
								<div class="col">
									<input type="email" class="form-control" name="product_name" value="<%=product.getProduct_name()%>">
								</div>
							</div>							
							<div class="form-group row">
								<div class="col">
									<input type="email" class="form-control" name="brand" value="<%=product.getBrand()%>">
								</div>
							</div>							
							<div class="form-group row">
								<div class="col">
									<input type="number" class="form-control" name="price" value="<%=product.getPrice()%>">
								</div>
							</div>					
									
							<div class="form-group row">
								<div class="col">
									<input type="number" class="form-control" name="discount" value="<%=product.getDiscount()%>">
								</div>
							</div>
								
							<div class="form-group row">
								<div class="col">
									<input type="file" class="form-control" name="file" multiple>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col">
									<template v-for="json in imageList">
										<imagebox :key="json.key" :obj="json"/>
									</template>
								</div>
							</div>
							
							
							<div class="form-group row">
								<div class="col">
									<textarea class="form-control" id="detail" name="detail"><%=product.getDetail()%></textarea>
								</div>
							</div>
														
							<div class="form-group row">
								<div class="col">
									<button type="button" class="btn btn-dark btn-md" id="bt_edit">수정</button>							
									<button type="button" class="btn btn-dark btn-md" id="bt_del">삭제</button>									
									<button type="button" class="btn btn-secondary btn-md" id="bt_list">목록</button>									
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
		
		<%@ include file="../inc/footer.jsp" %>		

		<!-- Control Sidebar -->
		<%@ include file="../inc/sidebar_right.jsp" %>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>
	<script type="text/javascript">
		let app1;
		let key=0;
		
		const imagebox={
			template:`
				<div class="box-style">
					<div>X</div>
					<img :src="json.src">
				</div>
			`,
			props:["obj"],
			data(){
				return{
					json:this.obj
				};
			}
		};
		
		app1=new Vue({
			el:"#app1",
			components:{
				imagebox
			},
			data:{
				count:5,
				imageList:[]  //files(read only) 배열의 정보를  담아놓을 배열
			}
		});
		
		function checkDuplicate(filename){
			let count=0;
			
			for(let i = 0; i < app1.imageList.length; i++){
				let json = app1.imageList[i];
				if(json.name == filename){
					count++;
					break;
				}
			}
			
			return count;
		}
		
		function preview(files){
			for(let i = 0; i < files.length; i++){
				let file = files[i];
				
				if(!checkDuplicate(file.name)){
					let reader = new FileReader();
					reader.onload= (e) => {
						//정보를 분석하여  json으로 바꾼다...
						let json=[];
						
						key++;
						json["key"]=key; //삭제시 사용..
						json["name"]=file.name;
						json["src"]=e.target.result;
						json["file"]=file;
					
						app1.imageList.push(json);
						console.log(app1.iamgeList);
					};
					reader.readAsDataURL(file);
				}
			}
		}
		
		function regist(){
			//image 등 파일 업로드를 위한 객체
			let formData = new FormData();
			
			formData.append("category.category_idx", $("select[name='category_idx']").val());
			formData.append("product_name", $("input[name='product_name']").val());
			formData.append("brand", $("input[name='brand']").val());
			formData.append("price", $("input[name='price']").val());
			formData.append("discount", $("input[name='discount']").val());
			
			//파일 갯수만큼 formData에 추가
			for(let i = 0; i < app1.imageList.length; i++){
				let json = app1.imageList[i];
				formData.append("photo", json.file);
			}
			
			formData.append("detail", $("textarea[name='detail']").val());
			
			$.ajax({
				type: "POST",
				url: "/admin/rest/product",
				data: formData,
				processData: false,
				contentType: false,
				success: function(result){
					alert(result.msg);
				}
			});
		}
		
		//서머노트 적용하기 
		$(function(){
			$("#detail").summernote({
				height:200
			});
			
			//파일에 이벤트 연결 
			$("input[name='file']").on("change", function(){
				preview(this.files);
			});
			
			$("#bt_regist").on("click", function(){
				regist();
			});
			
			$("#bt_list").on("click", function(){
				location.href="/admin/product/list";
			});
			
		});
	
	</script>
</body>
</html>









