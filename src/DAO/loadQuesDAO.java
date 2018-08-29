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
	static loadQuesDAO loadQues = new loadQuesDAO();

	private loadQuesDAO() {

	}

	public static loadQuesDAO getObj() {
		return loadQues;

	}

	public void addQtoList(Forms form, int formId) throws SQLException {
		Connection con = null;
		PreparedStatement prepStmt = null;
		String sql = "select * from questions where form_id=?;";
		ArrayList<MultipleChoiceQ> list = new ArrayList<>();
		//MultipleChoiceQ qObj = new MultipleChoiceQ();
		try {
			con = ConnectionDB.getConnection();
			prepStmt = con.prepareStatement(sql);
			System.out.println("formid before setting: " + formId);
			prepStmt.setInt(1, formId);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
					MultipleChoiceQ mulObj = new MultipleChoiceQ();
					mulObj.setQuestionId(rs.getInt(1));
					mulObj.setQuestion(rs.getString(2));
					mulObj.setQueType(rs.getString(4));
					String optn=rs.getString(5);
					System.out.println("optn: "+optn);
					String[] optnArray=optn.split(",");
					mulObj.setQuestionOptions(optnArray);
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(4) + " " + rs.getString(5));
					System.out.println(mulObj.getQuestionId() + " " + mulObj.getquestion() + " " + mulObj.getQueType()
							+ " " + mulObj.getQuestionOptions());
					list.add(mulObj);
				}
			
			form.setList(list);
			System.out.println("list in DAO:----" + list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			System.out.println("connection Closed");
		}

	}
}
