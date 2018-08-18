package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SurveyApplication.ConnectionDB;
import SurveyApplication.Forms;

public class AddFormDAO {
	public Forms add(Forms form,int adminId,String formName){
		Connection con=null;
		PreparedStatement prepStmt=null;
		String sql="insert into forms(form_title,admin_id) values(?,?);";
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, formName);
			prepStmt.setInt(2, adminId);
			prepStmt.executeUpdate();
			ResultSet rs=prepStmt.getGeneratedKeys();
			if(rs.next()){
				form.setFormId(rs.getInt(1));
				System.out.println("formId: "+form.getFormId());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return form;

	}
}
