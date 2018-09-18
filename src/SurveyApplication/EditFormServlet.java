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

import DAO.AddFormDAO;
import DAO.DeleteDAO;
import DAO.LoadFormDAO;
import DAO.loadQuesDAO;

/**
 * Servlet implementation class EditFormServlet
 */
@WebServlet("/EditFormServlet")
public class EditFormServlet extends HttpServlet {
	LoadFormDAO loadForm;
	loadQuesDAO loadQues;
	DeleteDAO deleteObj;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(EditFormServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		loadForm = LoadFormDAO.getObj();
		loadQues = loadQuesDAO.getObj();
		deleteObj = DeleteDAO.getObj();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = (String) request.getParameter("id");

		logr.info("id:  " + id);

		AdminInfoClass admin = (AdminInfoClass) session.getAttribute("admin");
		int adminId = admin.getId();
		logr.info("admin id: " + adminId);

		Forms form = new Forms();
		form.setFormId(Integer.parseInt(id));
		try {

			loadQues.addQtoList(form, Integer.parseInt(id));

			request.setAttribute("form", form);
			ArrayList<MultipleChoiceQ> list = form.getList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/FormOptions.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
