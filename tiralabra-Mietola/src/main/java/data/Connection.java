/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 * The edges for the traffic network.
 *
 * @author k
 */
public class Connection implements Serializable {

    private String departureStop;
    private String targetStop;
    private int departureTime;
    private int arrivalTime;
    private String routeName;

    public Connection(String departureStop, String targetStop, int departureTime, 
            int arrivalTime, String routeName) {
        this.departureStop = departureStop;
        this.targetStop = targetStop;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.routeName = routeName;
    }

    public String getDepartureStop() {
        return this.departureStop;
    }

    public String getTargetStop() {
        return this.targetStop;
    }

    public int getDepartureTime() {
        return this.departureTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }
    
    public String getRouteName() {
        return this.routeName;
    }

    @Override
    public String toString() {
        return this.getDepartureStop() + " klo " + this.getDepartureTime() + "-" + this.targetStop
                + " klo " + this.getArrivalTime();
    }

}
