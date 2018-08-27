package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.ConnectionDB;

public class DeleteDAO {
	static DeleteDAO deleteObj = new DeleteDAO();

	private DeleteDAO() {

	}

	public static DeleteDAO getObj() {
		return deleteObj;

	}

	public void delete(String sql) throws SQLException {
		Connection con = null;
		PreparedStatement prepStmt = null;
		try {
			con = ConnectionDB.getConnection();
			prepStmt = con.prepareStatement(sql);
			int records = prepStmt.executeUpdate();
			System.out.println("records deleted: " + records);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.close();
			System.out.println("connection Closed");
		}
	}
}
