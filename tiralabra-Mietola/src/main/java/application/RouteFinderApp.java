/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import api.ExecuteQuery;
import data.OptimalRoute;
import data.Stop;
import datastructures.MyArrayList;
import java.util.HashMap;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import ui.FinderUI;
import utils.DistanceCalculator;
import utils.PerformanceTest;

/**
 * step 1: Comment all the other code out, except the lines 26 and 27, this will
 * download the data from digitransit api, and save it locally.. Takes about 10
 * minutes, sorry :( step 2: Comment the line 30 out, and uncomment the rest.
 * The data is now loaded from a file. ui works only with dijkstra yet
 *
 * @author k
 */
public class RouteFinderApp {

    public void run() {
        ExecuteQuery query = new ExecuteQuery();
     //   query.saveStopData();
        Map<String, Stop> stopdata = query.loadStopData();
        System.out.println("haettu");
        Mapdata maps = new Mapdata();
        DistanceCalculator calculator = new DistanceCalculator();
        //    List<Stop> stops = new ArrayList<>(stopdata.values());
        MyArrayList stops = new MyArrayList();
        HashMap<String, Stop> stopNames = new HashMap();
        for (Stop s : stopdata.values()) {
            stops.insertObject(s);
            stopNames.put(s.getGtfsId() + " " + s.getName(), s);
        }
        maps.setStops(stops);
        DijkstraRoutefinder dikstrafinder = new DijkstraRoutefinder();
        AstarRouteFinder astarfinder = new AstarRouteFinder();
        astarfinder.setDistanceCalculator(calculator);
        dikstrafinder.setMapdata(maps);
        astarfinder.setMapdata(maps);
        PerformanceTest test = new PerformanceTest();
        test.setData(dikstrafinder, astarfinder, stops);
      //   test.run();

        FinderUI ui = new FinderUI();
        ui.setAlgorithms(dikstrafinder, astarfinder);
        ui.runUI(stopNames, stops, test);
       // OptimalRoute route=astarfinder.search("HSL:6050208", "HSL:9204213", 0); 
       // OptimalRoute route=dikstrafinder.search("HSL:6050208", "HSL:9204213", 0);
       // System.out.println(route.toString());**/
    }

}
