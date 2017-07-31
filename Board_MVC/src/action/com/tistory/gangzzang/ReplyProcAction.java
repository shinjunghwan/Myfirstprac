// ReplyProcAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;
import model.com.tistory.gangzzang.BoardDTO;

public class ReplyProcAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		int parent = Integer.parseInt(request.getParameter("parent"));
		int sort = Integer.parseInt(request.getParameter("sort")); // parent �뿉�꽌�쓽 �젙�젹
		int tab = Integer.parseInt(request.getParameter("tab")); // �뱾�뿬�벐湲�
		
		BoardDTO dto = new BoardDTO(0, id, pwd, title, content, null, 0, parent, sort, tab, file);
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.updateReplySort(dto);
		
		sort++;
		tab++;
		
		BoardDTO dto2 = new BoardDTO(0, id, pwd, title, content, null, 0, parent, sort, tab, file);
		
		int insertRe = dao.insertReply(dto2);
		
		if (insertRe == 1)
			return "replyok.jsp";
		else
			return "replyerror.jsp";
	} // process()
	
} // ReplyProcAction
