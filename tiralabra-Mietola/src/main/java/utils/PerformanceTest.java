/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;
import data.Connection;
import data.Stop;
import datastructures.MyArrayList;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;

/**
 * It's a start.
 *
 * @author k
 */
public class PerformanceTest {

    DijkstraRoutefinder dijkstrafinder;
    AstarRouteFinder astarfinder;
    MyArrayList stopdata;
    Mapdata mapdata = new Mapdata();
    int routesTotest = 10;
    int timesForRoute = 10;

    public void setData(DijkstraRoutefinder finder, AstarRouteFinder astarfinder,
            MyArrayList stopdata) {
        this.dijkstrafinder = finder;
        this.astarfinder = astarfinder;
        this.stopdata = stopdata;
    }

    public void run() {
        int n = stopdata.returnObjLength();
        Stop[] starts = new Stop[routesTotest];
        Stop[] goals = new Stop[routesTotest];
        String[] dijkstraresult = new String[routesTotest];
        String[] astarresult = new String[routesTotest];
        Stop[] coordinates = new Stop[100];

        Random random = new Random(1337);
        for (int i = 0; i < routesTotest; i++) {
            starts[i] = (Stop) stopdata.getObject(random.nextInt(n));
            goals[i] = (Stop) stopdata.getObject(random.nextInt(n));
        }
        for (int i = 0; i < routesTotest; i++) {
            System.out.println(i);
            System.out.println(starts[i].getGtfsId());
            System.out.println(goals[i].getGtfsId());
            long t = 0;
            for (int j = 0; j < timesForRoute; j++) {
                mapdata.setStops(stopdata);
                dijkstrafinder.setMapdata(mapdata);
                long alku = System.nanoTime();
                dijkstrafinder.search(starts[i].getGtfsId(), goals[i].getGtfsId(), 0);
                long loppu = System.nanoTime();
                t += (loppu - alku);
            }
            long time = (t / timesForRoute) / 3600;
            String thisResult = "dijkstralla haku pysäkiltä "
                    + starts[i].getName() + " pysäkille " + goals[i].getName()
                    + " vei aikaa " + (t / timesForRoute) / 1e9;
            dijkstraresult[i] = thisResult;

        }
        for (int i = 0; i < routesTotest; i++) {
            System.out.println(dijkstraresult[i]);
        }

        for (int i = 0; i < routesTotest; i++) {
            System.out.println(i);
            System.out.println(starts[i].getGtfsId());
            System.out.println(goals[i].getGtfsId());
            long t = 0;
            for (int j = 0; j < timesForRoute; j++) {
                mapdata.setStops(stopdata);
                astarfinder.setMapdata(mapdata);
                long alku = System.nanoTime();
                astarfinder.search(starts[i].getGtfsId(), goals[i].getGtfsId(), 0);
                long loppu = System.nanoTime();
                t += (loppu - alku);
            }
            long time = (t / timesForRoute) / 3600;
            String thisResult = "astarilla haku pysäkiltä " + starts[i].getName()
                    + " pysäkille " + goals[i].getName()
                    + " vei aikaa " + (t / timesForRoute) / 1e9;
            astarresult[i] = thisResult;

        }
        for (int i = 0; i < routesTotest; i++) {
            System.out.println(astarresult[i]);
        }

        for (int i = 0; i < 100; i++) {
            coordinates[i] = (Stop) stopdata.getObject(random.nextInt(n));
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(coordinates[i].getLat());
            System.out.println(coordinates[i].getLon());
            System.out.println();
        }

    }

}
