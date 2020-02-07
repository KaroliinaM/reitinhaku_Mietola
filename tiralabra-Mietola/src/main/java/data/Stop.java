package data;

import java.io.Serializable;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * The network nodes.
 * @author k
 */
public class Stop implements Comparable<Stop>, Serializable {

    private String gtfsId;
    private String name;
    private double lat;
    private double lon;
    private String zoneId;
    List<Connection> connections = new ArrayList<>();
    private int timeEstimate;
    private Connection previous;

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
        this.connections.add(connection);
    }

    public List<Connection> getConnections() {
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

    @Override
    public int compareTo(Stop t) {
        return this.getEstimate() - t.getEstimate();
    }

}
