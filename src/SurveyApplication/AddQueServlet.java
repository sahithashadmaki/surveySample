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
	loadQuesDAO loadQues;

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
		addQobj=AddQuesDAO.getObj();
		loadQues=loadQuesDAO.getObj();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Forms form=new Forms();
		
		
		String question=request.getParameter("question");
		System.out.println("question: "+question); 
		String type=request.getParameter("type");
		System.out.println("type: "+type);
		String formId=request.getParameter("id");
		
		System.out.println("formId in addQservlet: "+formId);
		try {
			MultipleChoiceQ obj=new MultipleChoiceQ();
			String str=request.getParameter("str");
			System.out.println("str: "+str);
			if(str!=null){
			String[] options=str.split(",");
			System.out.println("options (AddQueServlet)String: "+options);
			
			obj.setQuestionOptions(options);
			}
			 addQobj.addQ(obj,type,question,Integer.parseInt(formId));
			
			loadQues.addQtoList(form,Integer.parseInt(formId));
			
			ArrayList<MultipleChoiceQ> qlist=form.getList();

			System.out.println(qlist);
			request.setAttribute("list", qlist);
			request.setAttribute("form", form);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
