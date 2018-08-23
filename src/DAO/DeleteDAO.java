package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import SurveyApplication.ConnectionDB;

public class DeleteDAO {
public void delete(String sql) throws SQLException{
	Connection con=null;
	PreparedStatement prepStmt=null;
	try {
		con=ConnectionDB.getConnection();
		prepStmt=con.prepareStatement(sql);
		int records=prepStmt.executeUpdate();
		System.out.println("records deleted: "+records);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}finally{
		con.close();
		System.out.println("connection Closed");
	}
}
}
