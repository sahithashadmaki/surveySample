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

import DAO.loadQuesDAO;

/**
 * Servlet implementation class AddQHelperServlet
 */
@WebServlet("/AddQHelperServlet")
public class AddQHelperServlet extends HttpServlet {
	loadQuesDAO loadQ;
	private static final long serialVersionUID = 1L;
	private static final Logger logr = Logger.getLogger(AddQHelperServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQHelperServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		loadQ = loadQuesDAO.getObj();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Forms form = new Forms();
		String formId = request.getParameter("fid");
		logr.info("formId: " + formId);
		form.setFormId(Integer.parseInt(formId));
		try {
			loadQ.addQtoList(form, Integer.parseInt(formId));
			ArrayList<MultipleChoiceQ> list = form.getList();

			request.setAttribute("list", list);
			request.setAttribute("form", form);
			request.getRequestDispatcher("/AddQuePopper.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
