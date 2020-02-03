package wilken_project;
public class AlterDatabase extends DataBaseManipulator{
	public static void main(String[] args) {
		
		updateMySQL(getSQL(args));
	}
	
	private static String getSQL(String[] args) {
		if (args.length > 0) {
			System.out.println("no arguments needed");
			System.exit(0);
		}
		String alteration = args.toString();
		System.out.println(alteration);
		return alteration;
	}
}
