package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import SurveyApplication.AdminInfoClass;
import SurveyApplication.ConnectionDB;
import SurveyApplication.MyException;
import SurveyApplication.UserInfo;
 public class UserDAO 	{
		
	      public static UserInfo login(UserInfo userInfo,Connection con,String sql,String name,String pass) {
	    	  String role = null;
	    	  PreparedStatement prepStmt=null;
	         //preparing some objects for connection 
	       //  Statement stmt = null;    
	      try {
	    	  prepStmt=con.prepareStatement(sql);
	  		prepStmt.setString(1, name);
	  		prepStmt.setString(2, pass);
	  		//prepStmt.executeUpdate();
	  		ResultSet rs=prepStmt.executeQuery();
	  		boolean value=rs.next();
	  		System.out.println("value: "+value);
	  		if(value){
	  		role=rs.getString(1);
	  		userInfo.setRole(role);
	  		System.out.println(role);
	  		userInfo.setValid(true);
	  		System.out.println("admin.isValid()"+userInfo.isValid());
	  		}
	  		if(!value){
	  			userInfo.setValid(false);
	  			System.out.println("admin.isValid()"+userInfo.isValid());
	  			throw new MyException("User doesn't exist");
	  			
	  		}
	  		
	  	}
	      catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	      } 
		

	return userInfo;
		
	      }	
	   }

