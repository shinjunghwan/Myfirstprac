// ReplyAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class ReplyAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		if (no == null)
			return "null.jsp";
		
		BoardDTO dto = BoardDAO.getInstance().getBoard(no);
		
		request.setAttribute("dto", dto);
		return "reply.jsp";
	} // process()
	
} // ReplyAction
