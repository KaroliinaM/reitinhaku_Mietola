/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.*;
import reittiopas.Stop;

/**
 *
 * @author k
 */
public class Mapdata {
    
    private Map<String, Stop> stops=new HashMap();
   
    public void setStops(List<Stop> stopData) {
        for(Stop s: stopData) {
            stops.put(s.getGtfsId(), s);
        }
    } 
    
    
}
