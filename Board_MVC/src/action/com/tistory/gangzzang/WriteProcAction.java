// WriteProcAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class WriteProcAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO(0, id, pwd, title, content, null, 0, 0, 0, 0);
		int re = BoardDAO.getInstance().insertBoard(dto);
		
		if (re == 1)
			return "writeok.jsp";
		
		return "writeerror.jsp";
	} // process()
	
} // InsertHandler
