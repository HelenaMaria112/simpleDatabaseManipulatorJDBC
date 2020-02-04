package wilken_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DataBaseManipulator {
	String columns = null;
	String [] columnTypes = null;
	
	public void updateMySQL(String query, Boolean showResult ){
		loadDriver(); 
		//System.out.println("Connection builds...");	
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wilkendb", "root", "wilken");
		    //System.out.println("database wilkendb connected");
		    // Do something with the Connection	
		    statement = connection.createStatement();
		    if (query.contains("INSERT")) {
		    	statement.executeUpdate(query);
		    }
		    else {
		    	rs = statement.executeQuery(query);
		    
			    if (showResult) {
			    	printResult(rs);
			    }
			    //System.out.println("database updated");
			    setReturnValues(rs);
		    }
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
				    //System.out.println("Connection closed");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}	
	
	private void setReturnValues(ResultSet rs) {
		this.getColumnTypes(rs);
		this.getColumns(rs);
		
	}

	static void printResult(ResultSet rs) {
		try {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		for (int i = 1; i <= columnsNumber; i++) {
			System.out.print(rsmd.getColumnName(i) + ", ");
		}
		System.out.println("");
		
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        //if (i >2 && i<5) System.out.print("\t");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + "\t");
		    }
		    System.out.println("");
		}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	private static void loadDriver(){
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver");
    		//System.out.println("Driver loaded");
        } catch (Exception ex) {
    		System.out.println("Driver NOT loaded: ");
    		ex.printStackTrace();
            // handle the error
        }
	}
	
	private void getColumnTypes(ResultSet rs) {
		try {
			this.columns = "";
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			this.columnTypes = new String [columnsNumber];
			for (int i = 0; i < columnsNumber; i++) {
				this.columnTypes[i] = rsmd.getColumnTypeName(i+1);
				//System.out.println(rsmd.getColumnTypeName(i+1) + i);
			}
			
			
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

	private void getColumns(ResultSet rs) {
		try {
			this.columns = "";
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				this.columns += rsmd.getColumnName(i) ;
				if (i < columnsNumber ) { 
					this.columns += ", "; 
				}
			}
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}

