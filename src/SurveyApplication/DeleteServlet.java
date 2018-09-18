package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	DeleteDAO deleteObj;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(DeleteServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		deleteObj = DeleteDAO.getObj();
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
		String sql = null;
		String id = (String) request.getParameter("id");
		logr.info("id: "+id);
		String value = request.getParameter("value");
		if (value.equals("que")) {
			sql = "delete from questions where q_id=" + id + ";";

			/*
			 * sql="alter table forms nocheck constraint FK__user_id__form_id;"+
			 * "alter table questions nocheck constraint FK__form_questions;"+
			 * "alter table answers no check constraint FK_answers_questions_qId;"
			 * + "delete from forms where form_id="+id+";"+
			 * "alter table answers check constraint FK_answers_questions_qId;"+
			 * "alter table questions check constraint FK__form_questions;"+
			 * "alter table forms check constraint FK__user_id__form_id;";
			 */
			
		} else if (value.equals("form")) {
			sql = "alter table forms nocheck constraint FK__user_id__form_id;"
					+ "alter table questions nocheck constraint FK__form_questions;"
					+ "delete from forms where form_id=" + id + ";"
					+ "alter table questions check constraint FK__form_questions;"
					+ "alter table forms check constraint FK__user_id__form_id;";
		
		}

		try {
			deleteObj.delete(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
