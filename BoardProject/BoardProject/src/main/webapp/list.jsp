<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="${contextPath}/insert.do" id="btn_wirte">작성하러 가기</a>

	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${frees}" var="f">
						<tr>
								<td><div>${f.freeNo}</div></td>
								<td><div>${f.title}</div></td>
								<td><div>${f.writer}</div></td>
								<td><div>${f.hit}</div></td>
								<td>X</td>
						<tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>