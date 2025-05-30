package com.nit.testRegister;

import java.io.Serializable;

@SuppressWarnings("serial")
public class userBean implements Serializable {
	private String username, password, fname, lname, address, mail;
	private long phone;

	public userBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "userBean [username=" + username + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", address=" + address + ", mail=" + mail + ", phone=" + phone + "]";
	}

}
