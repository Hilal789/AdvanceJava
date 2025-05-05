package retrieve_empResume_5_5_25;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveResume {
	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
				Scanner sc = new Scanner(System.in);) {

			System.out.println("Enter EMP_Phone :");
			int phone = Integer.parseInt(sc.nextLine());

			PreparedStatement ps = con.prepareStatement("select *from emp_info where EMPPHNO=?");
			ps.setLong(1, phone);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob b = rs.getBlob("EMPRESUME");
				byte[] b1 = b.getBytes(6, (int) b.length());
				File f = new File("C:\\Demo\\ANAND.PDF");

				FileOutputStream fos = new FileOutputStream(f);

				fos.write(b1);
				System.out.println("fILE WRITE SUCCUSS");

			} else {
				System.out.println("not found");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
