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
	ArrayList<Forms> list=new ArrayList<>();
public void addFormsToList(int adminId, AdminInfoClass admin){
	Connection con=null;
	PreparedStatement prepStmt=null;
	
	String sql="select * from forms where admin_id=?;";
	try {
		con=ConnectionDB.getConnection();
		prepStmt=con.prepareStatement(sql);
		System.out.println("formid before setting: "+adminId);
		prepStmt.setInt(1, adminId);
		ResultSet rs=prepStmt.executeQuery();
		while(rs.next()){
			Forms formObj=new Forms();
			formObj.setFormId(rs.getInt(1));
			formObj.setFormTitle(rs.getString(2));
			list.add(formObj);
		}
		admin.setFormList(list);
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}
