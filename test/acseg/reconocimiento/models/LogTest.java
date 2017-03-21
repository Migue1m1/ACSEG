/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acseg.reconocimiento.models;

import java.text.ParseException;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joandv
 */
public class LogTest {

    public LogTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHora method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetHora() throws ParseException {
        System.out.println("getHora");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "5:45";
        String result = instance.getHora();
        assertThat(result, containsString(expResult));

    }

    /**
     * Test of getMtrAuto method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetMtrAuto() throws ParseException {
        System.out.println("getMtrAuto");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "AA233TF";
        String result = instance.getMtrAuto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOp method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetOp() throws ParseException {
        System.out.println("getOp");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "Entrada";
        String result = instance.getOp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHora method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetHora() throws ParseException {
        System.out.println("setHora");
        String hora = "";
        Log instance = new Log("AA233TF", "Entrada");
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMtrAuto method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetMtrAuto() throws ParseException {
        System.out.println("setMtrAuto");
        String mtrAuto = "AA233TF";
        Log instance = new Log("AA233TF", "Entrada");
        instance.setMtrAuto(mtrAuto);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setOp method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetOp() throws ParseException {
        System.out.println("setOp");
        String op = "AA233TT";
        Log instance = new Log("AA233TF", "Entrada");
        instance.setOp(op);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMonth method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetMonth() throws ParseException {
        System.out.println("setMonth");
        String month = "";
        Log instance = new Log("AA233TF", "Entrada");

    }

    /**
     * Test of setDay method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetDay() throws ParseException {
        System.out.println("setDay");
        String day = "";
        Log instance = new Log("AA233TF", "Entrada");
        instance.setDay(day);
    }

    /**
     * Test of setYear method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetYear() throws ParseException {
        System.out.println("setYear");
        String year = "";
        Log instance = new Log("AA233TF", "Entrada");
        instance.setYear(year);

    }

    /**
     * Test of getMonth method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetMonth() throws ParseException {
        System.out.println("getMonth");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "";
        String result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetDay() throws ParseException {
        System.out.println("getDay");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "";
        String result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Log.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetYear() throws ParseException {
        System.out.println("getYear");
        Log instance = new Log("AA233TF", "Entrada");
        String expResult = "";
        String result = instance.getYear();
        assertEquals(expResult, result);

    }

}
