package emp.info_2_5_25;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");

			PreparedStatement ps = con.prepareStatement("insert into emp_info values(?,?,?,?,?,?)");

			System.out.println("Enter Emp Id: ");
			String id = sc.nextLine();

			System.out.println("Enter Emp Name: ");
			String name = sc.nextLine();

			System.out.println("Enter Emp Address: ");
			String address = sc.nextLine();

			System.out.println("Enter Emp Mail: ");
			String email = sc.nextLine();

			System.out.println("Enter Phone No: ");
			int phone = Integer.parseInt(sc.nextLine());

			System.out.println("Enter your resume path: ");
			String file = sc.nextLine();

			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setInt(5, phone);
			File f = new File(file);
			FileInputStream fis = new FileInputStream(f);
			ps.setBlob(6, fis, f.length());

			int k = ps.executeUpdate();
			if (k > 0) {
				System.out.println("Insertion success");
			} else {
				System.out.println("faild");

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
