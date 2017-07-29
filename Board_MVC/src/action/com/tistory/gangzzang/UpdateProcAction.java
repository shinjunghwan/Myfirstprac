// UpdateProcAciton.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class UpdateProcAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setPwd(request.getParameter("pwd"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		int re = BoardDAO.getInstance().updateBoard(dto);
		
		if (re == 1)
			return "updateok.jsp";
		else
			return "updateerror.jsp";
	} // process()
	
} // UpdateProcAction
