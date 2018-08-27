package SurveyApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AddFormDAO;
import DAO.loadQuesDAO;

/**
 * Servlet implementation class ServletCreateForm
 */
@WebServlet("/ServletCreateForm")
public class ServletCreateForm extends HttpServlet {
	AddFormDAO addForm;
	loadQuesDAO loadQues;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreateForm() {
		super();
		// TODO Auto-generated constructor stub
	}
public void init(){
	addForm=AddFormDAO.getObj();
	loadQues=loadQuesDAO.getObj();
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
		
		AdminInfoClass admin=(AdminInfoClass) session.getAttribute("admin");

		int adminId=admin.getId();
		System.out.println("admin id: "+adminId);
		try {
			form=addForm.add(form,adminId,formName);
		int formId=form.getFormId();
		loadQues.addQtoList(form, formId);
		if(form.isValid()==true){
		ArrayList<QuestionClass> list=form.getList();
		//list=form.getList();
		request.setAttribute("list", list);
		//session.setAttribute("form", form);
		request.setAttribute("form", form);
		request.getRequestDispatcher("/FormOptions.jsp").forward(request, response);
		}else if(form.isValid()==false){
			response.sendRedirect("CreateForm.jsp");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
