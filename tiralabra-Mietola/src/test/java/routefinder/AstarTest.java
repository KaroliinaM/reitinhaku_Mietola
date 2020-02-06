/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routefinder;

import data.Connection;
import data.OptimalRoute;
import data.Stop;
import java.util.*;
import network.Mapdata;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import utils.DistanceCalculator;

/**
 *
 * @author k
 */
public class AstarTest {
    AstarRouteFinder finder;
    Stop stop1;
    Stop stop2;
    Stop stop3;
    Stop stop4;
    Stop stop5;
    Stop stop6;
    Stop stop7;
    Stop stop8;
    Stop stop9;
    Stop stop10;
    Stop stop11;
    Stop stop12;
    public AstarTest() {
    }
    
    @Before
    public void setUp() {
        finder=new AstarRouteFinder();
        Mapdata mapdata=createMapdata();
        finder.setMapdata(mapdata);
    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void testRoute1() {
         DistanceCalculator calculator=Mockito.mock(DistanceCalculator.class);
         finder.setDistanceCalculator(calculator);
         OptimalRoute route =finder.search("stop1", "stop5"); 
         assertEquals(route.getTime(), 35);
     }
     
     @Test
      public void testRoute2() {
         DistanceCalculator calculator=Mockito.mock(DistanceCalculator.class);

         Mockito.when(calculator.timeEstimate(stop7, stop5)).thenReturn(15);

         finder.setDistanceCalculator(calculator);
         OptimalRoute route =finder.search("stop1", "stop5");
         assertEquals(route.getTime(), 36);         
     }
     @Test
      public void testRoute3() {
         DistanceCalculator calculator=Mockito.mock(DistanceCalculator.class);
         Mockito.when(calculator.timeEstimate(stop8, stop5)).thenReturn(15);
         finder.setDistanceCalculator(calculator);
         OptimalRoute route =finder.search("stop1", "stop5");
         assertEquals(route.getTime(), 40);
     }     
     
     
     public Mapdata createMapdata() {
         Mapdata reitit=Mockito.mock(Mapdata.class);
         Connection connection1=new Connection("stop1", "stop2", 10);
         Connection connection2=new Connection("stop1", "stop6", 10);
         Connection connection3=new Connection("stop1", "stop9", 20);
         Connection connection4=new Connection("stop1", "stop11", 10);
         Connection connection5=new Connection("stop2", "stop3", 10);
         Connection connection6=new Connection("stop3", "stop4", 10);
         Connection connection7=new Connection("stop4", "stop5", 10);
         Connection connection8=new Connection("stop6", "stop7", 10);
         Connection connection9=new Connection("stop7", "stop8", 10);
         Connection connection10=new Connection("stop8", "stop5", 5);
         Connection connection11=new Connection("stop9", "stop10", 5);
         Connection connection12=new Connection("stop10", "stop8", 6);
         Connection connection13=new Connection("stop11", "stop12", 10);
         Connection connection14=new Connection("stop12", "stop3", 10);
         stop1= createStop("stop1", "stop1", Arrays.asList(connection1, connection2, connection3));
         stop2= createStop("stop2", "stop2", Arrays.asList(connection5));
         stop3= createStop("stop3", "stop3", Arrays.asList(connection6));
         stop4= createStop("stop4", "stop4", Arrays.asList(connection7));
         stop5= createStop("stop5", "stop5", Arrays.asList());
         stop6= createStop("stop6", "stop6", Arrays.asList(connection8));
         stop7= createStop("stop7", "stop7", Arrays.asList(connection9));
         stop8= createStop("stop8", "stop8", Arrays.asList(connection10));
         stop9= createStop("stop9", "stop9", Arrays.asList(connection11));
         stop10= createStop("stop10", "stop10", Arrays.asList(connection12));
         stop11= createStop("stop11", "stop11", Arrays.asList(connection13));
         stop12= createStop("stop12", "stop12", Arrays.asList(connection14));
         Mockito.when(reitit.getStop("stop1")).thenReturn(stop1);
         Mockito.when(reitit.getStop("stop2")).thenReturn(stop2);
         Mockito.when(reitit.getStop("stop3")).thenReturn(stop3);
         Mockito.when(reitit.getStop("stop4")).thenReturn(stop4);
         Mockito.when(reitit.getStop("stop5")).thenReturn(stop5);
         Mockito.when(reitit.getStop("stop6")).thenReturn(stop6);
         Mockito.when(reitit.getStop("stop7")).thenReturn(stop7);
         Mockito.when(reitit.getStop("stop8")).thenReturn(stop8);
         Mockito.when(reitit.getStop("stop9")).thenReturn(stop9);
         Mockito.when(reitit.getStop("stop10")).thenReturn(stop10);
         Mockito.when(reitit.getStop("stop11")).thenReturn(stop11);
         Mockito.when(reitit.getStop("stop12")).thenReturn(stop12);
        return reitit;
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
}
