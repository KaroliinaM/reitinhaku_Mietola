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
 * The application, that collects the data and starts the program.
 *
 * @author k
 */
public class RouteFinderApp {

    public void run() {
        ExecuteQuery query = new ExecuteQuery();
        Map<String, Stop> stopdata = query.loadStopData();
        if (stopdata != null) {
            System.out.println("haettu");
            Mapdata maps = new Mapdata();
            DistanceCalculator calculator = new DistanceCalculator();
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

            FinderUI ui = new FinderUI();
            ui.setAlgorithms(dikstrafinder, astarfinder);
            ui.runUI(stopNames, stops, test);
        }
    }

}
