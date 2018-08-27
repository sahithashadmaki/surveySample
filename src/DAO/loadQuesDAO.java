package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.ConnectionDB;
import SurveyApplication.Forms;
import SurveyApplication.MultipleChoiceQ;
import SurveyApplication.QuestionClass;
import SurveyApplication.QuestionsInterface;

public class loadQuesDAO {
static loadQuesDAO loadQues=new loadQuesDAO();
private loadQuesDAO(){
	
}
public static loadQuesDAO getObj(){
	return loadQues;
	
}
	public void addQtoList(Forms form,int formId) throws SQLException{
		Connection con=null;
		PreparedStatement prepStmt=null;
		String sql="select * from questions where form_id=?;";
		ArrayList<QuestionClass> list=new ArrayList<>();
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql);
			System.out.println("formid before setting: "+formId);
			prepStmt.setInt(1, formId);
			ResultSet rs=prepStmt.executeQuery();
			while(rs.next()){
				QuestionClass qObj=new QuestionClass();
				qObj.setQuestionId(rs.getInt(1));
				qObj.setQuestion(rs.getString(2));
				qObj.setQueType(rs.getString(4));
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(4));
				System.out.println(qObj.getQuestionId()+" "+qObj.getquestion()+" "+qObj.getQueType());
				list.add(qObj);
			}
			form.setList(list);
			System.out.println("list in DAO:----"+list);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			con.close();
			System.out.println("connection Closed");
		}
		
	}
}
