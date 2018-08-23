package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SurveyApplication.AdminInfoClass;
import SurveyApplication.ConnectionDB;
import SurveyApplication.Forms;

public class LoadFormDAO {
	
public AdminInfoClass addFormsToList(String sql) throws SQLException{
	Connection con=null;
	PreparedStatement prepStmt=null;
	AdminInfoClass adminObj=new AdminInfoClass();
	ArrayList<Forms> list=new ArrayList<>();
	try {
		con=ConnectionDB.getConnection();
		prepStmt=con.prepareStatement(sql);
		ResultSet rs=prepStmt.executeQuery();
		while(rs.next()){
			Forms formObj=new Forms();
			formObj.setFormId(rs.getInt(1));
			formObj.setFormTitle(rs.getString(2));
			list.add(formObj);
		}
		
		adminObj.setFormList(list);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		con.close();
		System.out.println("connection Closed");
	}
	return adminObj;

}
}
