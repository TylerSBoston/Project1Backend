package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.*;

public class DBConnection {
	private static String connectionString = "jdbc:postgresql://localhost:5432/Project0";
	private static String userName = "postgres";
	private static String password = "1234";
	private static Connection conn = null;
	private final static Logger log = LogManager.getLogger(DBConnection.class);
	
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			log.info("Estabilishing DB connection");
			conn = DriverManager.getConnection(connectionString,userName,password);
		} catch (SQLException e) {
			log.error("Connection Failed " + e.getMessage());
		}
	}
	
	public static Connection getConnection()
	{
		try {
			if(conn == null || conn.isClosed() == true)
			{
				log.info("ReEstabilishing DB connection");
				conn = DriverManager.getConnection(connectionString,userName,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Connection Failed " + e.getMessage());
		}
		return conn;
	}
	public static void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}