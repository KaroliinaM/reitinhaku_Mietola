/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import data.Stop;

/**
 * A heap structure for Stop objects.
 *
 * @author k
 */
public class StopHeap {

    Stop[] stops = new Stop[50];
    int pointer = 1;

    public void add(Stop stop) {
        if (pointer == stops.length) {
            Stop[] newStops = new Stop[stops.length + 50];
            for (int i = 0; i < stops.length; i++) {
                newStops[i] = stops[i];
            }
            stops = newStops;
        }
        stops[pointer] = stop;
        int place = pointer;
        pointer++;
        while (true) {
            if (place == 1) {
                break;
            }
            Stop parent = stops[place / 2];
            if (stops[place].getEstimate() >= parent.getEstimate()) {
                break;
            }
            Stop apu = parent;
            stops[place / 2] = stops[place];
            stops[place] = apu;
            place = place / 2;
        }
    }

    public Stop poll() {
        Stop closest = stops[1];
        stops[1] = stops[pointer - 1];
        int place = 1;
        while (true) {
            if (pointer <= place * 2) {
                break;
            }
            int minPlace;
            if (pointer == place * 2 + 1) {
                minPlace = place * 2;
            } else {
                minPlace = stops[place * 2].getEstimate() < stops[place * 2 + 1].getEstimate()
                        ? place * 2 : place * 2 + 1;
            }
            if (stops[minPlace].getEstimate() >= stops[place].getEstimate()) {
                break;
            }
            Stop apu = stops[place];
            stops[place] = stops[minPlace];
            stops[minPlace] = apu;
            place = minPlace;
        }
        pointer--;
        return closest;
    }

    public boolean isEmpty() {
        System.out.println(pointer);
        return pointer == 1;
    }

}
