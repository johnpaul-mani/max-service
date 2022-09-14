package com.ms.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class minAppTest extends TestCase{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public minAppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( minAppTest.class );
    }

    /**
     * Rigorous Test
     */
    public void testApp()
    {
        assertTrue( true );
    }
}

