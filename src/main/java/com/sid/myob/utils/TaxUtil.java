package com.sid.myob.utils;

import java.util.NavigableMap;
import java.util.TreeMap;

import com.sid.myob.employee.Employee;
import com.sid.myob.payslip.Payslip;
import com.sid.myob.tax.Tax;

public class TaxUtil {
	
	private static NavigableMap<Long, Tax> taxRateMap = new TreeMap<Long, Tax>();
	
	static{
		taxRateMap.put(new Long(0), new Tax(0,0));
		taxRateMap.put(new Long(18201),new Tax(0,0.19));
		taxRateMap.put(new Long(37001), new Tax(3572,0.325));
		taxRateMap.put(new Long(80001), new Tax(17547,0.37));
		taxRateMap.put(new Long(180001), new Tax(54547,0.45));
	}
	
	public Payslip calculateTax(Payslip payslip){
		Employee employee = payslip.getEmployee();
		long grossIncome = getMonthlyGrossIncome(employee.getAnnualSalary());
		payslip.setGrossIncome(grossIncome);
		payslip.setIncomeTax(getIncomeTax(employee.getAnnualSalary()));
		payslip.setNetIncome(getNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax()));
		payslip.setSuperAmount(getSuperAmount(employee.getSuperRate(), grossIncome)); 
		return payslip;
	}

	public long getNetIncome(long grossIncome, long incomeTax) {
		return Math.round(grossIncome - incomeTax);
	}

	public long getSuperAmount(int superRate, long grossIncome) {
		return Math.round((grossIncome * superRate)/100);
	}
	
	public long getIncomeTax(long annualIncome){
		return Math.round(getAnnualIncomeTax(annualIncome)/12);
	}
	
	public double getAnnualIncomeTax(long annualIncome){
		Long taxedIncome = taxRateMap.floorEntry(annualIncome).getKey() - 1;
		Tax taxSlab = taxRateMap.floorEntry(annualIncome).getValue();
		return taxSlab.getFixedComponent() + getTaxableComponent(annualIncome, taxedIncome) * 
				taxSlab.getVariablePercentage();
	}

	public long getTaxableComponent(long annualIncome, long fixedComponent) {
		return Math.round(annualIncome - fixedComponent);
	}

	public long getMonthlyGrossIncome(long annualSalary) {
		return Math.round(annualSalary/12);
	}
}
