/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routefinder;

import data.Connection;
import data.OptimalRoute;
import data.Stop;
import java.util.*;
import network.Mapdata;
import utils.DistanceCalculator;

/**
 *
 * @author k
 */
public class AstarRouteFinder {

    PriorityQueue<Stop> queue = new PriorityQueue();
    HashSet<String> done = new HashSet<>();
    Mapdata mapdata;
    private OptimalRoute route = new OptimalRoute();
    DistanceCalculator distancecalculator;

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
    }

    public void setDistanceCalculator(DistanceCalculator distancecalculator) {
        this.distancecalculator = distancecalculator;
    }

    public OptimalRoute search(String start, String goal, int time) {
        Stop beginning = mapdata.getStop(start);
        Stop destination = mapdata.getStop(goal);
        beginning.setEstimate(0);
        queue.add(beginning);
        while (!queue.isEmpty()) {
            Stop s = queue.poll();
            System.out.println("solmu " + s.getName() + " " + s.getEstimate());
            if (done.contains(s.getGtfsId())) {
                continue;
            }
            done.add(s.getGtfsId());
            if (s.getEstimate() > time) {
                time = s.getEstimate();
            }
            List<Connection> edges = s.getConnections();
            for (Connection e : edges) {
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
