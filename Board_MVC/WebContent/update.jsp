<!-- update.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<script  src="board.js" type="text/javascript"></script>
<link href="board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>게시글 수정</h1>
	<hr>
	<form name="boardform" action="updateProc.do" method="post">
		<table style="border: 0px; width: 600px;">
			<tr>
				<th class="read">글번호</th>
				<th class="read">아이디</th>
				<th class="read">작성일</th>
				<th class="read">비밀번호</th>
			</tr>
			<tr>
				<td><input type="text" size="27" disabled="disabled" value="${ dto.no }"></td>
				<td><input type="text" name="id" size="27" disabled="disabled" value="${ dto.id }"></td>
				<td><input type="text" name="regdate" size="27" disabled="disabled" value="${ dto.regdate }"></td>
				<td><input type="password" name="pwd" size="27"></td>
			</tr>
			<tr>
				<th class="read">제목</th>
				<td colspan="3"><input type="text" name="title" size="93" value="${ dto.title }"></td>
			</tr>
			<tr>
				<td colspan="4">	<textarea rows="20" cols="110" name="content">${ dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<input type="hidden" name="no" value="${ dto.no }" >
					<input type="button" value="수정" onclick="board_update_check(this.form)">
					<input type="button" value="취소" onclick="board_cancle()">
					<input type="button" value="리스트" onclick="board_list(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>