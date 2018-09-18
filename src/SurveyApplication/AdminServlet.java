package SurveyApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoadFormDAO;
import DAO.UserDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	UserDAO userdao;
	LoadFormDAO loadForm;
	 private static final Logger logr = Logger.getLogger(AdminServlet.class.getName());

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		userdao = UserDAO.getObj();
		loadForm = LoadFormDAO.getObj();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	PropertyConfigurator.configure("log4j.properties");
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*LogManager.getLogManager().reset();
		
		Handler consoleHandler=new ConsoleHandler();
		
		logr.addHandler(consoleHandler);
		consoleHandler.setLevel(Level.ALL);
	
		logr.setLevel(Level.ALL);
		logr.config("configuration done!");*/
		String uName = request.getParameter("uname");
		logr.info("username: "+uName);
		logr.error("username: "+uName);
		logr.debug("username: "+uName);
		logr.warn("username: "+uName);
		
		String uPass = request.getParameter("pass");

		UserInfo userInfo = new UserInfo();
		HttpSession session = request.getSession();

		try {
			userInfo = userdao.login(uName, uPass);
			String role = userInfo.getRole();
			logr.info("Role:  "+role);
					if (userInfo.isValid()) {
				session.setAttribute("isvalid", "isvalid");
				if (role.equals("admin")) {
					AdminInfoClass adminInfo = (AdminInfoClass) userInfo;
					session.setAttribute("admin", adminInfo);
					request.getRequestDispatcher("/AdminHeader.jsp").forward(request, response);
					
				}else if (role.equals("user")) {
					session.setAttribute("user", userInfo);
					request.getRequestDispatcher("/GeneralHeader.jsp").forward(request, response);
					
				}
				
			} else {
			logr.error("invalid username or password");
				request.setAttribute("errorMsg", "invalid username or password");
				request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/**/