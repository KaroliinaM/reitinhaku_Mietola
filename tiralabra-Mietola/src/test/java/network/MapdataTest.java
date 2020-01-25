/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import data.Stop;

/**
 *
 * @author k
 */
public class MapdataTest {
    Mapdata mapdata;
    public MapdataTest() {
    }
    
    
    @Before
    public void setUp() {
      mapdata=new Mapdata();
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addStopsTest() {
         List<Stop> stops=new ArrayList<>();
         Stop stop=new Stop();
         stop.setGtfsId("123456");
         stop.setName("Pasila");
         stops.add(stop);
         mapdata.setStops(stops);
         assertEquals(mapdata.getStop("123456").getName(), "Pasila");
         
         
     }
}
