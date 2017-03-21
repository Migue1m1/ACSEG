/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.utils;

import acseg.reconocimiento.models.Persona;
import java.awt.image.BufferedImage;
import java.util.List;
import javafx.scene.image.Image;
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opencv.core.Mat;

/**
 *
 * @author Miwi
 */
public class UtilsTest {
    
    public UtilsTest() {
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
     * Test of mat2Image method, of class Utils.
     */
    @Test
    public void testMat2Image() {
        System.out.println("mat2Image");
        Mat frame = null;
        Image expResult = null;
        Image result = Utils.mat2Image(frame);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of onFXThread method, of class Utils.
     */
    @Test
    public void testOnFXThread() {
        System.out.println("onFXThread");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of matToBufferedImage method, of class Utils.
     */
    @Test
    public void testMatToBufferedImage() {
        System.out.println("matToBufferedImage");
        Mat original = null;
        BufferedImage expResult = null;
        BufferedImage result = Utils.matToBufferedImage(original);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of objectToDoc method, of class Utils.
     */
    @Test
    public void testObjectToDoc() {
        System.out.println("objectToDoc");
        Object o = null;
        Document expResult = null;
        Document result = Utils.objectToDoc(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of docToPersona method, of class Utils.
     */
    @Test
    public void testDocToPersona() {
        System.out.println("docToPersona");
        Document doc = null;
        Persona expResult = null;
        Persona result = Utils.docToPersona(doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirLista method, of class Utils.
     */
    @Test
    public void testImprimirLista() {
        System.out.println("imprimirLista");
        List result_2 = null;
        Utils.imprimirLista(result_2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isRealPlate method, of class Utils.
     */
    @Test
    public void testIsRealPlate() {
        System.out.println("isRealPlate");
        //String plate = null;
        //String plate = "827N8";//Matricula de 5 caracteres
        //String plate = "1A27N8TH";//Matricula de 8 caracteres
        String plate = "B758AAJ";//Matricula de 6 caracteres
        //String plate = "PP587A0";//Matricula de 7 caracteres
        boolean expResult = true;
        boolean result = Utils.isRealPlate(plate);
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPlate method, of class Utils.
     */
    @Test
    public void testIsValidPlate() throws Exception {
        System.out.println("isValidPlate");
        //String strPlate = "B758AAJ";//Matricula invalida
        String strPlate = "999ZZZ";//Matricula valida
        boolean expResult = true;
        boolean result = Utils.isValidPlate(strPlate);
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
