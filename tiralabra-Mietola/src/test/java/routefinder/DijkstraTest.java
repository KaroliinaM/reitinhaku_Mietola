/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routefinder;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.*;
import data.Connection;
import data.OptimalRoute;
import data.Stop;
import network.Mapdata;

/**
 *
 * @author k
 */
public class DijkstraTest {

    DijkstraRoutefinder finder;
    DijkstraRoutefinder finder2;
    Connection conn1 = new Connection("stop1", "stop2", 0, 20, "0");
    Connection conn2 = new Connection("stop1", "stop3", 0, 21, "0");
    Connection conn3 = new Connection("stop1", "stop4", 0, 50, "0");
    Connection conn4 = new Connection("stop4", "stop3", 48, 63, "0");
    Connection conn5 = new Connection("stop2", "stop6", 20, 30, "0");
    Connection conn6 = new Connection("stop6", "stop5", 30, 37, "0");
    Connection conn7 = new Connection("stop5", "stop2", 37, 39, "0");
    Connection conn8 = new Connection("stop5", "stop8", 37, 46, "0");
    Connection conn9 = new Connection("stop5", "stop7", 37, 45, "0");
    Connection conn10 = new Connection("stop8", "stop6", 46, 52, "0");
    Connection conn11 = new Connection("stop7", "stop4", 45, 48, "0");
    Connection conn12 = new Connection("stop3", "stop5", 21, 38, "0");
    Connection conn13 = new Connection("stop8", "stop9", 46, 48, "0");
    Connection conn14 = new Connection("stop1", "stop9", 0, 50, "0");
    Stop stop1 = createStop("stop1", "stop1", Arrays.asList(conn1, conn2, conn3, conn14));
    Stop stop2 = createStop("stop2", "stop2", Arrays.asList(conn5));
    Stop stop3 = createStop("stop3", "stop3", Arrays.asList(conn12));
    Stop stop4 = createStop("stop4", "stop4", Arrays.asList(conn4));
    Stop stop5 = createStop("stop5", "stop5", Arrays.asList(conn7, conn8, conn9));
    Stop stop6 = createStop("stop6", "stop6", Arrays.asList(conn6));
    Stop stop7 = createStop("stop7", "stop7", Arrays.asList(conn11));
    Stop stop8 = createStop("stop8", "stop8", Arrays.asList(conn10, conn13));
    Stop stop9 = createStop("stop9", "stop9", Arrays.asList());

    Stop stop11 = createStop("stop11", "stop11", myltiplyConnections(Arrays.asList(
                    new Connection("stop11", "stop12", 0, 5, "0"),
                    new Connection("stop11", "stop13", 0, 18, "0"), 
                    new Connection("stop11", "stop14", 0, 20, "0"))));
    Stop stop12 = createStop("stop12", "stop12", myltiplyConnections(Arrays.asList(
            new Connection("stop12", "stop15", 0, 4, "0"))));
    Stop stop13 = createStop("stop13", "stop13", myltiplyConnections(Arrays.asList(
            new Connection("stop13", "stop17", 0, 1, "0"))));
    Stop stop14 = createStop("stop14", "stop14", Arrays.asList());
    Stop stop15 = createStop("stop15", "stop15", myltiplyConnections(Arrays.asList(
            new Connection("stop15", "stop16", 0, 4, "0"))));
    Stop stop16 = createStop("stop16", "stop16", myltiplyConnections(Arrays.asList(
            new Connection("stop16", "stop12", 0, 1, "0"))));
    Stop stop17 = createStop("stop17", "stop17", myltiplyConnections(Arrays.asList(
            new Connection("stop17", "stop16", 0, 3, "0"), 
            new Connection("stop17", "stop14", 0, 1, "0"), 
            new Connection("stop17", "stop14", 0, 1, "0"))));

    public DijkstraTest() {
    }

    @Before
    public void setUp() {
        Mapdata mapdata = Mockito.mock(Mapdata.class);
        Mockito.when(mapdata.getStop("stop1")).thenReturn(stop1);
        Mockito.when(mapdata.getStop("stop2")).thenReturn(stop2);
        Mockito.when(mapdata.getStop("stop3")).thenReturn(stop3);
        Mockito.when(mapdata.getStop("stop4")).thenReturn(stop4);
        Mockito.when(mapdata.getStop("stop5")).thenReturn(stop5);
        Mockito.when(mapdata.getStop("stop6")).thenReturn(stop6);
        Mockito.when(mapdata.getStop("stop7")).thenReturn(stop7);
        Mockito.when(mapdata.getStop("stop8")).thenReturn(stop8);
        Mockito.when(mapdata.getStop("stop9")).thenReturn(stop9);
        finder = new DijkstraRoutefinder();
        finder.setMapdata(mapdata);
        Mapdata mapdata2 = Mockito.mock(Mapdata.class);
        Mockito.when(mapdata2.getStop("stop11")).thenReturn(stop11);
        Mockito.when(mapdata2.getStop("stop12")).thenReturn(stop12);
        Mockito.when(mapdata2.getStop("stop13")).thenReturn(stop13);
        Mockito.when(mapdata2.getStop("stop14")).thenReturn(stop14);
        Mockito.when(mapdata2.getStop("stop15")).thenReturn(stop15);
        Mockito.when(mapdata2.getStop("stop16")).thenReturn(stop16);
        Mockito.when(mapdata2.getStop("stop17")).thenReturn(stop17);
        finder2 = new DijkstraRoutefinder();
        finder2.setMapdata(mapdata2);
    }

    @After
    public void tearDown() {
    }
    

    @Test
    public void testRoute() {
        OptimalRoute r = finder.search("stop1", "stop7", 0);
        assertEquals(r.getTime(), 45);
    }

    @Test
    public void testRoute3() {
        OptimalRoute r = finder.search("stop1", "stop9", 0);
        assertEquals(r.getTime(), 48);
        //48
    }

    @Test
    public void testRoute4() {
        OptimalRoute r = finder.search("stop1", "stop4", 0);
        assertEquals(r.getTime(), 48);
        //48
    }

    @Test
    public void testRoute5() {
        OptimalRoute r = finder2.search("stop11", "stop17", 0);
        assertEquals(r.getTime(), 21);
        //  finder2.search("stop11", "stop15", 0);
    }

    @Test
    public void testRoute6() {
        OptimalRoute r = finder2.search("stop11", "stop13", 0);
        assertEquals(r.getTime(), 18);
    }

    public Stop createStop(String gtfsId, String name, List<Connection> connections) {
        Stop stop = new Stop();
        stop.setGtfsId(gtfsId);
        stop.setName(name);
        stop.setEstimate(1999999999);
        connections.stream().forEach((c) -> {
            stop.addConnection(c);
        });
        return stop;
    }

    public List<Connection> myltiplyConnections(List<Connection> connections) {
        List<Connection> ret = new ArrayList<>();
        for (Connection c : connections) {
            for (int i = 0; i <= 30; i += 10) {
                Connection conn = new Connection(c.getDepartureStop(), c.getTargetStop(), 
                        c.getDepartureTime() + i, c.getArrivalTime() + i, "0");
                ret.add(conn);
            }
        }
        return ret;
    }
}
