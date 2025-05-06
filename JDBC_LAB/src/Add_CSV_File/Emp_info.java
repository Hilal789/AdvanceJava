package Add_CSV_File;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Emp_info {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "advjava", "123");
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?)");
			int k = 0;
			File f = new File("C:\\Users\\smhil\\Downloads\\MOCK_DATA.csv");
			FileInputStream fis = new FileInputStream(f);
			Scanner sc = new Scanner(f);
			sc.nextLine();
			while (sc.hasNext()) {
				String arr[] = sc.nextLine().split(",");
				for (int i = 0; i < arr.length; i++) {
					ps.setString(i + 1, arr[i]);
				}
				k = ps.executeUpdate();

			}
			if (k > 0) {
				System.out.println("DATA inserted..!");
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
