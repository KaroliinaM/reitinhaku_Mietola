package data;

import java.io.Serializable;
import java.util.*;
import datastructures.MyArrayList;
import utils.DistanceCalculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * The network nodes. The Stop object stores it's location in latituude and
 * longitude and also the connection information between stops.
 *
 * @author k
 */
public class Stop implements Comparable<Stop>, Serializable {

    private String gtfsId;
    private String name;
    private double lat;
    private double lon;
    private String zoneId;
    MyArrayList connections = new MyArrayList();
//    List<Connection> connections = new ArrayList<>();
    private int timeEstimate;
    private Connection previous;
    private int estimatedDistance = -1;

    public String getGtfsId() {
        return gtfsId;
    }

    public void setGtfsId(String gtfsId) {
        this.gtfsId = gtfsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public void addConnection(Connection connection) {
        this.connections.insertObject(connection);
    }

    public MyArrayList getConnections() {
        return this.connections;
    }

    public void setEstimate(int estimate) {
        this.timeEstimate = estimate;
    }

    public int getEstimate() {
        return this.timeEstimate;
    }

    public void setPrevious(Connection c) {
        previous = c;
    }

    public Connection getPrevious() {
        return previous;
    }

    public int getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(int distance) {
        this.estimatedDistance = distance;
    }

    @Override
    public int compareTo(Stop t) {
        return this.getEstimate() - t.getEstimate();
    }

}
