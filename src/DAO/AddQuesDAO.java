package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SurveyApplication.ConnectionDB;
import SurveyApplication.MultipleChoiceQ;
import SurveyApplication.QuestionClass;


public class AddQuesDAO {
public QuestionClass addQ(QuestionClass qObj,String type,String question,int formId) throws SQLException{
	 PreparedStatement prepStmt=null;
	  Connection con=null;
	  String sql="insert into questions(q_text,form_id,q_type) values(?,?,?);";
	 // String type=qObj.getQueType();
	 // String question=qObj.getquestion();
	
	  try {
		con=ConnectionDB.getConnection();
		prepStmt =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		prepStmt.setString(1, question);
		prepStmt.setInt(2, formId);
		prepStmt.setString(3, type);
		prepStmt.executeUpdate();
		ResultSet rs=prepStmt.getGeneratedKeys();
		if(qObj instanceof MultipleChoiceQ){
			MultipleChoiceQ mulObj=(MultipleChoiceQ)qObj;
			if(rs.next()){
				
				mulObj.setQuestionId(rs.getInt(1));
				System.out.println("question Id: "+rs.getInt(1));
			}
		
			System.out.println("In if() in AddQuesDAO");
			mulObj.setQuestion(question);
			mulObj.setQueType(type);
			return mulObj;
			
		}else{
			if(rs.next()){
				qObj.setQuestionId(rs.getInt(1));
				System.out.println("question Id: "+rs.getInt(1));
			}
			System.out.println("In else in AddQuesDAO");
			qObj.setQuestion(question);
			qObj.setQueType(type);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		con.close();
		System.out.println("connection Closed");
	}
	return qObj;

	  
	
	
}
}
