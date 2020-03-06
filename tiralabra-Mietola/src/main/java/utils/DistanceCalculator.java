/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Stop;

/**
 * The distances for the a* heuristics.
 *
 * @author k
 */
public class DistanceCalculator {

    MathFunc math = new MathFunc();

    public int timeEstimate(Stop current, Stop dest) {
        Double distance = distFrom(current.getLat(), current.getLon(), 
                dest.getLat(), dest.getLon());
        int estimate = timeForDist(distance);
        return estimate;
    }

    /**
     * converts the distance between two points in a map as distance.
     *
     * @param lat1 starting point latitude
     * @param lng1 starting point longitude
     * @param lat2 ending point latitude
     * @param lng2 ending point longitude
     * @return the distance as meters
     */
    public double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
    //    double dLat = Math.toRadians(lat2 - lat1);
    //    double dLng = Math.toRadians(lng2 - lng1);
         double dLat = math.toRadians(lat2 - lat1);
         double dLng = math.toRadians(lng2 - lng1);
        double a = math.sin(dLat / 2) * math.sin(dLat / 2)
                + math.cos(Math.toRadians(lat1)) * math.cos(Math.toRadians(lat2))
                * math.sin(dLng / 2) * math.sin(dLng / 2);

        /**
         * double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
         * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
         * Math.sin(dLng / 2) * Math.sin(dLng / 2);*
         */
        double c = 2 * Math.atan2(math.sqrt(a), math.sqrt(1 - a));
        double dist = earthRadius * c;

        return dist;
    }

    /**
     * Converts the distance as travel time.
     *
     * @param meters
     * @return minutes
     */
    public int timeForDist(double meters) {
        double ratio = 2000 / 6;
        int time = (int) (meters / ratio);
        return time;
    }

}
