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

	public static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	 public static  ObjectMapper mapper = new ObjectMapper();
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

		loadQuesDAO loadDb=new loadQuesDAO();
		Forms form=new Forms();

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
			JsonConvert json=new JsonConvert();
			String JSONstring=json.getOptionsAsJSONString(ow,arr);
			
			MultipleChoiceQ obj=new MultipleChoiceQ();
			//obj=(MultipleChoiceQ) loadDb.addQtoList(formId);
			
			obj=(MultipleChoiceQ) addQobj.addQ(obj, question, type, formId);
			obj=(MultipleChoiceQ) loadDb.addQtoList(form, obj, formId);
			obj.setQuestionOptions(arr);
			session.setAttribute("questionsObj",obj );
			int length=arr.length;
			for(int i=0;i<length;i++){
				System.out.println(arr[i]);
			}
			if(obj.isValid()==false){
				ArrayList<QuestionsInterface> list=new ArrayList<>();
				list.add(obj);
				for(QuestionsInterface q:list){
					System.out.println("qlist Id: "+q.getQuestionId());
					System.out.println("qlist Question: "+q.getquestion());
					System.out.println("qlist questn type: "+q.getQueType());
				}
				form.setList(list);
				session.setAttribute("form", form);
			}else{
			ArrayList<QuestionsInterface> qlist=form.getList();
			qlist.add(obj);
			for(QuestionsInterface q:qlist){
				System.out.println("qlist Id: "+q.getQuestionId());
				System.out.println("qlist Question: "+q.getquestion());
				System.out.println("qlist questn type: "+q.getQueType());
			}
			form.setList(qlist);
			session.setAttribute("form", form);
			}
		}else if(type.equals("Text Type")){
			QuestionClass qObj=new QuestionClass();
			qObj=loadDb.addQtoList(form, qObj, formId);
			
			qObj=addQobj.addQ(qObj, question, type, formId);
			if(qObj.isValid()==false){
				ArrayList<QuestionsInterface> qlist=new ArrayList<>();
				qlist.add(qObj);
				form.setList(qlist);
				session.setAttribute("form", form);
			}else{
			ArrayList<QuestionsInterface> list=form.getList();
			list.add(qObj);
			form.setList(list);
			session.setAttribute("form", form);
			}
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
