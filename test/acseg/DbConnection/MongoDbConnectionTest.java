/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.DbConnection;

import java.util.List;
import org.bson.Document;
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
public class MongoDbConnectionTest {
    
    public MongoDbConnectionTest() {
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
     * Test of setDbName method, of class MongoDbConnection.
     */
    @Test
    public void testSetDbName() {
        System.out.println("setDbName");
        String dbName = "";
        MongoDbConnection instance = new MongoDbConnection();
        instance.setDbName(dbName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of open method, of class MongoDbConnection.
     * @throws java.lang.Exception
     */
    @Test
    public void testOpen() throws Exception {
        System.out.println("open");
        MongoDbConnection instance = new MongoDbConnection();
        instance.open();
        instance.open();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MongoDbConnection.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String nameColl = "";
        MongoDbConnection instance = new MongoDbConnection();
        instance.create(nameColl);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class MongoDbConnection.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String nameColl = "";
        Object person = null;
        MongoDbConnection instance = new MongoDbConnection();
        instance.insert(nameColl, person);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MongoDbConnection.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String nameColl = "";
        String k1 = "";
        Object v1 = null;
        String k2 = "";
        Object v2 = null;
        MongoDbConnection instance = new MongoDbConnection();
        instance.update(nameColl, k1, v1, k2, v2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class MongoDbConnection.
     */
    @Test
    public void testReplace() {
        System.out.println("replace");
        String nameColl = "";
        String key = "";
        Object value = null;
        Object o = null;
        MongoDbConnection instance = new MongoDbConnection();
        instance.replace(nameColl, key, value, o);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MongoDbConnection.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String nameColl = "";
        String key = "";
        Object value = null;
        MongoDbConnection instance = new MongoDbConnection();
        instance.delete(nameColl, key, value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findOne method, of class MongoDbConnection.
     */
    @Test
    public void testFindOne() {
        System.out.println("findOne");
        String nameColl = "";
        String key = "";
        Object value = null;
        MongoDbConnection instance = new MongoDbConnection();
        Document expResult = null;
        Document result = instance.findOne(nameColl, key, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class MongoDbConnection.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        String nameColl = "";
        MongoDbConnection instance = new MongoDbConnection();
        List<Document> expResult = null;
        List<Document> result = instance.findAll(nameColl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class MongoDbConnection.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        MongoDbConnection instance = new MongoDbConnection();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
