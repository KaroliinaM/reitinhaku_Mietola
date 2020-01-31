/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author k
 */
public class OptimalRouteTest {

    private OptimalRoute optimalroute;

    public OptimalRouteTest() {
    }

    @Before
    public void setUp() {
        optimalroute = new OptimalRoute();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRouteFormation() {

        List<Connection> connections = Arrays.asList(new Connection("ekaLähtö", "ekaMaali", 40), 
                new Connection("tokaLähtö", "tokaMaali", 50), 
                new Connection("kolmasLähtö", "kolmasMaali", 60), 
                new Connection("neljäsLähtö", "neljäsMaali", 70),
                new Connection("viidesLähtö", "viidesMaali", 80));
        int time = 40;
        for (Connection c : connections) {
            optimalroute.addConnection(c);
            optimalroute.addTime(time);
            time += 10;
        }
        List<Connection> reitti = optimalroute.getConnections();
        Collections.reverse(connections);
        
        assertEquals(reitti, connections);
        assertEquals(optimalroute.getTime(), 300);
    }
}
