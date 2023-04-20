<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL을 활용한 방법 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/student.css?after" rel="stylesheet">
</head>
<body>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />

<section>
	<h3>학생성적 조회/수정</h3>
	<table border="1">
		<tr>
			<th>학번</th>
			<th>학생성명</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>역사</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<c:forEach var="member" items="${list}">
			<tr>
				<td><a href="UM?studno=${member.studno}">${member.studno}</a></td>
				<td>${member.studname}</td>
				<td>${member.korean}</td>
				<td>${member.english}</td>
				<td>${member.math}</td>
				<td>${member.history}</td>
				<td>${member.korean + member.english + member.math + member.history}</td>
				<td>${(member.korean + member.english + member.math + member.history)/4}</td>
			</tr>
		</c:forEach>
		
		
	</table>
</section>
<jsp:include page="../include/footer.jsp" />
</body>
</html>