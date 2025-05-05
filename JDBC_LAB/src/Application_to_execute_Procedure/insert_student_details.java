package Application_to_execute_Procedure;

import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class insert_student_details {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "advjava", "123");

			CallableStatement cs = con.prepareCall("{call StudentManagement1(?,?,?,?,?,?,?,?)}");
			
	        System.out.println("callable statement object prepared");
	        
	        System.out.println("Enter Student Id: ");
	        String id = sc.nextLine();
	        
	        System.out.println("Enter Roll No: ");
	        int roll = Integer.parseInt(sc.nextLine());
	        
	        System.out.println("Enter Branch: ");
	        String branch = sc.nextLine();
	        
	        System.out.println("Enter Home No: ");
	        Long hno = Long.parseLong(sc.nextLine());
	        
	        System.out.println("Enter City: ");
	        String city = sc.nextLine();
	        
	        System.out.println("Enter PinCode: ");
	        int pin = Integer.parseInt(sc.nextLine());
	        
	        System.out.println("Enter Mail Id:");
	        String mail = sc.nextLine();
	        
	        System.out.println("Enter Phone No: ");
	        long ph = Long.parseLong(sc.nextLine());
			
	        	
	        cs.setString(1, id);
	        cs.setInt(2, roll);
	        cs.setString(3, branch);
	        cs.setLong(4, hno);
	        cs.setString(5, city);
	        cs.setInt(6, pin);
	        cs.setString(7, mail);
	        cs.setLong(8, ph);
	        
	        
	        int records = cs.executeUpdate();
	        
	        if(records>0) {
	        	System.out.println("Records updated successfully");
	        }else {
	        	System.out.println("Please check ");
	        }
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
