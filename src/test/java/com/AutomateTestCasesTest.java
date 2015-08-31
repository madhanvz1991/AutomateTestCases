package com;


import static org.junit.Assert.*;
import org.junit.Test;

public class AutomateTestCasesTest {

    @Test
    public void testSuccessOprMul() {
        System.out.println("OprMul");
        int a = 0;
        int b = 0;
        AutomateTestCases instance = new AutomateTestCases();
        int expresult = 0;
        int result = instance.oprMul(a,b);
        assertEquals(expresult, result);
        //TODO review the generated test code and remove the default call to fail;
        //fail("The test case is a prototype.") ;
    }

    @Test
    public void testSuccessOprStr() {
        System.out.println("OprStr");
        String a = null;
        String b = null;
        AutomateTestCases instance = new AutomateTestCases();
        String expresult = null;
        String result = instance.oprStr(a,b);
        assertEquals(expresult, result);
        //TODO review the generated test code and remove the default call to fail;
        //fail("The test case is a prototype.") ;
    }

    @Test
    public void testSuccessOprSub() {
        System.out.println("OprSub");
        int a = 0;
        int b = 0;
        AutomateTestCases instance = new AutomateTestCases();
        int expresult = 0;
        int result = instance.oprSub(a,b);
        assertEquals(expresult, result);
        //TODO review the generated test code and remove the default call to fail;
        //fail("The test case is a prototype.") ;
    }
    
     @Test
    public void testSuccessOprAdd() {
        System.out.println("OprAdd");
        int a = 0;
        int b = 0;
        AutomateTestCases instance = new AutomateTestCases();
        int expresult = 0;
        int result = instance.oprAdd(a,b);
        assertEquals(expresult, result);
        //TODO review the generated test code and remove the default call to fail;
        //fail("The test case is a prototype.") ;
    }

   
}
