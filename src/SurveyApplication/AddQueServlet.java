package SurveyApplication;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import DAO.AddQuesDAO;

import DAO.loadQuesDAO;

/**
 * Servlet implementation class AddQueServlet
 */
@WebServlet("/AddQueServlet")
public class AddQueServlet extends HttpServlet {
	AddQuesDAO addQobj;
	loadQuesDAO loadQues;
	 private static final Logger logr = Logger.getLogger(AddQueServlet.class.getName());
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		addQobj = AddQuesDAO.getObj();
		loadQues = loadQuesDAO.getObj();
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Forms form = new Forms();

		String question = request.getParameter("question");
		logr.info("question: " + question);
		String type = request.getParameter("type");
		logr.info("type: " + type);
		String formId = request.getParameter("id");

		logr.info("formId in addQservlet: " + formId);
		try {
			MultipleChoiceQ obj = new MultipleChoiceQ();
			String optnStr = request.getParameter("optnStr");
			logr.info("optnStr: " + optnStr);
			if (optnStr != null) {
				String[] options = optnStr.split(",");
				logr.info("options (AddQueServlet)String: " + options);

				obj.setQuestionOptions(options);
			}
			addQobj.addQ(obj, type, question, Integer.parseInt(formId));

			loadQues.addQtoList(form, Integer.parseInt(formId));

			ArrayList<MultipleChoiceQ> qlist = form.getList();

			request.setAttribute("list", qlist);
			request.setAttribute("form", form);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
