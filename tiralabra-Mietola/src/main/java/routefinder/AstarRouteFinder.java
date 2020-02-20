/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routefinder;

import java.util.*;
import data.Connection;
import data.OptimalRoute;
import data.Stop;
import datastructures.MyArrayList;
import datastructures.MyHashSet;
import datastructures.StopHeap;
import network.Mapdata;
import utils.DistanceCalculator;
import utils.HashFunction;

/**
 *
 * @author k
 */
public class AstarRouteFinder {

    // PriorityQueue<Stop> queue = new PriorityQueue();
    StopHeap queue;
    // HashSet<String> done = new HashSet<>();
    MyHashSet done;
    Mapdata mapdata;
    private OptimalRoute route;
    DistanceCalculator distancecalculator;

    public void setMapdata(Mapdata mapdata) {
        route = new OptimalRoute();
        this.mapdata = mapdata;
        route.setMapdata(mapdata);
    }

    public void setDistanceCalculator(DistanceCalculator distancecalculator) {
        this.distancecalculator = distancecalculator;
    }

    public OptimalRoute search(String start, String goal, int time) {
        queue = new StopHeap();
        done = new MyHashSet(new HashFunction());
        Stop beginning = mapdata.getStop(start);
        Stop destination = mapdata.getStop(goal);
        beginning.setEstimate(0);
        queue.add(beginning);
        while (!queue.isEmpty()) {
            Stop s = queue.poll();
            //        System.out.println("solmu " + s.getName() + " " + s.getEstimate());
            if (done.contains(s.getGtfsId())) {
                continue;
            }
            done.add(s.getGtfsId());
            if (s.getEstimate() > time) {
                time = s.getEstimate();
            }
            //  List<Connection> edges = s.getConnections();
            MyArrayList edges = s.getConnections();
            //for (Connection e : edges) {
            Connection e = null;
            for (int i = 0; i < edges.returnObjLength(); i++) {
                e = (Connection) edges.getObject(i);
                if (e.getDepartureTime() < time) {
                    continue;
                }
                Stop t = mapdata.getStop(e.getTargetStop());
                int currentDistance = t.getEstimate();
                int heuristictime = distancecalculator.timeEstimate(t, destination);
                int newDistance = e.getArrivalTime() + heuristictime;
                if (newDistance < currentDistance) {
                    t.setEstimate(newDistance);
                    t.setPrevious(e);
                    queue.add(t);
                }
            }

        }
        Stop stop = mapdata.getStop(goal);
        route.addTime(stop.getEstimate());
        while (!stop.getGtfsId().equals(start)) {
            Connection c = stop.getPrevious();
            if (c == null) {
                route.setNonexistent();
                break;
            }
            route.addConnection(c);
            stop = mapdata.getStop(c.getDepartureStop());
        }
        return route;
    }

}
