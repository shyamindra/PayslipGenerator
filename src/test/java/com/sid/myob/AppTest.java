package com.sid.myob;

import com.sid.myob.utils.TaxUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testIncomeTax(){
    	TaxUtil taxUtil = new TaxUtil();
    	assertEquals(taxUtil.getIncomeTax(37001), 298);
    	assertEquals(taxUtil.getIncomeTax(60050), 922);
    	assertEquals(taxUtil.getIncomeTax(120000), 2696);
    }
    
    public void testGrossIncome(){
    	TaxUtil taxUtil = new TaxUtil();
    	assertEquals(taxUtil.getMonthlyGrossIncome(37001), Math.round(37001/12));
    	assertEquals(taxUtil.getMonthlyGrossIncome(60050), 5004);
    	assertEquals(taxUtil.getMonthlyGrossIncome(120000), 10000);
    }
    
    public void testSuperAmount(){
    	TaxUtil taxUtil = new TaxUtil();
    	assertEquals(taxUtil.getSuperAmount(9, 37001), Math.round(37001*.09));
    	assertEquals(taxUtil.getSuperAmount(9, 5004), 450);
    	assertEquals(taxUtil.getSuperAmount(10, 10000), 1000);
    }
    
}
