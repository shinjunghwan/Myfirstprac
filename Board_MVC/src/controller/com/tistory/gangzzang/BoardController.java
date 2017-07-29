// BoardController.java

package controller.com.tistory.gangzzang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.com.tistory.gangzzang.Action;
import action.com.tistory.gangzzang.NullAction;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> commandHandlerMap = new HashMap<String, Action>();
      
    @Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			String configFilePath = getServletContext().getRealPath(configFile);
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {try { fis.close(); } catch (IOException ex) { } }
		} // try - catch - finally
		
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String actionClassName = prop.getProperty(command);
			try {
				Class<?> actionClass = Class.forName(actionClassName);
				Action actionInstance = (Action) actionClass.newInstance();
				commandHandlerMap.put(command, actionInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} // try - catch
		} // while
	} // init()

	public BoardController() {
        super();
    } // BoardConroller 생성자
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	} // doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	} // doPost()

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getRequestURI();
		
		if (command.indexOf(request.getContextPath()) == 0)
			command = command.substring(request.getContextPath().length());
		
		Action action = commandHandlerMap.get(command);
		
		if (action == null)
			action = new NullAction();
		
		String viewPage = null;
		viewPage = action.process(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	} // processRequest()
	
} // BoardConroller
