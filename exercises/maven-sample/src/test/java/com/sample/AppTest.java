package com.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

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
        assertEquals(11, App.add(5,6));
    }

    public void testExcelReader(){
        Map result = ExcelReader.readExcel(new File("/projects/workshop/rich_text_stress.xlsx"));
        assertNotNull(result);
        assertEquals(14, result.size());
    }
}
