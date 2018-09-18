package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import DAO.AddAnswerDAO;
import DAO.CheckAnswersDAO;
import DAO.loadQuesDAO;

/**
 * Servlet implementation class StoreAnswersServlet
 */
@WebServlet("/StoreAnswersServlet")
public class StoreAnswersServlet extends HttpServlet {
	loadQuesDAO loadQues;
	AddAnswerDAO addanswer;
	CheckAnswersDAO checkAns;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(StoreAnswersServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreAnswersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		loadQues = loadQuesDAO.getObj();
		addanswer = AddAnswerDAO.getObj();
		checkAns = CheckAnswersDAO.getObj();
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
		// doGet(request, response);
		int userId;
		String sqlQuery;
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("user");
		
		if (user != null) {
			userId = user.getId();
			
		} else {
			AdminInfoClass admin = (AdminInfoClass) session.getAttribute("admin");
			userId = admin.getId();
			logr.info("admin id: " + userId);
		}
		Forms form = new Forms();
		String formId = (String) request.getParameter("id");
		logr.info("formid: "+formId);
		ArrayList<AnswersClass> answerList = new ArrayList<>();
		Map<Integer, AnswersClass> map = new HashMap<>();
		try {
			loadQues.addQtoList(form, Integer.parseInt(formId));
			ArrayList<MultipleChoiceQ> list = form.getList();
	
			String sql = "select * from answers where form_id=" + formId + "and user_id=" + userId + ";";
			
			for (MultipleChoiceQ qlist : list) {

				int id = qlist.getQuestionId();
				String qId = Integer.toString(id);
				String answer = request.getParameter(qId);
				AnswersClass answerObj = new AnswersClass();
				answerObj.setUserId(userId);
				answerObj.setQuesId(id);
				answerObj.setAnswer(answer);
				answerObj.setFormId(Integer.parseInt(formId));
				answerList.add(answerObj);
				map.put(id, answerObj);
				// System.out.println("answer: "+answer);
			}
			
			boolean value=checkAns.check(sql);
			addanswer.addAnswerToDB(Integer.parseInt(formId),userId,answerList,value);
	
			request.setAttribute("list", list);

			request.setAttribute("map", map);
			request.getRequestDispatcher("/DisplayAnswers.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
