// board.js

function email_check() {
	if (boardform.email3.value == "self") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = "";
		boardform.email2.readOnly = false;
	} else if (boardform.email3.value == "naver.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "nate.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "dreamwiz.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "yahoo.co.kr") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "empal.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "unitel.co.kr") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "gmail.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "korea.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "chol.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "paran.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "freechal.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "hanmail.net") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} else if (boardform.email3.value == "hotmail.com") {
		boardform.email2.style.display = "inline";
		boardform.email2.value = boardform.email3.value;
		boardform.email2.readOnly = true;
	} // if
} // email_check

function board_check(boardform) {
	var msg = null;
	var foc = null;
	
	if (boardform.email1.value == "") {
		msg = "이메일 앞자리를 입력해주세요";
		foc = boardform.email1;
	} else if (boardform.email2.value == "") {
		msg = "이메일 뒷자리를 입력해주세요";
		foc = boardform.email2;
	} else if (boardform.pwd.value == "") {
		msg = "비밀번호를 입력해주세요";
		foc = boardform.pwd;
	} else if (boardform.title.value == "") {
		msg = "제목을 입력해주세요";
		foc = boardform.title;
	} else if (boardform.content.value == "") {
		msg = "내용을 입력해주세요";
		foc = boardform.content;
	}
	
	if (msg != null) {
		alert(msg);
		foc.focus();
		return false;
	}
	
	boardform.id.value = boardform.email1.value + "@" + boardform.email2.value; // 이메일 합치기

	boardform.submit();
} // board_check

function board_list(boardform) {
	alert("리스트로 이동합니다");
	document.location.href = "list.do" ;
} // board_list

function board_update_check(boardform) {
	var msg = null;
	var foc = null;
	
	if (boardform.pwd.value == "") {
		msg = "비밀번호를 입력해주세요";
		foc = boardform.pwd;
	} else if (boardform.title.value == "") {
		msg = "제목을 입력해주세요";
		foc = boardform.title;
	} else if (boardform.content.value == "") {
		msg = "내용을 입력해주세요";
		foc = boardform.content;
	}
	
	if (msg != null) {
		alert(msg);
		foc.focus();
		return false;
	}
	
	boardform.submit();
} // board_update_check

function board_delete_check(boardform) {
	var msg = null;
	var foc = null;
	
	if (boardform.pwd.value == "") {
		msg = "비밀번호를 입력해주세요";
		foc = boardform.pwd;
	}
	
	if (msg != null) {
		alert(msg);
		foc.focus();
		return false;
	}
	
	boardform.submit();
} // board_delete_check

function board_cancle() {
	alert("이전 페이지로 돌아 갑니다.");
	history.back();
} // board_cancle