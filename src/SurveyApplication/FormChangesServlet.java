package SurveyApplication;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoadFormDAO;

/**
 * Servlet implementation class EditFormServlet
 */
@WebServlet("/FormChangesServlet")
public class FormChangesServlet extends HttpServlet {
	LoadFormDAO loadForm;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormChangesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init(){
	loadForm=new LoadFormDAO();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession();
		AdminInfoClass admin=(AdminInfoClass) session.getAttribute("admin");
		int adminId=admin.getId();
		System.out.println("admin id: "+adminId);
		
		loadForm.addFormsToList(adminId, admin);
		ArrayList<Forms> mylist=admin.getFormList();
		System.out.println(mylist);
		request.setAttribute("mylist", mylist);
		request.getRequestDispatcher("/FormHomePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
