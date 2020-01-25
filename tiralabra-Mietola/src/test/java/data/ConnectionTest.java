/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Connection;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k
 */
public class ConnectionTest {
    Connection connection;
    public ConnectionTest() {
    }
    
    @Before
    public void setUp() {
        connection=new Connection("1234567", "asdf", 123);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         assertNotNull(connection);
     }
     
     
}
