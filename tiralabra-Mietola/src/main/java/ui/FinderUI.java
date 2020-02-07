/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import api.ExecuteQuery;
import data.Stop;
import java.util.*;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DjikstraRoutefinder;
import utils.DistanceCalculator;

/**
 *
 * @author k
 */
public class FinderUI {

    /**
     * Doesn't work as UI, because cmd readers don't work. Going to look into it
     * next week. Gets the data, sets it into the map and then does the search.
     * Prints out only the stop id:s, got to make it more informative.
     */
    public void run() {
        ExecuteQuery query = new ExecuteQuery();
        //  query.saveStopData();
        Map<String, Stop> stopdata = query.loadStopData();
        System.out.println("haettu");
        Mapdata maps = new Mapdata();
        DistanceCalculator calculator = new DistanceCalculator();
        List<Stop> stops = new ArrayList<Stop>(stopdata.values());
        maps.setStops(stops);
        // DjikstraRoutefinder finder=new DjikstraRoutefinder();
        AstarRouteFinder finder = new AstarRouteFinder();
        finder.setDistanceCalculator(calculator);
        finder.setMapdata(maps);
        finder.search("HSL:1434114", "HSL:1453114", 0);
    }
    
}
