package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loadQuesDAO;

/**
 * Servlet implementation class StoreAnswersServlet
 */
@WebServlet("/StoreAnswersServlet")
public class StoreAnswersServlet extends HttpServlet {
	loadQuesDAO loadQues;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreAnswersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
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
		//doGet(request, response);
		HttpSession session=request.getSession();
		Forms form=new Forms();
		String formId= (String) request.getParameter("id");
		try {
			loadQues.addQtoList(form, Integer.parseInt(formId));
			ArrayList<MultipleChoiceQ> list = form.getList();
			System.out.println(list);
			int listLength=list.size();
			for(int value=0;value<=listLength;value++){
				
			}
			//request.setAttribute("list", list);
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
