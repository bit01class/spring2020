<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Home</title>
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
			<label for="file1">file</label>
			<input type="file" name="file1" />
		</div>
		<button type="submit">업로드</button>
	</form>
</body>
</html>
