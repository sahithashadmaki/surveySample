package SurveyApplication;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AddQuesDAO;

/**
 * Servlet implementation class AddQueServlet
 */
@WebServlet("/AddQueServlet")
public class AddQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		AddQuesDAO addQobj=new AddQuesDAO();
		Forms form=new Forms();
	
		String button1 = request.getParameter("add");
		String button2 = request.getParameter("addStop");
		String question=request.getParameter("question");
		MultipleChoiceQ obj=new MultipleChoiceQ();
		obj.question(question);
		System.out.println("que: "+question);
		String type=request.getParameter("questionType");
		obj.setQueType(type);
		System.out.println("type: "+type);
		form=(Forms) session.getAttribute("form");
		int formId=form.getFormId();
		if(type.equals("Multiple Choice")){
			String arr[]=request.getParameterValues("array");
			obj.setQuestionOptions(arr);
			int length=arr.length;
			for(int i=0;i<length;i++){
				System.out.println(arr[i]);
			}
		}
		obj=addQobj.addQ(obj, question, type, formId);
	if(button1!=null){
		request.getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
	}else if(button2!=null){
		request.getRequestDispatcher("/AdminHeader.jsp").forward(request, response);
	}
		List<QuestionsInterface> list=form.getList();
		list.add(obj);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
