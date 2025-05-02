package Studenta_aplication_2_5_25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	String studentId;
	String studentName;
	String course;
	int semester;
	String email;
	String phoneNumber;
	static Connection con;
	

	public Student() {
		super();
	}

	public Student(String studentId, String studentName, String course, int semester, String email,
			String phoneNumber) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.semester = semester;
		this.email = email;
		this.phoneNumber = phoneNumber;

	}

	static {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertStudent(Student st) {

		try {

			PreparedStatement ps1 = con.prepareStatement("insert into STUDENTMANAGEMENT values(?,?,?,?,?,?)");
			ps1.setString(1, st.studentId);
			ps1.setString(2, st.studentName);
			ps1.setString(3, st.course);
			ps1.setInt(4, st.semester);
			ps1.setString(5, st.email);
			ps1.setString(6, st.phoneNumber);
			int records = ps1.executeUpdate();
			if (records > 0) {
				System.out.println("Successfull Data inserted\n");
			} else {
				System.err.println("Error ,plese contact to Hilal");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fetchAllStudents() {
		try {
			Statement stmt = con.createStatement();

			ResultSet rSet = stmt.executeQuery("SELECT * FROM STUDENTMANAGEMENT");
			System.out.println("-------: Stuetn Details: -----");
			System.out.println("Student Id\t\tStudent Name\t\tCourse\t\tSemester\t\tEmail\t\tPhone Number");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3) + "\t\t"
						+ rSet.getInt(4) + "\t\t" + rSet.getString(5) + "\t\t" + rSet.getString(6));
				;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fetchStudentById(String studentId) {
		try {
			PreparedStatement pr2  = con.prepareStatement("SELECT * FROM STUDENTMANAGEMENT where STUDENTID=?");
			pr2.setString(1, studentId);
			ResultSet rSet = pr2.executeQuery();
			System.out.println("-------: Stuetn Details: -----");
			System.out.println("Student Id\t\tStudent Name\t\tCourse\t\tSemester\t\tEmail\t\tPhone Number");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3) + "\t\t"
						+ rSet.getInt(4) + "\t\t" + rSet.getString(5) + "\t\t" + rSet.getString(6));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudentEmail(String studentId, String newEmail) {
	try {
		PreparedStatement pr3 = con.prepareStatement("update STUDENTMANAGEMENT set email=? where studentid=?");
		pr3.setString(1, newEmail);
		pr3.setString(2, studentId);
		int k = pr3.executeUpdate();
		
		if(k>0) {
			System.out.println("Update complete");
		}else {
			System.out.println("Not  ");
		}
		
	}catch (Exception e) {
		e.getStackTrace();
	}
	}

	public void deleteStudentById(String studentId) {
		try {
			PreparedStatement pr4 = con.prepareStatement("delete from STUDENTMANAGEMENT  where STUDENTID=?");
			pr4.setString(1, studentId);
			int record = pr4.executeUpdate();
			if(record > 0) {
				System.out.println("Deletes a Student ");
			}else {
				System.err.println("Error not delete");
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
