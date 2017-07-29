// ReadAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class ReadAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		
		String no = request.getParameter("no");

		if (no == null)
			return "null.jsp";
		
		dao.updateHit(no);
		BoardDTO dto = dao.getBoard(no);
		
		String pg = request.getParameter("pg");
		
		request.setAttribute("dto", dto);
		request.setAttribute("pg", pg);
		
		return "read.jsp";
	} // process()
	
} // ReadAction
