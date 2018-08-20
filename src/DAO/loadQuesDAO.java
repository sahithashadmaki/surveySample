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
	public QuestionClass addQtoList(Forms form,QuestionClass qObj,int formId){
		Connection con=null;
		PreparedStatement prepStmt=null;
		//ResultSet rs=null;
		//QuestionClass queObj=new QuestionClass();
		ArrayList<QuestionClass> list=new ArrayList<>();
		String sql="select * from questions where form_id=?;";
		//Forms form=new Forms();
		//where form_id=?;
		//list=form.getList();
		
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql);
			System.out.println("formid before setting: "+formId);
			prepStmt.setInt(1, formId);
			ResultSet rs=prepStmt.executeQuery();
			
				if(qObj instanceof MultipleChoiceQ){
					System.out.println("instance of mul class");
					MultipleChoiceQ mulObj=(MultipleChoiceQ)qObj;
					while(rs.next()){
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
					
					return mulObj;
				}else{
					System.out.println("else instance of");
					while(rs.next()){
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
		return qObj;
	}
}
