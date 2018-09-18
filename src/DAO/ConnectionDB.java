package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;

public class ConnectionDB {
	 private static final Logger logr = Logger.getLogger(ConnectionDB.class.getName());
	private static String url = "jdbc:sqlserver://ggku3ser2;instanceName=SQL2016;databaseName=surveyDB";
	private static String uname = "sa";
	private static String pass = "Welcome@1234";
	// static ConnectionDB conObj=new ConnectionDB();

	private static SQLServerConnectionPoolDataSource datasource;
	private static PooledConnection pool;

	private ConnectionDB() {
	}

	static {
		datasource = new SQLServerConnectionPoolDataSource();
		datasource.setURL(url);
		datasource.setUser(uname);
		datasource.setPassword(pass);
		try {
			pool = datasource.getPooledConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = pool.getConnection();
			if (con != null) {
				//System.out.println("Connection created");
				logr.info("Connection created");
			}
		} catch (Exception e) {
			//System.out.println("error Connecting to DataBase");
			logr.fatal("error Connecting to DataBase");
		}

		return con;

	}
}
