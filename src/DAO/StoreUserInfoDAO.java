package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ConnectionDB;

public class StoreUserInfoDAO {
	static StoreUserInfoDAO user= new StoreUserInfoDAO();
	private StoreUserInfoDAO(){
		
	}
	public static StoreUserInfoDAO getObj(){
		return user;
		
	}
public boolean insertToDB(String emailCheckQuery,String sql) throws SQLException{
	Connection con=null;
	Statement stmt=null;
	try {
		con=ConnectionDB.getConnection();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(emailCheckQuery);
		if(rs.next()){
			System.out.println("record exists with this Email Id");
			return true;
		}else{
			stmt.executeUpdate(sql);
		System.out.println("----user info inserted to DataBase-----");
		return false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		con.close();
		System.out.println("connection Closed");
	}
	return true;
}
}
