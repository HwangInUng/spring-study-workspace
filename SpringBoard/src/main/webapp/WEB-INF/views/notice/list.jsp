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

<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
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
    <tbody id="root">
			
    </tbody>
  </table>
  <button class="btn btn-dark" type="button" id="regist">글등록</button>
	</div>
</body>
<script type="text/babel">
	let listJson = "";
	
	function List({list}){
	const [value, setValue] = React.useState([]);
	const onClick = (notice_idx) => {
		location.href="/notice/detail?notice_idx=" + notice_idx;
	}
	React.useEffect(() => {
		setValue(list);
	}, []);
		console.log(value);
		return (
			<>
		{value.map((value, index) => {
			return(
			<tr key={index}>
				<td>{value.notice_idx}1</td>
				<td>
					<a href="#" onClick={() => onClick(value.notice_idx)}>{value.title}</a>
				</td>
				<td>{value.writer}</td>
				<td>{value.regdate}</td>
				<td>{value.hit}</td>
			</tr>
			)
		})}
			</>
		);
	}

	$(function(){
		const root = ReactDOM.createRoot(document.getElementById("root"));

		$.ajax({
			type : "GET",
			url : "/rest/notices",
			success: function(result){
				console.log(result);

				root.render(<List list={result}/>);
			}
		});

		$("#regist").on("click", function(){
			location.href="/notice/registform";
		});

	});
</script>
</html>