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

import DAO.DeleteDAO;
import DAO.loadQuesDAO;

/**
 * Servlet implementation class EditQueServlet
 */
@WebServlet("/EditQueServlet")
public class EditQueServlet extends HttpServlet {
	loadQuesDAO loadQues;
	DeleteDAO deleteQ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init(){
	loadQues=new loadQuesDAO();
	deleteQ=new DeleteDAO();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session =request.getSession();
		String id=(String) request.getParameter("id");
		String question=request.getParameter("que");
		System.out.println(id);
		System.out.println(question);
	String sql="delete from questions where q_id="+id+"and q_text="+"'"+question+"'"+";";
	System.out.println(sql);
	try {
		deleteQ.delete(sql);
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
