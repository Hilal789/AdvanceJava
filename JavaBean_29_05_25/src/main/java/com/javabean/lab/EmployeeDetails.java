package com.javabean.lab;

import java.io.Serializable;

public class EmployeeDetails implements Serializable {
	
	private int empId;
	private String name;
	private String department;
	private String designation;
	private double salary;
	private String email;
	private long phone;
	
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", name=" + name + ", department=" + department + ", designation="
				+ designation + ", salary=" + salary + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
	

	
	
	
}
