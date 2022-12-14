<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#frm_write').submit(function(event){
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				$('#title').focus();
				event.preventDefault();
				return;
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/list.do';
		});
		
	});
</script>
</head>
<body>
	
	<h1>자유게시글 작성 화면</h1>
	<div>
		<form id="frm_write" action="${contextPath}/add.do" method="POST">
			<div>
				<label for="writer"></label>
				<input type="text" id="writer" name="writer" placeholder="작성자">
				<br>
				<label for="title"></label>
				<input type="text" id="title" name="title" placeholder="제목">
			</div>
			<div>
				<label for="content">내용</label>
				<br>
				<textarea id="content" name="content" rows="5" cols="30"></textarea>
			</div>
			<div>
				<input type="submit" value="작성완료">
				<input type="reset" value="다시작성">
				<input type="submit" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
</body>
</html>