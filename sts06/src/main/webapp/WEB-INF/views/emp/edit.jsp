<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 페이지</h1>
	<form method="post">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" value="${bean.sabun }" readonly="readonly"/>
		</div>
		<div>
			<label for="name">name</label>
			<input type="text" name="name" id="name" value="${bean.name }"/>
		</div>
		<div>
			<label for="nalja">nalja</label>
			<input type="text" name="nalja" id="nalja" value="${bean.nalja }" disabled="disabled"/>
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" name="pay" id="pay" value="${bean.pay }"/>
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
</body>
</html>



