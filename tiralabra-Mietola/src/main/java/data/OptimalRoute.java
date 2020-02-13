/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import network.Mapdata;

/**
 * the data that is derived from the algorithm is stored in this.
 *
 * @author k
 */
public class OptimalRoute {

    private List<Connection> connections = new ArrayList<>();
    Mapdata mapdata;
    private int time = 0;

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
    }

    public void addConnection(Connection c) {
        connections.add(c);
    }

    public void addTime(int t) {
        time += t;
    }

    public int getTime() {
        return time;
    }

    public List<Connection> getConnections() {
        Collections.reverse(connections);
        return connections;
    }

    /**
     * Format output to be presented to UI.
     *
     * @return html String.
     */
    public String toUiString() {
        //Collections.reverse(connections);

        String ret = "<html>";
        for (Connection c : connections) {
            ret += " [" + c.getDepartureStop() + " "
                    + mapdata.getStop(c.getDepartureStop()).getName() + " - " + c.getTargetStop()
                    + " " + mapdata.getStop(c.getTargetStop()).getName() + "] reitti: " 
                    + c.getRouteName() + "<br> ";
        }
        ret += " on time " + time + "</html>";
        return ret;
    }

    public String toString() {
        Collections.reverse(connections);
        String ret = "";
        for (Connection c : connections) {
            ret += " [" + c.getDepartureStop() + " - " + c.getTargetStop() + "] ";
        }
        ret += " on time " + time;
        return ret;
    }

}
