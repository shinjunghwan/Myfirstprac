// DeleteProcAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.com.tistory.gangzzang.BoardDAO;

public class DeleteProcAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		if (no == null)
			return "null.jsp";
		
		String pwd = request.getParameter("pwd");
		int re = BoardDAO.getInstance().deleteBoard(no, pwd);
		
		if (re == 1)
			return "deleteok.jsp";
		else
			return "deleteerror.jsp";
	} // process()
	
} // DeleteProcAction
