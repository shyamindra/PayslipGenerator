package com.sid.myob.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sid.myob.employee.Employee;
import com.sid.myob.payslip.Payslip;

public class FileIOUtil {
	
	public static List<Payslip> readFile(String file){
		Scanner scan = null;
		try {
			scan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Payslip> payslipList = new ArrayList<>();
		while(scan.hasNext()){
			payslipList.add(fetchPayslip(scan.nextLine()));
		}
		return payslipList;
	}
	
	
	public static void writeToFile(List<Payslip> payslipList, String fileName){
		PrintWriter out = null; 
		try{
			out = new PrintWriter(fileName);
			for(Payslip payslip : payslipList){
				Employee employee = payslip.getEmployee();
				out.println(employee.getFirstName() + " " + employee.getLastName() 
				+ "," + payslip.getPaymentDate() + "," + payslip.getGrossIncome() 
				+ "," + payslip.getIncomeTax() + "," + payslip.getNetIncome()
				+ "," + payslip.getSuperAmount());
			}
		}
		catch(FileNotFoundException fe){
			fe.printStackTrace();
		}
		finally {
			out.close();	
		}
	}
	
	private static Payslip fetchPayslip(String payslipStr){
		Employee employee = new Employee();
		Payslip payslip = new Payslip();
		String[] payslipArr = payslipStr.split(",");
		employee.setFirstName(payslipArr[0]);
		employee.setLastName(payslipArr[1]);
		employee.setAnnualSalary(Long.parseLong(payslipArr[2]));
		employee.setSuperRate(Integer.parseInt(payslipArr[3].replace("%", "")));
		payslip.setEmployee(employee);
		payslip.setPaymentDate(payslipArr[4]);
		return payslip;
		
	}
}
