package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDAO {
	static UserInfoDAO userInfo = new UserInfoDAO();

	public static UserInfoDAO getObj() {
		return userInfo;

	}

	private UserInfoDAO() {

	}
	public int userMethod(int formId){
		int count = 0;
		Connection con = null;
		PreparedStatement prepStmt = null;
		String sql="SELECT COUNT (DISTINCT user_id)AS total FROM answers where form_id="+formId+";";
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql);
			ResultSet rs=prepStmt.executeQuery();
			if(rs.next()){
			count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
