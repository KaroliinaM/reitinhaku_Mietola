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
public class StopTest {

    Stop stop;

    public StopTest() {
    }

    @Before
    public void setUp() {
        stop = new Stop();
        stop.setGtfsId("123456");
        stop.setName("Pasila");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setConnections() {
        stop.addConnection(new Connection("123456", "98765", 0, 130, "20"));
        stop.addConnection(new Connection("123456", "asdf", 0, 120, "20"));
        assertEquals(stop.getConnections().returnObjLength(), 2);
        Connection c = (Connection) stop.getConnections().getObject(1);
        assertEquals(c.getDepartureStop(), "123456");
    }
}
