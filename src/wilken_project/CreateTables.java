package wilken_project;
public class CreateTables extends DataBaseManipulator {
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("no arguments needed");
			System.exit(0);
		}
		creTables();
	}
	
	private static void creTables() {
		updateMySQL( "CREATE TABLE CLIENT " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " first_name VARCHAR(45), " + 
                " last_name VARCHAR(60), " +
                " title VARCHAR(30)," + 
                " date_of_birth DATE, " + 
                " PRIMARY KEY ( id ))"
				);
		
		updateMySQL( "CREATE TABLE ADDRESS " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " a_type VARCHAR(3) ," +
                " street VARCHAR(40)," +
                " street_number VARCHAR(10)," +
                " postal_code INTEGER," +
                " city VARCHAR(40)," +
                " customer_id INTEGER not NULL," +
                " PRIMARY KEY ( id )," +
                " FOREIGN KEY (customer_id) REFERENCES CLIENT (id))"
				);
		
		updateMySQL( "CREATE TABLE ARTICLE " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                " a_number INTEGER not NULL," +
                " description VARCHAR(100)," +
                " price DOUBLE," +
                " CONSTRAINT fontConst UNIQUE(a_number), " +
                " PRIMARY KEY ( id ))"
				);
		
		updateMySQL( "CREATE TABLE CUST_ORDER " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                " customer_id INTEGER NOT NULL," +
                " PRIMARY KEY ( id )," +
                " FOREIGN KEY (customer_id) REFERENCES ARTICLE (id))"
				);

		
		updateMySQL( "CREATE TABLE ORDERED_ARTICLE " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                " order_id INTEGER NOT NULL," +
                " article_id INTEGER NOT NULL," +
                " PRIMARY KEY ( id )," +
                " FOREIGN KEY (order_id) REFERENCES CUST_ORDER (id)," +
                " FOREIGN KEY (article_id) REFERENCES ARTICLE (id))"
				);
		}

}
