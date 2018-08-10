package SurveyApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=null;
		//response.setContentType("text/html");
		String adminName=request.getParameter("uname");
		String adminPass=request.getParameter("pass");
		UserInfo adminInfo=new AdminInfoClass();
		adminInfo.setName(adminName);
		adminInfo.setPassword(adminPass);
		HttpSession session=request.getSession();
		//	PrintWriter out=response.getWriter();
		String sql="select role from users where user_name=? and user_pass=?;";
	
		try{
		con=ConnectionDB.getconnection();
			//String role=(ValidateUser.check(con, sql, adminName, adminPass));
		adminInfo=UserDAO.login(adminInfo, con,sql, adminName, adminPass);
			String role=adminInfo.getRole();
			System.out.println(role);
			System.out.println(adminInfo.isValid());
			if(adminInfo.isValid()){
				System.out.println(adminInfo.isValid());
				if(role.equals("admin")){
					session.setAttribute("adminName", adminInfo);
					System.out.println("aaaaaaaaaaa");
					request.getRequestDispatcher("/AdminOptions.jsp").forward(request, response);
				}else if(role.equals("user")){

				}
			}
			else{

			}
		} catch (Exception e) {

			e.printStackTrace();
		}


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


	}
}
