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
<title>Update Page</title>
</head>
<body>
<div>
<h2>기사 수정</h2>
<hr>
<form action="/exam2/product/updateReq.do?id=${productVO.id}" method="post">
<table>
	<tr>
		<td>기자</td>
		<td><input type="text" name="writer" size="20" value="${productVO.writer}"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" size="30" value="${productVO.title}"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="body" size="30" value="${productVO.body}"></td>
	</tr>
	<tr>
		<td><input type="submit" value="수정" ></td> <td><input type="reset" value="취소" ></td>
	</tr>
</table>
</form>
</div>
</body>
</html>