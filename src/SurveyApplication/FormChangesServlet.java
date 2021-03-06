package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import DAO.LoadFormDAO;

/**
 * Servlet implementation class EditFormServlet
 */
@WebServlet("/FormChangesServlet")
public class FormChangesServlet extends HttpServlet {
	LoadFormDAO loadForm;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(FormChangesServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormChangesServlet() {
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
		

		HttpSession session = request.getSession();
		AdminInfoClass admin = (AdminInfoClass) session.getAttribute("admin");
		int adminId = admin.getId();
		logr.info("admin id: " + adminId);
		String sql = "select * from forms where admin_id=" + adminId + ";";
		AdminInfoClass adminObj = new AdminInfoClass();
		try {
			adminObj = loadForm.addFormsToList(sql);

			ArrayList<Forms> mylist = adminObj.getFormList();
		
			request.setAttribute("list", mylist);
			String type = request.getParameter("type");
			if (type.equals("forms")) {
				request.getRequestDispatcher("/FormHomePage.jsp").forward(request, response);
			} else if (type.equals("userinfo")) {
				request.setAttribute("userinfo", "userinfo");
				request.getRequestDispatcher("/FormList.jsp").forward(request, response);
			}
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
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

}
