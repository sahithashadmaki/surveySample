package SurveyApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		
		String uName = request.getParameter("uname");
		String uPass = request.getParameter("pass");

		UserInfo userInfo = new UserInfo();
		HttpSession session = request.getSession();

		try {
			userInfo = userdao.login(uName, uPass);
			String role = userInfo.getRole();
			System.out.println("role: " + role);
			System.out.println("userInfo.isValid(): " + userInfo.isValid());
			if (userInfo.isValid()) {
				session.setAttribute("isvalid", "isvalid");
				System.out.println("userInfo.isValid(): " + userInfo.isValid());
				if (role.equals("admin")) {
					AdminInfoClass adminInfo = (AdminInfoClass) userInfo;
					session.setAttribute("admin", adminInfo);
					request.getRequestDispatcher("/AdminHeader.jsp").forward(request, response);
					
				}else if (role.equals("user")) {
					session.setAttribute("user", userInfo);
					request.getRequestDispatcher("/GeneralHeader.jsp").forward(request, response);
					
				}
				
			} else {
				request.setAttribute("errorMsg", "invalid username or password");
				request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}
}
/*<url-pattern>/AdminServlet</url-pattern>
   <url-pattern>/AddQHelperServlet</url-pattern>
   <url-pattern>/AddQueServlet</url-pattern>
   <url-pattern>/DeleteServlet</url-pattern>
   <url-pattern>/DisplayQuesServlet</url-pattern>
   <url-pattern>/EditFormServlet</url-pattern>
   <url-pattern>/FormChangesServlet</url-pattern>
   <url-pattern>/LogOutServlet</url-pattern>
   <url-pattern>/StoreAnswersServlet</url-pattern>
   <url-pattern>/TakeSurveyServlet</url-pattern>
      <url-pattern>/UserInfoServlet</url-pattern>
         <url-pattern>/AddQuePopper.jsp</url-pattern>
         <url-pattern>/AdminHeader.jsp</url-pattern>
         <url-pattern>/AdminLogin.jsp</url-pattern>
         <url-pattern>/AdminOptions.jsp</url-pattern>
         <url-pattern>/CreateForm.jsp</url-pattern>
         <url-pattern>/DisplayAnswers.jsp</url-pattern>
         <url-pattern>/FormHomePage.jsp</url-pattern>
         <url-pattern>/FormList.jsp</url-pattern>
         <url-pattern>/FormOptions.jsp</url-pattern>
         <url-pattern>/GeneralHeader.jsp</url-pattern>
         
           <url-pattern>/SignUp.jsp</url-pattern>
            <url-pattern>/SurveyForm.jsp</url-pattern>
             <url-pattern>/UserInfoSurvey.jsp</url-pattern>
              <url-pattern>/UserLogin.jsp</url-pattern>*/