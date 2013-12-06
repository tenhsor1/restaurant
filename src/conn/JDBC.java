package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {
	   final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   String DB_URL = "jdbc:mysql://";

	   //  Usuario con el cual nos conectaremos a MySQL
	   String USER = "";
	   String PASS = "";
	   Connection conn;
	   public JDBC(String server, String db, String user, String pass) throws SQLException{
		   try {
			Class.forName(JDBC_DRIVER);
			DB_URL += server + "/" + db;
			USER = user;
			PASS = pass;
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	   }
	
	   public ResultSet query(String query){
		   Statement stmt = null;
		   try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
			   return null;
		   }
	   }
	   
	   public int queryUpdate(String query){
		   Statement stmt = null;
		   try {
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			return rs;
		   } catch (SQLException e) {
			   e.printStackTrace();
			   return 0;
		   }
	   }
	   
	   public void closeConn() throws SQLException{
		   conn.close();
	   }
}
