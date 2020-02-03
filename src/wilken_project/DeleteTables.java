package wilken_project;

public class DeleteTables extends DataBaseManipulator{
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("no arguments needed");
			System.exit(0);
		}
		delTables();
	}

	private static void delTables() {
		updateMySQL("DROP TABLE ORDERED_ARTICLE");
		updateMySQL("DROP TABLE CUST_ORDER");
		updateMySQL("DROP TABLE ARTICLE");
		updateMySQL("DROP TABLE ADDRESS");
		updateMySQL("DROP TABLE CLIENT");
	}
}
