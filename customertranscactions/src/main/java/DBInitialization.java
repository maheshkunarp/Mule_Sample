 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.springframework.beans.factory.InitializingBean;

 

public class DBInitialization implements InitializingBean {
	
	public void afterPropertiesSet() throws Exception {
		
		String dbURL = "jdbc:h2:mem:fetchcustomersdemo;create=true";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver").newInstance();
			// Get a connection on database
			conn = DriverManager.getConnection(dbURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE CustomerDetails (FirstName VARCHAR(255),LastName VARCHAR(255),AddressLine1 VARCHAR(255),AddressLine2 VARCHAR(255),CITY VARCHAR(50),STATE VARCHAR(50),POSTCODE INTEGER)");
			System.out.println("Table is created");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Hari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2140)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Hari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2135)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Gari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2170)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Sari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2160)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Pari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2165)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Kari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2165)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Nari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2175)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Mari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2140)");
			stmt.executeUpdate("INSERT INTO CustomerDetails VALUES ('Dari','Sunkara','Burlington Road','Homebush','Sydney','NSW',2140)");
			System.out.println("Rows are inserted");
		} 
		catch (java.sql.SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
	}
}