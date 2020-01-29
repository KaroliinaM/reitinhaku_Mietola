/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routefinder;

import data.Connection;
import data.Stop;
import java.util.*;
import network.Mapdata;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author k
 */
public class DjikstraTest {
    DjikstraRoutefinder finder;
    Connection conn1= new Connection("stop1", "stop2", 20);
    Connection conn2= new Connection("stop1", "stop3", 21);
    Connection conn3= new Connection("stop1", "stop4", 50);
    Connection conn4= new Connection("stop4", "stop3", 15);
    Connection conn5= new Connection("stop2", "stop6", 10);
    Connection conn6= new Connection("stop6", "stop5", 7);
    Connection conn7= new Connection("stop5", "stop2", 3);
    Connection conn8= new Connection("stop5", "stop8", 9);
    Connection conn9= new Connection("stop5", "stop7", 8);
    Connection conn10= new Connection("stop8", "stop6", 6);
    Connection conn11= new Connection("stop7", "stop4", 3);
    Connection conn12= new Connection("stop3", "stop5", 17);
    Connection conn13= new Connection("stop8", "stop9", 2);
    Connection conn14= new Connection("stop1", "stop9", 50);
    Stop stop1=createStop("stop1", "stop1", Arrays.asList(conn1, conn2, conn3, conn14));
    Stop stop2=createStop("stop2", "stop2", Arrays.asList(conn5));
    Stop stop3=createStop("stop3", "stop3", Arrays.asList(conn12));
    Stop stop4=createStop("stop4", "stop4", Arrays.asList(conn4));
    Stop stop5=createStop("stop5", "stop5", Arrays.asList(conn7, conn8, conn9));
    Stop stop6=createStop("stop6", "stop6", Arrays.asList(conn6));
    Stop stop7=createStop("stop7", "stop7", Arrays.asList(conn11));
    Stop stop8=createStop("stop8", "stop8", Arrays.asList(conn10, conn13));
    Stop stop9=createStop("stop9", "stop9", Arrays.asList());

    public DjikstraTest() {
    }
    
    @Before
    public void setUp() {
        Mapdata mapdata=Mockito.mock(Mapdata.class);
        Mockito.when(mapdata.getStop("stop1")).thenReturn(stop1);
        Mockito.when(mapdata.getStop("stop2")).thenReturn(stop2);
        Mockito.when(mapdata.getStop("stop3")).thenReturn(stop3);
        Mockito.when(mapdata.getStop("stop4")).thenReturn(stop4);
        Mockito.when(mapdata.getStop("stop5")).thenReturn(stop5);
        Mockito.when(mapdata.getStop("stop6")).thenReturn(stop6);
        Mockito.when(mapdata.getStop("stop7")).thenReturn(stop7);
        Mockito.when(mapdata.getStop("stop8")).thenReturn(stop8);
        Mockito.when(mapdata.getStop("stop9")).thenReturn(stop9);
        finder=new DjikstraRoutefinder();
        finder.setMapdata(mapdata);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testRoute() {
         finder.search("stop1", "stop7");
         //45
     }
     @Test
     public void testRoute2() {
         finder.search("stop5", "stop6");
         //13
     }
     
     @Test
     public void testRoute3() {
         finder.search("stop1", "stop9");
         //48
     }
          
     @Test
     public void testRoute4() {
         finder.search("stop1", "stop4");
         //48
     }
    
    public Stop createStop(String gtfsId, String name, List<Connection> connections) {
        Stop stop=new Stop();
        stop.setGtfsId(gtfsId);
        stop.setName(name);
        stop.setEstimate(1999999999);
        connections.stream().forEach((c) -> {
            stop.addConnection(c);
        });
        return stop;
    }
}
