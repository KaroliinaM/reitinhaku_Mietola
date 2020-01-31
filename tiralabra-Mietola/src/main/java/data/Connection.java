/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author k
 */
public class Connection {

    private String departureStop;
    private String targetStop;
    private int duration;

    public Connection(String departure, String arrival, int time) {
        departureStop = departure;
        targetStop = arrival;
        duration = time;
    }

    public String getDepartureStop() {
        return this.departureStop;
    }

    public String getTargetStop() {
        return this.targetStop;
    }

    public int getDuration() {
        return this.duration;
    }

}
