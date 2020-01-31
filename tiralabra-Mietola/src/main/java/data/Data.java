package data;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author k
 */
public class Data {

    private List<Stop> stops = null;
    private List<Route> routes = null;
    private Route route;

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

//    Stops stops;
    /**
     * public Data(Stops stops) { this.stops=stops; }*
     */
}
/**
 * class Stops { List<Stop> stops; public Stops(List<Stop> stops) {
 * this.stops=stops; } }*
 */
