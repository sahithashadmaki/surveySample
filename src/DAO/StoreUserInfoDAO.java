package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import SurveyApplication.ConnectionDB;

public class StoreUserInfoDAO {
public void insertToDB(String sql) throws SQLException{
	Connection con=null;
	PreparedStatement prepStmt=null;
	try {
		con=ConnectionDB.getConnection();
		prepStmt=con.prepareStatement(sql);
		prepStmt.executeUpdate();
		System.out.println("----user info inserted to DataBase-----");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		con.close();
		System.out.println("connection Closed");
	}
}
}
