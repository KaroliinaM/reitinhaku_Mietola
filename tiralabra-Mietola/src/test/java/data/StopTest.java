/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.Connection;
import data.Stop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        stop=new Stop();
        stop.setGtfsId("123456");
        stop.setName("Pasila");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void setConnections() {
        stop.addConnection(new Connection("123456", "98765", 130));
        stop.addConnection(new Connection("123456", "asdf", 120));
        assertEquals(stop.getConnections().size(), 2);
    }
}
