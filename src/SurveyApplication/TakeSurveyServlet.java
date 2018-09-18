package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.LoadFormDAO;

/**
 * Servlet implementation class TakeSurveyServlet
 */
@WebServlet("/TakeSurveyServlet")
public class TakeSurveyServlet extends HttpServlet {
	LoadFormDAO loadForm;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(TakeSurveyServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TakeSurveyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		loadForm = LoadFormDAO.getObj();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String sql = "select * from forms;";
		AdminInfoClass adminObj = new AdminInfoClass();
		try {
			adminObj = loadForm.addFormsToList(sql);
			ArrayList<Forms> list = adminObj.getFormList();
			
			request.setAttribute("list", list);
		
			request.getRequestDispatcher("/FormList.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

}
