package wilken_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseManipulator {
	
	public static void updateMySQL(String query){
		loadDriver(); 
		System.out.println("Connection builds...");	
		Connection connection = null;
		Statement statement = null;
		try {
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wilkendb", "root", "wilken");
		    System.out.println("database wilkendb connected");
		    // Do something with the Connection	
		    statement = connection.createStatement();
		    statement.executeUpdate(query);
		    System.out.println("database updated");
		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				    System.out.println("Connection closed");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	
	private static void loadDriver(){
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("Driver loaded");
        } catch (Exception ex) {
    		System.out.println("Driver NOT loaded: ");
    		ex.printStackTrace();
            // handle the error
        }
	}

}

