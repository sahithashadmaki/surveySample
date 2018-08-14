package SurveyApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AddFormDAO;

/**
 * Servlet implementation class ServletCreateForm
 */
@WebServlet("/ServletCreateForm")
public class ServletCreateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreateForm() {
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
		//	ConnectionDB db=new ConnectionDB();
		Forms form=new Forms();
		HttpSession session =request.getSession();
		String formName=request.getParameter("formName");
		form.setFormTitle(formName);

		AdminInfoClass admin=(AdminInfoClass) session.getAttribute("admin");

		int adminId=admin.getId();
		System.out.println("admin id: "+adminId);
		AddFormDAO addForm=new AddFormDAO();
		form=addForm.add(form,adminId,formName);

		session.setAttribute("form", form);
		request.getRequestDispatcher("/FormOptions.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
