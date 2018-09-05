package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckFormsDAO {
	static CheckFormsDAO chkForm = new CheckFormsDAO();

	public static CheckFormsDAO getObj() {
		return chkForm;

	}

	private CheckFormsDAO() {

	}
	
	public boolean formCheck(int formId,int adminId){
		Connection con=null;
		PreparedStatement prepStmt=null;
		String sql="select admin_id from forms where form_id="+formId;
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql);
			ResultSet rs=prepStmt.executeQuery();
			if(rs.next()){
			if(rs.getInt(1)==adminId){
				return true;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
