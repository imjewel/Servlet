<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/student.css?after" rel="stylesheet">
<script type="text/javascript" src="./script/student.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
	<h3>성적 정보 등록</h3>
	<form action="RM" method="post" name="frm">
		<table border="1">
			<tr>
				<td>학번(자동발생)</td>
				<td> <input type="text" name="studno" id="studno" value="${nextNumber}" readonly> </td>
			</tr>
			<tr>
				<td>학생 성명</td>
				<td> <input type="text" name="studname" id="studname"  > </td>
			</tr>
			<tr>
				<td>국어점수</td>
				<td> <input type="text" name="korean" id="korean"  > </td>
			</tr>
			<tr>
				<td>영어점수</td>
				<td> <input type="text" name="english" id="english"  > </td>
			</tr>
			<tr>
				<td>수학점수</td>
				<td> <input type="text" name="math" id="math"  > </td>
			</tr>
			<tr>
				<td>역사점수</td>
				<td> <input type="text" name="history" id="history"  > </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" onclick="return chkValue()">
					<input type="button" value="조회" onclick="location.href='VM'">
				</td>
			</tr>
		
		</table>
	
	
	</form>
</section>



<jsp:include page="../include/footer.jsp" />
</body>
</html>