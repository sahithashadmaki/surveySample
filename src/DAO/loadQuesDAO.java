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
		ArrayList<QuestionsInterface> list=form.getList();
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
			boolean value =rs.next();
			if(value){
				if(qObj instanceof MultipleChoiceQ){
					System.out.println("instance of mul class");
					MultipleChoiceQ mulObj=(MultipleChoiceQ)qObj;
					do{
						System.out.println("while loop in loadQuesDAO");
						mulObj.setQuestionId(rs.getInt(1));
						mulObj.setQuestion(rs.getString(2));
						mulObj.setQueType(rs.getString(4));

						list.add(mulObj);
					}while(rs.next());
					mulObj.setValid(true);
					for(QuestionsInterface q:list){
						System.out.println("Id: "+q.getQuestionId());
						System.out.println("Question: "+q.getquestion());
						System.out.println("questn type: "+q.getQueType());
					}
					form.setList(list);
					return mulObj;
				}else{
					System.out.println("else instance of");
					do{
						qObj.setQuestionId(rs.getInt(1));
						qObj.setQuestion(rs.getString(2));
						qObj.setQueType(rs.getString(4));
						list.add(qObj);
					}while(rs.next());
					qObj.setValid(true);
					form.setList(list);
				}
				
			}else{
				qObj.setValid(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qObj;
	}
}
