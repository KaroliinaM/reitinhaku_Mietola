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
import network.Mapdata;

/**
 *
 * @author k
 */
public class DijkstraRoutefinder {

    PriorityQueue<Stop> queue = new PriorityQueue();
    HashSet<String> done = new HashSet<>();
    Mapdata mapdata;
    private OptimalRoute route = new OptimalRoute();

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
    }

    /**
     * The Djikstra search algorithm.
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
            List<Connection> edges = s.getConnections();
            for (Connection e : edges) {
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
