package SurveyApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.loadQuesDAO;

/**
 * Servlet implementation class DisplayQuesServlet
 */
@WebServlet("/DisplayQuesServlet")
public class DisplayQuesServlet extends HttpServlet {
	loadQuesDAO loadQues;
	private static final long serialVersionUID = 1L;
	 private static final Logger logr = Logger.getLogger(DisplayQuesServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayQuesServlet() {
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
		String formId=request.getParameter("id");
		String formTitle=request.getParameter("name");
		Forms form=new Forms();
		form.setFormId(Integer.parseInt(formId));
		form.setFormTitle(formTitle);
		try {
			loadQues.addQtoList(form, Integer.parseInt(formId));
			ArrayList<MultipleChoiceQ> qlist=form.getList();
		
			request.setAttribute("list", qlist);
			request.setAttribute("form", form);
			request.getRequestDispatcher("SurveyForm.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		//doGet(request, response);
	}

}
