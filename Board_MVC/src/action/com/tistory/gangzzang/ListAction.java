// ListAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class ListAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();

		int pg = 1; // 페이지 번호
		int pgSize = 15; // 한 페이지에 보여줄 글의 개수
		int total = dao.getTotal(); // 총 게시글 개수

		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		int begin = (pg * pgSize) - (pgSize - 1); // (2 * 15) - (15 - 1) = 30 -
													// 14 = 16
		int end = (pg * pgSize); // (2 * 15) = 30

		ArrayList<BoardDTO> list = dao.listBoard(begin, end);

		int allPage = (int) Math.ceil(total / (double) pgSize); // 페이지 개수
		int block = 10; // 한 페이지에 보여줄 페이지 번호 범위

		int beginPage = ((pg - 1) / block * block) + 1; // 보여줄 페이지의 시작
		int endPage = ((pg - 1) / block * block) + block; // 보여줄 페이지의 끝

		if (endPage > allPage)
			endPage = allPage;

		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("block", block);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("allPage", allPage);

		return "list.jsp";
	} // process()
	
} // ListAction
