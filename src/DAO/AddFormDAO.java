package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ConnectionDB;
import SurveyApplication.Forms;

public class AddFormDAO {
	static AddFormDAO addForm=new AddFormDAO();
	public static AddFormDAO getObj(){
		return addForm;
		
	}
	private AddFormDAO(){
		
	}
	public Forms add(Forms form, int adminId, String formName) throws SQLException {
		Connection con = null;
		PreparedStatement prepStmt = null;
		String sql = "insert into forms(form_title,admin_id) values(?,?);";
		try {
			con = ConnectionDB.getConnection();
			prepStmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, formName);
			prepStmt.setInt(2, adminId);
			int records=prepStmt.executeUpdate();
			if(records>0){
				System.out.println("success");
				form.setValid(true);
			}else{
				System.out.println("stuck somewhere");
				form.setValid(false);
				//throw new SQLException("error inserting");
			}
			ResultSet rs = prepStmt.getGeneratedKeys();
			if (rs.next()) {
				form.setFormId(rs.getInt(1));
				System.out.println("formId: " + form.getFormId());
			}
			form.setFormTitle(formName);
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			con.close();
			System.out.println("connection Closed");
		}
		return form;

	}
}
