/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.*;
import data.Stop;
import datastructures.MyArrayList;
import datastructures.MyHashMap;
import utils.HashFunction;

/**
 *
 * @author k
 */
public class Mapdata {

    //private Map<String, Stop> stops = new HashMap();
    private MyHashMap stops = new MyHashMap(new HashFunction());

    /**
     * Sets the stop data fetched from api to hashmap. Separate class, because
     * the search modifies the estimates , and the data can be reseted by
     * re-fetching
     *
     * @param stopData List of stops
     */
    public void setStops(MyArrayList stopData) {
        for (int i = 0; i < stopData.returnObjLength(); i++) {
            Stop s = (Stop) stopData.getObject(i);
            s.setEstimate(1999999999);
            stops.put(s.getGtfsId(), s);
        }
    }

    /**
     * Get a stop by stop id.
     *
     * @param id stop identificator
     * @return stop object
     */
    public Stop getStop(String id) {
        return stops.get(id);
    }

}
