package com.sid.myob.employee;

public class Employee {

	private String firstName;
	private String lastName;
	private long annualSalary;
	private int superRate;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(long annualSalary) {
		this.annualSalary = annualSalary;
	}
	public int getSuperRate() {
		return superRate;
	}
	public void setSuperRate(int superRate) {
		this.superRate = superRate;
	}
}
