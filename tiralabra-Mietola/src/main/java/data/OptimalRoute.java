/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import datastructures.MyArrayList;
import java.util.*;
import network.Mapdata;

/**
 * the data for the route that is derived from the algorithm is stored in here.
 *
 * @author k
 */
public class OptimalRoute {

    //private List<Connection> connections = new ArrayList<>();
    private MyArrayList connections = new MyArrayList();
    Mapdata mapdata;
    private int time = 0;
    private boolean exist = true;

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
    }

    public void addConnection(Connection c) {
        connections.insertObject(c);
    }

    public void addTime(int t) {
        time += t;
    }

    public int getTime() {
        return time;
    }

    public MyArrayList getConnections() {
        //Collections.reverse(connections);
        connections.reverseObject();
        return connections;
    }

    public void setNonexistent() {
        this.exist = false;
    }

    public boolean getIfExists() {
        return exist;
    }

    /**
     * Format output to be presented to UI.
     *
     * @return html String.
     */
    public String toUiString() {
        //Collections.reverse(connections);

        String ret = "<html>";
        for (int i = 0; i < connections.returnObjLength(); i++) {
            Connection c = (Connection) connections.getObject(i);
            ret += " [" + c.getDepartureStop() + " "
                    + mapdata.getStop(c.getDepartureStop()).getName() + " - " + c.getTargetStop()
                    + " " + mapdata.getStop(c.getTargetStop()).getName() + "] reitti: "
                    + c.getRouteName() + "<br> ";
        }
        ret += " on time " + time + "</html>";
        return ret;
    }

    public String toString() {
        connections.reverseObject();
        String ret = "";
        for (int i = 0; i < connections.returnObjLength(); i++) {
            Connection c = (Connection) connections.getObject(i);
            ret += " [" + c.getDepartureStop() + " - " + c.getTargetStop() + "] ";
        }
        ret += " on time " + time;
        return ret;
    }

}
