package DAO;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import SurveyApplication.AnswersClass;

public class AddAnswerDAO {
	static AddAnswerDAO addanswer=new AddAnswerDAO();
	public static AddAnswerDAO getObj(){
		return addanswer;
		
	}
	private AddAnswerDAO(){
		
	}
	public void addAnswerToDB(ArrayList<AnswersClass> answersList,String sql) throws SQLException{
		Connection con = null;
		PreparedStatement prepStmt = null;
		
		
		try {
			con=ConnectionDB.getConnection();
			con.setAutoCommit(false);
			prepStmt=con.prepareStatement(sql);
			for(AnswersClass answer:answersList){
				prepStmt.setInt(1, answer.getQuesId());
				prepStmt.setInt(2, answer.getUserId());
				prepStmt.setString(3, answer.getAnswer());
				prepStmt.setInt(4, answer.getFormId());
				prepStmt.addBatch();
			}
			prepStmt.executeBatch();
			con.commit();
		}catch(BatchUpdateException e){
			con.rollback();
			System.out.println("rollBack");
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
			System.out.println("connection Closed");
		}
	}
}
