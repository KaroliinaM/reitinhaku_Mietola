/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import datastructures.MyArrayList;
import network.Mapdata;

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
                        new Connection("tokaLähtö", "tokaMaali", 45, 50, "17"),
                        new Connection("kolmasLähtö", "kolmasMaali", 55, 60, "17"),
                        new Connection("neljäsLähtö", "neljäsMaali", 65, 70, "55"),
                        new Connection("viidesLähtö", "viidesMaali", 75, 80, "30"));
        int time = 40;
        for (Connection c : connections) {
            optimalroute.addConnection(c);
            optimalroute.setTravelTimes(connections.get(0).getDepartureTime(),
                    connections.get(4).getArrivalTime());
            time += 10;
        }
        MyArrayList reitti = optimalroute.getConnections();
        Collections.reverse(connections);

        for (int i = 0; i < reitti.returnObjLength(); i++) {
            assertEquals(reitti.getObject(i), connections.get(i));
        }
        assertEquals(optimalroute.getTravelTime(), 80);
    }

    @Test
    public void testRouteOutput() {
        Connection connection1 = new Connection("Lauttasaari", "Ruoholahti", 20034, 20074, "21");
        Connection connection2 = new Connection("Ruoholahti", "Erottaja", 20100, 202000, "20");
        Connection connection3 = new Connection("Erottaja", "Hietaranta", 202400, 203000, "24");
        optimalroute.addConnection(connection1);
        optimalroute.addConnection(connection2);
        optimalroute.addConnection(connection3);
        optimalroute.setTravelTimes(20034, 203000);
        assertEquals(optimalroute.toString(), " [Erottaja - Hietaranta]  [Ruoholahti - Erottaja]  "
                + "[Lauttasaari - Ruoholahti]  on time 182966");

    }

    @Test
    public void testUIOutput() {

        Connection connection1 = new Connection("Lauttasaari", "Ruoholahti", 20034, 20074, "21");
        Connection connection2 = new Connection("Ruoholahti", "Erottaja", 20100, 202000, "20");
        Connection connection3 = new Connection("Erottaja", "Hietaranta", 202400, 203000, "24");
        Mapdata data = Mockito.mock(Mapdata.class);
        Mockito.when(data.getStop("Lauttasaari")).thenReturn(createStop("Lauttasaari"));
        Mockito.when(data.getStop("Ruoholahti")).thenReturn(createStop("Ruoholahti"));
        Mockito.when(data.getStop("Erottaja")).thenReturn(createStop("Erottaja"));
        Mockito.when(data.getStop("Hietaranta")).thenReturn(createStop("Hietaranta"));
        optimalroute.addConnection(connection1);
        optimalroute.addConnection(connection2);
        optimalroute.addConnection(connection3);
        optimalroute.setTravelTimes(20034, 203000);
        optimalroute.setMapdata(data);
        assertEquals(optimalroute.toUiString(), "<html> [Erottaja Erottaja klo 56:13 - "
                + "Hietaranta Hietaranta klo 56:23] reitti: 24<br>  [Ruoholahti Ruoholahti "
                + "klo 5:35 - Erottaja Erottaja klo 56:6] reitti: 20<br>  [Lauttasaari "
                + "Lauttasaari klo 5:33 - Ruoholahti Ruoholahti klo 5:34] reitti: 21<br>  "
                + "on time 50:49</html>");
    }

    public Stop createStop(String id) {
        Stop stop = new Stop();
        stop.setGtfsId(id);
        stop.setName(id);
        return stop;
    }
}
