<!-- write500.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.com.tistory.gangzzang.*" %>
<%
	for(int i = 1 ; i <= 500; i++) {
		BoardDTO dto = new BoardDTO(0, "gz.kyungho@gmail.com", "1234", "테스트 글 제목"+i, "테스트 글 내용"+i, null, 0, 0, 0, 0);
		BoardDAO.getInstance().insertBoard(dto);
	} // for
	System.out.println("500 글 저장 성공");
%>