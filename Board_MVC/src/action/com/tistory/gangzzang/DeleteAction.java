// DeleteAction.java

package action.com.tistory.gangzzang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		if (no == null)
			return "null.jsp";
		
		request.setAttribute("no", no);
		
		return "delete.jsp";
	} // process()
	
} // DeleteAction
