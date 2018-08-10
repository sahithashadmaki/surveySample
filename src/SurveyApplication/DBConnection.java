/*package SurveyApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;

public class DBConnection {
	private Connection con=null;
	public DBConnection(String url,String uname,String pass){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.con=DriverManager.getConnection(url,uname,pass);
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		
		return this.con;
	
	}
	public ResultSet runSql(String sql) throws SQLException {
		Statement sta = con.createStatement();
		return sta.executeQuery(sql);
	}
}
*/