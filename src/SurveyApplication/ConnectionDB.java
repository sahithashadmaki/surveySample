package SurveyApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;

public class ConnectionDB {
	private static String url="jdbc:sqlserver://ggku3ser2;instanceName=SQL2016;databaseName=surveyDB";
	private static String uname="sa";
	private static String pass="Welcome@1234";
	//static ConnectionDB conObj=new ConnectionDB();
	 
	private static SQLServerConnectionPoolDataSource datasource;
	private static PooledConnection pool; 
	private ConnectionDB(){}
	static{
		datasource=new SQLServerConnectionPoolDataSource();
		datasource.setURL(url);
		datasource.setUser(uname);
		datasource.setPassword(pass);
		try {
			pool=datasource.getPooledConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getconnection() throws SQLException{
		Connection con=null;
		try{
			
			con=pool.getConnection();
			if(con!=null){
				System.out.println("Connection created");
			}
		}catch(Exception e){

		}

		return con;

	}
}
