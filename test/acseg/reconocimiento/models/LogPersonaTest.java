/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acseg.reconocimiento.models;

import java.text.ParseException;
import java.time.LocalDateTime;
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
public class LogPersonaTest {

    public LogPersonaTest() {
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
     * Test of getHora method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetHora() throws ParseException {
        System.out.println("getHora");
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String expResult = "17:58";
        String result = instance.getHora();
        System.out.println(result);
        assertThat(result, containsString(expResult));

    }

    /**
     * Test of getCI method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetCI() throws ParseException {
        System.out.println("getCI");
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String expResult = "25933185";
        String result = instance.getCI();
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of getOp method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetOp() throws ParseException {
        System.out.println("getOp");
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String expResult = "Entrada";
        String result = instance.getOp();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of setHora method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetHora() throws ParseException {
        System.out.println("setHora");
        String hora = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setHora(hora);
    }

    /**
     * Test of setCI method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetCI() throws ParseException {
        System.out.println("setCI");
        String CI = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setCI(CI);
    }

    /**
     * Test of setOp method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetOp() throws ParseException {
        System.out.println("setOp");
        String op = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setOp(op);
    }

    /**
     * Test of getMonth method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetMonth() throws ParseException {
        System.out.println("getMonth");
        LocalDateTime now = LocalDateTime.now();
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String expResult =String.valueOf(now.getMonthValue());
        String result = instance.getMonth();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetDay() throws ParseException {
        System.out.println("getDay");
        LocalDateTime now = LocalDateTime.now();
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String expResult = String.valueOf(now.getDayOfMonth());
        String result = instance.getDay();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetYear() throws ParseException {
        System.out.println("getYear");
        LocalDateTime now = LocalDateTime.now();
        String expResult = String.valueOf(now.getYear());
        LogPersona instance = new LogPersona("25933185", "Entrada");
        String result = instance.getYear();
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of setMonth method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetMonth() throws ParseException {
        System.out.println("setMonth");
        String month = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setMonth(month);
    }

    /**
     * Test of setDay method, of class LogPersona.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetDay() throws ParseException {
        System.out.println("setDay");
        String day = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setDay(day);
    }

    /**
     * Test of setYear method, of class LogPersona.
     */
    @Test
    public void testSetYear() throws ParseException {
        System.out.println("setYear");
        String year = "";
        LogPersona instance = new LogPersona("25933185", "Entrada");
        instance.setYear(year);
    }

}
