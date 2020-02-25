<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Home</title>
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function(){
			$('form button[type=button]').click(function(){
					$('<input type="file" name="files" />').appendTo("form>div:eq(1)");
				});


			});

	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<form action="upload" method="post" enctype="multipart/form-data">
	
		<div>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" />
		</div>
		<div>
			<label for="file1">file1</label>
			<input type="file" name="files" />
		</div>
		<button type="button">첨부추가</button>
		<button type="submit">업로드</button>
	</form>
</body>
</html>
















