/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 *
 * @author k
 */
public class Trip {

    private String gtfsId;
    private List<Stoptime> stoptimes = null;

    public String getGtfsId() {
        return gtfsId;
    }

    public void setGtfsId(String gtfsId) {
        this.gtfsId = gtfsId;
    }

    public List<Stoptime> getStoptimes() {
        return stoptimes;
    }

    public void setStoptimes(List<Stoptime> stoptimes) {
        this.stoptimes = stoptimes;
    }

}
