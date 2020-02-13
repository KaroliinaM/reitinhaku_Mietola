/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import api.ExecuteQuery;
import data.Stop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import ui.FinderUI;
import utils.DistanceCalculator;

/**
 * step 1: Comment all the other code out, except the lines 26 and 27, 
 *         this will download the data from digitransit api, and save it locally..
 *         Takes about 10 minutes, sorry :(
 * step 2: Comment the line 30 out, and uncomment the rest. The data is now loaded from a file.
 *         comment out either lines 39 and 40, the the application uses Dijkstra, or line 38, 
 *         then a* is used. UI implementation is on it's way
 * @author k
 */
public class RouteFinderApp {
    
    public void run() {
        ExecuteQuery query = new ExecuteQuery();
        // query.saveStopData();
        Map<String, Stop> stopdata = query.loadStopData();
        System.out.println("haettu");
        Mapdata maps = new Mapdata();
        DistanceCalculator calculator = new DistanceCalculator();
        List<Stop> stops = new ArrayList<>(stopdata.values());
        maps.setStops(stops);
        DijkstraRoutefinder finder = new DijkstraRoutefinder();
        //    AstarRouteFinder finder = new AstarRouteFinder();
        //      finder.setDistanceCalculator(calculator);
        finder.setMapdata(maps);        
        FinderUI ui = new FinderUI();
        ui.setAlgorithm(finder);
        ui.runUI();
        //  finder.search("HSL:1434114", "HSL:1453114", 23520); 
    }
    
}
