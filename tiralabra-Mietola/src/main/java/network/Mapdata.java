/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.*;
import data.Stop;

/**
 *
 * @author k
 */
public class Mapdata {
    
    private Map<String, Stop> stops=new HashMap();
    
    /**
    * Sets the stop data fetched from api to hashmap 
    * @param stopData List of stops
    */
    public void setStops(List<Stop> stopData) {
        for(Stop s: stopData) {
            stops.put(s.getGtfsId(), s);
        }
    }
    
    /**
     * Get a stop by stop id
     * @param id stop identificator
     * @return stop object
     */
    public Stop getStop(String id) {
        return stops.get(id);
    }
    
    
}
