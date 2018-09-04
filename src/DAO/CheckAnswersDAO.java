package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAnswersDAO {
	static CheckAnswersDAO checkAns=new CheckAnswersDAO();
	public static CheckAnswersDAO getObj(){
		return checkAns;
		
	}
	private CheckAnswersDAO(){
		
	}
	public boolean check(String sql){
		Connection con = null;
		PreparedStatement prepStmt = null;
		
		try {
			con=ConnectionDB.getConnection();
			prepStmt=con.prepareStatement(sql);
			ResultSet rs=prepStmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
