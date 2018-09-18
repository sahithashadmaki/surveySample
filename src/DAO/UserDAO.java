package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import SurveyApplication.AdminInfoClass;
import SurveyApplication.AdminServlet;
import DAO.ConnectionDB;

import SurveyApplication.UserInfo;
 public class UserDAO 	{
	 private static final Logger logr = Logger.getLogger(UserDAO.class.getName());
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
	  	logr.info("value: "+value);
			if (value) {
				role = rs.getString(4);
			
				if (role.equals("admin")) {
					AdminInfoClass adminInfo = new AdminInfoClass();
					adminInfo.setValid(true);
					adminInfo.setId(rs.getInt(1));
					adminInfo.setName(rs.getString(2));
					adminInfo.setPassword(rs.getString(3));
					adminInfo.setRole(role);
					adminInfo.setEmail(rs.getString(5));
					return adminInfo;
				}else if(role.equals("user")){
				
					userInfo.setValid(true);
					userInfo.setId(rs.getInt(1));
					userInfo.setName(rs.getString(2));
					userInfo.setPassword(rs.getString(3));
					userInfo.setRole(role);
					userInfo.setEmail(rs.getString(5));
				}
			}
			else{
	  			userInfo.setValid(false);
	  			logr.info("userInfo.isValid(): "+userInfo.isValid());
	  		}
	  	}
	      catch (Exception ex) 
	      {
	    	  logr.error("Log In failed: An Exception has occurred! " + ex);
	         
	      }finally{
	  		con.close();
	  		logr.info("connection Closed");
	  	}
		return userInfo; 
	      }	
	   }

