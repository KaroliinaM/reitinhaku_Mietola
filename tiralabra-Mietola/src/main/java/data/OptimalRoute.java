/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import datastructures.MyArrayList;
import network.Mapdata;

/**
 * the data for the route that is derived from the algorithm is stored in here.
 *
 * @author k
 */
public class OptimalRoute {

    private MyArrayList connections = new MyArrayList();
    Mapdata mapdata;
    private int travelTime = 0;
    private int departureTime = 0;
    private int arrivalTime = 0;
    private boolean exist = true;

    public void setMapdata(Mapdata mapdata) {
        this.mapdata = mapdata;
    }

    public void addConnection(Connection c) {
        connections.insertObject(c);
    }

    /**
     * @param departure}
     *
     * @param arrival
     */
    public void setTravelTimes(int departure, int arrival) {
        this.departureTime = departure;
        this.arrivalTime = arrival;
        this.travelTime = arrivalTime - departureTime;
    }

    public int getTravelTime() {
        return travelTime;
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
        if (!exist) {
            return "Reittiä ei ole";
        }
        connections.reverseObject();
        String ret = "<html>";
        for (int i = 0; i < connections.returnObjLength(); i++) {
            Connection c = (Connection) connections.getObject(i);
            ret += " [" + c.getDepartureStop() + " "
                    + mapdata.getStop(c.getDepartureStop()).getName() + " klo "
                    + toTime(c.getDepartureTime()) + " - " + c.getTargetStop()
                    + " " + mapdata.getStop(c.getTargetStop()).getName() + " klo "
                    + toTime(c.getArrivalTime()) + "] reitti: "
                    + c.getRouteName() + "<br> ";
        }
        ret += " on time " + toTime(travelTime) + "</html>";
        return ret;
    }

    public String toTime(int travelTime) {
        int hours = travelTime / 3600;
        int minutes = (travelTime % 3600) / 60;
        return hours + ":" + minutes;
    }

    @Override
    public String toString() {
        connections.reverseObject();
        String ret = "";
        for (int i = 0; i < connections.returnObjLength(); i++) {
            Connection c = (Connection) connections.getObject(i);
            ret += " [" + c.getDepartureStop() + " - " + c.getTargetStop() + "] ";
        }
        ret += " on time " + travelTime;
        return ret;
    }

}
