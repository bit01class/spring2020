<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>download page</h1>
	<p>
		<div>sabun:${sabun }</div>
		<c:forEach items="${files }" var="file">
		<div><a href="download/${file }">download</a></div>
		</c:forEach>
		
	</p>
</body>
</html>