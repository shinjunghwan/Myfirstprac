<!-- reply.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글 작성</title>
<script  src="board.js" type="text/javascript"></script>
<link href="board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>답글 작성</h1>
	<hr>
	<form name="boardform" action="replyProc.do" method="post">
		<table style="border: 0px; width: 600px;">
			<tr>
				<th>아이디</th>
				<td>
					<input type="hidden" name="id">
					&nbsp;<input type="text" name="email1" maxlength="25" size="15">
					@
					<input type="text" name="email2" maxlength="25" size="15" style="display: inline;">
					<select name="email3" onchange="email_check()">
						<option value="self">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="dreamwiz.com">dreamwiz.com</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
						<option value="empal.com">empal.com</option>
						<option value="unitel.co.kr">unitel.co.kr</option>
						<option value="gmail.com">gmail.com</option>
						<option value="korea.com">korea.com</option>
						<option value="chol.com">chol.com</option>
						<option value="paran.com">paran.com</option>
						<option value="freechal.com">freechal.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="hotmail.com">hotmail.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					&nbsp;<input type="password" name="pwd" maxlength="20" size="15">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					&nbsp;<input type="text" name="title" maxlength="100" size="59" value="[RE] ${ dto.title }" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="20" cols="72" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="hidden" name="parent" value="${ dto.parent }">
					<input type="hidden" name="sort" value="${ dto.sort }">
					<input type="hidden" name="tab" value="${ dto.tab }">
					<input type="button" value="글쓰기" onclick="board_check(this.form)">
					<input type="button" value="리스트" onclick="board_list(this.form)">
					<input type="button" value="취소" onclick="board_cancle()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>