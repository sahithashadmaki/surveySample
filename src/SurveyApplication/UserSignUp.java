package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.StoreUserInfoDAO;

/**
 * Servlet implementation class UserSignUp
 */
@WebServlet("/UserSignUp")
public class UserSignUp extends HttpServlet {
	StoreUserInfoDAO user;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(UserSignUp.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init(){
	user=StoreUserInfoDAO.getObj();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pwd");
		String emailCheckQuery="select * from users where email='"+email+"';";
	
		String sql="insert into users(user_name,user_pass,role,email) values('"+uname+"','"+pass+"','user','"+email+"');";
		
		try {
			boolean emailExist=user.insertToDB(emailCheckQuery,sql);
			if(emailExist){
				String errorMsg="Record with this Email Id Exists";
				logr.info("Record with this Email Id Exists");
				request.setAttribute("emailError", errorMsg);
				request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
			}else{
			request.getRequestDispatcher("/UserLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
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
