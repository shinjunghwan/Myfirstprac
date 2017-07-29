<!-- read.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세</title>
<script  src="board.js" type="text/javascript"></script>
<link href="board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>게시글 상세</h1>
	<hr>
	<table style="border: 0px; width: 600px;">
		<tr>
			<th class="read">글번호</th>
			<th class="read">아이디</th>
			<th class="read">작성일</th>
		</tr>
		<tr>
			<td><input type="text" name="no" size="27" disabled="disabled" value="${ dto.no }"></td>
			<td><input type="text" name="id" size="27" disabled="disabled" value="${ dto.id }"></td>
			<td><input type="text" name="regdate" size="27" disabled="disabled" value="${ dto.regdate }"></td>
		</tr>
		<tr>
			<th class="read">제목</th>
			<td colspan="2"><input type="text" name="title" size="60" disabled="disabled" value="${ dto.title }"></td>
		</tr>
		<tr>
			<td colspan="3">	<textarea rows="20" cols="82" name="content" disabled="disabled">${ dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<a href="reply.do?no=${ dto.no }&pg=${ pg }"><button class="linkbutton">답글쓰기</button></a>
				<a href="update.do?no=${ dto.no }&pg=${ pg }"><button class="linkbutton">수정하기</button></a>
				<a href="delete.do?no=${ dto.no }&pg=${ pg }"><button class="linkbutton">삭제하기</button></a>
				<a href="list.do?pg=${ pg }"><button class="linkbutton">리스트</button></a>
				<input type="button" value="취소" onclick="board_cancle()">
			</td>
		</tr>
	</table>
</body>
</html>