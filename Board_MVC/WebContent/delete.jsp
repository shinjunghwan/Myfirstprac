<!-- delete.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 삭제 비밀번호 확인</title>
<script  src="board.js" type="text/javascript"></script>
<link href="board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>글 삭제 비밀번호 확인</h1>
	<hr>
	<form name="boardform" action="deleteProc.do" method="post">
		<table style="border: 0px;">
		<tr>
			<th>비밀번호</th>
				<td>
					<input type="hidden" name="pg" value="${ pg }">
					<input type="hidden" name="no" value="${ no }">
					&nbsp;<input type="password" name="pwd" maxlength="20" size="15">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="삭제" onclick="board_delete_check(this.form)">
					<input type="button" value="취소" onclick="board_cancle()">
					<input type="button" value="리스트" onclick="board_list(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>