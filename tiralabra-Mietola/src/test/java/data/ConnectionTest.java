/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        connection = new Connection("1234567", "asdf", 123);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreation() {
        assertNotNull(connection);
    }

}
