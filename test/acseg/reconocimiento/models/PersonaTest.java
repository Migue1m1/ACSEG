/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.reconocimiento.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miwi
 */
public class PersonaTest {
    
    public PersonaTest() {
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
     * Test of getCI method, of class Persona.
     */
    @Test
    public void testGetCI() {
        System.out.println("getCI");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getCI();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCI method, of class Persona.
     */
    @Test
    public void testSetCI() {
        System.out.println("setCI");
        int CI = 0;
        Persona instance = new Persona();
        instance.setCI(CI);
        
    }

    /**
     * Test of getNombre method, of class Persona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Persona.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Persona instance = new Persona();
        instance.setNombre(nombre);
    }

    /**
     * Test of getEdad method, of class Persona.
     */
    @Test
    public void testGetEdad() {
        System.out.println("getEdad");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getEdad();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEdad method, of class Persona.
     */
    @Test
    public void testSetEdad() {
        System.out.println("setEdad");
        int edad = 0;
        Persona instance = new Persona();
        instance.setEdad(edad);
    }

    /**
     * Test of getCarrera method, of class Persona.
     */
    @Test
    public void testGetCarrera() {
        System.out.println("getCarrera");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getCarrera();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCarrera method, of class Persona.
     */
    @Test
    public void testSetCarrera() {
        System.out.println("setCarrera");
        String carrera = "";
        Persona instance = new Persona();
        instance.setCarrera(carrera);
    }

    /**
     * Test of getSede method, of class Persona.
     */
    @Test
    public void testGetSede() {
        System.out.println("getSede");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getSede();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSede method, of class Persona.
     */
    @Test
    public void testSetSede() {
        System.out.println("setSede");
        String sede = "";
        Persona instance = new Persona();
        instance.setSede(sede);
    }

    /**
     * Test of getEnCampus method, of class Persona.
     */
    @Test
    public void testGetEnCampus() {
        System.out.println("getEnCampus");
        Persona instance = new Persona();
        Boolean expResult = false;
        Boolean result = instance.getEnCampus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnCampus method, of class Persona.
     */
    @Test
    public void testSetEnCampus() {
        System.out.println("setEnCampus");
        boolean enCampus = false;
        Persona instance = new Persona();
        instance.setEnCampus(enCampus);
    }

    /**
     * Test of getMatricula method, of class Persona.
     */
    @Test
    public void testGetMatricula() {
        System.out.println("getMatricula");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getMatricula();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMatricula method, of class Persona.
     */
    @Test
    public void testSetMatricula() {
        System.out.println("setMatricula");
        String mtr = "";
        Persona instance = new Persona();
        instance.setMatricula(mtr);
    }

    /**
     * Test of toString method, of class Persona.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
