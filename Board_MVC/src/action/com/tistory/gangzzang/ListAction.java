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

		int pg = 1; // �럹�씠吏� 踰덊샇
		int pgSize = 12; // �븳 �럹�씠吏��뿉 蹂댁뿬以� 湲��쓽 媛쒖닔
		int total = dao.getTotal(); // 珥� 寃뚯떆湲� 媛쒖닔

		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		int begin = (pg * pgSize) - (pgSize - 1); //
		int end = (pg * pgSize); // 

		ArrayList<BoardDTO> list = dao.listBoard(begin, end);

		int allPage = (int) Math.ceil(total / (double) pgSize); // �럹�씠吏� 媛쒖닔
		int block = 10; // �븳 �럹�씠吏��뿉 蹂댁뿬以� �럹�씠吏� 踰덊샇 踰붿쐞

		int beginPage = ((pg - 1) / block * block) + 1; // 蹂댁뿬以� �럹�씠吏��쓽 �떆�옉
		int endPage = ((pg - 1) / block * block) + block; // 蹂댁뿬以� �럹�씠吏��쓽 �걹

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
