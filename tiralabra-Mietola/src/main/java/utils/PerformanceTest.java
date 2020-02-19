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
 * @author k
 */
public class PerformanceTest {

    DijkstraRoutefinder dijkstrafinder;
    AstarRouteFinder astarfinder;
    MyArrayList stopdata;

    public void setData(DijkstraRoutefinder finder, AstarRouteFinder astarfinder, 
            MyArrayList stopdata) {
        this.dijkstrafinder = finder;
        this.astarfinder = astarfinder;
        this.stopdata = stopdata;
    }

    public void run() {
        Random random = new Random(1337);
        int n = stopdata.returnObjLength();
        Stop start = (Stop) stopdata.getObject(random.nextInt(n));
        Stop goal = (Stop) stopdata.getObject(random.nextInt(n));
        dijkstrafinder.search(start.getGtfsId(), goal.getGtfsId(), 0);
    }

}
