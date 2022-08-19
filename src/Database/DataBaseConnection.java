package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	

		
//		public static void main(String[] args) {
//			connection();
//		}
		public static Connection connection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbm_system","root","");
				return conn;
			}
			catch(Exception e){
				System.out.println(e);
				return null;
				
			}
		}
	}

