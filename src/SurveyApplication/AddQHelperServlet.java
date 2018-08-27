package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.loadQuesDAO;

/**
 * Servlet implementation class AddQHelperServlet
 */
@WebServlet("/AddQHelperServlet")
public class AddQHelperServlet extends HttpServlet {
	loadQuesDAO loadQ;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQHelperServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init(){
		loadQ=loadQuesDAO.getObj();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Forms form =new Forms();
		String formId=request.getParameter("fid");
		System.out.println("formId: "+formId);
		//String formTitle=request.getParameter("fname");
		form.setFormId(Integer.parseInt(formId));
		//form.setFormTitle(formTitle);
		try {
			loadQ.addQtoList(form, Integer.parseInt(formId));
			ArrayList<QuestionClass> list=form.getList();
			System.out.println("list:------"+list);
			request.setAttribute("list", list);
			request.setAttribute("form", form);
			request.getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
