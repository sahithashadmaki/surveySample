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
		String adminName=request.getParameter("aname");
		String adminPass=request.getParameter("apass");
		AdminInfoClass adminInfo=new AdminInfoClass();
		adminInfo.setAdminName(adminName);
		adminInfo.setAdminPassword(adminPass);
		HttpSession session=request.getSession();
	//	PrintWriter out=response.getWriter();
		String sql="select * from admin;";
		
		PreparedStatement prepStmt=null;
		try {
		con=ConnectionDB.getconnection();
		prepStmt=con.prepareStatement(sql);
			ResultSet rs=prepStmt.executeQuery();
		while(rs.next()){
			String adminNameDB=rs.getString(2);
			System.out.println("admin name from DB: "+adminNameDB);
			System.out.println("adminName: "+adminInfo.getAdminName());
			String adminPassDB=rs.getString(3);
			System.out.println("admin password: from DB"+adminPassDB);
			System.out.println("admin password: "+adminInfo.getAdminPassword());
			if(adminName.equals(adminInfo.getAdminName()) && adminPass.equals(adminInfo.getAdminPassword())){
				session.setAttribute("adminName", adminInfo);
				
				request.getRequestDispatcher("/AdminOptions.jsp").forward(request, response);
				//response.sendRedirect("/AdminOptions.jsp");
			}
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
