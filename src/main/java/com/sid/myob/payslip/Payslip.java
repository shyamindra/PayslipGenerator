package com.sid.myob.payslip;

import com.sid.myob.employee.Employee;

public class Payslip {

	private Employee employee;
	private long grossIncome;
	private long netIncome;
	private long incomeTax;
	private long superAmount;
	private String paymentDate;
	
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(long grossIncome) {
		this.grossIncome = grossIncome;
	}
	public long getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(long netIncome) {
		this.netIncome = netIncome;
	}
	public long getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(long incomeTax) {
		this.incomeTax = incomeTax;
	}
	public long getSuperAmount() {
		return superAmount;
	}
	public void setSuperAmount(long superAmount) {
		this.superAmount = superAmount;
	}
	
}
