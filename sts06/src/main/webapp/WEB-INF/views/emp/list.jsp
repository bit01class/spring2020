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
	<h1>list page</h1>
	<a href="add">입력</a>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${list }" var="bean">
		<c:url value="detail" var="one">
			<c:param name="sabun" value="${bean.sabun }"/>
		</c:url>
		<tr>
			<td><a href="${one }">${bean.sabun }</a></td>
			<td><a href="${one }">${bean.name }</a></td>
			<td><a href="${one }">${bean.nalja }</a></td>
			<td><a href="${one }">${bean.pay }</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>












