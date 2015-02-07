package com.shikkhok.taskmanagement;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String designation;

	public Employee() {

	}

	public Employee(int id, String name, String email, String phone,
			String designation) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
	}

	public Employee(String name, String email, String phone, String designation) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", designation=" + designation + "]";
	}
	
}
