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
<title>Insert title here</title>
</head>
<body>
<body>
<h2>${productVO.title}</h2>
<hr>
<p>
기자 : ${productVO.writer}
</p>
<p>
기사 내용 : <br>
${productVO.body}
</p>
<a href="/exam2/product/update.do?id=${productVO.id}">[기사 수정]</a> <a href="/exam2/product/backUpdate.do">[목록 보기]</a>
</html>