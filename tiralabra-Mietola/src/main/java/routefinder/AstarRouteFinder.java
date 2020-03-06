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

    StopHeap queue;
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
        beginning.setEstimate(time);
        beginning.setEstimatedDistance(distancecalculator.timeEstimate(beginning, destination));
        queue.add(beginning);
        while (!queue.isEmpty()) {
            Stop s = queue.poll();
            if (done.contains(s.getGtfsId())) {
                continue;
            }
            if (s.getGtfsId().equals(goal)) {
                break;
            }
            done.add(s.getGtfsId());
            if (s.getEstimate() > mapdata.getStop(goal).getEstimate()) {
                continue;
            }
            time = s.getEstimate() - s.getEstimatedDistance();
            MyArrayList edges = s.getConnections();
            Connection e = null;
            for (int i = 0; i < edges.returnObjLength(); i++) {
                e = (Connection) edges.getObject(i);
                if (e.getDepartureTime() < time) {
                    continue;
                }
                Stop t = mapdata.getStop(e.getTargetStop());
                int currentDistance = t.getEstimate();
                if (t.getEstimatedDistance() < 0) {
                    int heuristictime = distancecalculator.timeEstimate(t, destination);
                    t.setEstimatedDistance(heuristictime);
                }
                int newDistance = e.getArrivalTime() + t.getEstimatedDistance();
                if (newDistance < currentDistance) {
                    t.setEstimate(newDistance);
                    t.setPrevious(e);
                    queue.add(t);
                }
            }

        }
        Stop stop = mapdata.getStop(goal);
        route.setTravelTimes(beginning.getEstimate(), stop.getEstimate());
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
