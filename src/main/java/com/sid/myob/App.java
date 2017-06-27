package com.sid.myob;

import java.util.List;

import com.sid.myob.io.FileIOUtil;
import com.sid.myob.payslip.Payslip;
import com.sid.myob.utils.TaxUtil;

public class App 
{
    public static void main( String[] args )
    {
    	if(args.length != 2){
    		System.out.println("Usage java -jar [target-jar] [input file] [output file]");
    	}
		List<Payslip> payslipList = FileIOUtil.readFile(args[0]);
		for(Payslip payslip: payslipList){
			TaxUtil taxUtil = new TaxUtil();
			payslip = taxUtil.calculateTax(payslip); 
		}
		FileIOUtil.writeToFile(payslipList, args[1]);
    }
}
