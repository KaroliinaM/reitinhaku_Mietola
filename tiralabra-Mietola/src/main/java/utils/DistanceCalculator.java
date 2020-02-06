/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Stop;

/**
 *
 * @author k
 */
public class DistanceCalculator {
    
    public int timeEstimate(Stop current, Stop dest) {
        Double distance=distFrom(current.getLat(), current.getLon(), dest.getLat(), dest.getLon());
        int estimate=timeForDist(distance);
        return estimate;
    }

    public double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }

    public int timeForDist(double meters) {
        double ratio = 2000 / 6;
        int time = (int) (meters / ratio);
        return time;
    }
}
