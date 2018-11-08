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
public class WebClientTest extends TestCase {

    public WebClientTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(WebClientTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testGetRequest() throws Exception {
        WebClient client = new WebClient();
        String response = client.get("https://bittrex.com/api/v1.1/public/getticker?market=btc-ftc");

        assertNotNull("true", response);
        assertTrue(response.indexOf("result") != -1);
        assertTrue(response.indexOf("Bid") != -1);
        assertTrue(response.indexOf("Ask") != -1);
        assertTrue(response.indexOf("Last") != -1);

    }

}
