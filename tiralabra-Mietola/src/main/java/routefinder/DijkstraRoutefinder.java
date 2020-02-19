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
import utils.HashFunction;

/**
 *
 * @author k
 */
public class DijkstraRoutefinder {

    //PriorityQueue<Stop> queue = new PriorityQueue();
    StopHeap queue = new StopHeap();
    //HashSet<String> done = new HashSet<>();
    MyHashSet done = new MyHashSet(new HashFunction());
    Mapdata mapdata;
    private OptimalRoute route = new OptimalRoute();

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
        route.setMapdata(mapdata);
    }

    /**
     * The Dijkstra search algorithm.
     *
     * @param start the starting point id
     * @param goal the target point id
     * @return Route object
     */
    public OptimalRoute search(String start, String goal, int time) {
        Stop beginning = mapdata.getStop(start);
        beginning.setEstimate(0);
        queue.add(beginning);
        while (!queue.isEmpty()) {
            Stop s = queue.poll();
            if (done.contains(s.getGtfsId())) {
                continue;
            }
            done.add(s.getGtfsId());
            if (s.getEstimate() > time) {
                time = s.getEstimate();
            }
            MyArrayList edges = s.getConnections();
            //   List<Connection> edges = s.getConnections();
            //   for (Connection e : edges) {
            Connection e = null;
            for (int i = 0; i < edges.returnObjLength(); i++) {
                e = (Connection) edges.getObject(i);
                if (e.getDepartureTime() < time) {
                    continue;
                }
                Stop t = mapdata.getStop(e.getTargetStop());
                int currentDistance = t.getEstimate();
                int newDistance = e.getArrivalTime();
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
        System.out.println("tulos");
        System.out.println(route);
        System.out.println(route.getTime());
        System.out.println(mapdata.getStop(goal).getEstimate());
        return route;
    }
}
