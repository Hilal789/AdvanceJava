package Studenta_aplication_2_5_25;

import java.util.Scanner;

public class UniversityApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		while (true) {
			System.out.println("|-----------------------------|");

			System.out.println("Enter your Choice: ");
			System.out.println("1.Insert Student");
			System.out.println("2.Fetch All Student");
			System.out.println("3.Fetch Student By Id");
			System.out.println("4.Update Email");
			System.out.println("5.Delete Student");
			System.out.println("6.Exit");

			System.out.println("|-----------------------------|");

			int inp = Integer.parseInt(sc.nextLine());
			if (inp > 6) {
				System.err.println("Enter right choice !!");
			}

			switch (inp) {
			case 1:
				System.out.println("Enter Student Id: ");
				String id = sc.nextLine();

				System.out.println("Enter Student Name: ");
				String name = sc.nextLine();

				System.out.println("Enter Course: ");
				String course = sc.nextLine();

				System.out.println("Enter Semester: ");
				int sem = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Email: ");
				String email = sc.nextLine();

				System.out.println("Enter Phone Number: ");
				String phone = sc.nextLine();

				Student s = new Student(id, name, course, sem, email, phone);
				st.insertStudent(s);

				break;

			case 2:

				st.fetchAllStudents();
				break;
			case 3:
				System.out.println("Enter Id to Fetch :");
				id = sc.nextLine();
				st.fetchStudentById(id);
				break;
			case 4:
				System.out.println("Enter id: ");
				id = sc.nextLine();

				System.out.println("Enter New email Id: ");
				email = sc.nextLine();

				st.updateStudentEmail(id, email);
				break;

			case 5:
				System.out.println("Enter id For delete: ");
				id = sc.nextLine();

				st.deleteStudentById(id);
				break;
			case 6:
				System.err.println("I Appriciate you for using App");
				System.exit(0);
			default:
				System.out.println("invalid Choice");

			}

		}

	}

}
