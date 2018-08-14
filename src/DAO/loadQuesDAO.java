package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SurveyApplication.ConnectionDB;
import SurveyApplication.Forms;
import SurveyApplication.QuestionsInterface;

public class loadQuesDAO {
public void addQtoList(){
	Connection con=null;
	PreparedStatement prepStmt=null;
	ResultSet rs=null;
	ArrayList<QuestionsInterface> list=new ArrayList<>();
	String sql="select * from questions";
	Forms form=new Forms();
	list=form.getList();
	try {
		con=ConnectionDB.getConnection();
		prepStmt=con.prepareStatement(sql);
		rs=prepStmt.executeQuery();
		while(rs.next()){
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
