import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseMySQLAccess {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/db_merve";
	static final String USER = "root";
	static final String PASS = "1";

	public Connection Access() throws NamingException, SQLException {
		Connection connect = null;
		/*try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connect = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}*/
		
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/db_merve");
	    connect = ds.getConnection();
		return connect;
	}

	public void CloseConnection(Connection connect, PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Close!");
		preparedStatement.close();
		connect.close();
	}

}
