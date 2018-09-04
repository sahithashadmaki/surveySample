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
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

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
			System.out.println("admin id: " + userId);
		}
		Forms form = new Forms();
		String formId = (String) request.getParameter("id");

		ArrayList<AnswersClass> answerList = new ArrayList<>();
		Map<Integer, AnswersClass> map = new HashMap<>();
		try {
			loadQues.addQtoList(form, Integer.parseInt(formId));
			ArrayList<MultipleChoiceQ> list = form.getList();
			System.out.println(list);
			int listSize = list.size();
			System.out.println(listSize);
			String sql = "select * from answers where form_id=" + formId + "and user_id=" + userId + ";";
			if (checkAns.check(sql)) {
				sqlQuery = "delete from answers where form_id=" + formId + "and user_id=" + userId + ";"
						+ "insert into answers(q_id,user_id,answer,form_id)values(?,?,?,?)";
				System.out.println("survey already taken");
			} else {
				sqlQuery = "insert into answers(q_id,user_id,answer,form_id)values(?,?,?,?)";
			}
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
			System.out.println(answerList);
			addanswer.addAnswerToDB(answerList, sqlQuery);
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
		System.out.println(formId);
	}

}
