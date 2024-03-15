import java.sql.*;
import java.util.*;

public class crud {
 
	public static void main(String[] args) {
		
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/juan_db";
		String USER = "root";
		String PASS = "";
		
		try {
			
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL,USER, PASS);
			Statement stmt = conn.createStatement();
			
			String query ="CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT,name VARCHAR(255), email VARCHAR(25),PRIMARY KEY (id))";
			
			
			stmt.executeLargeUpdate(query);
			
			Scanner scan = new Scanner(System.in);
			
			
			System.out.println("1. add User");
			System.out.println("2. add User");
			
			System.out.print("enter choise");
			String choice = scan.nextLine();
			
			switch(choice) {
			case "1":
				System.out.print("Enter user name: ");
				String name = scan.nextLine();
				
				System.out.print("enter user email");
				
				
				String email = scan.nextLine();
				
				query = "INSERT INTO users(name,email) VALUES ('"+name+"','"+email+"')";
				
				stmt.executeUpdate(query);
				
				break;
			case "2":
				System.out.print("Enter user id: ");
				int id = scan.nextInt();
				
				query = "SELECT * FROM users WHERE id = "+ id;
				
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.next()) {
					System.out.println("Id:"+rs.getInt("id"));
					System.out.println("name :"+rs.getString("name"));
					System.out.println("Email :"+rs.getString("email"));				
				}else  {
					System.out.println("User not found");
				}
				break;
			}
			
			System.out.print("Enter user name: ");
			String name = scan.nextLine();
			
			System.out.print("enter user email");
			
			
			String email = scan.nextLine();
			
			query = "INSERT INTO users(name,email) VALUES ('"+name+"','"+email+"')";
			
			stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
				
		}catch(Exception e) {
			System.out.print("Error: "+e.getMessage());
			
			
		}

	}

}
