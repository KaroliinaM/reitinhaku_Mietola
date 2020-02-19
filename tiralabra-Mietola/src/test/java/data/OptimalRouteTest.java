/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import datastructures.MyArrayList;
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

        List<Connection> connections
                = Arrays.asList(new Connection("ekaLähtö", "ekaMaali", 0, 40, "13"),
                        new Connection("tokaLähtö", "tokaMaali", 0, 50, "17"),
                        new Connection("kolmasLähtö", "kolmasMaali", 0, 60, "17"),
                        new Connection("neljäsLähtö", "neljäsMaali", 0, 70, "55"),
                        new Connection("viidesLähtö", "viidesMaali", 0, 80, "30"));
        int time = 40;
        for (Connection c : connections) {
            optimalroute.addConnection(c);
            optimalroute.addTime(time);
            time += 10;
        }
        MyArrayList reitti = optimalroute.getConnections();
        Collections.reverse(connections);

        for (int i = 0; i < reitti.returnObjLength(); i++) {
            assertEquals(reitti.getObject(i), connections.get(i));
        }
        // assertEquals(reitti, connections);
        assertEquals(optimalroute.getTime(), 300);
    }
}
