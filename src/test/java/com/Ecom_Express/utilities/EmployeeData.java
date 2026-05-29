package com.Ecom_Express.utilities;

public class EmployeeData {

	private int employeeId;
	private String firstName;
	private String lastName;

	public EmployeeData(int employeeId, String firstName, String lastName)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}