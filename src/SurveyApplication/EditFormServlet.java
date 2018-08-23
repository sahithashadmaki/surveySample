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

import DAO.AddFormDAO;
import DAO.DeleteDAO;
import DAO.LoadFormDAO;
import DAO.loadQuesDAO;

/**
 * Servlet implementation class EditFormServlet
 */
@WebServlet("/EditFormServlet")
public class EditFormServlet extends HttpServlet {
	LoadFormDAO loadForm;
	loadQuesDAO loadQues; 
	DeleteDAO deleteQ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init(){
	loadForm=new LoadFormDAO();
	loadQues=new loadQuesDAO();
	deleteQ=new DeleteDAO();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		String button=request.getParameter("btn");
		String id=(String) request.getParameter("id");
		String title=request.getParameter("name");
	
		AdminInfoClass admin=(AdminInfoClass) session.getAttribute("admin");
		int adminId=admin.getId();
		System.out.println("admin id: "+adminId);
		
		Forms form=new Forms();
		form.setFormId(Integer.parseInt(id));
		form.setFormTitle(title);
		try {
		if(button.equals("edit")){
			System.out.print("id attri:  "+id);
			
				loadQues.addQtoList(form,Integer.parseInt(id));
			
			request.setAttribute("form", form);
			ArrayList<QuestionClass> list=form.getList();
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/FormOptions.jsp").forward(request, response);
		}else if(button.equals("delete")){
			String sql="delete from forms where form_id="+id+"form_title="+title;
			deleteQ.delete(sql);
		}
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
		doGet(request, response);
	}

}
