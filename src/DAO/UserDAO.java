package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SurveyApplication.AdminInfoClass;
import DAO.ConnectionDB;

import SurveyApplication.UserInfo;
 public class UserDAO 	{
		static UserDAO userdao=new UserDAO();
		private UserDAO(){}
		public static UserDAO getObj(){
			return userdao;
			
		}
	      public UserInfo login(String name,String pass) throws SQLException {
	    	  String role = null;
	    	  PreparedStatement prepStmt=null;
	    	  Connection con=null;
	    	  String sql="select * from users where user_name=? and user_pass=?;";
	    		UserInfo userInfo=new UserInfo();
	      try {
	    	  con=ConnectionDB.getConnection();
	    	  prepStmt=con.prepareStatement(sql);
	  		prepStmt.setString(1, name);
	  		prepStmt.setString(2, pass);
	  		//prepStmt.executeUpdate();
	  		ResultSet rs=prepStmt.executeQuery();
	  		
	  		boolean value=rs.next();
	  		System.out.println("value: "+value);
			if (value) {
				role = rs.getString(4);
				System.out.println(role);
				if (role.equals("admin")) {
					AdminInfoClass adminInfo = new AdminInfoClass();
					adminInfo.setValid(true);
					System.out.println("adminInfo.isValid()" + adminInfo.isValid());
					
					adminInfo.setId(rs.getInt(1));
					System.out.println("AdminId" + rs.getInt(1));
					
					adminInfo.setName(rs.getString(2));
					System.out.println("admin name: " + rs.getString(2));
					
					adminInfo.setPassword(rs.getString(3));
					System.out.println("admin password: "+rs.getString(3));
					
					adminInfo.setRole(role);
					System.out.println("role: "+role);
					
					adminInfo.setEmail(rs.getString(5));
					System.out.println("admin email Id: " + rs.getString(5));
					
					return adminInfo;
				}else if(role.equals("user")){
				
					userInfo.setValid(true);
					System.out.println("userInfo.isValid()" + userInfo.isValid());
					
					userInfo.setId(rs.getInt(1));
					System.out.println("User Id" + rs.getInt(1));
					
					userInfo.setName(rs.getString(2));
					System.out.println("User name: " + rs.getString(2));
					
					userInfo.setPassword(rs.getString(3));
					System.out.println("User password: "+rs.getString(3));
					
					userInfo.setRole(role);
					System.out.println("role: "+role);
					
					userInfo.setEmail(rs.getString(5));
					System.out.println("use email Id: " + rs.getString(5));
				}
			}
			else{
	  			userInfo.setValid(false);
	  			System.out.println("admin.isValid()"+userInfo.isValid());
	  		}
	  	}
	      catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	         
	      }finally{
	  		con.close();
	  		System.out.println("connection Closed");
	  	}
		return userInfo; 
	      }	
	   }

