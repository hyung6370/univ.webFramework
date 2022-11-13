<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 		
	request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Page</title>
</head>
<body>
<div>
<h2>기사 입력</h2>
<hr>
<form action="/exam2/product/insert.do" method="post">
<table>
	<tr>
		<td>기자</td>
		<td><input type="text" name="writer" size="20"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" size="30"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="body" size="30"></td>
	</tr>
	<tr>
		<td><input type="submit" value="등록" ></td> <td><input type="reset" value="취소" ></td>
	</tr>
</table>
</form>
</div>
</body>
</html>