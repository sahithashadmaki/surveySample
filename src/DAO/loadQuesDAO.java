package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SurveyApplication.ConnectionDB;
import SurveyApplication.Forms;
import SurveyApplication.MultipleChoiceQ;
import SurveyApplication.QuestionClass;
import SurveyApplication.QuestionsInterface;

public class loadQuesDAO {

	public void addQtoList(Forms form,String type,int formId){
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
			
				if(type.equals("Multiple Choice")){
					System.out.println("instance of mul class");
					
					while(rs.next()){
						MultipleChoiceQ mulObj=new MultipleChoiceQ();
						System.out.println("while loop in loadQuesDAO");
						mulObj.setQuestionId(rs.getInt(1));
						mulObj.setQuestion(rs.getString(2));
						mulObj.setQueType(rs.getString(4));
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(4));
						System.out.println(mulObj.getQuestionId()+" "+mulObj.getquestion()+" "+mulObj.getQueType());
						list.add(mulObj);
					}
					form.setList(list);
					System.out.println(list);
					
				}else if(type.equals("Text Type")){
					System.out.println("else instance of");
					while(rs.next()){
						QuestionClass qObj=new QuestionClass();
						qObj.setQuestionId(rs.getInt(1));
						qObj.setQuestion(rs.getString(2));
						qObj.setQueType(rs.getString(4));
						list.add(qObj);
					}
					form.setList(list);
				}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
