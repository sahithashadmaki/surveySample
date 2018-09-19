package DAO;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import SurveyApplication.AnswersClass;

public class AddAnswerDAO {
	static AddAnswerDAO addanswer = new AddAnswerDAO();

	public static AddAnswerDAO getObj() {
		return addanswer;

	}

	private AddAnswerDAO() {

	}
//jkh
	public void addAnswerToDB(int formId, int userId, ArrayList<AnswersClass> answersList, boolean value)
			throws SQLException {
		Connection con = null;
		PreparedStatement prepStmt = null;
		String insertQuery = "insert into answers(q_id,user_id,answer,form_id)values(?,?,?,?)";

		try {
			con = ConnectionDB.getConnection();
			con.setAutoCommit(false);
			if (value == true) {
				String sql = "delete from answers where form_id=" + formId + "and user_id=" + userId + ";";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.executeUpdate();
			}
			prepStmt = con.prepareStatement(insertQuery);
			for (AnswersClass answer : answersList) {
				prepStmt.setInt(1, answer.getQuesId());
				prepStmt.setInt(2, answer.getUserId());
				prepStmt.setString(3, answer.getAnswer());
				prepStmt.setInt(4, answer.getFormId());
				prepStmt.addBatch();
			}
			prepStmt.executeBatch();
			con.commit();
		} catch (BatchUpdateException e) {
			con.rollback();
			System.out.println("rollBack");
			System.out.println(e);
		} catch (SQLException e) {
			con.rollback();
			System.out.println("rollBack");
			System.out.println(e);
		} finally {
			con.close();
			System.out.println("connection Closed");
		}
	}
}
