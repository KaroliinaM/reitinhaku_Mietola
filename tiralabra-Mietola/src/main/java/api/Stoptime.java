/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import data.Stop;
import java.io.Serializable;

/**
 * For the api.
 * @author k
 */
public class Stoptime implements Serializable {

    private Stop stop;
    private int scheduledDeparture;
    private int scheduledArrival;
    private int serviceDay;

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public int getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(int scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public int getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(int scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public int getServiceDay() {
        return serviceDay;
    }

    public void setServiceDay(int serviceDay) {
        this.serviceDay = serviceDay;
    }

}
