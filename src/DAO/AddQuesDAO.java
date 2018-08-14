package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SurveyApplication.ConnectionDB;
import SurveyApplication.MultipleChoiceQ;


public class AddQuesDAO {
public MultipleChoiceQ addQ(MultipleChoiceQ qObj,String question,String type,int formId){
	 PreparedStatement prepStmt=null;
	  Connection con=null;
	  String sql="insert into questions(q_text,form_id,type) values(?,?,?))";
	  try {
		con=ConnectionDB.getConnection();
		prepStmt =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		prepStmt.setString(1, question);
		prepStmt.setInt(2, formId);
		prepStmt.setString(3, type);
		prepStmt.executeUpdate();
		ResultSet rs=prepStmt.getGeneratedKeys();
		if(rs.next()){
			qObj.setQuestionId(rs.getInt(1));
			System.out.println("question Id: "+rs.getInt(1));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	  
	return qObj;
	
}
}
