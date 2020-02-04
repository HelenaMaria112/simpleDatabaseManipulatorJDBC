package wilken_project;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class KundenAdressenverwaltung extends DataBaseManipulator {
	String table1de = "Kunde";
	String table2de = "Adresse";
	String table1en = "client";
	String table2en = "address";
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("no arguments needed");
			System.exit(0);
		}
		KundenAdressenverwaltung kundenAdressenverwaltung = new KundenAdressenverwaltung(); 
		while(true) {
		kundenAdressenverwaltung.startApplication();
		}
	}
	
	public void startApplication() {
		System.out.println("Bitte wählen Sie eine Option: \n"
				+ "(A) " + this.table1de + " anzeigen \n"
				+ "(B) " + this.table2de + " anzeigen \n"
				+ "(C) " + this.table1de + " hinzufügen \n"
				+ "(D) " + this.table2de + " hinzufügen \n"
				+ "(E) " + this.table1de + " bearbeiten \n"
				+ "(F) " + this.table2de + " bearbeiten \n"
				+ "(G) " + this.table1de + " löschen \n"
				+ "(H) " + this.table2de + " löschen \n");
		String action = getUserInput();
		act (action);
	}
	
	static String getUserInput() {
		Scanner sc = new Scanner(System.in);
 		System.out.println("Ihre Wahl:"); 
 		String userinput = sc.nextLine();  
 		//sc.close();
 		return userinput;
	}
	
	void act(String action) {
		switch (action) {
		case "A":
			show(this.table1en);
			break;
		case "B":
			show(this.table2en);
			break;
		case "C":
			add(this.table1en);
			break;
		case "D":
			add(this.table2en);
			break;
		case "E":
			alter(this.table1en);
			break;
		case "F":
			alter(this.table1en);
			break;
		case "G":
			delete(this.table1en);
			break;
		case "H":
			delete(this.table2en);
			break;
			
		}
	}
	
	void show(String table)  {
		updateMySQL("SELECT * FROM " + table, Boolean.TRUE);	
		waitToReturn();

	}
	
	static void waitToReturn() {
		System.out.println("\n \nTo return to main menu, type any key");
		String action = getUserInput();
	}
	
	void add(String table) {
		updateMySQL("SELECT * FROM " + table, Boolean.FALSE);
		String columnsWO1 = this.columns.substring(this.columns.indexOf(' '));
		System.out.println("Bitte Werte für "+ columnsWO1 + " eingeben. Bitte mit Leerzeichen separieren. Datumsformat ist YYYY-MM-DD.");
		String [] newValues = getUserInput().split(" ");
		
		String query = "INSERT INTO " + table + " ( " + columnsWO1 + " ) VALUES (";
		for (int i = 0; i < newValues.length; i++) {
			if(i != 0) {
				query += ", ";
			}
			if (this.columnTypes[i+1].contains("CHAR")){
					query += "'" + newValues[i] + "' ";
			}
			else if (this.columnTypes[i+1].contains("INT")){
					query += newValues[i];
			}
			else if (this.columnTypes[i+1].contains("DATE")){
					query += " DATE('" + newValues[i] + "')";
			}
		}
		query += ")";
		
		updateMySQL(query, Boolean.FALSE);
	}
	
	void alter(String table) {
		
	}
	
	void delete(String table) {
		
	}

}
