/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.reconocimiento.matriculas;

import javafx.stage.Stage;
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
public class ReconocimientoMatriculasTest {
    
    public ReconocimientoMatriculasTest() {
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
     * Test of start method, of class ReconocimientoMatriculas.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        String srcImg = "./test_001.jpg";//Imagen que contiene una matricula
        //String srcImg = "./test_002.jpg";//Imagen que no contiene una matricula
        javaanpr.Main.systemLogic = 
                new javaanpr.intelligence.Intelligence(false);
        javaanpr.imageanalysis.CarSnapshot car =
                                new javaanpr
                                .imageanalysis.CarSnapshot(srcImg);
        
        String strPlate = javaanpr.Main.systemLogic.recognize(car);
        System.out.println(strPlate);
    }
    
}
