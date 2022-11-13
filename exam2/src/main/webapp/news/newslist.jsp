<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="product.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 게시판</title>
</head>
<body>
<div align="center">
<h2>뉴스 게시판</h2>
<hr>
<h3><a href="/exam2/product/insertReq.do">기사 등록</a></h3>
<p>
<table border="1">
	<tr>
		<th>제목</th> <th>기자</th> <th>등록일</th> <th>조회수</th>
	</tr>
	<c:forEach var="product" items="${requestScope.productList}">
		<tr>
			<td><a href="/exam2/product/read.do?id=${product.id}">${product.title}</a></td>
			<td>${product.writer}</td>
			<td>${product.regdate}</td>
			<td>${product.readcnt}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>