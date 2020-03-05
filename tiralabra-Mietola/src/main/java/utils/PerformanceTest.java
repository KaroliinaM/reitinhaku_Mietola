/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;
import data.Connection;
import data.OptimalRoute;
import data.Stop;
import datastructures.MyArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;

/**
 * It's a start.
 *
 * @author k
 */
public class PerformanceTest {

    DijkstraRoutefinder dijkstrafinder;
    AstarRouteFinder astarfinder;
    MyArrayList stopdata;
    Mapdata mapdata = new Mapdata();
    int routesTotest = 70;
    int timesForRoute = 10;
    int pointer = 0;

    Stop[] starts = new Stop[routesTotest];
    Stop[] goals = new Stop[routesTotest];
    TreeMap<Double, Double> dijkstraByDistance = new TreeMap<>();
    TreeMap<Double, Double> astarByDistance = new TreeMap<>();
    TreeMap<Integer, Double> dijkstraByStops = new TreeMap<>();
    TreeMap<Integer, Double> astarByStops = new TreeMap<>();
    ArrayList<String> distances = new ArrayList<>();
    DistanceCalculator calculator;

    public void setData(DijkstraRoutefinder finder, AstarRouteFinder astarfinder,
            MyArrayList stopdata) {
        this.dijkstrafinder = finder;
        this.astarfinder = astarfinder;
        this.stopdata = stopdata;
    }

    public void run() {
        System.out.println("testataan...");
        int n = stopdata.returnObjLength();
        calculator = new DistanceCalculator();
        astarfinder.setDistanceCalculator(calculator);

        Random random = new Random(1337);
        for (int i = 0; i < routesTotest; i++) {
            Stop beg = (Stop) stopdata.getObject(random.nextInt(n));
            Stop end = (Stop) stopdata.getObject(random.nextInt(n));
            mapdata.setStops(stopdata);
            dijkstrafinder.setMapdata(mapdata);
            OptimalRoute route = dijkstrafinder.search(beg.getGtfsId(), end.getGtfsId(), 0);
            if (!route.getIfExists()) {
                continue;
            }
            starts[pointer] = beg;
            goals[pointer] = end;
            pointer++;
            //      double distance = calculator.distFrom(beg.getLat(), beg.getLon(), 
            //              end.getLat(), end.getLon());

        }
        for (int i = 0; i < pointer; i++) {
            getDjikstraRouteTime(starts[i], goals[i]);
            getAstarRouteTime(starts[i], goals[i]);
        }
        for (Map.Entry<Double, Double> entry : this.dijkstraByDistance.entrySet()) {
            System.out.println("Dijkstralla etäisyys " + entry.getKey() + " ajassa " 
                    + entry.getValue());
        }
        for (Map.Entry<Double, Double> entry : this.astarByDistance.entrySet()) {
            System.out.println("Astarilla etäisyys " + entry.getKey() + " ajassa " 
                    + entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : this.dijkstraByStops.entrySet()) {
            System.out.println("Dijkstralla pysäkit " + entry.getKey() + " ajassa " 
                    + entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : this.astarByStops.entrySet()) {
            System.out.println("Astarilla pysäkit " + entry.getKey() + " ajassa " + 
                    entry.getValue());
        }
        System.out.println("distances");
        for (String s : distances) {
            System.out.println(s);
        }

        /**
         * int pointer10 = 0; int pointer20 = 0; int pointer30 = 0; int
         * pointer30ab = 0;
         *
         * Stop[] under10starts = new Stop[30]; Stop[] under10goals = new
         * Stop[30]; Stop[] under20starts = new Stop[30]; Stop[] under20goals =
         * new Stop[30]; Stop[] under30starts = new Stop[30]; Stop[]
         * under30goals = new Stop[30]; Stop[] above30starts = new Stop[30];
         * Stop[] above30goals = new Stop[30]; String[] dijkstraresult = new
         * String[routesTotest]; String[] astarresult = new
         * String[routesTotest]; DistanceCalculator calculator = new
         * DistanceCalculator();
         *
         * Random random = new Random(1337); for (int i = 0; i < routesTotest;
         * i++) { Stop beg = (Stop) stopdata.getObject(random.nextInt(n)); Stop
         * end = (Stop) stopdata.getObject(random.nextInt(n));
         * mapdata.setStops(stopdata); dijkstrafinder.setMapdata(mapdata);
         * OptimalRoute route = dijkstrafinder.search(beg.getGtfsId(),
         * end.getGtfsId(), 0); if (!route.getIfExists()) { continue; } double
         * distance = calculator.distFrom(beg.getLat(), beg.getLon(),
         * end.getLat(), end.getLon()); if (distance < 10000) {
         * if (pointer10 > 29) { continue; } under10starts[pointer10] = beg;
         * under10goals[pointer10] = end; pointer10++; } else if (distance
         * < 20000) {
         * if (pointer20 > 29) { continue; } under20starts[pointer20] = beg;
         * under20goals[pointer20] = end; pointer20++; } else if (distance
         * < 30000) {
         * if (pointer30 > 29) { continue; } under30starts[pointer30] = beg;
         * under30goals[pointer30] = end; pointer30++; } else { if (pointer30ab
         * > 29) { continue; } above30starts[pointer30ab] = beg;
         * above30goals[pointer30ab] = end; pointer30ab++; } }
         * System.out.println("under 10 " + pointer10 + "under 20 " + pointer20
         * + "under 30 " + pointer30 + "above 30 " + pointer30ab);
         * testDistance(pointer10, under10starts, under10goals, dijkstraresult,
         * astarresult); testDistance(pointer20, under20starts, under20goals,
         * dijkstraresult, astarresult); testDistance(pointer30, under30starts,
         * under30goals, dijkstraresult, astarresult); testDistance(pointer30ab,
         * above30starts, above30goals, dijkstraresult, astarresult);*
         */
    }

    public void testDistance(int pointer, Stop[] starts, Stop[] goals,
            String[] dijkstraresult, String[] astarresult) {
        for (int i = 0; i < pointer; i++) {
            System.out.println(i);

            //        dijkstraresult[i] = getDjikstraRouteTime(starts[i], goals[i]);
        }
        for (int i = 0; i < pointer; i++) {
            System.out.println(dijkstraresult[i]);
        }

        for (int i = 0; i < pointer; i++) {
            System.out.println(i);
            //         astarresult[i] = getAstarRouteTime(starts[i], goals[i]);

        }
        for (int i = 0; i < pointer; i++) {
            System.out.println(astarresult[i]);
        }

    }

    public void getDjikstraRouteTime(Stop start, Stop end) {
        long t = 0;
        OptimalRoute route = null;
        for (int j = 0; j < timesForRoute; j++) {
            mapdata.setStops(stopdata);
            dijkstrafinder.setMapdata(mapdata);
            long alku = System.nanoTime();
            route = dijkstrafinder.search(start.getGtfsId(), end.getGtfsId(), 0);
            long loppu = System.nanoTime();
            t += (loppu - alku);
        }
        double distance = calculator.distFrom(start.getLat(), start.getLon(),
                end.getLat(), end.getLon());
        dijkstraByDistance.put(distance, (t / timesForRoute) / 1e9);
        dijkstraByStops.put(route.getConnections().returnObjLength(), distance);
        distances.add(String.valueOf(route.getTravelTime()) + " " + start.getGtfsId() 
                + " " + end.getGtfsId());
        System.out.println("dijkstra " + (t / timesForRoute) / 1e9);

        //    return (t / timesForRoute) / 1e9;
    }

    public void getAstarRouteTime(Stop start, Stop end) {
        long t = 0;
        OptimalRoute route = null;
        for (int j = 0; j < timesForRoute; j++) {
            mapdata.setStops(stopdata);
            astarfinder.setMapdata(mapdata);
            long alku = System.nanoTime();
            route = astarfinder.search(start.getGtfsId(), end.getGtfsId(), 0);
            long loppu = System.nanoTime();
            t += (loppu - alku);
        }
        double distance = calculator.distFrom(start.getLat(), start.getLon(),
                end.getLat(), end.getLon());
        astarByDistance.put(distance, (t / timesForRoute) / 1e9);
        this.astarByStops.put(route.getConnections().returnObjLength(), 
                (t / timesForRoute) / 1e9);
        System.out.println("astar " + (t / timesForRoute) / 1e9);
        distances.add(String.valueOf(route.getTravelTime()));
        // return (t / timesForRoute) / 1e9;
    }

}
