package wilken_project;
import java.lang.*;

public class AlterDatabase extends DataBaseManipulator{
	public static void main(String[] args) {
		
		updateMySQL(getSQL(args));
	}
	
	private static String getSQL(String[] args) {
		String alteration = "";
		for (int i=0; i < args.length; i++) {
			alteration += args[i] + " ";
		}
		System.out.println(alteration);
		//return "INSERT INTO client (first_name, last_name, title, date_of_birth) VALUES ('a', 'b', 'Herr', DATE('1988-01-01'))";
		//return "INSERT INTO article (id, a_number, description, price) VALUES (1, 1, 'b', 3.2)";

		return alteration;
	}
}
