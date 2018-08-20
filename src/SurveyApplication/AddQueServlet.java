package SurveyApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import DAO.AddQuesDAO;

import DAO.loadQuesDAO;

/**
 * Servlet implementation class AddQueServlet
 */
@WebServlet("/AddQueServlet")
public class AddQueServlet extends HttpServlet {
	AddQuesDAO addQobj;
	loadQuesDAO loadDb;

	//public static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	//public static  ObjectMapper mapper = new ObjectMapper();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init(){
		addQobj=new AddQuesDAO();
		loadDb=new loadQuesDAO();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		Forms form=new Forms();
		//ArrayList<QuestionClass> qlist = null;
		String button1 = request.getParameter("add");
		String button2 = request.getParameter("addStop");
		String question=request.getParameter("question");
		String type=request.getParameter("questionType");
		//List<QuestionsInterface> list=form.getList();

		form=(Forms) session.getAttribute("form");
		int formId=form.getFormId();
		System.out.println("formId in addQservlet"+formId);
		if(type.equals("Multiple Choice")){
			String arr[]=request.getParameterValues("array");
			//	JsonConvert json=new JsonConvert();
			//	String JSONstring=json.getOptionsAsJSONString(ow,arr);

			MultipleChoiceQ obj=new MultipleChoiceQ();
			//obj=(MultipleChoiceQ) loadDb.addQtoList(formId);

			obj=(MultipleChoiceQ) addQobj.addQ(obj, question, type, formId);
			 loadDb.addQtoList(form,type, formId);
			obj.setQuestionOptions(arr);
			session.setAttribute("questionsObj",obj );
			int length=arr.length;
			for(int i=0;i<length;i++){
				System.out.println(arr[i]);
			}

			ArrayList<QuestionClass> qlist=form.getList();

			System.out.println(qlist);
			request.setAttribute("list", qlist);
			session.setAttribute("form", form);

		}else if(type.equals("Text Type")){
			QuestionClass qObj=new QuestionClass();
			qObj=addQobj.addQ(qObj, question, type, formId);
			loadDb.addQtoList(form,type, formId);
			
			ArrayList<QuestionClass> list=form.getList();
			System.out.println(list);
			request.setAttribute("list", list);
			session.setAttribute("form", form);
		}


		if(button1!=null){
			request.getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
		}else if(button2!=null){
			request.getRequestDispatcher("/AdminHeader.jsp").forward(request, response);
		}

		//list.add(obj);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
