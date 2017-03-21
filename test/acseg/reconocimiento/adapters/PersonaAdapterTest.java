/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.DbException;
import acseg.DbConnection.IDbConnection;
import acseg.reconocimiento.models.Persona;
import java.util.List;
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
public class PersonaAdapterTest {
    
    public PersonaAdapterTest() {
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
     * Test of findRecord method, of class PersonaAdapter.
     */
    @Test
    public void testFindRecord() throws DbException {
        System.out.println("findRecord");
        /*IDbConnection db = null;
        String k = "";
        Object v = null;
        PersonaAdapter instance = new PersonaAdapter();
        Persona expResult = null;
        Persona result = instance.findRecord(db, k, v);*/
        
        acseg.DbConnection.MongoDbConnection db
                = new acseg.DbConnection.MongoDbConnection("Universidad");
        db.open();
        PersonaAdapter instance = new PersonaAdapter();
        Persona result = instance.findRecord(db, "mtrAuto", "999ZZZ");
        System.out.println(result);
        db.close();
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAllRecords method, of class PersonaAdapter.
     */
    @Test
    public void testFindAllRecords() throws DbException {
        System.out.println("findAllRecords");
        acseg.DbConnection.MongoDbConnection db
                = new acseg.DbConnection.MongoDbConnection("Universidad");
        db.open();
        PersonaAdapter instance = new PersonaAdapter();
        List<Persona> expResult = null;
        List<Persona> result = instance.findAllRecords(db);
        acseg.utils.Utils.imprimirLista(result);
        db.close();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertRecord method, of class PersonaAdapter.
     */
    @Test
    public void testInsertRecord() {
        System.out.println("insertRecord");
        IDbConnection db = null;
        Persona persona = null;
        PersonaAdapter instance = new PersonaAdapter();
        instance.insertRecord(db, persona);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateRecord method, of class PersonaAdapter.
     */
    @Test
    public void testUpdateRecord() {
        System.out.println("updateRecord");
        IDbConnection db = null;
        String k1 = "";
        Object v1 = null;
        String k2 = "";
        Object v2 = null;
        PersonaAdapter instance = new PersonaAdapter();
        instance.updateRecord(db, k1, v1, k2, v2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of replaceRecord method, of class PersonaAdapter.
     */
    @Test
    public void testReplaceRecord() {
        System.out.println("replaceRecord");
        IDbConnection db = null;
        String k = "";
        Object v = null;
        Object o = null;
        PersonaAdapter instance = new PersonaAdapter();
        instance.replaceRecord(db, k, v, o);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecord method, of class PersonaAdapter.
     */
    @Test
    public void testDeleteRecord() throws DbException {
        System.out.println("deleteRecord");
        IDbConnection db = null;
        String k = "";
        Object v = null;
        PersonaAdapter instance = new PersonaAdapter();
        instance.deleteRecord(db, k, v);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
